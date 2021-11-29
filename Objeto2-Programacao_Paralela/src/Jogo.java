import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Jogo extends JFrame {
    private static final int MAX_CARROS = 5;

    private static String vencedor = null;

    private static boolean rodando;

    private static Carro[] carros = new Carro[MAX_CARROS];
    private static ElementoPanel panel;

    public Jogo() {
        super("Objeto 2");
    }

    public void comecar() {
        setPreferredSize(new Dimension(865, 640));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);

        for (int i = 0; i < carros.length; i++) {
            carros[i] = new Carro(0, (i * 80) + 120, 10, 20, 800, i + 1);
        }

        panel = new ElementoPanel(carros);
        
        for (int i = 0; i < carros.length; i++) {
            carros[i].setPanel(panel);
        }

        getContentPane().add(panel);
        
        pack();

        setRodando(true);

        for (int i = 0; i < carros.length; i++) {
            carros[i].start();
        }
    }

    public static void parar() {
        if (acabou() && isRodando()) {
            System.out.println("======================================\n     " + getVencedor().toUpperCase() + " VENCEU A CORRIDA!!!\n======================================");

            setRodando(false);
        
            for (int i = 0; i < carros.length; i++) {
                try {
                    carros[i].join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static boolean isRodando() {
        return rodando;
    }

    public static void setRodando(boolean rodar) {
        rodando = rodar;
    }

    public static String getVencedor() {
        return vencedor;
    }

    public static void setVencedor(String nome) {
        if (vencedor == null) {
            vencedor = nome;
        }
    }

    private static boolean acabou() {
        for (Carro c : carros) {
            if (!c.getChegou()) {
                return false;
            }
        }
        return true;
    }
}
