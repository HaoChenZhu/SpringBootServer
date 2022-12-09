package es.nebrija.SpringBootServer.exceptions;

public class ShopNotFoundException extends RuntimeException {

    public ShopNotFoundException(String name) {
        super(String.format("Shop with name: %s not found", name));
    }
}
