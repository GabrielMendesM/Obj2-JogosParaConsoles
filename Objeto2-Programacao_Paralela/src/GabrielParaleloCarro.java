import java.util.concurrent.ThreadLocalRandom;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class GabrielParaleloCarro extends Thread {
    
    private int posX;
    private int posY;
    private int vel;
    private int velMin;
    private int velMax;

    private JPanel panel;
    private ImageIcon img;

    private final int posChegada;
    private final String ID;
    private boolean chegou = false;
    private Graphics g;

    public GabrielParaleloCarro(int posChegada, int id, int posX, int posY, int velMin, int velMax, JPanel panel, Graphics g) {
        this.posX = posX;
        this.posY = posY;
        this.velMin = velMin;
        this.velMax = velMax;
        this.panel = panel;
        this.posChegada = posChegada;
        this.ID = "Carro_0" + id;
        this.g = g;
        this.img = new ImageIcon(getClass().getResource("./img/carro" + id + ".png"));
    }

    public void draw(Graphics g) {
        img.paintIcon(panel, g, posX, posY);
        if (panel != null) {
            panel.revalidate();
            panel.repaint();
        }
    }

    public void mover() {
        vel = ThreadLocalRandom.current().nextInt(velMin, velMax + 1);

        if (posX <= posChegada) {
            int posAnterior = posX;
            posX += vel;
            System.out.println(ID + " andou " + (posX - posAnterior) + "m e já percorreu " + posX + "m.");
        } else if (!chegou) {
            chegou = true;
            System.out.println("=========================\n     "+ ID + " chegou!\n=========================");
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (GabrielParaleloFrame.getIsRodando()) {
            mover();
            draw(g);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
