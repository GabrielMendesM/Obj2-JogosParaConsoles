import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.WindowConstants;

public class Tela extends JFrame {
    public Tela() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final double RES_LARGURA = screenSize.getWidth();
        final double RES_ALTURA = screenSize.getHeight();

        int largura = (int) (RES_LARGURA - (RES_LARGURA / 10));
        int altura = (int) (RES_ALTURA / 4) * 3;
        
        int btnLargura = 120;
        int btnAltura = 30;

        Container jp = getContentPane();
        JButton btn = new JButton("COMEÇAR");
                
        btn.setBounds(
            (largura / 2) - (btnLargura / 2), 
            (altura / 2) - (btnAltura / 2), 
            btnLargura, 
            btnAltura
        );

        setTitle("Corrida");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(largura, altura);
        setLayout(null);
        
        jp.setBackground(Color.CYAN);

        add(btn);
        
        //FUNÇÃO IGUAL A DE BAIXO, PORÉM NO FORMATO LAMBDA
        btn.addActionListener(
            (ActionEvent e) -> {
                remove(btn);
                revalidate();
                repaint();
        });

        /*FUNÇÃO IGUAL A DE CIMA, PORÉM NO FORMATO ANTIGO
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(btn);
                revalidate();
                repaint();
            }
        });
        */
    }
}
