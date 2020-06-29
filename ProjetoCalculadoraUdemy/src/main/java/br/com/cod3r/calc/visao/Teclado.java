package br.com.cod3r.calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.cod3r.calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {
	private final Color COR_CINZA_ESCURO = new Color(68, 68, 68);
	private final Color COR_CINZA_CLARO = new Color(99, 99, 99);
	private final Color COR_LARANJA = new Color(242, 163, 60);

	// Construtor
	public Teclado() {
		setLayout(new GridLayout(5, 4));

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		setLayout(layout);

		c.fill = GridBagConstraints.BOTH; // Serve para preencher os espaços vazios entre os números
		c.weightx = 1; // Serve para preencher o eixo X de toda a tela
		c.weighty = 1; // Serve para preencher o eixo X de toda a tela
		/*
		 * FORMA MEIO RUIM DE SE FAZER
		 * 
		 * add(new Botao("AC", COR_CINZA_ESCURO)); add(new
		 * Botao("+/-",COR_CINZA_ESCURO)); add(new Botao("%", COR_CINZA_ESCURO));
		 * add(new Botao("/", COR_LARANJA));
		 * 
		 * add(new Botao("7", COR_CINZA_CLARO)); add(new Botao("8", COR_CINZA_CLARO));
		 * add(new Botao("9", COR_CINZA_CLARO)); add(new Botao("*", COR_LARANJA));
		 * 
		 * 
		 * add(new Botao("4", COR_CINZA_CLARO)); add(new Botao("5", COR_CINZA_CLARO));
		 * add(new Botao("6", COR_CINZA_CLARO)); add(new Botao("-", COR_LARANJA));
		 * 
		 * 
		 * add(new Botao("1", COR_CINZA_CLARO)); add(new Botao("2", COR_CINZA_CLARO));
		 * add(new Botao("3", COR_CINZA_CLARO)); add(new Botao("+", COR_LARANJA));
		 * 
		 * 
		 * add(new Botao("0", COR_CINZA_CLARO)); add(new Botao("8", COR_CINZA_CLARO));
		 * add(new Botao(".", COR_CINZA_CLARO)); add(new Botao("=", COR_LARANJA));
		 */

		/*
		 * OUTRA FORMA DE SE FAZER, PORÉM HÁ OUTRA MANEIRA MAIS FÁCIL
		 * 
		 * c.gridx = 0; Colocando a posição '0' no layout c.gridy = 0; Colocando a
		 * posição '0' no layout
		 * 
		 * add(new Botao("AC", COR_CINZA_ESCURO), c); c.gridx = 1; c.gridy = 1; add(new
		 * Botao("+/-", COR_CINZA_ESCURO), c); add(new Botao("%", COR_CINZA_ESCURO), c);
		 * add(new Botao("/", COR_LARANJA), c);
		 *
		 * add(new Botao("7", COR_CINZA_CLARO), c); add(new Botao("8", COR_CINZA_CLARO),
		 * c); add(new Botao("9", COR_CINZA_CLARO), c); add(new Botao("*", COR_LARANJA),
		 * c);
		 */

		// O gridX ou gridY já vem no 'GridBagConstrains' não é uma declaração de
		// variável

		// TEMOS OUTRA FORMA MELHOR QUE É CRIANDO MÉTODO
		c.gridwidth = 3; // Serve para deixar como uma tecla o botao "AC"
		adicionarBotao("AC", COR_CINZA_ESCURO, c, 0, 0); // Chamando o método da linha 1
		c.gridwidth = 1;
		/*
		 * Fizemos isso pois se tivéssemos deixado só com o 'gridwidth' como 3 daria
		 * problema gerando um preenchimento total da tela, ou seja, com isso voltaria
		 * ao normal os botões da linha 1
		 */

		adicionarBotao("/", COR_LARANJA, c, 3, 0);

		adicionarBotao("7", COR_CINZA_CLARO, c, 0, 1); // Chamando o método da linha 2
		adicionarBotao("8", COR_CINZA_CLARO, c, 1, 1);
		adicionarBotao("9", COR_CINZA_CLARO, c, 2, 1);
		adicionarBotao("*", COR_LARANJA, c, 3, 1);

		adicionarBotao("4", COR_CINZA_CLARO, c, 0, 2); // Chamando o método da linha 3
		adicionarBotao("5", COR_CINZA_CLARO, c, 1, 2);
		adicionarBotao("6", COR_CINZA_CLARO, c, 2, 2);
		adicionarBotao("-", COR_LARANJA, c, 3, 2);

		adicionarBotao("1", COR_CINZA_CLARO, c, 0, 3); // Chamando o método da linha 4
		adicionarBotao("2", COR_CINZA_CLARO, c, 1, 3);
		adicionarBotao("3", COR_CINZA_CLARO, c, 2, 3);
		adicionarBotao("+", COR_LARANJA, c, 3, 3);

		c.gridwidth = 2; // Deixando a mesma coisa do 'AC'
		adicionarBotao("0", COR_CINZA_CLARO, c, 0, 4); // Chamando o método da linha 5
		c.gridwidth = 1;
		adicionarBotao(",", COR_CINZA_CLARO, c, 2, 4);
		adicionarBotao("=", COR_LARANJA, c, 3, 4);
	}

	// Métodos

	private void adicionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
		Botao botao = new Botao(texto, cor);
		c.gridx = x;
		c.gridy = y;
		add(botao, c);
		botao.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			Memoria.getInstancia().processarComando(botao.getText());
		}
	}
}