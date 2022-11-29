package es.nebrija.SpringBootServer.Shop.Infrastructure.exceptions;

public class ShopNotFoundException extends RuntimeException {

    public ShopNotFoundException(String name) {
        super(String.format("Shop with name: %s not found", name));
    }
}
