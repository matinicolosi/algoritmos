package main.utils;

import java.util.List;

public class Utils {

	public static Integer maximaDistancia(String s, List<String> textos) {
		Integer maximaDistancia = 0;

		for (String texto : textos) {
			Integer distancia = distancia(s, texto);

			if (maximaDistancia < distancia)
				maximaDistancia = distancia;
		}

		return maximaDistancia;
	}

	public static Integer distancia(String textoA, String textoB) {
		Integer distancia = 0;

		for (int i = 0; i < textoA.length(); i++)
			if (textoA.charAt(i) != textoB.charAt(i))
				distancia++;

		return distancia;
	}
}
