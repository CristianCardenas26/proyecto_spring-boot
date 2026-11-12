En este ejemplo cree un proyecto muy basico que brinda un mensaje de bienvenida para demostrar el como funciona la *inyeccion de dependencias*.
para esto cree tres archivos 

# Messagerepository.java 
quien se encarga de proporcinar el mensaje de bienvenida

# MessageService.java
este es el encargado de contener la logica del proyecto, en este caso el ejemlo es muy basico y no contiene logica sin embargo este recibe a *Messagerepository* como dependencia pues necesita de esta para poder trabajar y enviar el mensaje al controlador

# MessageController.java
Este es el encargado de recibir el resultado que le entrega el Service y se encarga de enviarlo como respuesta al usuario por ende recibe a *MessageServise.java* como dependencia 



**MessageRepository** ->  **MessageService** ->  **MessageController**
