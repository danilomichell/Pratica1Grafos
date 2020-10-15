package praticadegrafos;

import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        ArrayList<Integer> adjacentes = new ArrayList();
        adjacentes = grafo.getAdjacentes(1, vertices, listas);//funcionando
        System.out.print("Os adjacentes são: ");
        for(int i = 0; i < adjacentes.size(); i++){
            System.out.print(adjacentes.get(i) + " ");
        }
        System.out.println("");
        //Verifica se um determinado grafo é regular ou não, recebendo true ou false
        boolean regular = grafo.ehRegular(vertices, listas);//funcionando
        if (regular) {
            System.out.println("O grafo é regular");
        } else {
            System.out.println("O grafo não é regular");
        }
        //Verifica se um determinado grafo é completo ou não, recebendo true ou false
        boolean completo = grafo.ehCompleto(vertices, listas);//funcionando
        if (regular) {
            System.out.println("O grafo é completo");
        } else {
            System.out.println("O grafo não é completo");
        }
    }     
}
