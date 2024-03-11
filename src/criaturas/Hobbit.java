package criaturas;

import java.util.Random;

/**
 * Representa a un héroe de tipo Hobbit en el juego.
 */

public class Hobbit extends Heroe {

    /**
     * Constructor de la clase Hobbit.
     * @param nombre El nombre del Hobbit.
     * @param puntosVida Los puntos de vida del Hobbit.
     * @param nivelArmadura El nivel de armadura del Hobbit.
     */
    public Hobbit(String nombre, int puntosVida, int nivelArmadura) {
        super(nombre, puntosVida, nivelArmadura);
    }

    /**
     * Implementación del método atacar para los Hobbits.
     * Genera dos números aleatorios entre 0 y 99 y utiliza el mayor
     * como potencia de ataque. Si el objetivo es un Trasgo, se reduce
     * la potencia de ataque en 5 unidades. Calcula el daño infligido
     * al objetivo restando su nivel de armadura a la potencia de ataque.
     * @param otro La criatura objetivo del ataque.
     */
    @Override
    public void atacar(Criatura otro) {
        if (otro != null) {
            // Genera dos números aleatorios para cada dado.
            Random random = new Random();
            int dado1 = random.nextInt(100);
            int dado2 = random.nextInt(100);
            //Selecciona el dado más alto para asignar la potencia de ataque.
            int potenciaAtaque = Math.max(dado1, dado2);
            System.out.println("Potencia de ataque Hobbit: " + potenciaAtaque);

             // Si el objetivo es un Trasgo, se reduce la potencia de ataque
            if (otro instanceof Trasgo) {
                potenciaAtaque -= 5; // Reducción de potencia contra trasgos
            }

            //Calcula el daño infligido.
            int danioInfligido = Math.max(0, potenciaAtaque - otro.nivelArmadura);
            //Resta los puntos de vida a la criatura atacada
            otro.puntosVida -= danioInfligido;
            System.out.println("Daño inflingido Hobbit: " + danioInfligido);
        }
    }
} //Fin Main
