public class Main {

    public static void main(String[] args) {
        // Definição dos Vetores
        int[] vetor1 = { 12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28 };
        int n1 = 20;
        int[] vetor2 = { 5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32 };
        int n2 = 20;
        int[] vetor3 = { 99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6 };
        int n3 = 20;

        // Estruturas dos vetores
        int[][] vetores = { vetor1, vetor2, vetor3 };
        int[] tamanhos = { n1, n2, n3 };
        String[] nomesVetores = { "Vetor 1 (Aleatório)", "Vetor 2 (Ordenado)", "Vetor 3 (Invertido)" };

        // array da interface
        AlgoritmoDeOrdenacao[] algoritmos = {
                new BubbleSort(),
                new SelectionSort(),
                new CocktailSort(),
                new GnomeSort(),
                new CombSort(),
                new BucketSort()
        };

        String[] nomesAlgoritmos = { "Bubble Sort", "Selection Sort", "Cocktail Sort", "Gnome Sort", "Comb Sort", "Bucket Sort" };

        // Matrizes para armazenar os resultados
        long[][] todasComparacoes = new long[6][3];
        long[][] todasTrocas = new long[6][3];

        System.out.println("Iniciando testes...");
        System.out.println();

        // Testes
        for (int i = 0; i < 3; i++) {
            System.out.println("Processando " + nomesVetores[i]);
            int[] vetorAtual = vetores[i];
            int n = tamanhos[i];

            // Itera sobre os algoritmos
            for (int j = 0; j < 6; j++) {

                // Copia o vetor original para não testar um vetor já ordenado
                int[] copia = copiarVetor(vetorAtual, n);

                // Cria o objeto de Resultados
                Resultados resultados = new Resultados();
                String nomeAlg = nomesAlgoritmos[j];

                System.out.print("  - " + nomeAlg + "...");

                algoritmos[j].ordenar(copia, n, resultados);

                //  Salva os resultados
                todasComparacoes[j][i] = resultados.comparacoes;
                todasTrocas[j][i] = resultados.trocas;
                System.out.println(" concluído.");
            }
            System.out.println();
        }

        System.out.println("Testes concluídos.");
        System.out.println();

        // Impressão das Tabelas
        imprimirTabela("Comparações (Iterações)", nomesAlgoritmos, nomesVetores, todasComparacoes);
        imprimirTabela("Trocas (Movimentos)", nomesAlgoritmos, nomesVetores, todasTrocas);
    }

    public static int[] copiarVetor(int[] original, int n) {
        int[] copia = new int[n];
        for (int i = 0; i < n; i++) {
            copia[i] = original[i];
        }
        return copia;
    }

    public static void imprimirTabela(String titulo, String[] algs, String[] vets, long[][] dados) {
        System.out.println("--- Tabela de " + titulo + " ---");

        System.out.printf("%-17s", "Algoritmo");
        for (int i = 0; i < 3; i++) {
            System.out.printf(" | %-19s", vets[i]);
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");

        for (int i = 0; i < 6; i++) {
            System.out.printf("%-17s", algs[i]);
            for (int j = 0; j < 3; j++) {
                System.out.printf(" | %-19d", dados[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}