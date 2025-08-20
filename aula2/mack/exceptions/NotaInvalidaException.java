package mack.exceptions;

public class NotaInvalidaException extends Exception {
    public NotaInvalidaException() {
        super("Nota Invalida - nao aceita nota negativa");
    }
}