package br.com.cod3r.calc.modelo;

import java.util.ArrayList;
import java.util.List;

//LÓGICA DA CALCULADORA

public class Memoria {
	/*
	 * Padrão de Projeto SINGLETON, é um padrão que você vai ter apenas uma única
	 * instância de uma determinada classe e para isso o construtor tem que ser
	 * PRIVADO, ou seja, pode controlar a criação dentro da propria classe.
	 */

	private static final Memoria instancia = new Memoria();

	// Atributos

	private String textoAtual = "";
	private final List<MemoriaObservador> observadores = new ArrayList<>();

	// Construtor
	private Memoria() {

	}

	// Métodos Getter

	public static Memoria getInstancia() {
		return instancia;
	}

	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual;
		// Se o texto atual estiver vazio, ele coloque '0' SENÃO coloque o 'textoAtual'
	}

	public void adicionarObservador(MemoriaObservador observador) {
		observadores.add(observador);
	}

	public void processarComando(String valor) {
		if ("AC".equals(valor)) {
			textoAtual = "";
		} else {
			textoAtual += valor;
		}
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}

}
