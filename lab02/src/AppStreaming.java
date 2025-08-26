import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AppStreaming {
    public static void main(String[] args) {
        List<Midia> midias = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n1 - Adicionar novo Filme");
            System.out.println("2 - Adicionar nova Série");
            System.out.println("3 - Listar todas as mídias");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o título do filme: ");
                    String tituloFilme = scanner.nextLine();
                    System.out.print("Digite a duração do filme (em minutos): ");
                    long duracaoFilme = scanner.nextLong();
                    scanner.nextLine();

                    Filme filme = new Filme(tituloFilme, duracaoFilme);
                    midias.add(filme);
                    System.out.println("\nFilme adicionado.");
                    break;

                case 2:
                    System.out.print("\nDigite o título da série: ");
                    String tituloSerie = scanner.nextLine();
                    Serie serie = new Serie(tituloSerie);

                    for (int i = 1; i <= 2; i++) {
                        Temporada temporada = new Temporada(i);

                        for (int j = 1; j <= 2; j++) {
                            System.out.print("\nDigite o título do Episódio " + j + " da Temporada " + i + ": ");
                            String tituloEpisodio = scanner.nextLine();
                            System.out.print("Digite a duração do Episódio " + j + " (em minutos): ");
                            long duracaoEpisodio = scanner.nextLong();
                            scanner.nextLine();

                            Episodio episodio = new Episodio(tituloEpisodio, duracaoEpisodio);
                            temporada.adicionar(episodio);
                        }
                        serie.adicionar(temporada);
                    }

                    midias.add(serie);
                    System.out.println("\nSérie adicionada.");
                    break;

                case 3:
                    System.out.println("\nMídias cadastradas:");
                    for (Midia m : midias) {
                        System.out.println(m.info());
                    }
                    break;

                case 4:
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
