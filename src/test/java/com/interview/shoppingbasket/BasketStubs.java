package com.interview.shoppingbasket;

public class BasketStubs {

    public static Basket buildSimpleBasket() {
        Basket basket = new Basket();
        basket.add("productCode", "productCode", 11);
        basket.add("productCode2", "productCode2", 10);
        basket.add("productCode2", "productCode2", 15);
        basket.add("productCode2", "productCode2", 20);
        basket.add("productCode3", "productCode3", 15);
        return basket;
    }
}
