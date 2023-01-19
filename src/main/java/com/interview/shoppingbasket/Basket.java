package com.interview.shoppingbasket;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Basket {
    private List<BasketItem> items = new ArrayList<>();

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductCode(productCode);
        basketItem.setProductName(productName);
        basketItem.setQuantity(quantity);

        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void consolidateItems() {
        Map<String, BasketItem> items = new HashMap<>();
        this.items.forEach(item -> {
            BasketItem foundItem = items.get(item.getProductCode());
            if (foundItem != null) {
                item.setQuantity(item.getQuantity() + foundItem.getQuantity());
            }
            items.put(item.getProductCode(), item);
        });
        this.items = new ArrayList<>();
        for (String key : items.keySet()) {
            this.items.add(items.get(key));
        }
    }

}
