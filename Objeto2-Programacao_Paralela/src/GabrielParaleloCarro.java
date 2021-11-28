import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;

public class GabrielParaleloCarro extends GabrielParaleloGameObject implements Runnable {
    private final int posChegada;
    private final String ID;
    private boolean chegou = false;

    public GabrielParaleloCarro(int posChegada, int id, int posX, int posY, int velMin, int velMax, JPanel panel) {
        super(posX, posY, velMin, velMax, panel, "./img/carro" + ThreadLocalRandom.current().nextInt(0,10) + ".png");
        this.posChegada = posChegada;
        this.ID = "Carro_0" + id;
    }

    @Override
    public void mover() {
        super.mover();

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
        while (GabrielParaleloFrame.isRodando) {
            mover();
        }
    }
}
