package mack.principal;

import java.util.List;
import java.util.Scanner;

import mack.exceptions.NomeInvalidoException;
import mack.exceptions.NotaInvalidaException;
import mack.model.Aluno;
import mack.service.CadastroAluno;

public class Main {
    public static void main(String[] args) throws NotaInvalidaException, NomeInvalidoException {
        Scanner scan = new Scanner(System.in);
        CadastroAluno cad = new CadastroAluno();

        System.out.println("Quantos alunos deseja cadastrar?");
        int numAlunos = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numAlunos; i++) {
            String nome = "";

            try {

                System.out.print("Digite o nome: ");
                nome = scan.nextLine();

                System.out.print("Digite a nota: ");
                double nota = Double.parseDouble(scan.nextLine());

                cad.cadastrar(nome, nota);
            } catch (NumberFormatException nfe) {
                System.out.println("Nota digitada inválida.");
            } catch (NotaInvalidaException e) {
                System.out.println("A nota informada é invalida - atribuindo 0 ao aluno.");
                cad.cadastrar(nome, 0);
            } catch (NomeInvalidoException e) {
                System.out.println("Nome inválido. O nome não pode ser vazio.");
            }

        }

        List<Aluno> alunos = cad.getAlunos();

        System.out.println("\nAlunos cadastrados:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome() + " - Nota: " + aluno.getNota());
        }

        double media = cad.calcularMedia();
        System.out.println("\nMédia geral da turma: " + media);

        Aluno maiorNotaAluno = cad.getAlunoComMaiorNota();
        Aluno menorNotaAluno = cad.getAlunoComMenorNota();

        System.out.println(
                "\nAluno com maior nota: " + maiorNotaAluno.getNome() + " - Nota: " + maiorNotaAluno.getNota());
        System.out
                .println("Aluno com menor nota: " + menorNotaAluno.getNome() + " - Nota: " + menorNotaAluno.getNota());
    }
}
