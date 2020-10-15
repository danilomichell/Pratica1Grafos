package praticadegrafos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {

    static String caminho = "C:\\Users\\paulo\\Documents\\GitHub\\Pratica1Grafos\\PraticaDeGrafos\\grafo.txt";

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
                listas[contador].add(Integer.parseInt(vertice));
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
    public ArrayList<Integer> getAdjacentes(int vertice, int numeroVertice, LinkedList listas[]) {
        ArrayList<Integer> adjacentes = new ArrayList();
        for (int i = 0; i < numeroVertice; i++) {
            if ((listas[i].get(0)).equals(vertice)) {
                for (int j = 1; j < listas[i].size(); j++) {
                    adjacentes.add((Integer) listas[i].get(j));
                }
               
            }
        }
        return adjacentes;
    }

    //Verifica se um determinado grafo é regular ou não.
    public boolean ehRegular(int numeroVertice, LinkedList listas[]) {
        for (int i = 0; i < numeroVertice - 1; i++) {
            if (listas[i].size() != listas[i + 1].size()) {
                return false;
            }
        }
        return true;
    }

    //Verifica se um determinado grafo é completo ou não.
    public boolean ehCompleto(int numeroVertice, LinkedList listas[]) {
        for (int i = 0; i < numeroVertice; i++) {
            if (listas[i].size() - 1 != numeroVertice - 1) {
                return false;
            }
        }
        return true;
    }

    //Efetua a busca em largura
    public ArrayList<Integer> buscaLargura(int numeroVertice, LinkedList listas[], int inicio) {
        ArrayList<Integer> fila = new ArrayList();
        ArrayList<Integer> visitados = new ArrayList();
        fila.add(inicio);
        while (fila.size() > 0) {
            visitados.add(fila.get(0));
            ArrayList<Integer> adjacentes = new ArrayList();
            int verticeBusca = fila.get(0);
            adjacentes = getAdjacentes(verticeBusca, numeroVertice, listas);
            for (int i = 0; i < adjacentes.size(); i++) {
                if (!(visitados.contains(adjacentes.get(i))) && !(fila.contains(adjacentes.get(i)))) {          
                    fila.add(adjacentes.get(i));
                }
            }
            fila.remove(0);
        }
        return visitados;
    }

    //Verifica se um determinado grafo é conexo ou não
    public boolean ehConexo(int numeroVertice, LinkedList listas[]){
        ArrayList visitado = new ArrayList();
        //1 é o vertice de inicio
        visitado = buscaLargura(numeroVertice, listas, 1);

        if(numeroVertice != visitado.size()){
            return false;
        }

        return true;
    }
}
