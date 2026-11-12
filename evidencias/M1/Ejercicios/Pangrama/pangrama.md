En este ejercicio debia verificar que una frase sea o no un "pangrama" (oracion que utiliza todas las letras del alfabeto) 

public class PangramChecker {

    public boolean isPangram(String input) {
        String minusculas = input.toLowerCase();
        
        for (char letra = 'a'; letra <= 'z'; letra++) {
            if (minusculas.indexOf(letra) == -1) {
                return false;
            }
        }
        
        return true;
    }
}

aqui primero utilice un booleano para verificar que esta oracion si sea o no un pangrama y se llegaria a una respuesta con un condicional 

char código para que el codigo guarde letra por letra
= "a" letra <= "z" pasamos desde la A hasta la Z
letra ++ ir letra por letra