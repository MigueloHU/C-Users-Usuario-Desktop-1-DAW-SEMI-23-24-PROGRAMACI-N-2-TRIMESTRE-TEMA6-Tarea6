package criaturas;

import java.util.Random;

/**
 * Representa a una bestia de tipo Trasgo en el juego.
 */
public class Trasgo extends Bestia {

    /**
     * Constructor de la clase Trasgo.
     * @param nombre El nombre del Trasgo.
     * @param puntosVida Los puntos de vida del Trasgo.
     * @param nivelArmadura El nivel de armadura del Trasgo.
     */
    public Trasgo(String nombre, int puntosVida, int nivelArmadura) {
        super(nombre, puntosVida, nivelArmadura);
    }

    /**
     * Implementación del método atacar para los Trasgos.
     * Genera un número aleatorio entre 0 y 89 para simular la potencia de ataque.
     * Calcula el daño infligido al oponente y lo muestra por pantalla.
     * @param otro La criatura objetivo del ataque.
     */
    @Override
    public void atacar(Criatura otro) {
        if (otro != null) {
            // Genera un número aleatorio para simular la potencia de ataque del Trasgo
            Random random = new Random();
            int potenciaAtaque = random.nextInt(90);

            // Calcula el daño infligido por el Trasgo al oponente
            int danioInfligido = Math.max(0, potenciaAtaque - otro.getNivelArmadura());
            otro.setPuntosVida(otro.getPuntosVida() - danioInfligido);

            System.out.println("Potencia de ataque Trasgo: " + potenciaAtaque);
            System.out.println("Daño inflingido Trasgo: " + danioInfligido);
        }
    }
} //Fin clase

