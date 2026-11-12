## MODULO 3 explicacion del proyecto

## ESTRUCTIURA DEL PROYECTO ## 

- # controller (OrderController.java)
gestiona los endpionts HTTP y la comunicacion externa

- # SERVICE (OrderService.JAVA)
Contiene la logica de negocio y manejo de excepcopnes

- # Entidades (Orderjava), (Product.java)
Modelo de datos del dominio

- # Pruebas (Order.http), (Product.http)
son las solicitudes http para la validacion de escenarion con exito o en su defecro con error


## FLUJO DE LA EJECUCIÓN ##

*solicitud http* --> *OrderControler* --> *OrderService* --> *Respuestahttp*
1. ingresa la solicitud (GET, POST, DELETE, PUT) en formato JASON
2. el controlador recibe la solicitud y la pasa al servicio
3. reglas de negocio: aqui en el servicio se realizan las validacions de SKU, existencia del inventario y disponiobilidad de stock 
4. respuesta: devuelve la solicitud ya procesada o en su defecto la excepcion mediante codigos de estado (200 ok), (400 bad request), (404 not found) etc...

## PRUEBAS DE ENDPOONT (Order.http) ##

- POST/api/orders para registro de pedidos
- GET/api/orders para consultar pedidos activos
- POST/api/orders/{id}/confirm par ala confirmacion de estados

## VALIDACIONES ##

