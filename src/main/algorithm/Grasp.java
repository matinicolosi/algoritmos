package main.algorithm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import main.utils.Utils;

public class Grasp {

	// 5. Construir un algoritmo GRASP para el problema del texto más parecido. La
	// entrada de su algoritmo será un archivo con una instancia del problema del
	// texto más parecido (un texto por línea) y la salida deberá ser un archivo de
	// texto plano con una secuencia en la primera línea y su distancia máxima en la
	// siguiente.
	public static void textoMasParecido(List<String> textos) {
		Integer iteraciones = 100;

		String s = null;
		String s_ = null;

		String mejorResultado = null;
		Integer mejorResultadoDistanciaMaxima = null;
		for (int i = 0; i < iteraciones; i++) {
			s = RandomGreedy.textoMasParecido(textos);
			s_ = LocalSearch.textoMasParecido(s, textos);

			Integer distanciaMaxima = Utils.maximaDistancia(s_, textos);
			if (mejorResultadoDistanciaMaxima == null || mejorResultadoDistanciaMaxima > distanciaMaxima) {
				mejorResultado = s_;
				mejorResultadoDistanciaMaxima = distanciaMaxima;
			}

			System.out.println("Iteracion " + i + " -> Mejor distancia maxima " + mejorResultadoDistanciaMaxima);
		}

		Path path = Paths.get("C:\\Users\\Matias\\Desktop\\resultado.txt");
		try {
			Files.write(path, mejorResultado.concat(System.lineSeparator())
					.concat(String.valueOf(mejorResultadoDistanciaMaxima)).getBytes());
		} catch (IOException e) {
			System.out.println("Error al escribir el resultado.");
			e.printStackTrace();
		}
	}

	public static String textoMasParecidoScoring(String rutaBaseInstancia, String nombreInstancia) {
		String data = nombreInstancia;

		List<String> textos = Utils.obtenerInstancia(rutaBaseInstancia.concat(nombreInstancia).concat(".txt"));

		Integer iteraciones = 100;

		String s = null;
		String s_ = null;

		Integer mejorResultadoDistanciaMaxima = null;
		for (int i = 0; i < iteraciones; i++) {
			s = RandomGreedy.textoMasParecido(textos);
			s_ = LocalSearch.textoMasParecido(s, textos);

			Integer distanciaMaxima = Utils.maximaDistancia(s_, textos);
			if (mejorResultadoDistanciaMaxima == null || mejorResultadoDistanciaMaxima > distanciaMaxima)
				mejorResultadoDistanciaMaxima = distanciaMaxima;

			System.out.println("Iteracion " + i + " -> Mejor distancia maxima " + mejorResultadoDistanciaMaxima);
			// Para el scoring ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			data = data.concat(System.lineSeparator()).concat(String.valueOf(i)).concat(";")
					.concat(String.valueOf(mejorResultadoDistanciaMaxima));
			// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		}

		// Para el scoring ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		return data;
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	}
}
