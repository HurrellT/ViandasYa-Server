package viandasYaModel.Exceptions;

public class NonexistentMenuException extends RuntimeException  {

    public NonexistentMenuException() {
        super("El menú ingresado es inexistente");
    }
}
