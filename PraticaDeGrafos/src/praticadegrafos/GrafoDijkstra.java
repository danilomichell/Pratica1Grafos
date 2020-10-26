package praticadegrafos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import praticadegrafos.VerticeValorado;
public class GrafoDijkstra {

    static String caminho = "grafo2.txt";

    //Pega o numero de vertices(apenas linked list)
    public static int numeroVertices() throws FileNotFoundException {
        int contador = 0;
        Scanner input = new Scanner(new FileReader(caminho));
        while (input.hasNextLine()) {
            input.nextLine();
            contador++;
        }
        return contador;
    }
    //le o grafo especifico para o dijkstra
    public static ArrayList<VerticeValorado> carregarGrafoDijkstra() {
        Scanner in;
        ArrayList<VerticeValorado> listas = new ArrayList();

        try {
            in = new Scanner(new FileReader(caminho));
            while (in.hasNextLine()) {
                //divide a linha do arquivo em elementos(vertice-valor da aresta)
                String[] linha = in.nextLine().split("\t");
                //divide o elemento em vertice e valor da aresta
                String valor = linha[0].substring(0, linha[0].indexOf("-"));
                //cria os vertices valorados
                VerticeValorado verticevalorado = new VerticeValorado(valor);
                //carrega o grafo valorado
                for (int i = 1; i < linha.length; i++) {
                    String valorAdjacente = linha[i].substring(0, linha[i].indexOf("-"));
                    int distAdjacente = Integer.valueOf(linha[i].substring(linha[i].indexOf("-") + 1, linha[i].length()));
                    VerticeValorado verticeAdjacente = new VerticeValorado(valorAdjacente, distAdjacente);
                    verticevalorado.getVertices().add(verticeAdjacente);
                }
                listas.add(verticevalorado);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado");
        }
        return listas;
    }
        static void printGrafoDijkstra(ArrayList<VerticeValorado> listas) {
        for (VerticeValorado vertice : listas) {
            System.out.print(vertice.getValor() + ": ");
            for (int j = 0; j < vertice.getVertices().size(); j++) {
                System.out.print(vertice.getVertices().get(j).getValor() + " ");
            }
            System.out.println();
        }
    }
}
