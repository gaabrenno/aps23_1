import java.text.DecimalFormat;

public class Cronometro extends Thread implements Runnable {
    private DecimalFormat decimal = new DecimalFormat("00");
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
                Main.lMilesimo.setText(decimal.format(n));
                try {
                    Thread.sleep(10);
                } catch (Exception erro) {
                }
                if (n == 99) {
                    contadorS++;
                    Main.lSegundo.setText(decimal.format(contadorS));
                    if (contadorS == 59) {
                        contadorS = -1;
                    }
                    if (contadorS == 0) {
                        contadorM++;
                        Main.lMinuto.setText(decimal.format(contadorM ));
                    }
                }
            }
        }
    }
}

