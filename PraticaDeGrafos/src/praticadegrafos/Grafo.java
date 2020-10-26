package praticadegrafos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {

    static String caminho = "C:\\Users\\Dinopc\\Desktop\\coisas aleatorias\\3 periodo\\arquivo.txt";

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
    
    //utilização do algoritmo de dijkstra
        public void Graphdijkstra(){
        Scanner scan = new Scanner(System.in);

        int[][] matriz = new int[5][5];
        int[] distance = new int[5];
        int[] visited = new int[5];
        int[] preD = new int[5];
        int min;
        int nextNode = 0;
        
        //considera-se um grafo conexo e que sempre parte o vértice 0 para os demais 
        System.out.println("Insira os valores das arestas para ccada vértice");

        for (int i = 0; i < distance.length; i++) {
            visited[i] = 0;
            preD[i] = 0;
            for (int j = 0; j < distance.length; j++) {
                matriz[i][j] = scan.nextInt();

                if (matriz[i][j] == 0) {
                    matriz[i][j] = 999;
                }

            }
        }
        distance = matriz[0];
        distance[0] = 0;
        visited[0] = 1;

        for (int i = 0; i < distance.length; i++) {
            min = 999;
            for (int j = 0; j < distance.length; j++) {
                if (min > distance[j] && visited[j] != 1) {
                    min = distance[j];
                    nextNode = j;
                }
            }

            visited[nextNode] = 1;
            for (int c = 0; c < 5; c++) {
                if (visited[c] != 1) {
                    if (min + matriz[nextNode][c] < distance[c]) {
                        distance[c] = min + matriz[nextNode][c];
                        preD[c] = nextNode;
                    }
                }
            }
        }

        //imprimindo os caminhos
        for (int i = 0; i < distance.length; i++) {
            System.out.print("|" + distance[i]);
        }
        System.out.print("|");
        System.out.println();
        for (int i = 0; i < distance.length; i++) {
            int j;
            System.out.print("Caminho = " + i);
            j = i;
            do {
                j = preD[j];
                System.out.print(" <- " + j);
            } while (j != 0);
            {
                System.out.println();
            }
        }
    }
}
