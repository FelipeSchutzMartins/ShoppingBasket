package com.interview.shoppingbasket;

import java.util.List;
import java.util.stream.Collectors;

public class RetailPriceCheckoutStep implements CheckoutStep {
    private PricingService pricingService;
    private double retailTotal;

    public RetailPriceCheckoutStep(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        retailTotal = 0.0;

        for (BasketItem basketItem: basket.getItems()) {
            double price = pricingService.getPrice(basketItem.getProductCode());
            List<Promotion> promotions = checkoutContext.getPromotions().stream()
                    .filter(promotion -> promotion.getProductCode().equals(basketItem.getProductCode()))
                    .collect(Collectors.toList());
            basketItem.setProductRetailPrice(price);
            retailTotal += applyPromotion(promotions, basketItem);
        }
        checkoutContext.setRetailPriceTotal(retailTotal);
    }

    public double applyPromotion(List<Promotion> promotions, BasketItem basketItem) {
        for (Promotion promotion : promotions) {
            promotion.getApplyDiscount().apply(basketItem);
        }
        return basketItem.getProductRetailPrice() * basketItem.getQuantity();
    }
}
