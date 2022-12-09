package es.nebrija.SpringBootServer.exceptions;

public class NotValuesException extends RuntimeException{
    public NotValuesException(){
        super(String.format("No hay datos en la base datos"));
    }
}
