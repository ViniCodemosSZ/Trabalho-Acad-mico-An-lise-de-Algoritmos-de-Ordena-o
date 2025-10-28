public class CocktailSort implements AlgoritmoDeOrdenacao {

    @Override
    public void ordenar(int[] ar, int n, Resultados resultados) {
        boolean trocou = true;
        int inicio = 0;
        int fim = n - 1;

        while (trocou) {
            // Passada da esquerda para a direita
            trocou = false;
            for (int i = inicio; i < fim; i++) {
                resultados.comparacoes++;
                if (ar[i] > ar[i + 1]) {
                    int aux = ar[i];
                    ar[i] = ar[i + 1];
                    ar[i + 1] = aux;
                    resultados.trocas++;
                    trocou = true;
                }
            }
            // Se não trocou está ordenado
            if (!trocou) {
                break;
            }
            fim--;

            //  Passada da direita para a esquerda
            trocou = false;
            for (int i = fim; i > inicio; i--) {
                resultados.comparacoes++;
                if (ar[i] < ar[i - 1]) {
                    int aux = ar[i];
                    ar[i] = ar[i - 1];
                    ar[i - 1] = aux;
                    resultados.trocas++;
                    trocou = true;
                }
            }
            inicio++;
        }
    }
}