import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;
import java.uitl.LinkedList;
/**
 * Clase <code>Parseo</code>
 * Clase en donde se encuentran los metodos para sacar la informacion de la grafica desde un archivo XML
 * @author Galicia Mendoza Fernando Abigail
 * @author Galvan Gamez Edwin Antonio
 * @author Prieto Larios Estefania
 * @version 1.0
 * @since 06/11/2014
 */

public class Parseo extends DefaultHandler{

    //Atributos para una grafica
    private LinkedList<Pais> clientes = new LinkedList<Pais>();
    private LinkedList<Integer> verticesAdyacentes = new LinkedList<Integer>();
    private LinkedList<Integer> verticesAdyacentes2 = new LinkedList<Integer>();
    private int numPaises = 0;   
    private int numEnlaces = 0;
    private LinkedList<String> nombresPaises = new LinkedList<String>();
    private LinkedList<Integer> codigosPaises = new LinkedList<Integer>();


    /**
     * Metodo constrcutor que inicializa los booleanos en falso, para el archivo xml.
     */
    public Parseo(){
    }

    /**
     *Metodo <code>startElement</code>. Heredado de la clase DefaultHandler.
     *Recibe notificación de el inicio de un elemento.
     *@param String uri- actua como cadena vacia si uri no tiene espacio de nombres
     *@param String localName- Cadena vacía si el procesamiento no se esta llevando a cabo
     *@param String qName- Cadena vacía si los nombre de los titulos no están disponibles
     *@param Attributes attributes- Atributos unidos a un elemento. Si no hay atributos es un objeto de atributos vacios
     *@throws SAXException- Lanzada por si ocurre un error básico o alerta de información del parser con el XML
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	String name, value;
	if(qName.equalsIgnoreCase("red")){
	    for(int i = 0; i < attributes.getLength(); i++){
		name = attributes.getQName(i);
		value = attributes.getValue(i);
		if(name.equalsIgnoreCase("numPaises"))
		    numEstaciones = Integer.parseInt(value);
		if(name.equalsIgnoreCase("numEnlaces"))
		    numEnlaces = Integer.parseInt(value);
	    }
	}
	if(qName.equalsIgnoreCase("pais")){	
	    numClientesEstacion = 0;
	    for(int i = 0; i < attributes.getLength(); i++){
		name = attributes.getQName(i);
		value = attributes.getValue(i);
		if(name.equalsIgnoreCase("nombrePais")){
		    String nombrePais = value;
		    nombresPaises.add(nombrePais);
		} 
		if(name.equalsIgnoreCase("codigo")){
		    int codigoPais = Integer.parseInt(value);
		    codigosPaises.add(codigoPais);
		}
	    }
	}
	if(qName.equalsIgnoreCase("enlace")){
	    double dist = 0;
	    int primerPais = 0;
	    int segundoPais = 0;
	    for(int i = 0; i < attributes.getLength(); i++){
		name = attributes.getQName(i);
		value = attributes.getValue(i);
		if(name.equalsIgnoreCase("paisUno")){
		    primerPais = Integer.parseInt(value);
		    verticesAdyacentes2.add(primerPais);
		}
		if(name.equalsIgnoreCase("paisDos")){
		    segundoPais = Integer.parseInt(value);
		    verticesAdyacentes.add(segundoPais);
		}
	    }
	}
    }//startElement

    /**
     *Metodos <code>endElement</code>. Heredado de la clase DefaultHandler.
     *Recibe la notificacion de el termino de un elemento.
     *@param String uri- actua como cadena vacia si uri no tiene espacio de nombres
     *@param String localName- Cadena vacía si el procesamiento no se esta llevando a cabo
     *@param String qName- Cadena vacía si los nombre de los titulos no están disponibles
     *@throws SAXException- Cualquier excepción que se presente de la clase
     */
    public void endElement(String uri, String localName,String qName) throws SAXException{
	if(qName.equalsIgnoreCase("red")){
	}
    }

    /**
     *Metodos <code>parseDocument</code>. 
     *Hace el parse con el contenido de un archivo XML. Extraer la información de un archivo
     *.xml, para luego trabajar con ésta información.
     */
    public void parseDocument(InputStream is) {
	SAXParserFactory spf = SAXParserFactory.newInstance();
	try {
	    SAXParser sp = spf.newSAXParser();
	    sp.parse(is, this);
	}catch(SAXException se) {
	    se.printStackTrace();
	}catch(ParserConfigurationException pce) {
	    pce.printStackTrace();
	}catch (IOException ie) {
	    ie.printStackTrace();
	}
    }

    /**
     * Metodo <code>daListaVerticesAdyacentesInicial</code>
     * Devuelve el identificador de los primeros vertices adyacentes al vertice actual
     * @return ListaLigada - Lista con los identificadores de los vertices adyacentes al vertice actual
     */
    public LinkedList<Integer> daListaVerticesAdyacentesInicial(){
	return verticesAdyacentes2;
    }


    /**
     * Metodo <code>daListaVerticesAdyacentesFinal</code>
     * Devuelve el identificador de los segundos vertices adyacentes al vertice actual
     * @return ListaLigada - Lista con los identificadores de los vertices adyacentes al vertice actual
     */
    public LinkedList<Integer> daListaVerticesAdyacentesFinal(){
	return verticesAdyacentes;
    }

    
    /**
     * Metodo <code>daNumEstaciones</code>
     * Nos devuelve el entero que indica el numero de estaciones (vertices)
     * @return int - el número de estaciones
     */
    public int daNumPaises(){
	return numPaises;
    }
     
    /**
     * Metodo <code>daNumEnlaces</code>
     * Nos devuelve el entero que indica el numero de enlaces en la grafica
     * @return int - el número de enlaces
     */
    public int daNumEnlaces(){
	return numEnlaces;
    }

    /**
     * Metodo <code>daListaNombresEstaciones</code>
     * Nos devuelve la lista que contiene los nombres de las estaciones
     * @return ListaLigada - lista con los nombres de las estaciones
     */
    public LinkedList<String> daListaNombresPaises(){
	return nombresPaises;
    }

    /**
     * Metodo <code>daListaCodigosEstaciones</code>
     * Nos devuelve la lista de los codigos (identificadores) de las estaciones
     * @return ListaLigada - Lista con los identificadores de las estaciones
     */
    public LinkedList<String> daListaCodigosPaises(){
	return codigosPaises;
    }
}

