import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame implements ActionListener {

    //criando botões
    JButton bCar1 = new JButton("Car 1"); //criando objeto botão
    JButton bCar2 = new JButton("Car 2"); //criando objeto botão
    JButton bStart = new JButton("Start"); //criando objeto botão
    JButton bSair = new JButton("Sair");
    JButton bFinish = new JButton("Finish");

    //criando fontes
    Font fAI10 = new Font("Arial", Font.ITALIC, 10);
    Font fAB10 = new Font("Arial", Font.BOLD, 10);

    //Método que cria ação do botão
    public void actionPerformed(ActionEvent e) { //implementa a ação execultada ao clicar no botão
        if (e.getSource() == bCar1) {
            JOptionPane.showMessageDialog(null, "O carro 1 deu mais uma volta!");
        } else if (e.getSource() == bCar2) {
            JOptionPane.showMessageDialog(null, "O carro 2 deu mais uma volta!");
        } else if (e.getSource() == bStart) {
            JOptionPane.showMessageDialog(null, "A Corrida iniciou!");
        } else if (e.getSource() == bFinish) {
            JOptionPane.showMessageDialog(null, "A Corrida iniciou!");
        } else if (e.getSource() == bSair) {
            System.exit(0);
        }
    }

    //método que cria Frame e seta os elementos
    public Janela() {

        JFrame jf = new JFrame(); //Cria o objeto Janela // obsoleto caso eu use o extends JFrame

        setTitle("Titulo Titulo"); //add o titulo
        setSize(500, 500); //seta o tamanho (altura / largura)
        setVisible(true); //Deixa a janela visivel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //encerra a execulção após fechar o programa
        setLocationRelativeTo(null); //seta a abertura do programa no centro
        setResizable(false); // bloqueia o redimencionamento da janela

        bCar1.addActionListener(this);
        bCar2.addActionListener(this);
        bStart.addActionListener(this);
        bFinish.addActionListener(this);
        bSair.addActionListener(this);

        setLayout(null);//Retira o Layaout pré programado, fazendo com que eu programe o layout de cada coisa
        //edita tamanho, posição e fonte dos botões
        bStart.setBounds(200, 240, 100, 60); //Define o tamanho e a posição do botão
        bStart.setFont(fAB10);
        bCar1.setBounds(150, 300, 100, 60); //Define o tamanho e a posição do botão
        bCar1.setFont(fAB10);
        bCar2.setBounds(250, 300, 100, 60); //Define o tamanho e a posição do botão
        bCar2.setFont(fAB10);
        bFinish.setBounds(200, 360, 100, 60); //Define o tamanho e a posição do botão
        bFinish.setFont(fAB10);
        bSair.setBounds(420, 400, 60, 60); //Define o tamanho e a posição do botão
        bSair.setFont(fAI10);

        //add botões na janela
        getContentPane().add(bCar1); //add botão
        getContentPane().add(bCar2); //add botão
        getContentPane().add(bStart); //add botão
        getContentPane().add(bFinish); //add botão
        getContentPane().add(bSair); //add botão
        
    }

    public static void main(String[] args) {
        new Janela();
    }
}