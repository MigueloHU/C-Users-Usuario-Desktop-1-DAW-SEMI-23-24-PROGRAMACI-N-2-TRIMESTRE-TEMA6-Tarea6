package senoranillos;

import java.util.Arrays;
import criaturas.*;
/** Clase Lista que permite crear una lista de la clase Criaturas
*
* @author arkano
*/

public class Lista {
private final int CAPACIDAD = 10;
private final int INCREMENTO = 5;
private int longitud;
private Criatura[ ] tabla;

public Lista(){
tabla = new Criatura[CAPACIDAD];
longitud = 0;
}

public Lista(int capacidad){
tabla = new Criatura[capacidad];
longitud = 0;
}

/**
* Devuelve un array con los elementos de la lista
* @return
*/
public Criatura[] elementos(){
Criatura aux[] = new Criatura[longitud];
for (int i = 0; i < longitud; i++){
aux[i] = tabla[i];
}
return aux;
}

/**
* Devuelve el elemento de la lista que ocupa la posicion recibida como parámetro
*
* @param posicion
* @return
*/
public Criatura elemento(int posicion){
if (posicion <= longitud){
return tabla[posicion];
}
return null;
}
/**
* Devuekve true si la lista está vacía, false en caso contrario
* @return
*/
public boolean vacia (){
if (longitud == 0){
return true;
}
return false;
}

/**
* Devuelve el numero de elmeotos que contiene la lista
* @return
*/
public int numeroElementos(){
return longitud;
}

/**
* Elimina el elemento que se encuentra en la posición recibida como parámetro
* @param pos
* @return
*/
public boolean eliminar (int pos){
boolean resultado = false;
if (pos >= 0 && pos < longitud){
for (int i = pos; i < longitud-1; i++){
tabla[i] = tabla[i+1];
}
longitud--;
resultado = true;
if (tabla.length - longitud > INCREMENTO){
Criatura[] aux = new Criatura[tabla.length-INCREMENTO];
for (int i = 0; i < longitud; i++){
aux[i] = tabla[i];
}
tabla = aux;
}
}
return resultado;
}

/**
* Inserta un elemento al final de la lista
* @param elemento, elemanto a insertar
*/
public void insertarAlFinal(Criatura elemento){
if (tabla.length == longitud){ // Tabla llena
tabla = Arrays.copyOf(tabla, tabla.length + INCREMENTO);
}
tabla[longitud++] = elemento;
}

/**
* Añade al final de la lista los elementos de la lista recibida como parámetro
* @param lista
*/
public void insertarAlFinal(Lista lista){
for (int i = 0; i < lista.longitud; i++){
insertarAlFinal(lista.tabla[i]);
}
}

/**
* Inseta un elemento al principio de la lista
* @param elemento, elemento a insertar
*/
public void insertarAlPrincipio(Criatura elemento){
if (tabla.length == longitud){ // Tabla llena
Criatura aux[] = new Criatura[tabla.length+INCREMENTO];
for (int i = 0; i < longitud; i++ ){
aux[i+1] = tabla[i];
}
tabla = aux;
} else {
for (int i = longitud -1; i >= 0; i--){
tabla[i+1] = tabla[i];
}
}
longitud++;
tabla[0] = elemento;
}

/**
* Inserta un elemento en la posición
* @param elemento,elemento a insertar
* @param posicion, posición en la que insetar
*/
public void insertar(Criatura elemento, int posicion){
if (posicion >= longitud){
insertarAlFinal(elemento);
} else if (posicion <= 0){
insertarAlPrincipio(elemento);
} else {
if (tabla.length == longitud){ // Tabla llena
Criatura aux[] = new Criatura[tabla.length+INCREMENTO];
for (int i = 0; i < longitud; i++ ){
aux[i+1] = tabla[i];
}
tabla = aux;
} else {
for (int i = longitud -1; i >= posicion; i--){
tabla[i+1] = tabla[i];
}
}
longitud++;
tabla[posicion] = elemento;
}
}

@Override
public String toString() {
String salida = "";
for (int i = 0; i < longitud; i++){
salida += tabla[i] + "\n";
}
return salida;
}

}