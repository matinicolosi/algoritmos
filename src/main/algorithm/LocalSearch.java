package main.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import main.utils.Utils;

public class LocalSearch {

	// 3. Proponer un algoritmo de búsqueda local para el problema del texto más
	// parecido.
	public static String textoMasParecido(String s, List<String> textos) {
		Integer iteraciones = 100;

		String s_ = s;
		for (int iteracion = 0; iteracion < iteraciones; iteracion++)
			for (int i = 0; i < s.length(); i++) {
				s = s_;
				s_ = busquedaEnVecindad(s, textos, i);
			}

		return s_;
	}

	private static String busquedaEnVecindad(String s, List<String> textos, Integer indice) {
		LinkedList<String> vecindad = obtenerVecindad(s, textos, indice);

		Integer maximaDistancia = Utils.maximaDistancia(s, textos);

		String s_ = s;
		Integer maximaDistanciaVecino = maximaDistancia;
		while (!vecindad.isEmpty() && maximaDistanciaVecino >= maximaDistancia) {
			s_ = vecindad.pop();
			maximaDistanciaVecino = Utils.maximaDistancia(s_, textos);
		}

		return maximaDistanciaVecino < maximaDistancia ? s_ : s;
	}

	private static LinkedList<String> obtenerVecindad(String s, List<String> textos, Integer indice) {
		HashSet<String> vecindad = new HashSet<String>();

		char[] vecino = s.toCharArray();
		for (String texto : textos)
			if (s.charAt(indice) != texto.charAt(indice)) {
				vecino[indice] = texto.charAt(indice);

				vecindad.add(String.valueOf(vecino));
			}

		return new LinkedList<String>(vecindad);
	}
}
