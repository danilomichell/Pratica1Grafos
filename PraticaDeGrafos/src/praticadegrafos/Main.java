package praticadegrafos;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        PraticaDeGrafos grafo = new PraticaDeGrafos();
        int vertices = PraticaDeGrafos.numeroVertices();
        LinkedList listas[] = new LinkedList[vertices];
        grafo.carregarGrafo(listas);
        grafo.imprimirGrafo(listas, vertices);
        grafo.adjacentesVertice("1", vertices, listas);
    }
}
