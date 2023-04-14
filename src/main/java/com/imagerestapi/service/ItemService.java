package com.imagerestapi.service;


import com.imagerestapi.entity.Item;
import com.imagerestapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class ItemService {
        @Autowired
        private ItemRepository itemRepository;

        public Item createItem(Item item) {
            return itemRepository.save(item);
        }

        public Item updateItem(Long id, Item item) {
            Optional<Item> optionalItem = itemRepository.findById(id);
            if (optionalItem.isPresent()) {
                Item existingItem = optionalItem.get();
                existingItem.setName(item.getName());
                existingItem.setCategory(item.getCategory());
                existingItem.setQuantity(item.getQuantity());
                existingItem.setPrice(item.getPrice());
                return itemRepository.save(existingItem);
            }
            return null;
        }

        public List<Item> getAllItems() {
            return itemRepository.findAll();
        }

        public void deleteItem(Long id) {
            itemRepository.deleteById(id);
        }

        public int getStock() {
            List<Item> items = itemRepository.findAll();
            int stock = 0;
            for (Item item : items) {
                stock += item.getQuantity();
            }
            return stock;
        }
    }


