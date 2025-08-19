package mack.principal;

import java.util.Scanner;

import mack.exceptions.NomeInvalidoException;
import mack.exceptions.NotaInvalidaException;
import mack.service.CadastroAluno;

public class Main {
    public static void main(String[] args) throws NotaInvalidaException, NomeInvalidoException {
        Scanner scan = new Scanner(System.in);
        CadastroAluno cad = new CadastroAluno();
        String nome = "";
        double nota = "";

        try{
            System.out.println("Digite o nome: ");
            nome = scan.nextLine();

            System.out.println("Digite a nota: ");
            double nota = Double.parseDouble(scan.nextLine());


            cad.cadastrar(nome, nota);
        } catch(NumberFormatException nfe){
            System.out.println("Nota digitada invalida - finalizando");
        } catch(NotaInvalidaException e) {
            System.out.println("A nota informada é inválida - atribuindo 0 ao aluno");
            // e.printStackTrace();
            cad.cadastrar(nome, nota = 0);
        } catch(NomeInvalidoException e) {
            e.printStackTrace();
        }

        List<Aluno> res = cad.getAlunos();

        for (Aluno alunos in res){
            
        }
        
    }
}
