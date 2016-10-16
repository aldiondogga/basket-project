package com.lastminute.basket.model;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created by Dogga on 14/10/2016.
 */
@Data
@Slf4j
public class Basket {
    private List<ItemProduct> basket;
    private double salesTaxes;
    private double total;
}
