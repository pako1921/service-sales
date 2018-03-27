package tax;

import models.Product;
import models.ProductType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by plongobucco on 25/03/18.
 */
public abstract class AbstractTax implements Action {

    protected final BigDecimal salesTax = new BigDecimal(0.10).setScale(2, RoundingMode.HALF_UP);

    protected final Collection<ProductType> exemptProducts = Arrays.asList(
            ProductType.BOOK,
            ProductType.FOOD,
            ProductType.MEDICAL);

    @Override
    public boolean applicable(Product product) {
        return false;
    }

    @Override
    public Product apply(Product product) {
        return null;
    }

    protected BigDecimal getTotalPrice(Product product){

        return product.getPrice().getNetPrice()
                .multiply(new BigDecimal(product.getQuantity()));

    }
}
