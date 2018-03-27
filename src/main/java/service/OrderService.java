package service;

import models.Price;
import models.Product;
import models.ProductOrigin;
import models.ProductType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by plongobucco on 27/03/18.
 *
 * The class returns the orders made with the product details, represents a mock
 *
 */
public class OrderService {

    private static Map<Integer, List<Product>> mapBaskets = new HashMap<>();

    static {

        List<Product> productsOrderOne = new ArrayList<>();

        Product bookOrderOne = new Product("book", 1, Price.price("12.49"), ProductOrigin.LOCAL, ProductType.BOOK);
        Product musicOrderOne = new Product("music CD", 1, Price.price("14.99"), ProductOrigin.LOCAL, ProductType.MUSIC);
        Product chocolatesOrderOne = new Product("chocolate bar", 1, Price.price("0.85"), ProductOrigin.LOCAL, ProductType.FOOD);

        productsOrderOne.add(bookOrderOne);
        productsOrderOne.add(musicOrderOne);
        productsOrderOne.add(chocolatesOrderOne);

        List<Product> productsOrderTwo = new ArrayList<>();

        Product chocolatesOrderTwo = new Product("box of chocolates", 1, Price.price("10.00"), ProductOrigin.IMPORTED, ProductType.FOOD);
        Product perfumeOrderTwo = new Product("imported bottle of perfume", 1, Price.price("47.50"), ProductOrigin.IMPORTED, ProductType.PARFUME);

        productsOrderTwo.add(chocolatesOrderTwo);
        productsOrderTwo.add(perfumeOrderTwo);

        List<Product> productsOrderThree = new ArrayList<>();
        Product perfumeOrderThree = new Product("bottle of perfume", 1, Price.price("27.99"), ProductOrigin.IMPORTED, ProductType.PARFUME);
        Product perfumeLocalOrderThree = new Product("bottle of perfume", 1, Price.price("18.99"), ProductOrigin.LOCAL, ProductType.PARFUME);
        Product pillsOrderOrderThree = new Product("packet of headache pills", 1, Price.price("9.75"), ProductOrigin.LOCAL, ProductType.MEDICAL);
        Product chocolateOrderThree = new Product("box of chocolates", 1, Price.price("11.25"), ProductOrigin.IMPORTED, ProductType.FOOD);

        productsOrderThree.add(perfumeOrderThree);
        productsOrderThree.add(perfumeLocalOrderThree);
        productsOrderThree.add(pillsOrderOrderThree);
        productsOrderThree.add(chocolateOrderThree);

        mapBaskets.put(1, productsOrderOne);
        mapBaskets.put(2, productsOrderTwo);
        mapBaskets.put(3, productsOrderThree);

    }

    /**
     * Return the list of products of a specific order
     *
     * @param idBasket The id of an order
     */
    public static List<Product> getBasket(Integer idBasket) {

        return mapBaskets.get(idBasket);
    }

}
