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
        Grafo.imprimirGrafo(listas, vertices);//funcionando
        //Mostra os adjacentes de um grafo indicado por parametro(grafo passdo por String)
        grafo.getAdjacentes("1", vertices, listas);//funcionando
        //Verifica se um determinado grafo é regular ou não, recebendo true ou false
        boolean regular = grafo.ehRegular(vertices, listas);//funcionando
        if (regular) {
            System.out.println("O grafo é regular");
        } else {
            System.out.println("O grafo não é regular");
        }
    }
}
