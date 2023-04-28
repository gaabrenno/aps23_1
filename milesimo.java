import javax.swing.*;
import java.awt.*;

public class milesimo {
    JLabel lMilesimo = new JLabel("0");
    public void contagem(){
        int n =0;
        while(true){
            lMilesimo.setFont(Font.getFont(n+""));
            n++;
            try {
                Thread.sleep(1000);
            }catch (Exception erro){}
        }
    }
    
    public static void main (String[]args){
        
    }

}
