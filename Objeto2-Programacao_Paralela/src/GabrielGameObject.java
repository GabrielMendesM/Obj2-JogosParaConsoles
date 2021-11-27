import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GabrielGameObject {
    protected int posX;
    protected int posY;
    protected int vel;

    protected JPanel panel;
    protected ImageIcon img;

    public GabrielGameObject(int posX, int posY, JPanel panel, String imgCaminho) {
        this.posX = posX;
        this.posY = posY;
        this.panel = panel;
        this.img = new ImageIcon(getClass().getResource(imgCaminho));
    }

    public void draw(Graphics g) {
        img.paintIcon(panel, g, posX, posY);
    }

    public void mover(int velMin, int velMax) {
        vel = ThreadLocalRandom.current().nextInt(velMin, velMax + 1);
    }
}
