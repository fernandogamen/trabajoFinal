/**
 * Clase <code>Arista</code>
 * Se crea un objeto del tipo arista, el cual representa las aristas de una grafica no dirigida
 * @author Garcia Cortes Emilio
 * @author Galicia Mendoza Fernando Abigail
 * @version 1.0
 * @since 09/06/2012
 */
public class Arista{
    //Atributos
    private int verticeFinal;
    private int verticeInicial;
    private Vertice first;
    private Vertice last;

    /**
     * Metodo <code>constructor</code>
     * Se crea un constructor de la clase
     * @param int - identificador del vertice inicial
     * @param int - identificador del vertice adyacente
     */
    public Arista(int verticeInicial, int verticeFinal){
	this.verticeFinal = verticeFinal;
	this.verticeInicial = verticeInicial;
    }

    /**
     * Metodo <code>constructor</code>
     * Se crea un constructor de la clase
     * @param Vertice - vertice inicial
     * @param Vertice - vertice adyacente
     */
    public Arista(Vertice v1, Vertice v2){
	first = v1;
	last = v2;
    }

    /**
     * Metodo <code>daVerticeFirst</code>
     * Nos devuelve el vertice inicial de una arista
     * @return Vertice - vertice inicial de la arista
     */
    public Vertice daVerticeFirst(){
	return first;
    }

    /**
     * Metodo <code>daVerticeLast</code>
     * Nos devuelve el vertice adyacente al vertice inicial
     * @return Vertice - vertice adyacente
     */
    public Vertice daVerticeLast(){
	return last;
    }

    /**
     * Metodo <code>daVertInicial</code>
     * Nos devuelve el identificador del vertice inicial
     * @return int - el identificador del vertice inicial
     */
    public int daVertInicial(){
	return verticeInicial;
    }

    /**
     * Metodo <code>daVertFinal</code>
     * Nos devuelve el identificador del vertice adyacente
     * @return int - identificador del vertice adyacente
     */
    public int daVertFinal(){
	return verticeFinal;
    }

    /**
     * Metodo <code>toString</code>
     * Nos dal el formato de impresion de un objeto Arista
     * @return String - la informacion de un aarista
     */
    public String toString(){
	return "Vertice Actual: " + daVerticeFirst() + " Vertice adyacente: " + daVerticeLast() + " Distancia: " + daDist();
    }
}