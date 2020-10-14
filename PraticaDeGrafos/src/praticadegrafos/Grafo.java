package praticadegrafos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Grafo {

    static String caminho = "grafo.txt";

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

    //Imprime o vertice de saída e os de chegada
    public static void imprimirGrafo(LinkedList[] listas, int numeroVertice) {
        for (int i = 0; i < numeroVertice; i++) {
            System.out.printf("%s: ", (listas[i].get(0)));
            for (int j = 1; j < listas[i].size(); j++) {
                System.out.print(listas[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    //Mostrar adjacentes passando vertice em parametro
    public void getAdjacentes(String vertice, int numeroVertice, LinkedList listas[]) {
        for (int i = 0; i < numeroVertice; i++) {
            if ((listas[i].get(0)).equals(vertice)) {
                for (int j = 1; j < listas[i].size(); j++) {
                    System.out.print(listas[i].get(j) + " ");
                }
                System.out.println("são adjacentes de " + listas[i].get(0));
            }
        }
    }

    //Verifica se um determinado grafo é regular ou não.
    public boolean ehRegular(int numeroVertice, LinkedList listas[]) {
        for (int i = 0; i < numeroVertice - 1; i++) {
            if(listas[i].size() != listas[i+1].size()){
                return false;
            }
        }
        return true;
    }

}
