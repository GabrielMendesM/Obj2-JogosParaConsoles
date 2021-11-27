import javax.swing.JPanel;

public class GabrielCarro extends GabrielGameObject {
    private final int posChegada;
    private final String ID;
    private boolean chegou = false;

    public GabrielCarro(int posChegada, int id, int posX, int posY, JPanel panel) {
        super(posX, posY, panel, "./img/carro" + id + ".png");
        this.posChegada = posChegada;
        this.ID = "Carro " + id;
    }

    @Override
    public void mover(int velMin, int velMax) {
        super.mover(velMin, velMax);

        if (posX <= posChegada) {
            posX += vel;
        } else if (!chegou) {
            chegou = true;
            System.out.println(ID + " chegou!");
        }
    }
}
