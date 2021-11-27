import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GabrielCarroPanel extends JPanel implements ActionListener {
    List<GabrielGameObject> gameObjects = new ArrayList<>();

    public GabrielCarroPanel() {
        super();
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawRect(0, 0, getWidth(), getHeight());

        for (GabrielGameObject go : gameObjects) {
            go.draw(g);
        }
    }

    public void addFundo() {
        gameObjects.add(new GabrielGameObject(0, 0, this, "./img/fundo.png"));
    }

    public void addCarro(int id, int posX, int posY) {
        gameObjects.add(new GabrielCarro(800, id, posX, posY, this));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (GabrielGameObject go : gameObjects) {
            go.mover(10, 15);
        }
        repaint();
    }
}
