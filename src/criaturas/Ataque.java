package criaturas;

public interface Ataque {

    /**
     * Método que define cómo una criatura ataca a otra criatura.
     * @param otro La criatura a la que se va a atacar.
     */
    void atacar(Criatura otro);
}
