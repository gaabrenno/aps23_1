import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame implements ActionListener {


    int contador = 0;
    int contador2 = 0;
    //criando botões
    JButton bCar1 = new JButton("Car 1"); //criando objeto botão
    JButton bCar2 = new JButton("Car 2"); //criando objeto botão
    JButton bStart = new JButton("Start"); //criando objeto botão
    JButton bFinish = new JButton("Stop");
    JButton bSair = new JButton("Sair");
    JButton bResultados = new JButton("Resultados");

    //Criando Label
    JLabel lTime = new JLabel("Time");
    static JLabel lMinuto = new JLabel("00");
    static JLabel lSegundo = new JLabel("00");
    static JLabel lMilesimo = new JLabel("00");
    JLabel lVoltac1 = new JLabel("Voltas:");
    JLabel lContVolta1 = new JLabel("0");
    JLabel lVoltac2 = new JLabel("Voltas:");
    JLabel lContVolta2 = new JLabel("0");
    JLabel lTitulo = new JLabel("Cronus Start");
    JLabel lPonto = new JLabel(":");
    JLabel lPonto2 = new JLabel(":");
    JLabel lCop = new JLabel("Copyright © 2023 GABRIEL BRENNO.");
    JLabel lNome = new JLabel("Nome da Corrida:");

    JTextField cNome = new JTextField(15);

    //criando fontes
    Font fAI10 = new Font("Arial", Font.ITALIC, 10);
    Font fAB10 = new Font("Arial", Font.BOLD, 10);
    Font fAL75 = new Font("Alfa Slab One Regular", Font.BOLD, 75);
    Font fAL30 = new Font("Alfa Slab One Regular", Font.BOLD, 30);
    Font fAL15 = new Font("Alfa Slab One Regular", Font.BOLD, 15);
    Font fALP15 = new Font("Alfa Slab One Regular", Font.PLAIN, 10);
    Font fAn50 = new Font("Andada Pro", Font.BOLD, 50);

    //criando cores
    Color cor1 = new Color(255, 161, 177, 255);
    Color cor2 = new Color(218, 215, 215);
    int caro1[] = new int[3];
    int caro2[] = new int[3];
    String tempo = lMinuto+":"+lSegundo+":"+lMilesimo;
    //Método que cria ação do botão
    private Cronometro cronometro = new Cronometro();
    @Override
    public void actionPerformed(ActionEvent e) { //implementa a ação execultada ao clicar no botão

        if (e.getSource() == bCar1) {
            contador++;
            lContVolta1.setText(String.valueOf(contador));
        }
        if (e.getSource() == bCar2) {
            contador2++;
            lContVolta2.setText(String.valueOf(contador2));
        }
        if (e.getSource() == bStart) {
            cronometro.start();
        }if (e.getSource() == bFinish) {
            cronometro.pararCronometro();
            JOptionPane.showMessageDialog(null,"A Corrida foi encerrada! Para iniciar outra reinicie o programa!");
        }
        if (e.getSource() == bSair) {
            System.exit(0);
        }
    }

    //método que cria Frame e seta os elementos
    public Janela() {

        setTitle("Cronus Start 1.0"); //add o titulo
        setSize(500, 500); //seta o tamanho (altura / largura)
        setVisible(true); //Deixa a janela visivel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //encerra a execulção após fechar o programa
        setLocationRelativeTo(null); //seta a abertura do programa no centro
        setResizable(false); // bloqueia o redimencionamento da janela
        setBackground(cor2);

        bCar1.addActionListener(this);
        bCar2.addActionListener(this);
        bStart.addActionListener(this);
        bFinish.addActionListener(this);
        bSair.addActionListener(this);

        setLayout(null);//Retira o Layaout pré programado, fazendo com que eu programe o layout de cada coisa
        //edita tamanho, posição e fonte dos botões
        bStart.setBounds(200, 240, 100, 60); //Define o tamanho e a posição do botão
        bStart.setFont(fAB10);//fonte do texto
        bStart.setForeground(Color.BLUE);
        bCar1.setBounds(150, 300, 100, 60); //Define o tamanho e a posição do botão
        bCar1.setFont(fAB10);//fonte do texto
        bCar2.setBounds(250, 300, 100, 60); //Define o tamanho e a posição do botão
        bCar2.setFont(fAB10);//fonte do texto
        bFinish.setBounds(200, 360, 100, 60); //Define o tamanho e a posição do botão
        bFinish.setFont(fAB10);//fonte do texto
        bFinish.setForeground(Color.red);
        bSair.setBounds(420, 400, 60, 60); //Define o tamanho e a posição do botão
        bSair.setFont(fAI10);//fonte do texto
        bSair.setBackground(cor1);//Cor do fundo do botão (setForeground para cor do texto)
        bResultados.setBounds(10, 400, 100, 60); //Define o tamanho e a posição do botão
        bResultados.setFont(fAB10);//fonte do texto

        //Editando Label
        lTitulo.setBounds(95, 3, 500, 100);
        lTitulo.setFont(fAn50);
        lVoltac1.setBounds(80, 260, 60, 60);
        lContVolta1.setBounds(90, 300, 100, 60);
        lContVolta1.setFont(fAL30);
        lVoltac2.setBounds(360, 260, 60, 60);
        lContVolta2.setBounds(370, 300, 100, 60);
        lContVolta2.setFont(fAL30);
        lTime.setBounds(225, 75, 100, 60);
        lTime.setFont(fAL15);
        lNome.setBounds(150, 185, 150, 60);
        lNome.setFont(fALP15);
        lMinuto.setBounds(40, 85, 150, 150);
        lMinuto.setFont(fAL75);
        lSegundo.setBounds(190, 85, 150, 150);
        lSegundo.setFont(fAL75);
        lMilesimo.setBounds(330, 85, 150, 150);
        lMilesimo.setFont(fAL75);
        lPonto.setBounds(165, 90, 150, 150);
        lPonto2.setBounds(305, 90, 150, 150);
        lPonto.setFont(fAL75);
        lPonto2.setFont(fAL75);
        lCop.setBounds(160, 420, 500, 60);
        lCop.setFont(fAI10);
        cNome.setBounds(245,205,75,20);

        //add botões na janela
        getContentPane().add(bCar1); //add botão
        getContentPane().add(bCar2); //add botão
        getContentPane().add(bStart); //add botão
        getContentPane().add(bFinish); //add botão
        getContentPane().add(bSair); //add botão
        getContentPane().add(bResultados); //add botão
        getContentPane().add(lVoltac1);
        getContentPane().add(lVoltac2);
        getContentPane().add(lContVolta1);
        getContentPane().add(lContVolta2);
        getContentPane().add(lTime);
        getContentPane().add(lMinuto);
        getContentPane().add(lSegundo);
        getContentPane().add(lMilesimo);
        getContentPane().add(lTitulo);
        getContentPane().add(lPonto);
        getContentPane().add(lPonto2);
        getContentPane().add(lCop);
        getContentPane().add(lNome);
        getContentPane().add(cNome);
    }

    public static void main(String[] args) {
        new Janela();
    }
}