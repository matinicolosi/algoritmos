package main.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class RandomGreedy {

	// 2. Aleatorizar el algoritmo anterior.
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

			List<Entry<Character, Integer>> aparicionesOrdenadas = new ArrayList<Entry<Character, Integer>>(
					apariciones.entrySet());
			aparicionesOrdenadas.sort((a, b) -> b.getValue().compareTo(a.getValue()));

			double indiceMaxDentroDelCuarto = Math.max(Math.floor(aparicionesOrdenadas.size() / 2) - 1, 0d);

			Character letraConMasApariciones = null;

			if (indiceMaxDentroDelCuarto == 0)
				letraConMasApariciones = aparicionesOrdenadas.get(0).getKey();
			else
				letraConMasApariciones = aparicionesOrdenadas
						.get(new Random().nextInt((int) indiceMaxDentroDelCuarto + 1)).getKey();

			s += letraConMasApariciones;
		}

		return s;
	}
}
