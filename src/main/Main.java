package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.algorithm.Grasp;
import main.algorithm.Greedy;
import main.algorithm.LocalSearch;
import main.algorithm.LocalSearchOptimized;
import main.algorithm.RandomGreedy;
import main.utils.Utils;

public class Main {

	public static void main(String[] args) {
		List<String> instancia = obtenerInstancia(
				"C:\\Users\\Matias\\Desktop\\instancias texto mas parecido_az\\instancias texto mas parecido_az_10_10_1.txt");

		System.out.println("Greedy -> " + Utils.maximaDistancia(Greedy.textoMasParecido(instancia), instancia));
		System.out.println(
				"RandomGreedy -> " + Utils.maximaDistancia(RandomGreedy.textoMasParecido(instancia), instancia));
		System.out.println("LocalSearch -> "
				+ Utils.maximaDistancia(LocalSearch.textoMasParecido(instancia.get(0), instancia), instancia));
		System.out.println("LocalSearchOptimized -> "
				+ Utils.maximaDistancia(LocalSearchOptimized.textoMasParecido(instancia.get(0), instancia), instancia));

		Grasp.textoMasParecido(instancia);
	}

	private static List<String> obtenerInstancia(String ruta) {
		List<String> textos = new ArrayList<String>();

		try {
			Scanner lector = new Scanner(new File(ruta));

			while (lector.hasNextLine())
				textos.add(lector.nextLine());

			lector.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo de instancia.");
			e.printStackTrace();
		}

		return textos;
	}
}
