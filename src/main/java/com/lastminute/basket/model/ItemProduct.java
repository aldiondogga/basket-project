package com.lastminute.basket.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Dogga on 15/10/2016.
 */
@Data
@Slf4j
public class ItemProduct {
    private Product product;
    private int quantity;
    private double price;
    private double amount;
    private double taxes;

}
