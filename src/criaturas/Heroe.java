package criaturas;

import java.util.Random;

public abstract class Heroe extends Criatura {

    // Constructor
    public Heroe(String nombre, int puntosVida, int nivelArmadura) {
        super(nombre, puntosVida, nivelArmadura);
    }

/**
 * Establece las cifras para atacar a otra criatura.
 * Calcula la potencia de ataque e inflige daño a la otra criatura
 * y reduce sus puntos de vida en función de su nivel de armadura.
 * Si la armadura de la criatura objetivo es mayor que la potencia de ataque,
 * no se inflige ningún daño.
 * @param otro La criatura objetivo del ataque.
 */
@Override
public void atacar(Criatura otro) {
    // Genera dos números aleatorios, uno para cada dado.
    Random random = new Random();
    int dado1 = random.nextInt(100);
    int dado2 = random.nextInt(100);
    
    // Elige el dado mayor para establecer la potencia de ataque.
    int potenciaAtaque = Math.max(dado1, dado2);

    // Calcula el daño infligido.
    int danioInfligido = Math.max(0, potenciaAtaque - otro.nivelArmadura);
    
    // Resta los puntos de vida a la criatura atacada.
    otro.puntosVida -= danioInfligido;
}


    /**
     * toString para representar el Héroe como String.
     *
     * @return g
     */
    @Override
    public String toString() {
        return "Heroe: " + super.toString();
    }
}
