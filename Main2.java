package com.tabeladobrasileirao;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        String[] times = {
            "América Mineiro", "Athletico-PR", "Atlético Mineiro", "Bahia", "Botafogo", "Corinthians", "Coritiba",
            "Cruzeiro", "Cuiabá", "Flamengo", "Fluminense", "Fortaleza", "Goiás", "Grêmio", "Internacional",
            "Palmeiras", "Bragantino",
            "Santos", "São Paulo", "Vasco"
        };
        int[] pontuacoes = new int[times.length];
        int[] vitorias = new int[times.length];
        int[] cartoesAmarelos = new int[times.length];

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nEscolha uma opção: ");
            System.out.println("1 - Visualizar Tabela");
            System.out.println("2 - Editar Pontuação e Vitórias");
            System.out.println("3 - Editar Cartões Amarelos");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    scanner.close();
                    return;
                case 1:
                    ordenarTabela(times, pontuacoes, vitorias); 
                    exibirTabela(times, pontuacoes, cartoesAmarelos, vitorias, scanner);
                    break;
                case 2:
                    editarPontuacao(times, pontuacoes, cartoesAmarelos, vitorias, scanner);
                    break;
                case 3:
                    editarCartoesAmarelo(times, pontuacoes, cartoesAmarelos, vitorias, scanner);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static void exibirTabela(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] vitorias, Scanner scanner) {
        System.out.println("\nPosição | Time               | Pontuação | Cartões Amarelos | Vitórias");
        for (int i = 0; i < times.length; i++) {
            System.out.printf("%-7d | %-18s | %-9d | %-16d | %-8d%n", (i + 1), times[i], pontuacoes[i], cartoesAmarelos[i], vitorias[i]);
        }
    }

    public static void editarPontuacao(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] vitorias, Scanner scanner) {
        while (true) {
            System.out.println("\nTimes disponíveis para edição: ");
            exibirTabela(times, pontuacoes, cartoesAmarelos, vitorias, scanner);
            System.out.println("Escolha o número do time para editar a pontuação (ou 0 para voltar): ");

            int posicao = scanner.nextInt();

            if (posicao == 0) {
                break;
            }
            if (posicao >= 1 && posicao <= times.length) {
                System.out.println("Digite a nova pontuação para " + times[posicao - 1] + ":");
                int novaPontuacao = scanner.nextInt();

                if (novaPontuacao >= 0) {
                    pontuacoes[posicao - 1] = novaPontuacao;

                    System.out.println("Digite o número de vitórias para " + times[posicao - 1] + ":");
                    int numVitorias = scanner.nextInt();

                    if (numVitorias >= 0) {
                        vitorias[posicao - 1] = numVitorias;
                    } else {
                        System.out.println("O número de vitórias não pode ser negativo.");
                    }
                } else {
                    System.out.println("A pontuação não pode ser negativa.");
                }
            } else {
                System.out.println("Posição inválida. Tente novamente.");
            }

            scanner.nextLine();
        }
    }

    public static void editarCartoesAmarelo(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] vitorias, Scanner scanner) {
        while (true) {
            System.out.println("\nTimes disponíveis para edição: ");
            exibirTabela(times, pontuacoes, cartoesAmarelos, vitorias, scanner);
            System.out.println("Escolha o número do time para editar os cartões amarelos (ou 0 para voltar): ");
            int posicao = scanner.nextInt();

            if (posicao == 0) {
                break;
            }
            if (posicao >= 1 && posicao <= times.length) {
                System.out.println("Digite o novo número de cartões amarelos para " + times[posicao - 1] + ":");
                int novosCartoes = scanner.nextInt();
                if (novosCartoes >= 0) {
                    cartoesAmarelos[posicao - 1] = novosCartoes;
                } else {
                    System.out.println("O número de cartões amarelos não pode ser negativo.");
                }
            } else {
                System.out.println("Posição inválida. Tente novamente.");
            }
            scanner.nextLine();
        }
    }

    public static void ordenarTabela(String[] times, int[] pontuacoes, int[] vitorias) {
        boolean trocou;
        int n = times.length;

        do {
            trocou = false;
            for (int i = 0; i < n - 1; i++) {
                if (pontuacoes[i] < pontuacoes[i + 1] || (pontuacoes[i] == pontuacoes[i + 1] && vitorias[i] < vitorias[i + 1])) {
                    // Trocar times, pontuações e vitórias
                    String tempTime = times[i];
                    times[i] = times[i + 1];
                    times[i + 1] = tempTime;

                    int tempPontuacao = pontuacoes[i];
                    pontuacoes[i] = pontuacoes[i + 1];
                    pontuacoes[i + 1] = tempPontuacao;

                    int tempVitorias = vitorias[i];
                    vitorias[i] = vitorias[i + 1];
                    vitorias[i + 1] = tempVitorias;

                    trocou = true;
                }
            }
            n--;
        } while (trocou);
    }
}
