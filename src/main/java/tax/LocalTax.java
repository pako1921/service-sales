package tax;

import models.Product;
import models.ProductOrigin;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by plongobucco on 25/03/18.
 */
public class LocalTax extends AbstractTax {

    @Override
    public boolean applicable(Product product) {
        return product.getProductOrigin() == ProductOrigin.LOCAL &&
                !exemptProducts.contains(product.getProductType());
    }

    @Override
    public Product apply(Product product) {

        BigDecimal totalPrice = getTotalPrice(product);

        BigDecimal totalTax = product.getPrice().getTaxAmount()
                .add(totalPrice.multiply(salesTax).setScale(2, RoundingMode.HALF_UP));
        product.getPrice().setTaxAmount(totalTax);

        return product;
    }
}
