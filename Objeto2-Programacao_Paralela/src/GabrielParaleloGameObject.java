import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GabrielParaleloGameObject {
    protected int posX;
    protected int posY;
    protected int vel;
    protected int velMin;
    protected int velMax;

    protected JPanel panel;
    protected ImageIcon img;

    public GabrielParaleloGameObject(int posX, int posY, int velMin, int velMax, JPanel panel, String imgCaminho) {
        this.posX = posX;
        this.posY = posY;
        this.velMin = velMin;
        this.velMax = velMax;
        this.panel = panel;
        this.img = new ImageIcon(getClass().getResource(imgCaminho));
    }

    public void draw(Graphics g) {
        img.paintIcon(panel, g, posX, posY);
    }

    public void mover() {
        vel = ThreadLocalRandom.current().nextInt(velMin, velMax + 1);
    }

    /*
    @Override
    public void run() {
        super.run();
        //System.out.println("GabrielParaleloGameObject");
        while (GabrielParaleloFrame.isRodando) {
            mover();

            
            try {
                Thread.sleep(GabrielParaleloFrame.THREAD_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
    */
}
