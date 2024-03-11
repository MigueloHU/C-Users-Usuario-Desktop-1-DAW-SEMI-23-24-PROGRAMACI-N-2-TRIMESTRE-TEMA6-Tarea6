package criaturas;

/**
 * Esta clase representa a una criatura en el juego.
 * Es una clase abstracta que sirve como estructura base para todas las criaturas en el juego.
 * Implementa la interfaz Comparable para que las criaturas puedan ser comparadas entre sí
 * según la cantidad de puntos de vida que les queden.
 */

public abstract class Criatura implements Comparable<Criatura>, Ataque {

    // Atributos de la clase
    protected String nombre;
    protected int puntosVida;
    protected int nivelArmadura;

    /**
     * Constructor de la clase Criatura.
     * @param nombre El nombre de la criatura.
     * @param puntosVida Los puntos de vida de la criatura.
     * @param nivelArmadura El nivel de armadura de la criatura.
     */
    public Criatura(String nombre, int puntosVida, int nivelArmadura) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.nivelArmadura = nivelArmadura;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getNivelArmadura() {
        return nivelArmadura;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setNivelArmadura(int nivelArmadura) {
        this.nivelArmadura = nivelArmadura;
    }
    // Método abstracto para atacar, implementado por las subclases de Criatura
    @Override
    public abstract void atacar(Criatura otro);

    // Método compareTo para ordenar criaturas por puntos de vida restantes
    @Override
    public int compareTo(Criatura otra) {
        return Integer.compare(this.puntosVida, otra.puntosVida);
    }

    // Método toString para representación de la criatura como String
    @Override
    public String toString() {
        return nombre + " (Vida: " + puntosVida + ")";
    }
} //Fin clase
