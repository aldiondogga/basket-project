package com.lastminute.basket.service;

import com.lastminute.basket.model.Product;

import java.io.InputStream;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Created by Dogga on 15/10/2016.
 */
public class ProductService {
    public int addAllProduct(List<Product> productList){
        for(Product product: productList){
            ofy().save().entity(product).now();
        }
        return 0;
    }
    public int addProduct(Product product){
        ofy().save().entity(product).now();
        return 0;
    }
    public List<Product> loadAllProduct(){
        List<Product> productList = ofy().load().type(Product.class).list();
        return productList;
    }
}
