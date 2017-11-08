package casas;

import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
	File dir = new File(".//IN//");
	
	for(File arch : dir.listFiles()) {
	    Grafo grafo = new Grafo(arch);
	    grafo.coloreoM();
	}

    }

}
