package Anim;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.imageio.ImageIO;

public class CirculoAnim extends JPanel {
    private int posX, posY;
    private final int tamanho = 20;
    private final int velX = 1;
    private Timer timer;
    private BufferedImage carro1;
    private JLabel carroLabel;

    public CirculoAnim() {
        timer = new Timer(10, new MoveListener());
        posX = 0;
        posY = 100;
        try {
            carro1 = ImageIO.read(this.getClass().getResource("../img/carro1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        carroLabel = new JLabel(new ImageIcon(carro1));

        add(carroLabel);
    }
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        Ellipse2D.Double circulo = new Ellipse2D.Double(posX, posY, tamanho, tamanho);
        g2.setColor(Color.blue);
        g2.draw(circulo);
        g2.fill(circulo);

        timer.start();
    }

    private class MoveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (posX <= 250) {
                posX += velX;
                revalidate();
                repaint();    
            }
        }
    }
}
