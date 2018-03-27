package models;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by plongobucco on 25/03/18.
 *
 * The class represents the detail of the price of a product
 *
 */
public class Price {

    public static Price price(String netPrice) {

        return new Price(new BigDecimal(netPrice));
    }

    private Price(BigDecimal netPrice) {
        this.netPrice = netPrice.setScale(2, RoundingMode.HALF_UP);
        this.taxAmount = BigDecimal.ZERO;

    }

    private BigDecimal netPrice;
    private BigDecimal taxAmount;

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

}
