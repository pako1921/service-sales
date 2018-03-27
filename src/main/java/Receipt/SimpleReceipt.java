package Receipt;

import models.Price;
import models.Product;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.Function;

/**
 * Created by plongobucco on 24/03/18.
 */
public class SimpleReceipt implements Receipt {

    private final PrintStream out;

    public static SimpleReceipt printReceipt(PrintStream out) {
        return new SimpleReceipt(out);
    }

    private SimpleReceipt(PrintStream out) {
        this.out = out;
    }

    @Override
    public void headerReceipt() {
        out.printf("\n-------------------- Order Receipt ------------------\n\n");
    }

    @Override
    public void printProductsInfo(List<Product> products) {

        products.stream().forEach(product -> out.printf("%03d %35s      %8s\n",
                product.getQuantity(),
                product.getDescription(),
                product.getPrice().getNetPrice().add(product.getPrice().getTaxAmount()).setScale(2, RoundingMode.UP)));

    }

    @Override
    public void printSalesTax(List<Price> prices) {

        out.printf("%39s       %7s\n", "Sales Taxes", prices.stream()
                .map(Price::getTaxAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    @Override
    public void printTotal(List<Price> prices) {

        Function<Price, BigDecimal> totalMapper = price -> price.getNetPrice().add(price.getTaxAmount());
        BigDecimal result = prices.stream()
                .map(totalMapper)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        out.printf("%39s       %7s\n", "Total", result);


    }

    @Override
    public void footerReceipt() {
        out.printf("\n");
    }
}
