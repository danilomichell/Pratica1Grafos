package praticadegrafos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class PraticaDeGrafos {

    static String caminho = "grafo.txt";

    public static void main(String[] args) throws FileNotFoundException {
        int vertices = numeroVertices();
        LinkedList listas[] = new LinkedList[vertices];
        carregarGrafo(listas);
        imprimirGrafo(listas, vertices);
    }
    
    //Pega o numero de vertices
    public static int numeroVertices() throws FileNotFoundException {
        int contador = 0;
        Scanner input = new Scanner(new FileReader(caminho));
        while (input.hasNextLine()) {
            input.nextLine();
            contador++;
        }
        return contador;
    }

    //Liga o grafo
    public static void ligarGrafo(LinkedList[] listas) {
        for (int i = 0; i < listas.length; i++) {
            listas[i] = new LinkedList();
        }
    }

    //Carrega o grafo
    public static void carregarGrafo(LinkedList listas[]) throws FileNotFoundException {
        ligarGrafo(listas);
        Scanner input = new Scanner(new FileReader(caminho));
        int contador = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String vertices[] = line.split("\t");
            for (String vertice : vertices) {
                listas[contador].add(vertice);
            }
            contador++;
        }
    }

    //Imprime os vertices de saída e os de chegada
    public static void imprimirGrafo(LinkedList[] listas, int numeroVertice) {
        for (int i = 0; i < numeroVertice; i++) {
            System.out.printf("%s: ", (listas[i].get(0)));
            for (int j = 0; j < listas[i].size() - 1; j++) {
                System.out.print(listas[i].get(j + 1) + " ");
            }
            System.out.println();
        }
    }
    
    //Mostrar adjacentes passando vertice em parametro
    public void adjacentesVertice(String vertice){
        
    }
}