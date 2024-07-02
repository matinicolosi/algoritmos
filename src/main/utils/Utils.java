package main.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	public static List<String> obtenerInstancia(String ruta) {
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
