public class SelectionSort implements AlgoritmoDeOrdenacao {

    @Override
    public void ordenar(int[] ar, int n, Resultados resultados) {
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            // Encontra o índice do menor elemento restante
            for (int j = i + 1; j < n; j++) {
                resultados.comparacoes++;
                if (ar[j] < ar[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            // Só troca se o índice for diferente
            if (i != indiceMenor) {
                int aux = ar[i];
                ar[i] = ar[indiceMenor];
                ar[indiceMenor] = aux;
                resultados.trocas++;
            }
        }
    }
}