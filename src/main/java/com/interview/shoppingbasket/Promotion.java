package com.interview.shoppingbasket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {
    private String productCode;
    private Function<BasketItem, BasketItem> applyDiscount;
}
