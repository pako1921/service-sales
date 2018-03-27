package Receipt;

import models.Price;
import models.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by plongobucco on 24/03/18.
 */
public interface Receipt {

    void headerReceipt();
    void printProductsInfo(List<Product> products);
    void printSalesTax(List<Price> prices);
    void printTotal(List<Price> prices);
    void footerReceipt();

}
