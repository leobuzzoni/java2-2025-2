package mack.exceptions;

public class NomeInvalidoException extends Exception{
    public NomeInvalidoException(String s){
        super("Nota inválida - não aceita nota negativa");
    }
}
