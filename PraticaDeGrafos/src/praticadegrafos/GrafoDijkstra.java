package praticadegrafos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
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

    public static void printGrafoDijkstra(ArrayList<VerticeValorado> listas) {
        listas.stream().map(vertice -> {
            System.out.print(vertice.getValor() + ": ");
            return vertice;
        }).map(vertice -> {
            for (int j = 0; j < vertice.getVertices().size(); j++) {
                System.out.print(vertice.getVertices().get(j).getValor() + " ");
            }
            return vertice;
        }).forEachOrdered(_item -> {
            System.out.println();
        });
    }

    public static void menorCaminho1(VerticeValorado vertice, ArrayList<VerticeValorado> grafo) {
        VerticeValorado verticeInicio = vertice;
        ArrayList<VerticeValorado> vertices = new ArrayList();
        ArrayList<Boolean> explorado = new ArrayList();
        ArrayList<Float> dist = new ArrayList();
        ArrayList path1 = new ArrayList();
        ArrayList path2 = new ArrayList();
        Stack caminho = new Stack();
        //Adiciona os vértices do grafo em uma lista
        for (int i = 0; i < grafo.size(); i++) {
            vertices.add(grafo.get(i));
        }
        //Adiciona valores a lista Explorado
        for (int i = 0; i < grafo.size(); i++) {
            explorado.add(i, false);
        }
        //Inicia o vertice de inicio no explorado passando como "true"
        explorado.set(vertices.indexOf(vertice), true);
        //Adiciona valores a lista dist
        for (int i = 0; i < grafo.size(); i++) {
            dist.add(i, Float.POSITIVE_INFINITY);
        }
        //Inicia o vertice de inicio no dist recebendo 0
        dist.set(vertices.indexOf(vertice), (float) 0);
        //Adiciona valores a lista path1 e path2
        for (int i = 0; i < grafo.size(); i++) {
            if (i == vertices.indexOf(vertice)) {
                path1.add("-");
                path2.add("-");
            } else {
                path1.add(0);
                path2.add(0);
            }
        }
        // Pega os adjacentes e calcula os caminhos
        while (explorado.contains(false)) {
            //Inicia um auxiliador de controle
            VerticeValorado auxiliador = grafo.get(grafo.indexOf(vertice));
            for (int i = 0; i < auxiliador.getVertices().size(); i++) {
                //Controle dos vertices adjacentes
                VerticeValorado a = auxiliador.getVertices().get(i);
                for (VerticeValorado vertice1 : vertices) {
                    if (vertice1.getValor().equals(a.getValor())) {
                        int aux1 = vertices.indexOf(vertice1);
                        int aux2 = vertices.indexOf(vertice);
                        if (dist.get(aux1) > dist.get(aux2) + a.getDist()) {
                            dist.set(aux1, dist.get(aux2) + a.getDist());
                            path1.set(aux1, aux2);
                        }
                    }
                }
            }

            ArrayList<Float> listaMenorCaminho = new ArrayList();
            for (int i = 0; i < grafo.size(); i++) {
                if (!explorado.get(i)) {
                    listaMenorCaminho.add(dist.get(i));
                }
            }

            Collections.sort(listaMenorCaminho);
            for (int j = 0; j < grafo.size(); j++) {
                if (!explorado.get(j) && (dist.get(j).floatValue() == listaMenorCaminho.get(0).floatValue())) {
                    vertice = vertices.get(j);
                    explorado.set(j, true);
                }
            }

            for (int k = 0; k < path1.size(); k++) {
                if (path2.get(k).equals("-")) {
                    path2.set(k, "-");
                } else {
                    path2.set(k, vertices.get(Integer.parseInt(path1.get(k).toString())));
                }
            }

        }

        for (int i = 0; i < grafo.size(); i++) {
            VerticeValorado vertFinal = vertices.get(i);
            caminho.add(vertFinal);
            while (!caminho.contains("-")) {
                caminho.add(path2.get(vertices.indexOf(vertFinal)));
                vertFinal = path2.get(vertices.indexOf(vertFinal)) instanceof VerticeValorado ? (VerticeValorado) path2.get(vertices.indexOf(vertFinal)) : null;
            }
            caminho.pop();
            Collections.reverse(caminho);

            System.out.print("Distância miníma de " + verticeInicio.getValor() + " para " + vertices.get(i).getValor() + ": " + dist.get(i) + " => CAMINHO: ");
            for (int j = 0; j < caminho.size(); j++) {
                System.out.print(" - " + (caminho.get(j) instanceof VerticeValorado ? ((VerticeValorado) caminho.get(j)).getValor() : null));
            }
            System.out.println("");
            caminho = new Stack();
        }
    }
}
