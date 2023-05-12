import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public abstract class Main extends JFrame implements ActionListener {

    private Cronometro cronometro = new Cronometro();
    private static PrintBloc bloPrint = new PrintBloc();
    int contador = 0;
    int contador2 = 0;
    int posicao = 0;
    int min;
    int seg;
    int mil;
    String nomes;
    String tempo;
    String volta1;
    String tempo1;
    String volta2;
    String tempo2;

    //criando botões
    JButton bCar1 = new JButton("Caro 1"); //criando objeto botão
    JButton bCar2 = new JButton("Caro 2"); //criando objeto botão
    JButton bStart = new JButton("Start"); //criando objeto botão
    JButton bFinish = new JButton("Stop");
    JButton bSair = new JButton("Sair");
    JButton bResultados = new JButton("Resultado:");

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

    JPanel painel = new JPanel();
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
    private java.lang.Object Object;

    //Método que cria ação do botão

    @Override
    public void actionPerformed(ActionEvent e) { //implementa a ação execultada ao clicar no botão

        if (e.getSource() == bCar1) {
            posicao++;
            contador++;
            lContVolta1.setText(String.valueOf(contador));
            bdCar1();
            System.out.println(posicao);
            if (posicao == 1) {
                volta1 = "Carro 1";
            }
            if (posicao == 3) {
                volta2 = "Carro 1";
            }
            if (posicao == 1) {
                tempo1 = tempo;
            }
            if (posicao == 3) {
                tempo2 = tempo;
            }
        }
        if (e.getSource() == bCar2) {
            posicao++;
            contador2++;
            lContVolta2.setText(String.valueOf(contador2));
            bdCar2();
            System.out.println(posicao);
            if (posicao == 1) {
                volta1 = "Carro 2";
            }
            if (posicao == 3) {
                volta2 = "Carro 2";
            }
            if (posicao == 1) {
                tempo1 = tempo;
            }
            if (posicao == 3) {
                tempo2 = tempo;
            }
        }
        if (e.getSource() == bStart) {
            cronometro.start();
            bdStart();
            bStart.setEnabled(false);
        }
        if (e.getSource() == bFinish) {
            cronometro.pararCronometro();
            String nome = cNome.getText();
            min = Integer.parseInt(lMinuto.getText());
            seg = Integer.parseInt(lSegundo.getText());
            mil = Integer.parseInt(lMilesimo.getText());
            tempo = min + ":" + seg + ":" + mil;
            JOptionPane.showMessageDialog(null, "A Corrida " + nome + " foi encerrada!" +
                    "\nPara iniciar outra reinicie o programa!" +
                    "\nO tempo total foi de: " + tempo);
        }
        if (e.getSource() == bSair) {
            System.exit(0);
        }
        if (e.getSource() == bResultados) {
            JOptionPane.showMessageDialog(null, "VOLTA 1:" +
                    "\nMelhor tempo: " + volta1 + " com o tempo: " + tempo1 + "! " +
                    "\n\nVOLTA 2:\nMelhor tempo:" + volta2 + " com o tempo: " + tempo2 + ". " +
                    "\n\nVENCEDOR DA CORRIDA " + nomes + ": " + volta2 + "!");
        }
    }

    Connection conecta() {
        String url = "jdbc:mysql://localhost/cronus_start?useSSL=false&serverTimezone=UTC";
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
            return con;
        } catch (Exception erro) {
            return null;
        }
    }

    public void bdStart() {
        Connection con = conecta();
        try {
            Statement st = con.createStatement();
            String nomes = cNome.getText();
            int result = st.executeUpdate("insert into race (NOME) values ('" + nomes + "')");
        } catch (Exception erro) {
        }
    }

    public void bdCar1() {
        Connection con = conecta();
        try {
            Statement st = con.createStatement();
            nomes = cNome.getText();
            min = Integer.parseInt(lMinuto.getText());
            seg = Integer.parseInt(lSegundo.getText());
            mil = Integer.parseInt(lMilesimo.getText());
            tempo = min + ":" + seg + ":" + mil;
            if (posicao == 1) {
                int result = st.executeUpdate("update race set volta1_carro1 = 1, tempo1_carro1 ='" + tempo + "' WHERE NOME = '" + nomes + "';");
            } else if (posicao == 2) {
                int result = st.executeUpdate("update race set volta1_carro2 = 1, tempo1_carro2 ='" + tempo + "' WHERE NOME = '" + nomes + "';");
            } else if (posicao == 3) {
                int result = st.executeUpdate("update race set volta2_carro1 = 1, tempo2_carro1 ='" + tempo + "' WHERE NOME = '" + nomes + "';");
            } else if (posicao == 4) {
                int result = st.executeUpdate("update race set volta2_carro2 = 1, tempo2_carro2 ='" + tempo + "' WHERE NOME = '" + nomes + "';");
            }
        } catch (Exception erro) {
        }
    }

    public void bdCar2() {
        Connection con = conecta();
        try {
            Statement st = con.createStatement();
            nomes = cNome.getText();
            String tempos = tempo;
            min = Integer.parseInt(lMinuto.getText());
            seg = Integer.parseInt(lSegundo.getText());
            mil = Integer.parseInt(lMilesimo.getText());
            tempo = min + ":" + seg + ":" + mil;
            if (posicao == 1) {
                int result = st.executeUpdate("update race set volta1_carro1 = 2, tempo1_carro1 ='" + tempo + "' WHERE NOME = '" + nomes + "';");
            } else if (posicao == 2) {
                int result = st.executeUpdate("update race set volta1_carro2 = 2, tempo1_carro2 ='" + tempo + "' WHERE NOME = '" + nomes + "';");
            } else if (posicao == 3) {
                int result = st.executeUpdate("update race set volta2_carro1 = 2, tempo2_carro1 ='" + tempo + "' WHERE NOME = '" + nomes + "';");
            } else if (posicao == 4) {
                int result = st.executeUpdate("update race set volta2_carro2 = 2, tempo2_carro2 ='" + tempo + "' WHERE NOME = '" + nomes + "';");
            }
        } catch (Exception erro) {
        }
    }

    //método que cria Frame e seta os elementos
    public Main() {

        setTitle("Cronus Start 1.0"); //add o titulo
        setSize(500, 500); //seta o tamanho (altura / largura)
        setVisible(true); //Deixa a janela visivel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //encerra a execulção após fechar o programa
        setLocationRelativeTo(null); //seta a abertura do programa no centro
        setResizable(false); // bloqueia o redimencionamento da janela
        setBackground(cor2);
        setFocusable(true);//manter o foco no JF
        setLayout(null);//Retira o Layaout pré programado, fazendo com que eu programe o layout de cada coisa

        painel.setSize(500, 500);
        painel.setLayout(null);

        bCar1.addActionListener(this);
        bCar2.addActionListener(this);
        bStart.addActionListener(this);
        bFinish.addActionListener(this);
        bSair.addActionListener(this);
        bResultados.addActionListener(this);

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
        cNome.setBounds(245, 205, 75, 20);

        //add botões na janela
        painel.add(bCar1); //add botão
        painel.add(bCar2); //add botão
        painel.add(bStart); //add botão
        painel.add(bFinish); //add botão
        painel.add(bSair); //add botão
        painel.add(bResultados); //add botão
        painel.add(lVoltac1);
        painel.add(lVoltac2);
        painel.add(lContVolta1);
        painel.add(lContVolta2);
        painel.add(lTime);
        painel.add(lMinuto);
        painel.add(lSegundo);
        painel.add(lMilesimo);
        painel.add(lTitulo);
        painel.add(lPonto);
        painel.add(lPonto2);
        painel.add(lCop);
        painel.add(lNome);
        painel.add(cNome);
        this.add(painel);

    }


    public static void main(String[] args) throws SQLException {
        new Main() {
        };
        bloPrint.blockPrintsScreen();
    }
}