package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPipeline {

    private List<CheckoutStep> steps = new ArrayList<>();
    private CheckoutContext checkoutContext;

    public PaymentSummary checkout(Basket basket) {
        checkoutContext = new CheckoutContext(basket);
        for (CheckoutStep checkoutStep : steps) {
            checkoutStep.execute(checkoutContext);
        }

        return checkoutContext.paymentSummary();
    }

    public void addStep(CheckoutStep checkoutStep) {
        steps.add(checkoutStep);
    }

    public CheckoutContext getCheckoutContext() {
        return this.checkoutContext;
    }
}
