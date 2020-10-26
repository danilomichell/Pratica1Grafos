package praticadegrafos;

import java.util.ArrayList;

public class VerticeValorado {

    private String valor;
    private boolean visitado;
    private float dist;
    private ArrayList<VerticeValorado> vertices;

    public VerticeValorado(String valor) {
        this.vertices = new ArrayList<>();
        this.visitado = false;
        this.valor = valor;
        this.dist = 0;
    }

    public VerticeValorado(String valor, float dist) {
        this.vertices = new ArrayList<>();
        this.valor = valor;
        this.visitado = false;
        this.dist = dist;
    }

    public VerticeValorado(String valor, float dist, ArrayList<VerticeValorado> adjacentes) {
        this.vertices = adjacentes;
        this.valor = valor;
        this.visitado = false;
        this.dist = dist;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public float getDist() {
        return dist;
    }

    public void setDist(float dist) {
        this.dist = dist;
    }

    public ArrayList<VerticeValorado> getVertices() {
        return vertices;
    }

    public void setListaAdjacentes(ArrayList<VerticeValorado> vertices) {
        this.vertices = vertices;
    }

}
