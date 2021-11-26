import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GabrielCarro extends JPanel implements Runnable {
    private int aux = 0;
    private ImageIcon carro;
    private int posX, posY;
    private final int posLinhaChegada;
    private int velX;
    private Timer timer;

    public GabrielCarro(int telaLargura, int telaAltura) {
        timer = new Timer(1, new MoverListener());

        carro = new ImageIcon(getClass().getResource("./img/carro1.png"));
        posX = 0;
        posY = (telaAltura / 2) - (carro.getIconHeight() / 2);
        velX = 10;

        posLinhaChegada = telaLargura - (carro.getIconWidth() * 2);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        carro.paintIcon(this, g, posX, posY);

        timer.start();
    }

    private class MoverListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (posX <= posLinhaChegada) {
                posX += velX;
                revalidate();
                repaint();    
            }
        }
    }

    @Override
    public void run() {
        System.out.println("runnable " + aux++);
    }
}