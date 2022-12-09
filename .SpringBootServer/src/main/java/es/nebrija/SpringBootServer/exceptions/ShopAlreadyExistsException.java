package es.nebrija.SpringBootServer.exceptions;

public class ShopAlreadyExistsException extends RuntimeException {

    public ShopAlreadyExistsException(String name) {
        super(String.format("Shop with name: %s already exists", name));
    }


}
