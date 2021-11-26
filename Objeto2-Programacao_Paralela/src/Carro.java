import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.Graphics;


public class Carro extends JPanel {

    /*
    private final static String IMAGE_NAME = "ship1_";
    protected ImageIcon ship1[];
    private final int TOTAL_IMAGES = 16;
    private int currentIMAGE = 0;
    private final int ANIMATION_DELAY = 100;
    private int width;
    private int height;
    private int x = 0;
    private int y = 0;
    private int velX = 0;
    private int velY = 0;
    
    private Timer animationTimer;
    */
    
    private ImageIcon carro;
    private int largura, altura;
    private int posX, posY;
    private int velX;
    private Timer timer;

    public Carro() {
        carro = new ImageIcon(getClass().getResource("./img/carro1.png"));
        largura = 20;
        altura = 10;
        posX = 0;
        posY = 150 - altura / 2;
        velX = 1;

        timer = new Timer(100, new MoverListener());
/*        
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
*/    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        carro.paintIcon(this, g, posX, posY);
    }

    private class MoverListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (posX <= 250) {
                posX += velX;
                revalidate();
                repaint();    
            }
        }
    }
/*
    public void startAnimation() {
        if (animationTimer == null) {
            currentIMAGE = 0;
            animationTimer = new Timer(ANIMATION_DELAY, new TimerHandler());

            animationTimer.start();
        } else {
            if (!animationTimer.isRunning()) {
                animationTimer.restart();
            }
        }
    }

    public void stopAnimation() {
        animationTimer.stop();
    }

    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }



    private class TimerHandler implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            repaint();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (x < 0) {
            velX = 0;
            x = 0;
        }
        if (x > 850) {
            velX = 0;
            x = 850;
        }
        if (y < 0) {
            velY = 0;
            y = 0;
        }
        if (y > 650) {
            velY = 0;
            y = 650;
        }

        x = x + velX;
        y = y + velY;

    }
    */
}