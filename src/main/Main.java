package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import main.algorithm.Grasp;
import main.algorithm.Greedy;
import main.algorithm.LocalSearch;
import main.algorithm.LocalSearchOptimized;
import main.algorithm.RandomGreedy;
import main.utils.Utils;

public class Main {

	public static void main(String[] args) {
		List<String> instancia = Utils.obtenerInstancia(
				"C:\\Users\\Matias\\Desktop\\instancias texto mas parecido_az\\instancias texto mas parecido_az_10_10_1.txt");

		// Pruebas simples de cada algoritmo
//		System.out.println("Greedy -> " + Utils.maximaDistancia(Greedy.textoMasParecido(instancia), instancia));
//		System.out.println(
//				"RandomGreedy -> " + Utils.maximaDistancia(RandomGreedy.textoMasParecido(instancia), instancia));
//		System.out.println("LocalSearch -> "
//				+ Utils.maximaDistancia(LocalSearch.textoMasParecido(instancia.get(0), instancia), instancia));
//		System.out.println("LocalSearchOptimized -> "
//				+ Utils.maximaDistancia(LocalSearchOptimized.textoMasParecido(instancia.get(0), instancia), instancia));
//		Grasp.textoMasParecido(instancia);

		// Ejecuciones para graficos de scoring
		ejecutarInstanciasGrasp("C:\\Users\\Matias\\Desktop\\instancias texto mas parecido\\",
				"texto_mas_parecido_10_300_1", 3);
		ejecutarInstanciasGrasp("C:\\Users\\Matias\\Desktop\\instancias texto mas parecido\\",
				"texto_mas_parecido_10_500_1", 3);
		ejecutarInstanciasGrasp("C:\\Users\\Matias\\Desktop\\instancias texto mas parecido\\",
				"texto_mas_parecido_15_300_1", 3);
		ejecutarInstanciasGrasp("C:\\Users\\Matias\\Desktop\\instancias texto mas parecido\\",
				"texto_mas_parecido_15_500_1", 3);
		ejecutarInstanciasGrasp("C:\\Users\\Matias\\Desktop\\instancias texto mas parecido\\",
				"texto_mas_parecido_20_300_1", 3);
	}

	private static void ejecutarInstanciasGrasp(String rutaBaseInstancia, String nombreInstancia,
			Integer cantidadInstancias) {
		for (int i = 0; i < cantidadInstancias; i++) {
			String dataScoring = Grasp.textoMasParecidoScoring(rutaBaseInstancia, nombreInstancia);

			Path path = Paths.get("C:\\Users\\Matias\\Desktop\\".concat(nombreInstancia).concat("___")
					.concat(String.valueOf(i + 1)).concat(".txt"));
			try {
				Files.write(path, dataScoring.getBytes());
			} catch (IOException e) {
				System.out.println("Error al escribir el resultado ".concat(nombreInstancia).concat("___")
						.concat(String.valueOf(i + 1)).concat(".txt"));
				e.printStackTrace();
			}
		}
	}
}
