import java.awt.Graphics;

import javax.swing.JPanel;

public class GabrielParaleloPanel extends JPanel {
    GabrielParaleloGameObject fundo;
    GabrielParaleloCarro[] carros;

    public GabrielParaleloPanel(GabrielParaleloCarro[] carros) {
        super();
        this.carros = carros;
        fundo = new GabrielParaleloGameObject(0, 0, 0, 0, this, "./img/fundo.png");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(0, 0, getWidth(), getHeight());

        fundo.draw(g);
        for (GabrielParaleloCarro c : carros) {
            c.draw(g);
        }
    }

    public void addFundo() {
        //fundo = new GabrielParaleloGameObject(0, 0, 0, 0, this, "./img/fundo.png");
    }
}
