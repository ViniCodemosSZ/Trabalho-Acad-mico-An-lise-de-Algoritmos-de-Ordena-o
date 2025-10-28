public class BubbleSort implements AlgoritmoDeOrdenacao {

    @Override
    public void ordenar(int[] ar, int n, Resultados resultados) {
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                resultados.comparacoes++;
                if (ar[j] > ar[j + 1]) {
                    // Troca
                    int aux = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = aux;
                    resultados.trocas++;
                    trocou = true;
                }
            }
            // Se não houve trocas nesta passada, o vetor está ordenado
            if (!trocou) {
                break;
            }
        }
    }
}