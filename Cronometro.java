import javax.swing.*;
import java.awt.event.ActionListener;

public class Cronometro extends Thread implements Runnable {
    public void Cronometro() {
        int contadorS = 0;
        int contadorM = 0;
        while (true) {
            for (int n = 0; n < 100; n++) {
                Janela.lMilesimo.setText(n + "");
                try {Thread.sleep(10);} catch (Exception erro) {}
                if (n == 99) {
                    contadorS++;
                    Janela.lSegundo.setText(contadorS + "");
                    if (contadorS == 10) {
                        contadorS = 0;
                    }
                    if (contadorS == 9) {
                        contadorM++;
                        Janela.lMinuto.setText(contadorM + "");
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        Cronometro();
    }
}


