# tp-final
https://lucid.app/lucidchart/4916e674-ba1c-4f4a-9049-7ddb562b5a46/edit?viewport_loc=-1662%2C-1712%2C9244%2C4806%2C0_0&invitationId=inv_9b53f36c-2881-429d-995d-50e6de584e21
Menu
clase que podria tener estas opciones
Iniciar Sesion o Cargar partida
NuevaPartida
Records(verias los equipos y sus records)

Participantes

GestorParticipante(nombre del equipo, arraylist de estudiantes (1, 2, 3, 4), cant de pistas, puntaje total. Esta gestiona la trama del juego (método propio), cuando se pierden vidas o ganan puntos (llamada a métodos de estudiante)
Metodos
GestionarTrama -> A través de un for recorrer el arreglo de estudiantes en donde se responderá el acertijo en caso de no responder bien perderás vida, en caso de responder bien pasará a la siguiente acertijo y al próximo participante y así recorrer toda la trama.
ReiniciarPista -> Método para cuando pase de nivel las pistas se reinicien. Deben ser max 3
ElegirParticipante -> si son 4 y muere 1, la 4ta pista eligen los jugadores quien la hace


estudiantes: nombre, cant vidas(empieza en 3), puntaje. métodos: perderVida(sin llega a 0 pierde), ganarPuntos

Salas

gestorSalas: araylist de salas. AgregarSala,BorrarSala,BuscarSala

Sala(nombre,descripción,arraylist pruebas). metodos:AsignarPrueba(esta asignará a cada participante una prueba individual, cada una de ellas será de diferente tipo)

Pruebas

Pruebas(enum tipoDePrueba (LÓGICA,CAOS,RECUERDO,CONTROL),descripción,arraylist respuestaEsperada)

—---------------------------------------------------------

JSON

json: inicio de sesion participantes, record de puntaje del equipo, retomar la ultima partida

GestorInicioSesion
Este gestor va a ser usado para iniciar sesión de tu equipo o registrarlo en caso de registrarlo se guardará los datos pedidos de equipo y contraseña con doble validación y se almacenará los datos en un json de partidas o equipos Almacenados. En caso de iniciar sesión se comparara el nombre y contraseña si es correcta se  a partir del nombre su estado en em juego( es decir su progreso) y empezará desde ahí.

La clase Récord guardará el nombre del equipo y puntaje en un json.

clase Estado de juego guardará nombre del equipo,nivelActual y pruebasResueltas en un json para su posterior uso


