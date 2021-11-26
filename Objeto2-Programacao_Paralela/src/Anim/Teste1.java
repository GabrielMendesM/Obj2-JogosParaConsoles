package Anim;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Teste1 extends JFrame {
    public Teste1() {
        JFrame frame = new JFrame();
        frame.setTitle("Teste 1");
        frame.setSize(300,300);
        frame.add(new CirculoAnim());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
