package mack.exceptions;

public class NotaInvalidaException extends Exception {
    public NotaInvalidaException() {
        super("Nota Invalida - não aceita nota negativa ou maior que 10");
    }
}
