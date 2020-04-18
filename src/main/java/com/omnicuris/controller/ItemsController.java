package com.omnicuris.controller;

import com.omnicuris.payload.ItemPayload;
import com.omnicuris.service.ItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/items")
public class ItemsController {

    private final ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<?> getItems() {
        return itemsService.getItems();
    }

    @GetMapping(path = {"{itemId}", "{itemId}/"})
    public ResponseEntity<?> getItem(@PathVariable("itemId") Long itemId) {
        return itemsService.getItem(itemId);
    }

    @PostMapping(path = {"", "/"})
    public ResponseEntity<?> createItem(@Valid @RequestBody ItemPayload payload,
                                        BindingResult result) {
        return itemsService.createItem(payload, result);
    }

    @PutMapping(path = {"", "/"})
    public ResponseEntity<?> updateItem(@Valid @RequestBody ItemPayload payload,
                                        BindingResult result) {
        return itemsService.updateItem(payload, result);
    }
    @DeleteMapping(path = {"{itemId}", "{itemId}/"})
    public ResponseEntity<?> deleteItem(@PathVariable("itemId") Long itemId) {
        return itemsService.deleteItem(itemId);
    }
}
