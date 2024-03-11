package criaturas;

import java.util.Random;

/**
 * Clase que representa a un Elfo de tipo Héroe.
 */
public class Elfo extends Heroe {

    /**
     * Constructor de la clase Elfo.
     * @param nombre Nombre del Elfo.
     * @param puntosVida Puntos de vida del Elfo.
     * @param nivelArmadura Nivel de armadura del Elfo.
     */
    public Elfo(String nombre, int puntosVida, int nivelArmadura) {
        super(nombre, puntosVida, nivelArmadura);
    }

    /**
     * Método atacar para Elfo
     * @param otro Criatura a la que se va a atacar.
     */
    @Override
    public void atacar(Criatura otro) {
        if (otro != null) {
            Random random = new Random();
            int dado1 = random.nextInt(100);
            int dado2 = random.nextInt(100);
            int potenciaAtaque = Math.max(dado1, dado2);
            System.out.println("Potencia de ataque Elfo: " + potenciaAtaque);

            if (otro instanceof Orco) {
                potenciaAtaque += 10; // Si se enfrenta a un orco, incrementa la
                                      //potencia de ataque.
            }

            //Calcula el daño infligido y comprueba que no sea negativo.
            int danioInfligido = Math.max(0, potenciaAtaque - otro.nivelArmadura);
            //Resta los puntos de vida a la criatura atacada
            otro.puntosVida -= danioInfligido;
            System.out.println("Daño inflingido Elfo: " + danioInfligido);
        }
    }

} //Fin clase
