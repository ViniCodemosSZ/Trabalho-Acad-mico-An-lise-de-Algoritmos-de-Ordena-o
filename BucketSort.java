public class BucketSort implements AlgoritmoDeOrdenacao {

    @Override
    public void ordenar(int[] ar, int n, Resultados resultados) {
        if (n <= 0) {
            return;
        }

        //  Encontrar o valor máximo e mínimo
        int min = ar[0];
        int max = ar[0];
        for (int i = 1; i < n; i++) {
            resultados.comparacoes++;
            if (ar[i] < min) {
                min = ar[i];
            } else {
                resultados.comparacoes++;
                if (ar[i] > max) {
                    max = ar[i];
                }
            }
        }

        //  Criar os buckets
        int numBaldes = 10;
        int[][] baldes = new int[numBaldes][n];
        int[] tamanhosBaldes = new int[numBaldes];

        //  Distribuir os elementos nos buckets
        int divisor = (max - min) / numBaldes + 1;

        for (int i = 0; i < n; i++) {
            int valor = ar[i];
            int j = (valor - min) / divisor;

            if (j >= numBaldes) {
                j = numBaldes - 1;
            }

            baldes[j][tamanhosBaldes[j]] = valor;
            tamanhosBaldes[j]++;
        }

        //  Ordenar cada bucket individualmente (usando Insertion Sort)
        for (int i = 0; i < numBaldes; i++) {
            if (tamanhosBaldes[i] > 0) {
                insertionSort(baldes[i], tamanhosBaldes[i], resultados);
            }
        }

        // Juntar os buckets ordenados de volta no array original
        int indice = 0;
        for (int i = 0; i < numBaldes; i++) {
            for (int j = 0; j < tamanhosBaldes[i]; j++) {
                ar[indice] = baldes[i][j];
                indice++;
            }
        }
    }

    private void insertionSort(int[] ar, int n, Resultados resultados) {
        for (int i = 1; i < n; i++) {
            int chave = ar[i];
            int j = i - 1;

            resultados.comparacoes++;
            while (j >= 0 && ar[j] > chave) {
                ar[j + 1] = ar[j];
                resultados.trocas++;
                j--;
                resultados.comparacoes++;
            }
            ar[j + 1] = chave;
        }
    }
}