package br.com.zaqueo.cm.visao;

import br.com.zaqueo.cm.modelo.Tabuleiro;

public class Temp {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(3, 3, 9);

        tabuleiro.registrarObservador(resultado -> {
            if (resultado) {
                System.out.println("Parabéns! Você ganhou o jogo!");
            } else {
                System.out.println("Que pena! Você perdeu o jogo.");
            }
        });

        tabuleiro.alternarMarcacao(0, 0);
        tabuleiro.alternarMarcacao(0, 1);
        tabuleiro.alternarMarcacao(0, 2);
        tabuleiro.alternarMarcacao(1, 0);
        tabuleiro.alternarMarcacao(1, 1);
        tabuleiro.alternarMarcacao(1, 2);
        tabuleiro.alternarMarcacao(2, 0);
        tabuleiro.alternarMarcacao(2, 1);
        tabuleiro.alternarMarcacao(2, 2);
    }
}
