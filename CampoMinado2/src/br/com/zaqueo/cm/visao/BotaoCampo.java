package br.com.zaqueo.cm.visao;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import org.w3c.dom.events.MouseEvent;

import br.com.zaqueo.cm.modelo.Campo;
import br.com.zaqueo.cm.modelo.CampoEvento;
import br.com.zaqueo.cm.modelo.CampoObservador;

public class BotaoCampo extends JButton implements CampoObservador, MouseListener {
    private final Color BG_PADRAO = new Color(184, 184, 184);
    private final Color BG_MARCAR = new Color(8, 179, 247);
    private final Color BG_EXPLODIR = new Color(189, 66, 68);
    private final Color TEXTO_VERDE = new Color(0, 100, 0);
    private Campo campo;

    public BotaoCampo(Campo campo) {
        this.campo = campo;
        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createBevelBorder(0));

        addMouseListener(this);
        campo.registrarObservador(this);
    }
    @Override
    public void eventoOcorreu(Campo campo, CampoEvento evento) {
        switch (evento) {
            case ABRIR:
                aplicarEstiloAbrir(campo);
                break;
            case MARCAR:
                aplicarEstiloMarcar(campo);
                break;
            case DESMARCAR:
                aplicarEstiloDesmarcar(campo);  
                break;
            case EXPLODIR:
                aplicarEstiloExplodir(campo);
                break;
            default:
                aplicarEstiloPadrao(campo);
                break;
        }
    }
    private void aplicarEstiloPadrao(Campo campo) {
        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createBevelBorder(0));
        setText("");
    }
    private void aplicarEstiloExplodir(Campo campo) {
        setBackground(BG_EXPLODIR);
        setForeground(Color.WHITE);
        setText("X");
    }
    private void aplicarEstiloDesmarcar(Campo campo) {
        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createBevelBorder(0));
        setText("");
    }
    private void aplicarEstiloMarcar(Campo campo) {
        setBackground(BG_MARCAR);
        setForeground(Color.BLACK);
        setText("M");
    }
    private void aplicarEstiloAbrir(Campo campo) {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        if (campo.isMinado()) {
            setBackground(BG_EXPLODIR);
            setForeground(Color.WHITE);
            return;
        }

        setBackground(BG_PADRAO);

        switch (campo.minasNaVizinhanca()) {
            case 1:
                setForeground(TEXTO_VERDE);
                break;
            case 2:
                setForeground(Color.BLUE);
                break;
            case 3:
                setForeground(Color.YELLOW);
                break;  
            case 4:
            case 5:
            case 6:
                setForeground(Color.RED);
                break;
            default:
                setForeground(Color.PINK);
        }

        String valor = !campo.vizinhancaSegura() ? 
            Long.toString(campo.minasNaVizinhanca()) : 
            "";

        setText(valor);

    }

    // MouseListener methods
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        if(e.getButton() == 1) {
            campo.abrir();
        } else {
            campo.alternarMarcacao();
        }
    }
    
    public void mouseClicked(java.awt.event.MouseEvent e) {}
    public void mouseEntered(java.awt.event.MouseEvent e) {}
    public void mouseExited(java.awt.event.MouseEvent e) {}
    public void mouseReleased(java.awt.event.MouseEvent e) {}

}