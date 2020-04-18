package com.omnicuris.controller;

import com.omnicuris.payload.OrderPayload;
import com.omnicuris.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<?> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping(path = {"{emailId:.+}", "{emailId:.+}/"})
    public ResponseEntity<?> getOrders(@PathVariable("emailId") String emailId) {
        System.err.println(emailId);
        return orderService.getOrders(emailId);
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderPayload payload,
                                         BindingResult result) {
        return orderService.createOrder(payload, result);
    }

    @PostMapping(path = {"orders", "orders/"})
    public ResponseEntity<?> createOrder(@Valid @RequestBody List<OrderPayload> payloads,
                                         BindingResult result) {
        return orderService.createOrders(payloads, result);
    }
}
