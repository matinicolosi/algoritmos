package main.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import main.utils.Utils;

public class LocalSearchOptimized {

	// 4. Variar parámetros y la estrategia del algoritmo de búsqueda local que
	// optimicen el funcionamiento del mismo.
	public static String textoMasParecido(String s, List<String> textos) {
		Integer iteraciones = 100;
		
		String s_ = s;
		for (int iteracion = 0; iteracion < iteraciones; iteracion++)
			for (int i = 0; i < s.length(); i++) {
				s = s_;
				s_ = busquedaEnVecindadVariado(s, textos, i);
			}

		return s_;
	}

	private static String busquedaEnVecindadVariado(String s, List<String> textos, Integer indice) {
		LinkedList<Character> vecindad = obtenerVecindadVariado(s, textos, indice);

		Integer maximaDistancia = Utils.maximaDistancia(s, textos);

		String s_ = s;
		Integer maximaDistanciaVecino = maximaDistancia;
		while (!vecindad.isEmpty() && maximaDistanciaVecino >= maximaDistancia) {
			char[] vecino = s_.toCharArray();
			vecino[indice] = vecindad.pop();

			s_ = String.valueOf(vecino);
			maximaDistanciaVecino = Utils.maximaDistancia(s_, textos);
		}

		return maximaDistanciaVecino < maximaDistancia ? s_ : s;
	}

	private static LinkedList<Character> obtenerVecindadVariado(String s, List<String> textos, Integer indice) {
		HashSet<Character> vecindad = new HashSet<Character>();

		for (String texto : textos)
			if (s.charAt(indice) != texto.charAt(indice))
				vecindad.add(texto.charAt(indice));

		return new LinkedList<Character>(vecindad);
	}
}
