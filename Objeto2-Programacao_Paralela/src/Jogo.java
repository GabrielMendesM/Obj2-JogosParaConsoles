import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Jogo extends JFrame {
    private static final int MAX_CARROS = 5;

    private static String vencedor = null;

    private static boolean isRodando;
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

        setIsRodando(true);

        for (int i = 0; i < carros.length; i++) {
            carros[i].start();
        }
    }

    public void declararVencedor(String nome) {
        if (vencedor == null) {
            vencedor = nome;
        }
    }

    public static void parar() {
        
        /*
        setIsRodando(false);
        
        for (int i = 0; i < carros.length; i++) {
            try {
                carros[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        */
        System.out.println("PARAR");
    }
    
    public static boolean getIsRodando() {
        return isRodando;
    }

    public static void setIsRodando(boolean rodar) {
        isRodando = rodar;
    }

    public static String getVencedor() {
        return vencedor;
    }
}
