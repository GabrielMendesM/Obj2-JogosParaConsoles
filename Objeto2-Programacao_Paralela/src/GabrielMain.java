import javax.swing.SwingUtilities;

public class GabrielMain {
    public GabrielMain() {
        SwingUtilities.invokeLater(() -> new GabrielCarroFrame().setVisible(true));
    }
}
