package com.interview.shoppingbasket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class CheckoutPipelineTest {

    CheckoutPipeline checkoutPipeline;
    PromotionsService promotionsService;
    PricingService pricingService;

    @Mock
    Basket basket;

    @BeforeEach
    void setup() {
        checkoutPipeline = new CheckoutPipeline();
        promotionsService = Mockito.mock(PromotionsService.class);
        pricingService = Mockito.mock(PricingService.class);
    }

    @Test
    void returnZeroPaymentForEmptyPipeline() {
        PaymentSummary paymentSummary = checkoutPipeline.checkout(basket);

        assertEquals(paymentSummary.getRetailTotal(), 0.0);
    }

    @Test
    void executeAllPassedCheckoutSteps() {
        Basket basket = BasketStubs.buildSimpleBasket();
        List<Promotion> promotions = PromotionStubs.buildPresetPromotions();

        BasketConsolidationCheckoutStep basketConsolidationCheckoutStep = new BasketConsolidationCheckoutStep();
        DefinePromotionsCheckoutStep definePromotionsCheckoutStep = new DefinePromotionsCheckoutStep(promotionsService);
        RetailPriceCheckoutStep retailPriceCheckoutStep = new RetailPriceCheckoutStep(pricingService);

        when(pricingService.getPrice("productCode")).thenReturn(3.99);
        when(pricingService.getPrice("productCode2")).thenReturn(2.0);
        when(pricingService.getPrice("productCode3")).thenReturn(5.0);
        when(promotionsService.getPromotions(any())).thenReturn(promotions);

        checkoutPipeline.addStep(basketConsolidationCheckoutStep);
        checkoutPipeline.addStep(definePromotionsCheckoutStep);
        checkoutPipeline.addStep(retailPriceCheckoutStep);

        checkoutPipeline.checkout(basket);

        assertEquals(checkoutPipeline.getCheckoutContext().paymentSummary().getRetailTotal(), 136.44);

    }

}
