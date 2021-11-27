import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;

public class GabrielCarro extends GabrielGameObject {
    private final int posChegada;
    private final String ID;
    private boolean chegou = false;

    public GabrielCarro(int posChegada, int id, int posX, int posY, JPanel panel) {
        super(posX, posY, panel, "./img/carro" + ThreadLocalRandom.current().nextInt(0,10) + ".png");
        this.posChegada = posChegada;
        this.ID = "Carro_0" + id;
    }

    @Override
    public void mover(int velMin, int velMax) {
        super.mover(velMin, velMax);

        if (posX <= posChegada) {
            int posAnterior = posX;
            posX += vel;
            System.out.println(ID + " andou " + (posX - posAnterior) + "m e já percorreu " + posX + "m.");
        } else if (!chegou) {
            chegou = true;
            System.out.println("=========================\n     "+ ID + " chegou!\n=========================");
        }
    }
}
