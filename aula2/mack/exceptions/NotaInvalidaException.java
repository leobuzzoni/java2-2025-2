package mack.exceptions;

public class NotaInvalidaException extends Exception{
    public NotaInvalidaException(String s){
        super("Nota inválida - não aceita nota negativa");
    }
}
