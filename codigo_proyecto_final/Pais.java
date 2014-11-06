/**
* Clase <code>Pais<code> que representa a un pais
* donde cada pais tiene conocimiento de que jugador
* lo tiene invadido.
 * @author Galicia Mendoza Fernando Abigail
 * @author Galvan Gamez Edwin Antonio
 * @author Prieto Larios Estefania
 * @version 1.0
 * @since 06/11/2014
*/

public class Pais{

	//nombre del país
	private String nomPais;
	//jugador que lo posee
	private Jugador jugador;
	//id del pais
	private int id;
	
	/**
	* Metodo <code>constructor<code>
	* Que dado el nombre del jugador y total de paises
	* crea a un jugador y asigna a las tablas sus correspondientes
	* valores iniciales, i.e., ningun pais ocupado y 0 tropas en cada
	* pais
	*/
	public Pais(String nomPais,int id,Jugador jugador){
		this.nomPais = nomPais;
		this.jugador = jugador;
		this.id = id;
	}

	/**
	* Metodo <code>getNombrePais<code> 
	* que devuelve el nombre del pais
	* @return String - nombre del país
	*/
	public String getNombrePais(){
		return nomPais;
	}
	
	/**
	* Metodo <code>getJugador<code> 
	* que devuelve el jugador
	* @return Jugador - jugador que tiene invadido el pais
	*/
	public Jugador getJugador(){
		return jugador;
	}
	
	/**
	* Metodo <code>getId<code> 
	* que devuelve el id del pais
	* @return int - id del pais
	*/
	public int getId(){
	  return id;
	}
	
	/**
	* Metodo <code>setJugador<code>
	* que asigna un nuevo jugador al pais
	* @param jugadornuevo - Nuevo jugador
	*/
	public void setJugador(Jugador jugadornuevo){
		this.jugador = jugadornuevo;
	}
	
	/**
	* Metodo <code>toString<code>
	* Impresion del pais
	* @return String - Vision del pais
	*/
	public Strin toString(){
	  return "Pais "+nomPais+"\tJugador "+jugador;
}


