package br.com.zaqueo.cm.visao;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.zaqueo.cm.modelo.Tabuleiro;

public class PainelTabuleiro extends JPanel{

    public PainelTabuleiro(Tabuleiro tabuleiro) {
        
        setLayout(new GridLayout(
            tabuleiro.getLinhas(), tabuleiro.getColunas()
        ));

        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
        tabuleiro.registrarObservador(e -> {

            SwingUtilities.invokeLater(() -> { 
                if (e) {
                    JOptionPane.showMessageDialog(
                        this, "Você ganhou! :)"
                    );
                } else {
                    JOptionPane.showMessageDialog(
                        this, "Você perdeu! :("
                    );
                }
                tabuleiro.reiniciar();
            });
        });
    }
}
