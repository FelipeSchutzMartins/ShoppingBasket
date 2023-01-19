package com.interview.shoppingbasket;

public class DefinePromotionsCheckoutStep implements CheckoutStep {

    private PromotionsService promotionsService;

    public DefinePromotionsCheckoutStep(PromotionsService promotionsService) {
        this.promotionsService = promotionsService;
    }

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        checkoutContext.setPromotions(this.promotionsService.getPromotions(basket));
    }

}
