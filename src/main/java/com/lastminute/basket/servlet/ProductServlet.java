package com.lastminute.basket.servlet;

import com.google.appengine.repackaged.com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.googlecode.objectify.ObjectifyService;
import com.lastminute.basket.model.Product;
import com.lastminute.basket.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by Dogga on 15/10/2016.
 */
public class ProductServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(ProductServlet.class.getName());
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectifyService.register(Product.class);
        resp.setContentType("text/html; charset=UTF-8");
        String method = req.getParameter("method");
        ProductService productService = new ProductService();
        switch (method) {
            case "LOAD_PRODUCT":
                resp.getWriter().print(gson.toJson(productService.loadAllProduct()));
                break;
            case "ADD_ALL_PRODUCT":
                InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/product.properties");
                Properties props = new Properties();
                props.load(is);
                String product = props.getProperty("product");
                TypeToken<List<Product>> token = new TypeToken<List<Product>>(){};
                List<Product> productList = gson.fromJson(product, token.getType());
                productService.addAllProduct(productList);
                break;
            case "ADD_PRODUCT":
                String pojo = req.getParameter("pojo");
                Product newProduct = gson.fromJson(pojo, Product.class);
                productService.addProduct(newProduct);

        }

    }

}
