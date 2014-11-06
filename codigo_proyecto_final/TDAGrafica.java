/**
 * <code>Interfaz TDAGrafica</code>
 * Implementamos el TDA de una grafica
 * @author Garcia Cortes Emilio
 * @author Galicia Mendoza Fernando Abigail
 * @version 1.0
 * @since 09/06/2012
 */
interface TDAGrafica{
    /**
     * <code>Metodo create</code>
     * Crea una grafica con n vertices sin aristas
     * @param int - El numero de vertices de la grafica
     */
    void create(int n);

    /**
     * <code>Metodo verticesNum</code>
     * Nos devuelve la cantidad de vertices de la grafica
     * @return int - El numero de vertices en la grafica
     */
    int verticesNum();

    /**
     * <code>Metodo vertices</code>
     * Regresa el diccionario de vertices de la grafica
     * @return Vertice[][] - Matriz de la grafica, es una matriz de vertices
     */
    Vertice[][] vertices();

    /**
     * <code>Metodo vertex</code>
     * Nos devuelve el vértice con un identificador dado
     * @param int - identificador de un vertice
     * @return Vertice - vertice con identificador i
     */
    Vertice vertex(int id);

    /**
     * <code>Metodo edgesNum</code>
     * Devuelve el numero de aristas de la grafica
     * @param Parseo - Objeto para leer la informacion de la grafica desde un archivo XML
     * @return int - el numero de aristas en la grafica
     */
    int edgesNum(Parseo p);

    /**
     * <code>Metodo setEdge</code>
     * Coloca una nueva arista entre dos vertices, dado sus identificadores
     * @param int - identificador de un vertice
     * @param int - identidicador de un vertice
     */
    void setEdge(int id1, int id2);

    /**
     * <code>Metodo edges</code>
     * Nos da la lista de todas las aristas en la grafica
     * @param Parseo - Objeto para leer informacion de la grafica desde un XML
     * @return ListaLigada - Nos devuelve una lista ligada con todas las aristas de la grafica
     */
    ListaLigada edges(Parseo p);

    /**
     * <code>Metodo edge</code>
     * Nos devuelve la arista dado su identificador
     * @param int - identificador de la arista
     * @param Parseo - Objeto para leer informacion de la grafica desde un XML
     * @return Arista - La arista con el identificador dado
     */
    Arista edge(int id, Parseo p);

    /**
     * <code>Metodo neighbours</code>
     * Nos devuelve una lista de los vecinos de un vertice dado su identificador
     * @param int -Identificador del vertice
     * @return ListaLigada - Lista con los vertices vecinos del vertice con identificador dado
     */
    ListaLigada neighbours(int id);

    /**
     * <code>Metodo areAdyacent</code>
     * Dados dos identificadores de dos vertices, nos dice si estos son adyacentes
     * @param int - identificador de un vertice
     * @param int - identificador del otro vertice
     * @return boolean - true si los vertices son adyacentes, false en otro caso
     */
    boolean areAdyacent(int id1, int id2);
}