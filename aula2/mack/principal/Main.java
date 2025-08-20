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
        String nome = "";
        try {
            System.out.println("Digite o nome: ");
            nome = scan.nextLine();

            System.out.println("Digite a nota: ");
            double nota = Double.parseDouble(scan.nextLine());
            cad.cadastrar(nome, nota);

        } catch (NumberFormatException nfe) {
            System.out.println("Nota digitada invalida - finalizando");
        } catch (NotaInvalidaException e) {
            System.out.println("A nota informada e invalida - atribuindo 0 ao aluno");
            // e.printStackTrace();
            cad.cadastrar(nome, 0);
        } catch (NomeInvalidoException e) {
            e.printStackTrace();
        }

        List<Aluno> res = cad.getAlunos();

        for (Aluno aluno : res) {
            System.out.println(aluno.getNome() + " - " + aluno.getNota());
        }

    }
}