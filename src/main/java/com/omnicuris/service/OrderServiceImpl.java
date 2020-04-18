package com.omnicuris.service;

import com.omnicuris.dto.ResponseMessage;
import com.omnicuris.entity.Items;
import com.omnicuris.entity.Order;
import com.omnicuris.payload.OrderPayload;
import com.omnicuris.repository.ItemsRepository;
import com.omnicuris.repository.OrderRepository;
import com.omnicuris.util.ErrorCollector;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ErrorCollector errorCollector;
    private final ItemsRepository itemsRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ErrorCollector errorCollector,
                            ItemsRepository itemsRepository,
                            ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.errorCollector = errorCollector;
        this.itemsRepository = itemsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> getOrders() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getOrders(String emailId) {
        List<Order> orders = orderRepository.findByEmailIdAndActiveTrue(emailId);
        ResponseEntity<?> responseEntity;
        if (!orders.isEmpty()) {
            responseEntity = new ResponseEntity<>(orders, HttpStatus.OK);
        } else {
            URI location = getUri(emailId);
            responseEntity = new ResponseEntity<>(
                    new ResponseMessage("Orders not found, Provide valid email Id",
                            "Invalid email id", location)
                    , HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<?> createOrder(OrderPayload payload,
                                         BindingResult result) {
        ResponseEntity<?> responseEntity;
        if (result.hasErrors()) {
            responseEntity = new ResponseEntity<>(errorCollector.getErrorResponses(result),
                    HttpStatus.BAD_REQUEST);
        } else {
            responseEntity = createSingleOrder(payload);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<?> createOrders(List<OrderPayload> payloads,
                                          BindingResult result) {
        List<ResponseEntity<?>> responseEntities = new ArrayList<>();
        if (result.hasErrors()) {
            ResponseEntity<?> responseEntity = new ResponseEntity<>(errorCollector.getErrorResponses(result),
                    HttpStatus.BAD_REQUEST);
            responseEntities.add(responseEntity);
        } else {
            responseEntities = payloads
                    .stream()
                    .map(this::createSingleOrder)
                    .collect(Collectors.toList());
        }

        return new ResponseEntity<>(responseEntities.stream()
                .map(HttpEntity::getBody)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    private ResponseEntity<?> createSingleOrder(OrderPayload payload) {
        ResponseEntity<?> responseEntity;

        Optional<Items> itemsOptional = itemsRepository.findByIdAndActiveTrue(payload.getItemId());
        if (itemsOptional.isPresent()) {
            Items items = itemsOptional.get();
            if (items.getUnitsInStock() == 0L) {
                responseEntity = new ResponseEntity<>(new ResponseMessage(
                        "Out of stock",
                        "Item is not available",
                        getUri("")
                ),
                        HttpStatus.CONFLICT);
            } else {
                if (items.getUnitsInStock() >= payload.getNumberOfItems()) {
                    Order order = modelMapper.map(payload, Order.class);
                    order.setDateCreated(LocalDateTime.now());
                    order.setActive(true);
                    order = orderRepository.saveAndFlush(order);
                    items.setUnitsInStock(items.getUnitsInStock() - order.getNumberOfItems());
                    itemsRepository.saveAndFlush(items);
                    responseEntity = new ResponseEntity<>(order, HttpStatus.CREATED);
                } else {
                    responseEntity = new ResponseEntity<>(new ResponseMessage(
                            "Not enough quantity available",
                            "Item Quantity is less than order Quantity",
                            getUri("")
                    ),
                            HttpStatus.CONFLICT);
                }
            }
        } else {
            responseEntity = new ResponseEntity<>(new ResponseMessage(
                    "Invalid Item id, Provide valid item id",
                    "Item not found",
                    getUri("")
            ),
                    HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    private URI getUri(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(id).toUri();
    }
}
