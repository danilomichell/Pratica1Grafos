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

    //Menor caminho do vertice de inicio para todos os vertice
    public static void menorCaminho1(String origem, ArrayList<VerticeValorado> grafo) {
        VerticeValorado verticeInicio = null;
        VerticeValorado controle = null;
        ArrayList<VerticeValorado> vertices = new ArrayList();
        ArrayList<Boolean> explorado = new ArrayList();
        ArrayList<Float> dist = new ArrayList();
        ArrayList path1 = new ArrayList();
        ArrayList path2 = new ArrayList();
        Stack pilhaCaminho = new Stack();
        for (int i = 0; i < grafo.size(); i++) {
            if ((grafo.get(i).getValor()).equals(origem)) {
                verticeInicio = grafo.get(i);
                controle = grafo.get(i);
            }
        }
        //Coloca os vertices na lista
        for (int i = 0; i < grafo.size(); i++) {
            vertices.add(grafo.get(i));
        }
        //Iniciar o explorado, todos como false pois nao iniciou o algoritmo
        for (int i = 0; i < grafo.size(); i++) {
            explorado.add(i, false);
        }
        //Inicia o vertice de inicio no explorado passando como "true"
        explorado.set(vertices.indexOf(controle), true);
        //Inicia o dist, todos como 0
        for (int i = 0; i < grafo.size(); i++) {
            dist.add(0, Float.POSITIVE_INFINITY);
        }
        //Inicia o vertice de inicio no dist recebendo 0
        dist.set(vertices.indexOf(controle), (float) 0);
        //Inicia o path1 e path2
        for (int i = 0; i < grafo.size(); i++) {
            if (i == vertices.indexOf(controle)) {
                path1.add("-");
                path2.add("-");
            } else {
                path1.add(0);
                path2.add(0);
            }
        }
        // Pega os adjacentes e calcula os caminhos para cada um
        while (explorado.contains(false)) {
            //Inicia um auxiliador de controle
            VerticeValorado auxiliador = grafo.get(grafo.indexOf(controle));
            for (int i = 0; i < auxiliador.getVertices().size(); i++) {
                //Controle dos vertices adjacentes
                VerticeValorado a = auxiliador.getVertices().get(i);
                for (int j = 0; j < vertices.size(); j++) {
                    if (vertices.get(j).getValor().equals(a.getValor())) {
                        int aux1 = vertices.indexOf(vertices.get(j));
                        int aux2 = vertices.indexOf(controle);
                        if (dist.get(aux1) > dist.get(aux2) + a.getDist()) {
                            dist.set(aux1, dist.get(aux2) + a.getDist());
                            path1.set(aux1, aux2);
                        }
                    }
                }
            }
            //Atualiza o menor caminho no dist
            ArrayList<Float> listaMenorCaminho = new ArrayList();
            for (int i = 0; i < grafo.size(); i++) {
                if (!explorado.get(i)) {
                    listaMenorCaminho.add(dist.get(i));
                }
            }
            //Adiciona "true" a lista Explorado quando vertice for explorado
            Collections.sort(listaMenorCaminho);
            for (int j = 0; j < grafo.size(); j++) {
                if (!explorado.get(j) && (dist.get(j).floatValue() == listaMenorCaminho.get(0).floatValue())) {
                    controle = vertices.get(j);
                    explorado.set(j, true);
                }
            }
            //Pega os valores de path1 e transforma em vértices no path2
            for (int i = 0; i < path1.size(); i++) {
                if (path2.get(i).equals("-")) {
                    path2.set(i, "-");
                } else {
                    path2.set(i, vertices.get(Integer.parseInt(path1.get(i).toString())));
                }
            }

        }
        //Printa os caminhos armazenados na pilhaCaminho
        for (int i = 0; i < grafo.size(); i++) {
            VerticeValorado verticeFinal = vertices.get(i);
            pilhaCaminho.add(verticeFinal);
            while (!pilhaCaminho.contains("-")) {
                pilhaCaminho.add(path2.get(vertices.indexOf(verticeFinal)));
                verticeFinal = path2.get(vertices.indexOf(verticeFinal)) instanceof VerticeValorado ? (VerticeValorado) path2.get(vertices.indexOf(verticeFinal)) : null;
            }
            pilhaCaminho.pop();
            Collections.reverse(pilhaCaminho);

            System.out.print("Menor caminho de " + verticeInicio.getValor() + " até " + vertices.get(i).getValor() + ": " + dist.get(i) + " | Path: ");
            for (int j = 0; j < pilhaCaminho.size(); j++) {
                System.out.print(" - " + ((VerticeValorado) pilhaCaminho.get(j)).getValor());
            }
            System.out.println("");
            pilhaCaminho = new Stack();
        }
    }

    //Menor caminho do vertice de inicio para todos os vertice
    public static void menorCaminho2(String origem, String destino, ArrayList<VerticeValorado> grafo) {
        VerticeValorado verticeInicio = null;
        VerticeValorado controle = null;
        VerticeValorado verticeDestino = null;
        ArrayList<VerticeValorado> vertices = new ArrayList();
        ArrayList<Boolean> explorado = new ArrayList();
        ArrayList<Float> dist = new ArrayList();
        ArrayList path1 = new ArrayList();
        ArrayList path2 = new ArrayList();
        Stack pilhaCaminho = new Stack();
        //Pega o vertice de origem valorado
        for (int i = 0; i < grafo.size(); i++) {
            if ((grafo.get(i).getValor()).equals(origem)) {
                verticeInicio = grafo.get(i);
                controle = grafo.get(i);
            }
        }
        //Pega o vertice de destino valorado
        for (int i = 0; i < grafo.size(); i++) {
            if ((grafo.get(i).getValor()).equals(destino)) {
                verticeDestino = grafo.get(i);
            }
        }
        //Coloca os vertices na lista
        for (int i = 0; i < grafo.size(); i++) {
            vertices.add(grafo.get(i));
        }
        //Iniciar o explorado, todos como false pois nao iniciou o algoritmo
        for (int i = 0; i < grafo.size(); i++) {
            explorado.add(i, false);
        }
        //Inicia o vertice de inicio no explorado passando como "true"
        explorado.set(vertices.indexOf(controle), true);
        //Inicia o dist, todos como 0
        for (int i = 0; i < grafo.size(); i++) {
            dist.add(0, Float.POSITIVE_INFINITY);
        }
        //Inicia o vertice de inicio no dist recebendo 0
        dist.set(vertices.indexOf(controle), (float) 0);
        //Inicia o path1 e path2
        for (int i = 0; i < grafo.size(); i++) {
            if (i == vertices.indexOf(controle)) {
                path1.add("-");
                path2.add("-");
            } else {
                path1.add(0);
                path2.add(0);
            }
        }
        // Pega os adjacentes e calcula os caminhos para cada um
        while (explorado.contains(false)) {
            //Inicia um auxiliador de controle
            VerticeValorado auxiliador = grafo.get(grafo.indexOf(controle));
            for (int i = 0; i < auxiliador.getVertices().size(); i++) {
                //Controle dos vertices adjacentes
                VerticeValorado a = auxiliador.getVertices().get(i);
                for (int j = 0; j < vertices.size(); j++) {
                    if (vertices.get(j).getValor().equals(a.getValor())) {
                        int aux1 = vertices.indexOf(vertices.get(j));
                        int aux2 = vertices.indexOf(controle);
                        if (dist.get(aux1) > dist.get(aux2) + a.getDist()) {
                            dist.set(aux1, dist.get(aux2) + a.getDist());
                            path1.set(aux1, aux2);
                        }
                    }
                }
            }
            //Atualiza o menor caminho no dist
            ArrayList<Float> listaMenorCaminho = new ArrayList();
            for (int i = 0; i < grafo.size(); i++) {
                if (!explorado.get(i)) {
                    listaMenorCaminho.add(dist.get(i));
                }
            }
            //Adiciona "true" a lista Explorado quando vertice for explorado
            Collections.sort(listaMenorCaminho);
            for (int j = 0; j < grafo.size(); j++) {
                if (!explorado.get(j) && (dist.get(j).floatValue() == listaMenorCaminho.get(0).floatValue())) {
                    controle = vertices.get(j);
                    explorado.set(j, true);
                }
            }
            //Pega os valores de path1 e transforma em vértices no path2
            for (int i = 0; i < path1.size(); i++) {
                if (path2.get(i).equals("-")) {
                    path2.set(i, "-");
                } else {
                    path2.set(i, vertices.get(Integer.parseInt(path1.get(i).toString())));
                }
            }

        }
        //Printa o caminho ate o vertice de destino armazenado na pilhaCaminho
        //Nao possui o for pois printa apenas o caminho ate o vertice de destino
        VerticeValorado verticeFinal = verticeDestino;
        pilhaCaminho.add(verticeFinal);
        while (!pilhaCaminho.contains("-")) {
            pilhaCaminho.add(path2.get(vertices.indexOf(verticeFinal)));
            verticeFinal = path2.get(vertices.indexOf(verticeFinal)) instanceof VerticeValorado ? (VerticeValorado) path2.get(vertices.indexOf(verticeFinal)) : null;
        }
        pilhaCaminho.pop();
        Collections.reverse(pilhaCaminho);
        System.out.print("Menor caminho de " + verticeInicio.getValor() + " até " + verticeDestino.getValor() + ": " + dist.get(vertices.indexOf(verticeDestino)) + " | Path: ");
        for (int j = 0; j < pilhaCaminho.size(); j++) {
            System.out.print(" - " + ((VerticeValorado) pilhaCaminho.get(j)).getValor());
        }
        System.out.println("");
        pilhaCaminho = new Stack();
    }
}
