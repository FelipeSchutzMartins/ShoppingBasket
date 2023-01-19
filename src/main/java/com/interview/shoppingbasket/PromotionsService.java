package com.interview.shoppingbasket;

import java.util.List;

public interface PromotionsService {
    List<Promotion> getPromotions(Basket basket);
}
