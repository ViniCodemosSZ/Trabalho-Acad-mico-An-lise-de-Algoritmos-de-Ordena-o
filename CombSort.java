public class CombSort implements AlgoritmoDeOrdenacao {

    @Override
    public void ordenar(int[] ar, int n, Resultados resultados) {
        double fatorEncolhimento = 1.3;
        int gap = n;
        boolean ordenado = false;

        while (!ordenado) {
            gap = (int) (gap / fatorEncolhimento);

            if (gap <= 1) {
                gap = 1;
                ordenado = true;
            }

            // Loop principal de comparação com o 'gap'
            int i = 0;
            while (i + gap < n) {
                resultados.comparacoes++;
                if (ar[i] > ar[i + gap]) {
                    // Troca
                    int aux = ar[i];
                    ar[i] = ar[i + gap];
                    ar[i + gap] = aux;
                    resultados.trocas++;
                    // Se houve troca não está ordenado
                    ordenado = false;
                }
                i++;
            }
        }
    }
}