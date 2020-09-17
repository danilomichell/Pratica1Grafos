package praticadegrafos;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Cria e carrega o grafo
        Grafo grafo = new Grafo();
        int vertices = Grafo.numeroVertices();
        LinkedList listas[] = new LinkedList[vertices];
        Grafo.carregarGrafo(listas);

        //Imprime o grafo
        Grafo.imprimirGrafo(listas, vertices);

        //Mostra os adjacentes de um grafo indicado por parametro
        grafo.adjacentesVertice("1", vertices, listas);
    }
}
