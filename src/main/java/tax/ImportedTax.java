package tax;

import models.Product;
import models.ProductOrigin;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by plongobucco on 25/03/18.
 */
public class ImportedTax extends AbstractTax {

    private final BigDecimal additionalSalesTax = new BigDecimal(0.05).setScale(2, RoundingMode.HALF_UP);

    @Override
    public boolean applicable(Product product) {
        return product.getProductOrigin() == ProductOrigin.IMPORTED;
    }

    @Override
    public Product apply(Product product) {

        BigDecimal totalPrice = getTotalPrice(product);

        BigDecimal totalTax = product.getPrice().getTaxAmount()
                .add(!exemptProducts.contains(product.getProductType()) ? totalPrice.multiply(salesTax).setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO)
                .add(new BigDecimal(Math.ceil(totalPrice.multiply(additionalSalesTax).doubleValue() * 20)/20).setScale(2, RoundingMode.HALF_UP));
        product.getPrice().setTaxAmount(totalTax);

        return product;
    }
}
