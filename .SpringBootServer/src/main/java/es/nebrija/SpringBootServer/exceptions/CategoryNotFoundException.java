package es.nebrija.SpringBootServer.exceptions;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(String name){
        super(String.format("Category with name: %s not found", name));
    }
}
