import java.util.LinkedList;
/**
 * Clase <code>Jugador<code> que simula un jugador para el Risk
 * @author Galicia Mendoza Fernando Abigail
 * @author Galvan Gamez Edwin Antonio
 * @author Prieto Larios Estefania
 * @version 1.0
 * @since 06/11/2014
 */
*/

public class Jugador{

	//Arreglo que representa a los paises ocupados por el jugador, por ejemplo
	//si el pais 0 esta ocupado entonces paises[0] = true
	private boolean[] paises;
	//Arreglo que tendrá a las tropas en cada pais,
	//el indice corresponde al pais, por ejemplo tropas[0] son
	//las tropas que estan en el pais 0
	private int[] tropas;
	//Nombre del jugador
	private String nombreJugador;
	//Numero de paises que tiene el jugador
	private int totalPaises;
	
	/**
	* Metodo <code>constructor<code>
	* Que dado el nombre del jugador y total de paises
	* crea a un jugador y asigna a las tablas sus correspondientes
	* valores iniciales, i.e., ningun pais ocupado y 0 tropas en cada
	* pais
	*/
	public Jugador(String nombreJugador, int totalPaises){
	  this.nombreJugador = nombreJugador;
	  paises = new boolean[totalPaises];
	  tropas = new int[totalPaises];
	  for(int i = 0; i < totalPaises; i++){
	    paises[i] = false;
	    tropas[i] = 0;
	  }
	  totalPaises = 0;
	}
	
	/**
	* Metodo <code>constructor<code>
	* Alternativo, es un jugador sin nombre y sin paises ocupados
	*/
	public Jugador(int totalPaises){
	  nombreJugador = "";
	  paises = new boolean[totalPaises];
	  tropas = new int[totalPaises];
	  for(int i = 0; i < totalPaises; i++){
	    paises[i] = false;
	    tropas[i] = 0;
	  }
	  totalPaises = 0;
	}

	/**
	* Metodo <code>daNombre<code>
	* Devuelve el nombre del jugador
	* @return String - Nombre del jugador
	*/
	public String daNombre(){
	  return nombreJugador;
	}
	
	/**
	* Metodo <code>ponNombre<code>
	* Asigna el nombre del jugador
	* @param nombreJugador - Nombre del jugador
	*/
	public void ponNombre(String nombreJugador){
	  this.nombreJugador = nombreJugador;
	}
	
	/**
	* Metodo <code>totalPaises<code>
	* Devuelve el total de paises
	* @return int - numero de paises ocupados por el jugador
	*/
	public int totalPaises(){
	  return totalPaises;
	}
	
	/**
	* Metodo <code>ingresaPais<code>
	* Dado el identificador del pais, si este en la tabla
	* correspondiente no esta ocupado, cambia su valor a verdadero
	* @param id - identificador del pais
	*/
	public void ingresaPais(int id){
	  if(!paises[id-1]){ 
	    paises[id-1] = true;
	    totalPaises++;
	  }
	}
	
	/**
	* Metodo <code>ingresaTropas<code>
	* Dado el identificador del pais y el numero de tropas
	* si este esta ocupado por el jugador, ingresa el numero de tropas correspondiente
	* @param id - identificador del pais
	* @param tropasP - numero de tropas nuevas
	*/
	public void ingresaTropas(int id, int tropasP){
	  if(paises[id-1]) tropas[id-1] = tropasP;
	}  
	
	/**
	* Metodo <code>totalTropas<code>
	* Devuelve el total de tropas del jugador que estan ocupado paises
	* @return int - total de tropas
	*/
	public int totalTropas(){
	  int contador = 0;
	  for(int i = 0; i < tropas.length; i++){
	    if(paises[i]) contador+=tropas[i];
	  }
	  return contador;
	}
	
	/**
	* Metodo <code>tropas<code>
	* Devuelve el total de tropas del jugador que estan ocupado un pais
	* @return int - total de tropas
	*/
	public int tropas(int id){
	  return tropas[id];
	}
	
	/**
	* Metodo <code>daPaises<code>
	* Devuelve el diccionario de paises
	* @return boolean[] - Diccionario de paises
	*/
	public boolean[] daPaises(){
	  return paises;
	}
	
	/**
	* Metodo <code>daPais<code>
	* Devuelve el diccionario de paises
	* @param id - id del pais
	* @return boolean - True si esta ocupado
	*/
	public boolean daPais(int id){
	  return paises[id];
	}
	
	/**
	* Metodo <code>toString<code>
	* Impresion del jugador
	* @return String - Vision del jugador
	*/
	public String toString(){
	  return "Jugador "+nombreJugador+"\tTotal Paises "+totalPaises()+"\tTotal tropas "+totalTropas();
}
