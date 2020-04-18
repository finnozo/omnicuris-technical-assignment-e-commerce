package com.omnicuris.service;

import com.omnicuris.payload.ItemPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface ItemsService {
    ResponseEntity<?> getItems();

    ResponseEntity<?> getItem(Long itemId);

    ResponseEntity<?> createItem(ItemPayload payload, BindingResult result);

    ResponseEntity<?> updateItem(ItemPayload payload, BindingResult result);

    ResponseEntity<?> deleteItem(Long itemId);
}
