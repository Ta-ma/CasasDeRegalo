package casas;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Grafo {

    public static final int NUM_GRANDE = 999;
    int[][] mat;

    public Grafo(File arch) throws IOException {
	Scanner sc = new Scanner(arch);
	int tam = sc.nextInt();
	mat = new int[tam][tam];

	// inicializo con número grande
	for (int i = 0; i < tam; i++) {
	    for (int j = 0; j < tam; j++)
		mat[i][j] = NUM_GRANDE;
	}

	for (int i = 0; i < tam; i++) {
	    sc.nextInt(); // me como el primer num que solo da confusiones
	    int numLeido = sc.nextInt() - 1;
	    while (numLeido != -2) {
		mat[i][numLeido] = mat[numLeido][i] = 1; // grafo no dirigido
		numLeido = sc.nextInt() - 1;
	    }

	}

	sc.close();
    }

    public Nodo getNodo(int num) {
	Nodo nodo = new Nodo(num + 1);

	for (int i = 0; i < mat.length; i++) {
	    if (mat[num][i] != NUM_GRANDE)
		nodo.agregarArista(new Arista(num, i, mat[num][i]));
	}

	return nodo;
    }

    public Nodo[] getNodos() {
	int tam = mat.length;
	Nodo[] nodos = new Nodo[tam];

	for (int i = 0; i < tam; i++)
	    nodos[i] = getNodo(i);

	return nodos;
    }

    public void coloreoM() {
	Nodo[] nodos = getNodos();
	Arrays.sort(nodos);

	coloreo(nodos);
    }

    public void coloreo(Nodo[] nodos) {
	int tam = mat.length;

	// vector con el color que cada nodo tiene asignado
	int[] colores = new int[tam];
	// vector que indicara cuantos nodos tiene asignado cada color
	int[] nodosPorColor = new int[tam];
	boolean[] puedoPintar = new boolean[tam];

	for (int i = 0; i < tam; i++) {
	    colores[i] = -1; // sin color
	    puedoPintar[i] = true;
	}

	// asigno color 0 al primero
	colores[nodos[0].getNombre() - 1] = 0;
	nodosPorColor[0]++;

	for (int i = 1; i < tam; i++) {
	    for (Arista a : nodos[i].getAristas()) {
		int nodoD = a.getNodoD();
		if (colores[nodoD] != -1) {
		    puedoPintar[colores[nodoD]] = false;
		}
	    }

	    int j = 0;
	    while (!puedoPintar[j]) {
		j++;
	    }

	    colores[nodos[i].getNombre() - 1] = j;
	    nodosPorColor[j]++;

	    for (int k = 0; k < tam; k++) {
		puedoPintar[k] = true;
	    }
	}

	// busco el color que más nodos tiene
	int maxColor = 0, maxCantColores = 0;
	for (int i = 0; i < tam; i++) {
	    if (maxCantColores < nodosPorColor[i]) {
		maxColor = i;
		maxCantColores = nodosPorColor[i];
	    }
	}

	// muestro
	System.out.println(maxCantColores);
	for (int i = 0; i < tam; i++) {
	    if (colores[nodos[i].getNombre() - 1] == maxColor)
		System.out.print(nodos[i].getNombre() + " ");
	}
	System.out.println();
    }

}
