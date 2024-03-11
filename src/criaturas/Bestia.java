package criaturas;

import java.util.Random;

public abstract class Bestia extends Criatura {

    // Constructor
    public Bestia(String nombre, int puntosVida, int nivelArmadura) {
        super(nombre, puntosVida, nivelArmadura);
    }

   /**
 * Realiza un ataque contra otra criatura.
 * Calcula la potencia de ataque como un número aleatorio entre 0 y 89,
 * inflige daño a la criatura objetivo y reduce sus puntos de vida
 * en función de su nivel de armadura. Si la armadura de la criatura atacada
 * es mayor que la potencia de ataque, no se inflige ningún daño.
 * @param otro La criatura objetivo del ataque.
 */
@Override
public void atacar(Criatura otro) {
    // Genera un número aleatorio para simular la potencia de ataque
    Random random = new Random();
    int potenciaAtaque = random.nextInt(90);

    // Calcula el daño infligido, asegurándose de que no sea negativo
    int danioInfligido = Math.max(0, potenciaAtaque - otro.nivelArmadura);
    
    // Reduce los puntos de vida de la criatura atacada
    otro.puntosVida -= danioInfligido;
}


    /**
     *
     * Método toString para representar la Bestia como Strin
     *
     * @return g
     */
    @Override
    public String toString() {
        return "Bestia: " + super.toString();
    }
}
