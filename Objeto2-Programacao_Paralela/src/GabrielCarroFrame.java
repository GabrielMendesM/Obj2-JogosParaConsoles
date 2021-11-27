import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class GabrielCarroFrame extends JFrame {
    static final int MOVE_DELAY = 16;
    static final int MAX_CARROS = 5;
    
    GabrielCarroPanel container = new GabrielCarroPanel();

    public GabrielCarroFrame() {
        super("Objeto 2");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        getContentPane().add(container);


        container.addFundo();

        for (int i = 0; i < MAX_CARROS; i++) {
            container.addCarro(i, 0, (i * 80) + 120);
        }
        pack();

        new Timer(MOVE_DELAY, container).start();
    }
}
