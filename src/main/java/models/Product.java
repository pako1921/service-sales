package models;

/**
 * Created by plongobucco on 25/03/18.
 *
 * The class represents the structure of a product, containing quantity, description,
 * origin, type and price detail
 *
 */
public class Product {

    private String description;
    private int quantity;
    private Price price;
    private ProductOrigin productOrigin;
    private ProductType productType;

    public Product(String description, int quantity, Price price, ProductOrigin productOrigin, ProductType productType) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.productOrigin = productOrigin;
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public ProductOrigin getProductOrigin() {
        return productOrigin;
    }

    public void setProductOrigin(ProductOrigin productOrigin) {
        this.productOrigin = productOrigin;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }


}
