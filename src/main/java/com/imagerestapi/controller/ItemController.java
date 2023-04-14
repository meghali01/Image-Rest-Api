package com.imagerestapi.controller;


import com.imagerestapi.entity.Item;
import com.imagerestapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
    @RequestMapping("/api")
    public class ItemController {
        @Autowired
        private ItemService itemService;

        @PostMapping("/image")
        public void uploadImage(@RequestParam("image") MultipartFile file) {
            // logic for storing the image in the memory database
        }

        @GetMapping("/image")
        public void getImage(HttpServletResponse response) {
            // logic for retrieving the image from the memory database and printing it on the browser
        }

        @PostMapping("/items")
        public Item createItem(@RequestBody Item item) {
            return itemService.createItem(item);
        }

        @PutMapping("/items/{id}")
        public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
            return itemService.updateItem(id, item);
        }

        @GetMapping("/items")
        public List<Item> getAllItems() {
            return itemService.getAllItems();
        }

        @DeleteMapping("/items/{id}")
        public void deleteItem(@PathVariable Long id) {
            itemService.deleteItem(id);
        }

        @GetMapping("/items/stock")
        public int getStock() {
            return itemService.getStock();
        }
    }


