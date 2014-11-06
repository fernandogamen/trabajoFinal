import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;
import java.util.LinkedList;
/**
 * Clase <code>Grafica</code>
 * Clase en donde se construye la grafica a partir de la lectura del archivo xml el cual contiene
 * la informacion de las aristas, los vertices, el tamaño de la grafica y la distancia entre los vertices
 * @author Galicia Mendoza Fernando Abigail
 * @author Galvan Gamez Edwin Antonio
 * @author Prieto Larios Estefania
 * @version 1.0
 * @since 06/11/2014
 */
public class Grafica implements TDAGrafica{

    //Atributos
    int numPaises;
    Vertice[][] vertices; //Grafica vista como una matriz
    LinkedList<Vertice> listaVert = new LinkedList<Vertice>();


    /**
     * Metodo <code>Constructor por omision</code>
     */
    public Grafica(){
    }

    /**
     * Metodo <code>create</code>
     * Crea una grafica de un número de vertices dado sin aristas
     * @param int - Numero de vertices de la grafica
     */
    public void create(int numVertices){
	vertices = new Vertice[numVertices][numVertices];
	for(int i = 0; i < vertices.length; i++){
	    for(int j = 0; j < vertices[i].length; j++){
		vertices[i][j] = null;
	    }
	}
    }

    /*
     * Metodo privado, dada una lista invierte el orden de los elementos de la lista
     */
    private LinkedList<E> invierteLista(LinkedList<E> lista){
	LinkedList<E> invertida = new LinkedList<E>();
	for(int i = 1; i <= lista.size(); i++)
	    invertida.add(lista.get(i));
	return invertida;
    }
    
    /**
     * Metodo <code>llenaGrafica</code>
     * Se encarga de llenar con valores no nulos, los vertices de la grafica, ademas de las aristas que contendra esta
     * para cada vertice. Los datos con los que se llena la grafica son obtenidos despues de haber parseado un archivo xml
     * que contiene toda la informacion de la grafica.
     * @param Parseo - Objeto con el cual se parsean los datos del archivo XML
     */
    public void llenaGrafica(Parseo p){
	LinkedList<String> nombres = invierteLista(p.daListaNombresPaises());
	LinkedList<Integer> codigos = invierteLista(p.daListaCodigosEstaciones());
	LinkedList<Arista> aristas = edges(p);
	for(int i = 0; i < vertices.length; i++){
	    LinkedList<Arista> aux = new LinkedList<Arista>();
	    for(int k = 0; k <= aristas.size(); k++){
		if(((Integer)((Arista)aristas.get(k)).daVertInicial()).equals((Integer)codigos.get(i)))
		    aux.add(aristas.get(k));
	    }
	    for(int l = 0; l <= aux.size(); l++)
		vertices[i][((Arista)aux.get(l)).daVertFinal()-1] = new Vertice(
		new Pais((String)nombres.get(i),(Integer)codigos.get(i),new Jugador(verticesNum())),
		(Integer)codigos.get(i),aux);
	    for(int k = 0; k <= aux.size(); k++)
		vertices[i][((Arista)aux.get(k)).daVertFinal()-1].ponBoolVertice(false);
	}
    }
    
    /**
     * Metodo <code>verticesNum</code>
     * Nos dá el número de vertices en la grafica
     * @return int - el numero de vertices de la grafica
     */
    public int verticesNum(){
	return vertices.length;
    }

    /**
     * Metodo <code>vertices</code>
     * Nos devuelve la grafica, la cual es representada con una matriz
     * @return Vertice[][] - la grafica como matriz
     */
    public Vertice[][] vertices(){
	return vertices;
    }

    /**
     * Metodo <code>vertex</code>
     * Nos devuelve el vetice con identificador i
     * @param int - identificador del vertice
     * @return Vertice - el vertice con identificador pasado como parametro
     */
    public Vertice vertex(int i){
	for(int k = 0; k < vertices.length; k++){
	    for(int j = 0; j < vertices.length; j++){
		if(vertices[k][j] != null && (vertices[k][j].daIdentificador() == i))
		    return vertices[k][j];
	    }
	}
	return null;
    }

    /**
     * Metodo <code>edgesNum</code>
     * Nos devuelve la cantidad de aristas en la grafica. Pero está informacion en el archivo XML
     * @param Parseo - Objeto para parsear el XML y sacar informacion sobre la grafica
     * @return int - el número de aristas en la grafica
     */
    public int edgesNum(Parseo p){
	return p.daNumEnlaces();
    }

    /**
     * Metodo <code>setEdge</code>
     * Agrega una arista entre dos vertices dado su identificador
     * @param int - identificador del vertice
     * @param int - identificador del vertice
     */
    public void setEdge(int l, int r){
	vertices[l-1][r-1].ponBoolVertice(true);
    }

    /**
     * Metodo <code>edges</code>
     * Nos da una lista ligada la cual contiene todas las aristas de la grafica, leidas desde el archivo XML
     * @param Parseo - Objeto para realizar el parseo de la informacion de la grafica
     * @return ListaLigada - Lista que contiene todas las aristas de la grafica
     */
    public LinkedList<Arista> edges(Parseo p){
	LinkedList<Arista> aristas = new LinkedList<Arista>();
	for(int i = 1; i <= p.daListaVerticesAdyacentesInicial().size(); i++){
	    Arista ar = new Arista((Integer)p.daListaVerticesAdyacentesInicial().get(i),
				   (Integer)p.daListaVerticesAdyacentesFinal().get(i), (Double)(p.daDistanciaEntreVertices().get(i)));
	    aristas.add(1, ar);
	}
	for(int i = 1; i <= p.daListaVerticesAdyacentesInicial().size(); i++){
	    Arista ar = new Arista((Integer)p.daListaVerticesAdyacentesFinal().get(i),
				   (Integer)p.daListaVerticesAdyacentesInicial().get(i), (Double)(p.daDistanciaEntreVertices().get(i)));
	    aristas.add(1, ar);
	}
	return aristas;
    }

    /**
     * Metodo <code>edge</code>
     * Nos devuelve una arista dado su identificador
     * @param int - el identificador de la arista
     * @param Parseo - Objeto para obetener informacion de la grafica
     * @return Arista - la arista con identificador i
     */
    public Arista edge(int i, Parseo p){
	return (Arista)edges(p).get(i);
    }

    /**
     * Metodo <code>neighbours</code>
     * Dado el identificador de un vertice, nos devuelve una lista ligada que contiene los vertices adyacentes a esta
     * @param int - identificador del vertice
     * @return ListaLigada - lista con los vertices adyacentes
     */
    public LinkedList<Vertice> neighbours(int i){
	LinkedList<Vertice> ls = new ListaLigada();
	if(vertex(i) != null){
	    return vertex(i).daAristas();
	}
	return null;
    }

    /**
     * Metodo <code>areAdyacent</code>
     * Dados dos identificadores de dos vertices, se verifica si estos son adyacentes o no
     * @param int - identificador de un vertice
     * @param int - identificador de un vertice
     * @return boolean - true si son adyacentes, false en caso contrario
     */
    public boolean areAdyacent(int i, int j){
	Vertice aux = vertex(i);
	if(aux == null){
	    return false;
	}else{
	    ListaLigada arist = aux.daAristas();
	    for(int t = 1; t <= arist.size(); t++){
		if(((Arista)arist.get(t)).daVertFinal() == j)
		    return true;
	    }

	}
	return false;
    }
}