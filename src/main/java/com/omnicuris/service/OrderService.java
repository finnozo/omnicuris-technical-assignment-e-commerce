package com.omnicuris.service;

import com.omnicuris.payload.OrderPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface OrderService {
    ResponseEntity<?> getOrders();

    ResponseEntity<?> getOrders(String orderId);

    ResponseEntity<?> createOrder(OrderPayload payload,
                                  BindingResult result);

    ResponseEntity<?> createOrders(List<OrderPayload> payloads,
                                   BindingResult result);
}
