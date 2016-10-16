package com.lastminute.basket.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Dogga on 14/10/2016.
 */
@Entity
@Data
@Slf4j
public class Product {
    @Id
    private Long id;
    private String name;
    private double price;
    private boolean exemptTax;
    private boolean isImported;


}
