public class Cronometro extends Thread implements Runnable {
    private boolean rodando = true;
    private int contadorS = 0;
    private int contadorM = 0;
    public void pararCronometro() {
        rodando = false;
    }

    @Override
    public void run() {
        while (rodando == true) {
            for (int n = 0; n < 100 && rodando; n++) {
                Janela.lMilesimo.setText(n + "");
                try {
                    Thread.sleep(10);
                } catch (Exception erro) {
                }
                if (n == 99) {
                    contadorS++;
                    Janela.lSegundo.setText(contadorS + "");
                    if (contadorS == 9) {
                        contadorS = -1;
                    }
                    if (contadorS == 0) {
                        contadorM++;
                        Janela.lMinuto.setText(contadorM + "");
                    }
                }
            }
        }
    }
}

