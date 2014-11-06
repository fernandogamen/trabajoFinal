/**
 * Clase <code>Vertice</code>
 * Se crea un objeto llamado vertice, el cual sirve para modelar los vertices de una grafica dirigida
 * Los vertices seran las estaciones del modelo
 * @author Galicia Mendoza Fernando Abigail
 * @author Galvan Gamez Edwin Antonio
 * @author Prieto Larios Estefania
 * @version 1.0
 * @since 06/11/2014
 */
public class Vertice{
    //Atributos
    Pais representante;
    int id;
    LinkedList<Arista> aristas;
    boolean bolVertice;
    Vertice parent;

    /**
     * Metodo Constructor de la clase
     * @param Pais - Pais que representa al vertice
     * @param int - Identificador del vertice 
     * @param ListaLigada - Lista de objetos aristas del vertice
     */
    public Vertice(Pais representante, int id, LinkedList<Arista> aristas){
	this.representante = representante;
	this.id = id;
	this.aristas = aristas;
	bolVertice = false;
	parent = null;
    }

    /**
     * Metodo <code>daRepresentante</code>
     * Nos da el pais
     * @return Pais - Representante del vertice
     */
    public Pais daRepresentante(){
	return representante;
    }

    /**
     * Metodo <code>daIdentificador</code>
     * Nos da el identificador del vertice
     * @return int - identificador del vertice
     */
    public int daIdentificador(){
	return id;
    }

    /**
     * Metodo <code>daAristas</code>
     * Nos da la lista ligada de las aristas del vertice
     * @return ListaLigada - Lista de las aristas del vertice
     */
    public LinkedList<Arista> daAristas(){
	return aristas;
    }

    /**
     * Metodo <code>ponBoolVertice</code>
     * Permite modificar el valor booleano del vertice (para marcarlo como visitado o no)
     * @param boolean - valor nuevo del vertice
     */
    public void ponBoolVertice(boolean bolVertice){
	this.bolVertice = bolVertice;
    }

    /**
     * Metodo <code>daBoolVertice</code>
     * Nos regresa el valor booleano del vertice
     * @return boolean - el valor booleano del vertice
     */
    public boolean daBoolVertice(){
	return bolVertice;
    }

    /**
     * Metodo <code>ponParent</code>
     * Se encarga de asignarle la tarjete parent a un vertice
     * @param Vertice - el parent del vertice
     */
    public void ponParent(Vertice v){
	parent = v;
    }

    /**
     * Metodo <code>daParent</code>
     * Nos devuelve la etiqueta parent del vertice
     * @return Vertice - la etiqueta parent del vertice
     */
    public Vertice daParent(){
	return parent;
    }

    /**
     * Metodo <code>toString</code>
     * Da el formato para imprimir objetos tipo vertice
     * @return String - la informacion de un vertice
     */
    public String toString(){
	return "Pais: " + daPais() + " \nIdentificador: " + daIdentificador();
    }
}