package senoranillos;

import criaturas.*;
import java.util.Arrays;

/**
* Batalla en tierra media.
*
* @author arkano
*/
public class SenorAnillos {

// Método que implementa una batalla por turnos entre dos ejércitos
public static void batalla(Lista ejercitoHeroes, Lista ejercitoBestias) {
int menorLongitud, i, turno = 1;
Heroe heroe;
Bestia bestia;

// Mientras exista algún ejército en pie continua la batalla (turno a turno)
while (!ejercitoHeroes.vacia()&& !ejercitoBestias.vacia()) {
System.out.println("Turno " + turno + ":");
menorLongitud = Math.min(ejercitoHeroes.numeroElementos(), ejercitoBestias.numeroElementos());
// En cada turno de batalla se enfrenta un oponente de cada ejército (por orden de lista).
// Si sobra algún oponente, por que alguno de los ejécitos es más grande que el otro,
// se queda esperando (no lucha en este turno).
for (i = 0; i < menorLongitud; i++) {
heroe = (Heroe) ejercitoHeroes.elemento(i); // Se obtiene el heroe i de la lista
bestia = (Bestia) ejercitoBestias.elemento(i); // Se obtiene la bestia i de la lista
System.out.println(" Lucha entre " + heroe.getNombre()
+ " (Vida = " + heroe.getPuntosVida() + " ) y "
+ bestia.getNombre() + " ( Vida =" + bestia.getPuntosVida() + ")");
heroe.atacar(bestia); // El heroe ataca primero
bestia.atacar(heroe); // Luego ataca la bestia
if (heroe.getPuntosVida() <= 0) { // Si muere el heroe se elimina de la lista
ejercitoHeroes.eliminar(i);
menorLongitud = Math.min(ejercitoHeroes.numeroElementos(), ejercitoBestias.numeroElementos());
System.out.println("¡¡Muere " + heroe + "!");
}
if (bestia.getPuntosVida() <= 0) { // Si muere la bestia se elimina de la lista
ejercitoBestias.eliminar(i);
menorLongitud = Math.min(ejercitoHeroes.numeroElementos(), ejercitoBestias.numeroElementos());
System.out.println("¡¡Muere " + bestia + "!");
}
}
turno++;
}

Criatura ordenada[];
if (ejercitoHeroes.vacia()) {
System.out.println("\n¡¡ VICTORIA DE LAS BESTIAS !! ");
System.out.println("¡¡ Supervivientes!! ");
ordenada = ejercitoBestias.elementos();
} else {
System.out.println("\n¡¡ VICTORIA DE LOS HÉROES !! ");
System.out.println("¡¡ Supervivientes !! ");
ordenada = ejercitoHeroes.elementos();
}
// Listamos los supervivientes por orden de vida restante.
Arrays.sort(ordenada);
for (Criatura c: ordenada){
System.out.println(c);
}
}

/**
     
* @param args the command line arguments
*/
public static void main(String[] args) {
Lista heroes = new Lista(5);
Lista bestias = new Lista(7);

// Ejercito de Heroes
heroes.insertarAlFinal(new Hombre("Boromir", 300, 20));
heroes.insertarAlFinal(new Hombre("Aragor", 370, 35));
heroes.insertarAlFinal(new Elfo("Legolas", 400, 35));
heroes.insertarAlFinal(new Hobbit("Sam", 250, 15));
heroes.insertarAlFinal(new Hobbit("Pipin", 200, 20));

// Ejercito de Bestias
bestias.insertarAlFinal(new Orco("TRUfas", 400, 20));
bestias.insertarAlFinal(new Orco("Zratcasc", 500, 35));
bestias.insertarAlFinal(new Orco("Sahrag", 400, 35));
bestias.insertarAlFinal(new Trasgo("Uglk", 500, 15));
bestias.insertarAlFinal(new Trasgo("Lurtz", 600, 20));
bestias.insertarAlFinal(new Trasgo("Fieghh", 600, 20));

// A la batalla!!!
batalla(heroes, bestias);

}
}