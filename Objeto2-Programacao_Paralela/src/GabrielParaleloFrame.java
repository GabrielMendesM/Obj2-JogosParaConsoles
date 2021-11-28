import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class GabrielParaleloFrame extends JFrame implements Runnable {
    public static final int THREAD_SLEEP = 100;
    private static final int MAX_CARROS = 5;

    public static boolean isRodando;
    private Thread gameLoop = null;
    private Thread[] carros = new Thread[MAX_CARROS];
    private GabrielParaleloPanel container = new GabrielParaleloPanel();

    public GabrielParaleloFrame() {
        super("Objeto 2");
    }

    public void comecar() {
        setPreferredSize(new Dimension(815, 639));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);
        getContentPane().add(container);
        
        container.addFundo();

        for (int i = 0; i < MAX_CARROS; i++) {
            container.addCarro(i + 1, 0, (i * 80) + 120, 10, 15);
        }

        pack();

        isRodando = true;
        gameLoop = new Thread(this);
        gameLoop.start();
        for (int i = 1; i < container.getGameObjects().size(); i++) {
            carros[i - 1] = new Thread((Runnable)container.getGameObjects().get(i));
            carros[i - 1].start();
        }
    }

    public void parar() {
        isRodando = false;
        
        try {
            gameLoop.join();
            for (int i = 1; i < container.getGameObjects().size(); i++) {
                carros[i - 1].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setVisible(false);
        dispose();
    }

    @Override
    public void run() {
        while (isRodando) {
            //container.update();
//            update();

            try {
                Thread.sleep(THREAD_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
  /*  
    private void update() {
        System.out.println(NUM_THREAD);
        container.update();
    }
    */
}
