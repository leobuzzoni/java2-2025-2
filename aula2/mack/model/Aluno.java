package mack.model;

public class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return this.nome;
    }

    public double getNota() {
        return this.nota;
    }
}
