package com.lastminute.basket.servlet;

import com.google.appengine.repackaged.com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.lastminute.basket.model.ItemProduct;
import com.lastminute.basket.service.BasketService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Dogga on 15/10/2016.
 */
public class BasketServlet   extends HttpServlet {
    private Logger logger = Logger.getLogger(ProductServlet.class.getName());
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String method = req.getParameter("method");
        BasketService basketService = new BasketService();
        switch (method) {
            case "CHECKOUT":
                String pojo = req.getParameter("pojo");
                TypeToken<List<ItemProduct>> token = new TypeToken<List<ItemProduct>>(){};
                List<ItemProduct> itemProductList = gson.fromJson(pojo, token.getType());
                resp.getWriter().print(gson.toJson(basketService.checkout(itemProductList)));
        }

    }

}
