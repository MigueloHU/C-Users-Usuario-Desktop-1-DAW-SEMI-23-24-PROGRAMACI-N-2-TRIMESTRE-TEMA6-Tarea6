package criaturas;

import java.util.Random;

/**
 * Representa a una bestia de tipo Orco en el juego.
 */
public class Orco extends Bestia {

    /**
     * Constructor de la clase Orco.
     * @param nombre El nombre del Orco.
     * @param puntosVida Los puntos de vida del Orco.
     * @param nivelArmadura El nivel de armadura del Orco.
     */
    public Orco(String nombre, int puntosVida, int nivelArmadura) {
        super(nombre, puntosVida, nivelArmadura);
    }

    /**
     * Implementa el método atacar para los Orcos.
     * Genera un número aleatorio entre 0 y 89 para simular la potencia de ataque.
     * Reduce temporalmente la armadura del oponente en un 10%, calcula el daño infligido
     * al oponente y restaura la armadura original del oponente después del ataque.
     * @param otro La criatura objetivo del ataque.
     */
    @Override
    public void atacar(Criatura otro) {
        if (otro != null) {
            // Genera un número aleatorio para simular la potencia de ataque del Orco
            Random random = new Random();
            int potenciaAtaque = random.nextInt(90);

            // Almacena la armadura original del oponente
            int armaduraOriginalOtro = otro.getNivelArmadura();

            // Reducción temporal de la armadura del oponente en un 10%
            int armaduraReduccion = (int) (otro.getNivelArmadura() * 0.1);
            otro.setNivelArmadura(otro.getNivelArmadura() - armaduraReduccion);

            // Calcula el daño infligido por el Orco al oponente
            int danioInfligido = Math.max(0, potenciaAtaque - otro.getNivelArmadura());
            otro.setPuntosVida(otro.getPuntosVida() - danioInfligido);

            // Restaura la armadura original del oponente
            otro.setNivelArmadura(armaduraOriginalOtro);

            System.out.println("Potencia de ataque Orco: " + potenciaAtaque);
            System.out.println("Daño inflingido Orco: " + danioInfligido);
        }
    }
} //Fin clase
