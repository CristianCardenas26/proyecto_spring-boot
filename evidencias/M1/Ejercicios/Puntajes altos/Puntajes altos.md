Este es un ejercicio donde existe una lista de puntajes en un juego, mi deber era sacar unos puntajes en especifico  

*para sacar la lista de puntajes entera*
List<Integer> scores() {
    return new ArrayList<>(puntuaciones);
}

*ultimo puntaje*
Integer latest() {
    return puntuaciones.get(puntuaciones.size() - 1);
}

size() llama la lista entera y el -1 devuelve la ultima posición

*el puntaje mas alto*
Integer personalBest() {
    return Collections.max(puntuaciones);
}

Collections.max(...) busca y devuelve el número mayor de la lista

*los 3 mejores*

List<Integer> personalTopThree() {
    List<Integer> ordenada = new ArrayList<>(puntuaciones);
    Collections.sort(ordenada, Collections.reverseOrder());
    if (ordenada.size() > 3) {
        return ordenada.subList(0, 3);
    } else {
        return ordenada;
    }
}

AL sacar los primeros 3 primero hay que ordenar la lista de mayor a menor con callections.reverseOrder()
y ya luego se toman los promeros 3 con  return ordenada.subList(0, 3);