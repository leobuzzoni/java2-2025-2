import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {
        ContaDao dao;
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.bwhmjlaqsndctdrgxclu&password=GiCz8El9K0UfQFTU";
        dao = new ContaDao(ConnectionFactory.getConnection(url));
        Scanner sc = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n(1) Listar todas as contas");
            System.out.println("(2) Buscar uma conta pelo número");
            System.out.println("(3) Criar uma nova conta");
            System.out.println("(4) Alterar o saldo de uma conta");
            System.out.println("(5) Apagar uma conta");
            System.out.println("(0) Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "0":
                    sair = true;
                    break;

                case "1":
                    List<Conta> contas = dao.lerTodas();
                    System.out.println("\nContas:");
                    for (Conta conta : contas) {
                        System.out.println(conta);
                    }

                    break;

                case "2":
                    System.out.print("Número da conta: ");
                    long numeroBusca = Long.parseLong(sc.nextLine());
                    Conta encontrada = dao.buscarPeloNumero(numeroBusca);
                    if (encontrada != null) {
                        System.out.println("Conta encontrada: " + encontrada);
                    }
                    break;

                case "3":
                    System.out.print("Número da conta: ");
                    long numeroNova = Long.parseLong(sc.nextLine());
                    System.out.print("Saldo: ");
                    BigDecimal saldoNovo = new BigDecimal(sc.nextLine());

                    Conta novaConta = new Conta(numeroNova, saldoNovo);
                    boolean criada = dao.criar(novaConta);
                    if (criada) {
                        System.out.println("Conta criada com sucesso.");
                    }
                    break;

                case "4":
                    System.out.print("Número da conta: ");
                    long numeroAtualizar = Long.parseLong(sc.nextLine());
                    Conta contaParaAtualizar = dao.buscarPeloNumero(numeroAtualizar);

                    System.out.println("Saldo atual: " + contaParaAtualizar.getSaldo());
                    System.out.print("Informe o novo saldo: ");
                    BigDecimal novoSaldo = new BigDecimal(sc.nextLine());
                    contaParaAtualizar.setSaldo(novoSaldo);
                    boolean atualizada = dao.atualizar(contaParaAtualizar);
                    if (atualizada) {
                        System.out.println("Saldo atualizado com sucesso.");
                    }
                    break;

                case "5":
                    System.out.print("Número da conta: ");
                    long numeroApagar = Long.parseLong(sc.nextLine());
                    Conta contaParaApagar = dao.buscarPeloNumero(numeroApagar);
                    boolean apagada = dao.apagar(contaParaApagar);
                    if (apagada) {
                        System.out.println("Conta apagada com sucesso.");
                    }

                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        sc.close();
    }
}