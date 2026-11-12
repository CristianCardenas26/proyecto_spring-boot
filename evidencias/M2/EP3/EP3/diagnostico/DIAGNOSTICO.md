1. se inicia el proyecto generado en spting incialitr de manera satisfactoria sin ningun cambio

2. Se realizo un error controlado en la ruta tienda-aula/src/main/resources/application.properties,
al cambiar un valor entero por un valor string


# mensaje en la consola... 

***************************
APPLICATION FAILED TO START
***************************

Description:

Failed to bind properties under 'server.port' to java.lang.Integer:

    Property: server.port
    Value: "abc"
    Origin: class path resource [application.properties] - 2:13
    Reason: failed to convert java.lang.String to java.lang.Integer (caused by java.lang.NumberFormatException: For input string: "abc")



3. en la imagen adjunta se detalla el lugar exacacto donde se encuantra el error de sintaxys ademas tambien informa cual fue este error de la suiguiente manera

# Failed to bind properties under 'server.port' to java.lang.Integer:
Indica que spring boot intentó leer y asociar el proyecto, sin embargo esperaba obligatoriamente un número entero (Integer) y no lo encontor

# Property: server.port
Indica cuál es el archivo específica del sistema que causó el conflicto.

# Value: "abc"
Muestra el texto que esta causando el error, en este caso (abs) es un texto *string* 
y spring esperaba un *integer* (numero entero)

# Origin: class path resource [application.properties] - 2:13
indica el lugar en donde se encuantra el error, *archivo application.properties* y en la linea 2 caracter 13.



3. El dato incorrecto: Fue asignar una cadena de texto ("abc") a la propiedad del puerto del servidor (server.port), cuando Spring Boot esperaba estrictamente un valor numérico entero (Integer).


Como ultimo paso se volvio a corregir el valor cambiado anterirormente y se volvio a ejecutar el proyecto con **mvn spring-boot:run**, el proyecto volvio a correr de manera normal sin algina novedad.
