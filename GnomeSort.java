public class GnomeSort implements AlgoritmoDeOrdenacao {

    @Override
    public void ordenar(int[] ar, int n, Resultados resultados) {
        int i = 0;
        while (i < n) {

            resultados.comparacoes++;
            if (i == 0 || ar[i - 1] <= ar[i]) {
                // Se está em ordem avança
                i++;
            } else {
                // Se não está em ordem troca e volta
                int aux = ar[i];
                ar[i] = ar[i - 1];
                ar[i - 1] = aux;
                i--;
                resultados.trocas++;
            }
        }
    }
}