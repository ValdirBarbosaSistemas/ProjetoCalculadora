package br.com.cod3r.calc.visao;

import javax.swing.JFrame;

public class Calculadora extends JFrame {

    //Construtor
    public Calculadora() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setPreferredSize(null);
        setSize(233, 322);
        //Configurações da tela

    }

    public static void main(String[] args) {
        new Calculadora(); //Chamando o construtor
    }
}
