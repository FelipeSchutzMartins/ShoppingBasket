package com.interview.shoppingbasket;

import java.util.List;

public class PromotionStubs {

    public static List<Promotion> buildPresetPromotions() {
        var twoPerOnePromotion = new Promotion("productCode", basketItem -> {
            basketItem.setQuantity((int) Math.round(basketItem.getQuantity() / 2.0));
            return basketItem;
        });
        var retailPriceFiftyOffPromotion = new Promotion("productCode2", basketItem -> {
            var discount = (basketItem.getProductRetailPrice() * 50) / 100;
            basketItem.setProductRetailPrice(basketItem.getProductRetailPrice() - discount);
            return basketItem;
        });
        var retailPriceTenOffPromotion = new Promotion("productCode3", basketItem -> {
            var discount = (basketItem.getProductRetailPrice() * 10) / 100;
            basketItem.setProductRetailPrice(basketItem.getProductRetailPrice() - discount);
            return basketItem;
        });
        return List.of(twoPerOnePromotion, retailPriceFiftyOffPromotion, retailPriceTenOffPromotion);
    }
}
