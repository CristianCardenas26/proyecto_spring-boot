en este ejercicio se me pedia crear un constructor, pues un constructor es el que se ancarga de crear un objeto nuevo, en este caso un vehiculo a control remoto para las carreras con unas siertas caracteristicas las cuales primero se nombraron en la clase principal que llamada need for speed

*caracteristicas nombradas en la clase principal*
int speed ->  velocidad
int batteryDrain -> consumo
int battery = 100; -> bateria
int distance = 0 -> distancia

*constructor*

NeedForSpeed(int speed, int batteryDrain) {
    this.speed = speed;
    this.batteryDrain = batteryDrain;
}

Recibe dos valores creados en la clase principal: la velocidad y el consumo

this.speed = speed → Guardo la velocidad que me diste en la característica del auto
this = "este mismo auto" → distingue la característica del valor que me pasas

Ejemplo: new NeedForSpeed(5, 2) → crea un auto que avanza 5m y gasta 2% cada vez