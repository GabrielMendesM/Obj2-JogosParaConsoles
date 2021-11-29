import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class GabrielParaleloFrame extends JFrame {
    private static final int MAX_CARROS = 5;

    private static boolean isRodando;
    private GabrielParaleloCarro[] carros = new GabrielParaleloCarro[MAX_CARROS];
    private GabrielParaleloPanel container;

    public GabrielParaleloFrame() {
        super("Objeto 2");
    }

    public void comecar() {
        setPreferredSize(new Dimension(865, 639));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);

        for (int i = 0; i < MAX_CARROS; i++) {
            carros[i] = new GabrielParaleloCarro(800, i + 1, 0, (i * 80) + 120, 10, 15, container, getGraphics());
        }

        container = new GabrielParaleloPanel(carros);

        getContentPane().add(container);
        
        container.addFundo();

        pack();

        setIsRodando(true);
        for (int i = 0; i < carros.length; i++) {
            carros[i].start();
        }
    }

    public void parar() {
        setIsRodando(false);
        
        try {
            for (int i = 0; i < carros.length; i++) {
                carros[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setVisible(false);
        dispose();
    }

    public static boolean getIsRodando() {
        return isRodando;
    }

    public static void setIsRodando(boolean rodar) {
        isRodando = rodar;
    }
}
