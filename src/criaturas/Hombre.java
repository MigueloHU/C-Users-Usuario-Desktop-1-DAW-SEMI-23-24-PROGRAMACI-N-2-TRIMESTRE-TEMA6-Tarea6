package criaturas;

import java.util.Random;

/**
 * Clase que representa a un Elfo de tipo Héroe.
 */
public class Hombre extends Heroe {

    /**
     * Constructor de la clase Hombre.
     * @param nombre El nombre del Hombre.
     * @param puntosVida Los puntos de vida del Hombre.
     * @param nivelArmadura El nivel de armadura del Hombre.
     */
    public Hombre(String nombre, int puntosVida, int nivelArmadura) {
        super(nombre, puntosVida, nivelArmadura);
    }

    /**
     * Implementación del método atacar para los Hombres.
     * Genera dos números aleatorios entre 0 y 99 y utiliza el mayor
     * como potencia de ataque. Calcula el daño infligido al objetivo
     * restando su nivel de armadura a la potencia de ataque.
     * @param otro La criatura objetivo del ataque.
     */
    @Override
    public void atacar(Criatura otro) {
        // Genera dos números aleatorios para simular la potencia de ataque
        Random random = new Random();
        int dado1 = random.nextInt(100);
        int dado2 = random.nextInt(100);
        //Selecciona el valor más alto de los dos dados y lo asigna como valor
        //de potencia de atacuq
        int potenciaAtaque = Math.max(dado1, dado2);
        System.out.println("Potencia de ataque Hombre: " + potenciaAtaque);
        
        
        // Calcula el daño infligido
        int danioInfligido = Math.max(0, potenciaAtaque - otro.nivelArmadura);
        
        // Reduce los puntos de vida de la criatura atacada
        otro.puntosVida -= danioInfligido;
        
        // Muestra el daño infligido en la consola
        System.out.println("Daño inflingido Hombre: " + danioInfligido);
    }

    /**
     * Representación del Hombre como String.
     * @return Una cadena que representa al Hombre, incluyendo su nombre y 
     * puntos de vida.
     */
    @Override
    public String toString() {
        return "Hombre: " + super.toString();
    }
} //Fin clase
