package tax;

import models.Product;

/**
 * Created by plongobucco on 25/03/18.
 */
public interface Action {

    boolean applicable(Product product);

    Product apply(Product product);
}
