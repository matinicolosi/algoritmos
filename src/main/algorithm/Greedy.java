package main.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Greedy {

	// 1. Proponer un algoritmo goloso para el problema del texto más parecido.
	public static String textoMasParecido(List<String> textos) {
		if (textos.isEmpty())
			return null;
		else if (textos.size() == 1 || textos.get(0).isEmpty())
			return textos.get(0);

		String s = "";
		for (Integer i = 0; i < textos.get(0).length(); i++) {
			Map<Character, Integer> apariciones = new HashMap<Character, Integer>();
			for (String texto : textos)
				apariciones.put(texto.charAt(i), apariciones.getOrDefault(texto.charAt(i), 0) + 1);

			Character letraConMasApariciones = null;
			for (Entry<Character, Integer> tupla : apariciones.entrySet())
				if (letraConMasApariciones == null || apariciones.get(letraConMasApariciones) < tupla.getValue())
					letraConMasApariciones = tupla.getKey();

			s += letraConMasApariciones;
		}

		return s;
	}
}
