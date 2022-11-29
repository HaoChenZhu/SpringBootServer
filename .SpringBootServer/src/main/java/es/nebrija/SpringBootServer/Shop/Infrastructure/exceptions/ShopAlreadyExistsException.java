package es.nebrija.SpringBootServer.Shop.Infrastructure.exceptions;

public class ShopAlreadyExistsException extends RuntimeException {

    public ShopAlreadyExistsException(String name) {
        super(String.format("Shop with name: %s already exists", name));
    }


}
