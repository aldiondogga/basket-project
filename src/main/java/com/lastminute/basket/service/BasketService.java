package com.lastminute.basket.service;

import com.lastminute.basket.model.Basket;
import com.lastminute.basket.model.ItemProduct;
import com.lastminute.basket.model.Product;
import com.lastminute.basket.utils.Params;

import java.util.List;

/**
 * Created by Dogga on 15/10/2016.
 */
public class BasketService {

    public Basket checkout(List<ItemProduct> itemProductList) {
        Basket basket = new Basket();
        double salesTaxes = 0;
        double total = 0;
        for (ItemProduct item : itemProductList) {
            Product product = item.getProduct();
            //Set amount = price x quantity for each product
            double amount = round(product.getPrice() * item.getQuantity(), 2);
            item.setAmount(amount);
            total += amount;
            item.setTaxes(0);
            //if product is not exempt taxes, set taxes
            if (!product.isExemptTax()) {
                double taxes = round(amount * Params.TAXES / 100, 2);
                //round up to the nearest 0.05
                taxes = Math.round(taxes * 20) / 20.0;
                item.setAmount(round((amount + taxes), 2));
                item.setTaxes(taxes);
                total += taxes;
                salesTaxes += taxes;
            }
            //if product is imported, set taxes
            if (product.isImported()) {
                double oldAmount = item.getAmount();
                double oldTaxes = item.getTaxes();
                double importTaxes = round(amount * Params.IMPORT_TAXES / 100, 2);
                //round up to the nearest 0.05
                importTaxes = Math.round(importTaxes * 20) / 20.0;
                item.setAmount(round((oldAmount + importTaxes), 2));
                item.setTaxes(round((oldTaxes + importTaxes), 2));
                total += importTaxes;
                salesTaxes += importTaxes;
            }
        }
        basket.setBasket(itemProductList);
        basket.setSalesTaxes(salesTaxes);
        basket.setTotal(round(total, 2));
        return basket;
    }

    public static double round(double value, int decimal) {
        if (decimal < 0) {
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10, decimal);
        value = value * factor;
        long tmp = Math.round(value);
        double result = (double) tmp / factor;
        return result;
    }
}
