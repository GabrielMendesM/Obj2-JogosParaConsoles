import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GabrielMain extends JFrame {
    private static final int TELA_LARGURA = 800;
    private static final int TELA_ALTURA = 600;

    public GabrielMain() {
        JFrame frame = new JFrame();
        frame.setTitle("Teste 1");
        frame.setSize(TELA_LARGURA, TELA_ALTURA);
        frame.add(new GabrielCarro(TELA_LARGURA, TELA_ALTURA));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
