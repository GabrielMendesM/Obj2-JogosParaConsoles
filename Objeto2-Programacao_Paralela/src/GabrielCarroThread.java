
public class GabrielCarroThread extends Thread {
    GabrielCarro carro;
    int velMin;
    int velMax;

    public GabrielCarroThread(GabrielCarro carro, int velMin, int velMax) {
        this.carro = carro;
        this.velMin = velMin;
        this.velMax = velMax;
    }

    @Override
    public void run() {
        super.run();

        carro.mover(velMin, velMax);
    }
}
