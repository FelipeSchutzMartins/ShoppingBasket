package com.interview.shoppingbasket;

public class BasketStubs {

    public static Basket buildSimpleBasket() {
        Basket basket = new Basket();
        basket.add("productCode", "productCode", 11); //3.99
        basket.add("productCode2", "productCode2", 10);
        basket.add("productCode2", "productCode2", 15);
        basket.add("productCode2", "productCode2", 20); //2.0
        basket.add("productCode3", "productCode3", 15); // 5.0
        return basket;
    }
}
