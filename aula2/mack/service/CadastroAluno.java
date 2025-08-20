package mack.service;

import java.util.ArrayList;
import java.util.List;

import mack.exceptions.NomeInvalidoException;
import mack.exceptions.NotaInvalidaException;
import mack.model.Aluno;

public class CadastroAluno {
    private List<Aluno> alunos;

    public CadastroAluno() {
        this.alunos = new ArrayList<>();
    }

    public void cadastrar(String nome, double nota) throws NotaInvalidaException, NomeInvalidoException {
        if (nome == null || "".equals(nome)) {
            throw new NomeInvalidoException();
        }
        if (nota < 0 || nota > 10)
            throw new NotaInvalidaException();

        this.cadastrar(new Aluno(nome, nota));
    }

    public void cadastrar(Aluno a) {
        this.alunos.add(a);
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public double calcularMedia() {
        double somaNotas = 0;
        for (Aluno aluno : alunos) {
            somaNotas += aluno.getNota();
        }
        return somaNotas / alunos.size();
    }

    public Aluno getAlunoComMaiorNota() {
        Aluno maiorNotaAluno = null;
        for (Aluno aluno : alunos) {
            if (maiorNotaAluno == null || aluno.getNota() > maiorNotaAluno.getNota()) {
                maiorNotaAluno = aluno;
            }
        }
        return maiorNotaAluno;
    }

    public Aluno getAlunoComMenorNota() {
        Aluno menorNotaAluno = null;
        for (Aluno aluno : alunos) {
            if (menorNotaAluno == null || aluno.getNota() < menorNotaAluno.getNota()) {
                menorNotaAluno = aluno;
            }
        }
        return menorNotaAluno;
    }
}
