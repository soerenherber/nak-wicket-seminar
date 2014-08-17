package de.nordakademie.business.product;

public class Product {

    private final String name;
    
    private final Integer price;

    public Product(final String name, final Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    
    public Integer getPrice() {
    	return price;
    }
}
