import java.util.LinkedList;
/**
 * Clase <code>FuncionEvaluacion</code>
 * Clase en donde se construye la funcion de evaluacion
 * de evaluacion
 * @author Galicia Mendoza Fernando Abigail
 * @author Galvan Gamez Edwin Antonio
 * @author Prieto Larios Estefania
 * @version 1.0
 * @since 06/11/2014
 */
public class Juego{

  private Grafica tablero;
  
  /**
  * Metodo <code>constructor<code>
  * Contruye la funcion sin valor
  */
  public FuncionEvaluacion(Grafica g){
    this.tablero=tablero;
  }
    
  /*
  * Metodo privado que obtiene a jugador max
  */
  private Jugador obtenJugadorMAX(){
    Jugador jugador1;
    int totalVertices = g.verticesNum();
    for(int i = 1; i <= totalVertices; i++){
      Pais rep = vertex(i).daRepresentante(); //Obtenemos el pais que representa al vertice
      if(rep.daJugador().daNombre() == "max"){ //Verificamos que sea max
	jugador1 = rep.daJugador();
	break;
      }
    }
    return jugador1;
  }
  
  /*
  * Metodo privado que obtiene a jugador min
  */
  private Jugador obtenJugadorMIN(){
    Jugador jugador1;
    int totalVertices = g.verticesNum();
    for(int i = 1; i <= totalVertices; i++){
      Pais rep = vertex(i).daRepresentante(); //Obtenemos el pais que representa al vertice
      if(rep.daJugador().daNombre() == "min"){ //Verificamos que sea min
	jugador1 = rep.daJugador();
	break;
      }
    }
    return jugador1;
  }
  
  /*
  * Metodo privado que checa los vecinos de cada pais ocupado
  * por min.
  */
  private int condicion1(Jugador j1, Jugador j2){
    int cuenta = 0;
    boolean[] paises1 = j1.daPaises();
    for(int i = 0; i < paises.length; i++){
      if(paises1[i]){ //Si el pais esta ocupado
	LinkedList<Vertice> vecinos = g.neighbours(i+1); //Obtenemos los vecino del pais ocupado
	for(int i = 0; i <= vecinos.size(); i++){
	  int id = ((Vertice)vecinos.get(i)).daIdentificador(); //Obtenemos el id del pais
	  if(j2.daPais(id-1)) cuenta++; //Si esta ocupado, aumentamos el contador
	}
      }
    }
    return cuenta;
  }
  
  /*
  * Metodo privado que checa la diferencia de tropas dados dos vertices
  * adyacentes
  */
  private int condicion2(Jugador j1, Jugador j2){
    int cuenta = 0;
    boolean[] paises1 = j1.daPaises();
    for(int i = 0; i < paises.length; i++){
      if(paises1[i]){ //Si el pais esta ocupado
	LinkedList<Vertice> vecinos = g.neighbours(i+1); //Obtenemos los vecino del pais ocupado
	for(int i = 0; i <= vecinos.size(); i++){
	  int id = ((Vertice)vecinos.get(i)).daIdentificador(); //Obtenemos el id del pais
	  if(j1.tropas[i] > j2.tropas[id-1]) cuenta++;
	  if(j1.tropas[i] < j2.tropas[id-1]) cuenta--;
	}
      }
    }
    return cuenta;
  }
  
  /**
  * Metodo <code>funcion<code>
  * Simula la funcion de evaluacion dada la grafica
  * @return int - Evaluacion de la grafica
  */
  public int funcion(){
    int total = 0;
    Jugador jugador1 = obtenJugadorMAX();
    Jugador jugador2 = obtenJugadorMIN();
    if(jugador1.totalPaises() = g.verticesNum()){
	total = Integer.MAX_VALUE; 
    }else{
      if(jugador2.totalPaises() = g.verticesNum()){ 
	  total = Integer.MIN_VALUE; 
      }else{
	total = jugador1.totalPaises()+jugador1.totalTropas()-jugador2.totalPaises()-jugador2.totalTropas()
	-condicion1(juegador1,jugador2)+condicion2(jugador1, jugador2);
      }
    }
    return total;
  }
}
