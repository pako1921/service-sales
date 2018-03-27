package models;

import Receipt.Receipt;
import tax.Action;
import tax.ImportedTax;
import tax.LocalTax;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by plongobucco on 24/03/18.
 *
 * The class represents the structure of an order, containing the list of product
 *
 */
public class Order {

    private final List<Product> products = new ArrayList<>();
    private final List<Action> taxes = new ArrayList<>();

    public void initOrder(){
        taxes.add(new LocalTax());
        taxes.add(new ImportedTax());
    }

    /**
     * Adds a product to the list
     *
     * @param product The product to add to the list
     *
     */
    public void add(Product product) {

        Product processedProduct = product;

        for (Action action : taxes) {
            if (action.applicable(product)) {
                processedProduct = action.apply(product);
            }
        }

        products.add(processedProduct);
    }

    /**
     * Call the print of the order receipt
     *
     * @param receipt print order console
     *
     */
    public void print(Receipt receipt) {
        receipt.headerReceipt();
        receipt.printProductsInfo(products);
        receipt.printSalesTax(products.stream().map(item -> item.getPrice()).collect(Collectors.toList()));
        receipt.printTotal(products.stream().map(item -> item.getPrice()).collect(Collectors.toList()));
        receipt.footerReceipt();
    }

}
