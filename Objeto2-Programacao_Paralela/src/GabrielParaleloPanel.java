import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GabrielParaleloPanel extends JPanel {
    List<GabrielParaleloGameObject> gameObjects = new ArrayList<>();

    public GabrielParaleloPanel() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(0, 0, getWidth(), getHeight());

        for (GabrielParaleloGameObject go : gameObjects) {
            go.draw(g);
        }
    }

    public void addFundo() {
        gameObjects.add(new GabrielParaleloGameObject(0, 0, 0, 0, this, "./img/fundo.png"));
    }

    public void addCarro(int id, int posX, int posY, int velMin, int velMax) {
        gameObjects.add(new GabrielParaleloCarro(800, id, posX, posY, velMin, velMax, this));
    }

    /*
    public void update() {
        System.out.println("GabrielParaleloPanel");
        for (GabrielParaleloGameObject go : gameObjects) {
            go.mover();
        }
    }
    */

    public List<GabrielParaleloGameObject> getGameObjects() {
        return gameObjects;        
    }
}
