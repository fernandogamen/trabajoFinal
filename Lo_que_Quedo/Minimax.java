import java.util.LinkedList;
import java.util.Queue;
/**
 * Clase <code>Minimax</code>
 * Se implementa el algoritmo minimax, funcion de evaluacion
 * y posibles movimientos.
 * El algoritmo minimax, hara la simulacion de un arbol sin la
 * necesidad de tal estructura, utilizando un metodo recursivo.
 * @author Galicia Mendoza Fernando Abigail
 * @author Galvan Gamez Edwin Antonio
 * @author Prieto Larios Estefania
 * @version 1.0
 * @since 06/11/2014
*/
public class Minimax{
  
  private Grafica tablero;

  /**
  * Metodo constructor de la clase
  * @param tablero - Grafica con la que inicia el algoritmo
  */
  public Minimax(Grafica tablero){
    this.tablero = tablero;
  }
  
  /**
  * Metodo <code>mejorMovimiento</code>
  * Devuelve la grafica con el mejor movimiento para max
  * @return Grafica - Grafica con el mejor movimiento
  */
  public Grafica mejorMovimiento(){
    Grafica mejor = minimax(4, int jugador, tablero); //Calculamos la mejor estrategia para max, una arbol de 4 niveles
    return mejor;
  }
  
  /*
  * Metodo privado que simula a minimax
  * Simula la creacion de un arbol por medio de la creacion de todos los movimientos posibles
  * esto se logra gracias a que la cantidad de movimientos es finita y la parte recursiva
  * del algoritmo ayuda a la simulacion de la creacion de nodos
  */
  private Grafica minimax(int profundidad, int jugador, Grafica inicial){
    //Generamos una lista de graficas con todos los posibles movimientos
    LinkedList<Grafica> movimientos = generaMovimientos(inicial);
    //Esto simulara la creacion de nodos del arbol de juego
    
    //Si el ganador es max daremos el maximo de los enteros, e.o.c. daremos el minimo
    int mejorPuntuacion = (jugador == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    int puntuacionActual;
    Grafica mejor = null; //Aun no hay mejor jugada
    
    if(movimientos.isEmpty() || profundidad == 0){ //Si ya no hay mas movimientos o llegamos a una hoja
      mejorPuntuacion = funcionEvaluacion(inicial); //Evaluamos la grafica
    }else{
      for(Grafica movimiento:movimientos){
	if(jugador == 1){ //Si el jugador es max
	  puntuacionActual = minimax(profundidad-1, jugador+1, movimiento);
	  if(puntuacionActual > mejorPuntuacion){
	    mejorPuntuacion = puntuacionActual;
	    mejor = movimiento;
	  }
	}else{
	  puntuacionActual = minimax(profundidad-1, jugador-1, movimiento);
	  if(puntuacionActual < mejorPuntuacion){
	    mejorPuntuacion = puntuacionActual;
	    mejor = movimiento;
	  }
	}
      }
    }
    return mejor; //Regresamos la mejor grafica
  }
  
  /*
  * Metodo privado que cuenta el numero de tropas
  * de cada jugador, suma los que pertenecen a max 
  * y resta los que pertenezcan a min
  * Algoritmo dado por modificaciones en bfs
  */
  private int paisesYTropas(Grafica inicial){
    int puntuacion = 0;
    Queue<Vertice> cola = new LinkedList<Vertice>();
    for(int i = 1; i <= inicial.verticesNum(); i++){
	inicial.vertex(i).ponBoolVertice(false);
    }
    inicial.vertex(1).ponBoolVertice(true);
    cola.add(inicial.vertex(1));
    while(cola.peek() != null){
      Vertice u = cola.remove();
      LinkedList<Arista> vecinos = u.neighbours(u.daIdentificador());
      for(Arista vecino:vecinos){
	Vertice v = inicial.vertex(vecino.daVerticeFinal());
	if(!v.daBoolVertice()){
	  if(v.daInvasor() == 1) puntuacion += v.daTropas()+1;
	  if(v.daInvasor() == 2) puntuacion -= v.daTropas()+1;
	  v.ponBoolVertice(true);
	  cola.add(v);
	}
      }
    }
    return puntuacion;
  }
  
  /*
  * Metodo privado que:
  * 1. Checa cuantos paises invadidos por min son vecinos de uno de max y los suma
  * 2. Checa de los vecinos de max y min, cual es el que tiene el mayor numero de tropas
  * esto se suma o resta respectivamente
  * Este algoritmo busca en cada vertice, por lo cual su eficiencia es n^2, con n
  * numero de vertices
  */
  private int muchosVecinosYTropas(Grafica inicial){
    int puntuacion = 0;
    for(int i = 1; i <= inicial.verticesNum(); i++){
	Vertice u = inicial.vertex(i);
	if(u.daInvasor() == 1){
	  LinkedList<Arista> vecinos = u.neighbours(u.daIdentificador());
	  for(Arista vecino:vecinos){
	    Vertice v = inicial.vertex(vecino.daVerticeFinal());
	    if(v.daInvasor() == 2) puntuacion -= 1;
	    if(u.daTropas() > v.daTropas()) puntuacion += 1;
	    if(u.daTropas() == v.daTropas()) puntuacion += 0;
	    if(u.daTropas() < v.daTropas()) puntuacion -= 1;
	  }
	}
    }
    return puntuacion;
  }
  
  /*
  * Metodo privado que simula la funcion de evaluacion, unicamente
  * suma los valores dados por los metodos paisesYTropas y muchosVecinosYTropas
  */
  private int funcionEvaluacion(Grafica inicial){
    return paisesYTropas(inicial)+muchosVecinosYTropas(inicial);
  }
  
  //Falta generar todos los posibles movimientos y con esto se supone que terminamos el proyecto
}