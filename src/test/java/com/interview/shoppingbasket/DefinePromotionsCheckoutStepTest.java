package com.interview.shoppingbasket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DefinePromotionsCheckoutStepTest {

    private PromotionsService promotionsService;
    private CheckoutContext checkoutContext;

    @BeforeEach
    void setup() {
        this.promotionsService = Mockito.mock(PromotionsService.class);
        this.checkoutContext = Mockito.mock(CheckoutContext.class);
    }

    @Test
    void shouldReturnPromotionList() {
        Basket basket = new Basket();
        basket.add("productCode", "myProduct", 10);
        basket.add("productCode2", "myProduct2", 10);
        List<Promotion> promotions = PromotionStubs.buildPresetPromotions();

        when(checkoutContext.getBasket()).thenReturn(basket);
        when(promotionsService.getPromotions(any())).thenReturn(promotions);

        DefinePromotionsCheckoutStep step = new DefinePromotionsCheckoutStep(promotionsService);
        step.execute(checkoutContext);

        Mockito.verify(promotionsService).getPromotions(basket);

    }

}
