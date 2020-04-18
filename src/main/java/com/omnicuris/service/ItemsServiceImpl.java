package com.omnicuris.service;

import com.omnicuris.dto.ResponseMessage;
import com.omnicuris.entity.Items;
import com.omnicuris.payload.ItemPayload;
import com.omnicuris.repository.ItemsRepository;
import com.omnicuris.util.ErrorCollector;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ItemsServiceImpl implements ItemsService {

    private final ItemsRepository itemsRepository;
    private final ModelMapper modelMapper;
    private final ErrorCollector errorCollector;

    public ItemsServiceImpl(ItemsRepository itemsRepository,
                            ModelMapper modelMapper,
                            ErrorCollector errorCollector) {
        this.itemsRepository = itemsRepository;
        this.modelMapper = modelMapper;
        this.errorCollector = errorCollector;
    }

    @Override
    public ResponseEntity<?> getItems() {
        return new ResponseEntity<>(itemsRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getItem(Long itemId) {
        Optional<Items> itemsOptional = itemsRepository.findByIdAndActiveTrue(itemId);
        ResponseEntity<?> itemsResponseEntity;
        if (itemsOptional.isPresent()) {
            itemsResponseEntity = new ResponseEntity<>(itemsOptional.get(), HttpStatus.OK);
        } else {
            URI location = getUri(itemId + "");

            itemsResponseEntity = new ResponseEntity<>(
                    new ResponseMessage("Item not found", "Invalid Item id", location)
                    , HttpStatus.NOT_FOUND);
        }
        return itemsResponseEntity;
    }

    @Override
    public ResponseEntity<?> createItem(ItemPayload payload,
                                        BindingResult result) {
        ResponseEntity<?> responseEntity;
        if (result.hasErrors()) {
            responseEntity = new ResponseEntity<>(errorCollector.getErrorResponses(result),
                    HttpStatus.BAD_REQUEST);
        } else {
            Items items = modelMapper.map(payload, Items.class);
            items.setDateCreated(LocalDateTime.now());
            itemsRepository.saveAndFlush(items);
            responseEntity = new ResponseEntity<>(items,
                    HttpStatus.CREATED);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<?> updateItem(ItemPayload payload,
                                        BindingResult result) {
        ResponseEntity<?> responseEntity;
        if (result.hasErrors()) {
            responseEntity = new ResponseEntity<>(errorCollector.getErrorResponses(result),
                    HttpStatus.BAD_REQUEST);
        } else {
            Optional<Items> itemsOptional =
                    itemsRepository.findByIdAndActiveTrue(payload.getId());
            if (itemsOptional.isPresent()) {
                Items items = itemsOptional.get();
                items.setDescription(payload.getDescription());
                items.setImageUrl(payload.getImageUrl());
                items.setName(payload.getName());
                items.setSku(payload.getSku());
                items.setUnitPrice(payload.getUnitPrice());
                items.setUnitsInStock(payload.getUnitsInStock());
                items.setActive(payload.isActive());
                items.setLastUpdated(LocalDateTime.now());
                itemsRepository.saveAndFlush(items);
                responseEntity = new ResponseEntity<>(items,
                        HttpStatus.CREATED);
            } else {
                URI location = getUri("");

                responseEntity = new ResponseEntity<>(
                        new ResponseMessage("Item not found, " +
                                "Provide valid item id", "Invalid Item id", location)
                        , HttpStatus.NOT_FOUND);
            }
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<?> deleteItem(Long itemId) {
        Optional<Items> itemsOptional =
                itemsRepository.findById(itemId);
        ResponseEntity<?> responseEntity;
        URI location = getUri("");
        if (itemsOptional.isPresent()) {
            itemsRepository.delete(itemsOptional.get());
            responseEntity = new ResponseEntity<>(
                    new ResponseMessage("Item deleted Successfully", "", location)
                    , HttpStatus.OK);
        } else {

            responseEntity = new ResponseEntity<>(
                    new ResponseMessage("Item not found, " +
                            "Provide valid item id", "Invalid Item id", location)
                    , HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    private URI getUri(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(id).toUri();
    }
}
