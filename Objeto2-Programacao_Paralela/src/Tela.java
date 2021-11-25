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
        //PEGO A RESOLUÇÃO DA TELA DO USUÁRIO
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final double RES_LARGURA = screenSize.getWidth();
        final double RES_ALTURA = screenSize.getHeight();

        //ESCOLHO AS DIMENSÕES DA JANELA QUE VAI ABRIR (largura = largura da tela - 1/10 dela; altura = 3/4 da altura da tela)
        int largura = (int) (RES_LARGURA - (RES_LARGURA / 10));
        int altura = (int) (RES_ALTURA / 4) * 3;
        
        //DEFINO O TAMANHO DO BOTÃO
        int btnLargura = 120;
        int btnAltura = 30;

        //ESSE CONTAINER É NECESSÁRIO PARA COLOCAR COR
        Container jp = getContentPane();
        //DECLARO E INICIALIZO O BOTÃO
        JButton btn = new JButton("COMEÇAR");
                
        //DEFINO O TAMANHO DO BOTÃO
        btn.setBounds(
            (largura / 2) - (btnLargura / 2), 
            (altura / 2) - (btnAltura / 2), 
            btnLargura, 
            btnAltura
        );

        //DEFINIÇÕES DA JANELA. COMO ESSA CLASSE TELA HERDA DE JFRAME, EU POSSO CHAMAR OS MÉTODOS DO JFRAME DIRETO, MAS PODERIA TER FEITO: Jframe frame = new Jframe(); frame.setTitle("Corrida"), POR EXEMPLO
        setTitle("Corrida");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(largura, altura);
        setLayout(null);
        
        //COLOCO A COR
        jp.setBackground(Color.CYAN);

        //ADICIONO O BOTÃO NA TELA
        add(btn);
        
        //MÉTODO QUE VÊ SE O BOTÃO FOI CLICADO, E NELE EU REMOVO O BOTÃO E REDESENHO A TELA. PELO QUE EU VI, O REVALIDATE É NECESSÁRIO PRA PODER ADICIONAR NOVOS COMPONENTES NA TELA DEPOIS DE REMOVER OUTROS.
        btn.addActionListener(e -> {
            remove(btn);
            revalidate();
            repaint();
        });

        /*FUNÇÃO IGUAL A DE CIMA, PORÉM ESTA NO FORMATO ANTIGO E A DE CIMA NO FORMATO LAMBDA
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
