package es.nebrija.SpringBootServer.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String name) {
        super(String.format("Product with name: %s not found", name));
    }
}
