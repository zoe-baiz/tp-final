import enums.TipoDePrueba;
import models.*;

public class Main {
    public static void main(String[] args) {
        Equipo e=new Equipo("equipito","no me mires");
        Jugador j1=new Jugador(126,"Ivan");
        Jugador j2=new Jugador(127,"Zoe");
        Jugador j3=new Jugador(128,"Carito");
        e.getJugadores().add(j1);
        e.getJugadores().add(j2);
        e.getJugadores().add(j3);

        GestorSalas gs=createRooms(e);

        JuegoEscapeRoom j=new JuegoEscapeRoom(e,gs);
        j.jugar();
        //wawawa
    }



    public static GestorSalas createRooms(Equipo e) {
        // 1. Crear el Gestor (Contenedor principal)
        GestorSalas gs = new GestorSalas();
        Sala sala1 = new Sala("El Laboratorio Cerrado", "La primera prueba de tu ingenio. Necesitarás lógica y un poco de suerte.");
        Sala sala2 = new Sala("El Archivo Perdido", "Un lugar lleno de documentos y viejos recuerdos que podrían no ser ciertos.");
        Sala sala3 = new Sala("El Círculo Mágico", "Un entorno donde la fantasía y el pensamiento lateral son la única salida.");
        Sala sala4 = new Sala("El Vacío del Alma", "Una sala diseñada para romper tus esquemas y obligarte a actuar por instinto.");
        Sala sala5 = new Sala("La Salida Final", "El último desafío. Combina todo lo que has aprendido.");
        if(e.getJugadores().size() == 1){
            sala1.agregar(new Prueba("Acertijo de las Lámparas", "Usa la lógica para encender la luz correcta.", TipoDePrueba.LOGICA, "v"));
            sala2.agregar(new Prueba("Patrón del Archivador", "Encuentra la secuencia de colores para abrir el cajón principal.", TipoDePrueba.LOGICA, "v"));
            sala3.agregar(new Prueba("Dibujo Ilógico", "Dibuja un animal que no existe y descríbelo.", TipoDePrueba.CREATIVIDAD, "v"));
            sala4.agregar(new Prueba("Palabra Oculta", "Encuentra la palabra de 8 letras entre símbolos.", TipoDePrueba.RECUERDO, "v"));
            sala5.agregar(new Prueba("El Botón del Pánico", "Hay 10 botones. Tienes que elegir uno al azar en 1 segundo.", TipoDePrueba.CAOS, "v"));
        }else if(e.getJugadores().size() == 2){
            sala1.agregar(new Prueba("Acertijo de las Lámparas", "Usa la lógica para encender la luz correcta.", TipoDePrueba.LOGICA, "v"));
            sala2.agregar(new Prueba("Patrón del Archivador", "Encuentra la secuencia de colores para abrir el cajón principal.", TipoDePrueba.LOGICA, "v"));
            sala3.agregar(new Prueba("Dibujo Ilógico", "Dibuja un animal que no existe y descríbelo.", TipoDePrueba.CREATIVIDAD, "v"));
            sala4.agregar(new Prueba("Palabra Oculta", "Encuentra la palabra de 8 letras entre símbolos.", TipoDePrueba.RECUERDO, "v"));
            sala5.agregar(new Prueba("El Botón del Pánico", "Hay 10 botones. Tienes que elegir uno al azar en 1 segundo.", TipoDePrueba.CAOS, "v"));

            sala1.agregar(new Prueba("Acertijo de las Lámparas", "Usa la lógica para encender la luz correcta.", TipoDePrueba.LOGICA, "v"));
            sala2.agregar(new Prueba("Patrón del Archivador", "Encuentra la secuencia de colores para abrir el cajón principal.", TipoDePrueba.LOGICA, "v"));
            sala3.agregar(new Prueba("Dibujo Ilógico", "Dibuja un animal que no existe y descríbelo.", TipoDePrueba.CREATIVIDAD, "v"));
            sala4.agregar(new Prueba("Riesgo Innecesario", "Pulsa un botón que dice 'NO TOCAR' para ver qué sucede.", TipoDePrueba.CAOS, "v"));
            sala5.agregar(new Prueba("El Botón del Pánico", "Hay 10 botones. Tienes que elegir uno al azar en 1 segundo.", TipoDePrueba.CAOS, "v"));
        }else if(e.getJugadores().size() == 3){
            sala1.agregar(new Prueba("Acertijo de las Lámparas", "Usa la lógica para encender la luz correcta.", TipoDePrueba.LOGICA, "v"));
            sala2.agregar(new Prueba("Patrón del Archivador", "Encuentra la secuencia de colores para abrir el cajón principal.", TipoDePrueba.LOGICA, "v"));
            sala3.agregar(new Prueba("Dibujo Ilógico", "Dibuja un animal que no existe y descríbelo.", TipoDePrueba.CREATIVIDAD, "v"));
            sala4.agregar(new Prueba("Palabra Oculta", "Encuentra la palabra de 8 letras entre símbolos.", TipoDePrueba.RECUERDO, "v"));
            sala5.agregar(new Prueba("El Botón del Pánico", "Hay 10 botones. Tienes que elegir uno al azar en 1 segundo.", TipoDePrueba.CAOS, "v"));

            sala1.agregar(new Prueba("Acertijo de las Lámparas", "Usa la lógica para encender la luz correcta.", TipoDePrueba.LOGICA, "v"));
            sala2.agregar(new Prueba("Patrón del Archivador", "Encuentra la secuencia de colores para abrir el cajón principal.", TipoDePrueba.LOGICA, "v"));
            sala3.agregar(new Prueba("Dibujo Ilógico", "Dibuja un animal que no existe y descríbelo.", TipoDePrueba.CREATIVIDAD, "v"));
            sala4.agregar(new Prueba("Riesgo Innecesario", "Pulsa un botón que dice 'NO TOCAR' para ver qué sucede.", TipoDePrueba.CAOS, "v"));
            sala5.agregar(new Prueba("El Botón del Pánico", "Hay 10 botones. Tienes que elegir uno al azar en 1 segundo.", TipoDePrueba.CAOS, "v"));

            sala1.agregar(new Prueba("La Llave Imposible", "Debes crear la forma de sacar la llave de un tubo sellado.", TipoDePrueba.CREATIVIDAD, "v"));
            sala2.agregar(new Prueba("Nombre en Clave", "Debes escribir el nombre de un objeto que viste en el Laboratorio.", TipoDePrueba.RECUERDO, "v"));
            sala3.agregar(new Prueba("El Orden del Tiempo", "Ordena 5 eventos históricos aleatorios.", TipoDePrueba.RECUERDO, "v"));
            sala4.agregar(new Prueba("Puente de Papel", "Construye un puente que soporte una moneda solo con papel.", TipoDePrueba.CREATIVIDAD, "v"));
            sala5.agregar(new Prueba("Código Maestro", "Combina la primera letra de cada respuesta anterior.", TipoDePrueba.LOGICA, "v"));
        }else{
            sala1.agregar(new Prueba("Acertijo de las Lámparas", "Usa la lógica para encender la luz correcta.", TipoDePrueba.LOGICA, "v"));
            sala2.agregar(new Prueba("Patrón del Archivador", "Encuentra la secuencia de colores para abrir el cajón principal.", TipoDePrueba.LOGICA, "v"));
            sala3.agregar(new Prueba("Dibujo Ilógico", "Dibuja un animal que no existe y descríbelo.", TipoDePrueba.CREATIVIDAD, "v"));
            sala4.agregar(new Prueba("Palabra Oculta", "Encuentra la palabra de 8 letras entre símbolos.", TipoDePrueba.RECUERDO, "v"));
            sala5.agregar(new Prueba("El Botón del Pánico", "Hay 10 botones. Tienes que elegir uno al azar en 1 segundo.", TipoDePrueba.CAOS, "v"));

            sala1.agregar(new Prueba("Acertijo de las Lámparas", "Usa la lógica para encender la luz correcta.", TipoDePrueba.LOGICA, "v"));
            sala2.agregar(new Prueba("Patrón del Archivador", "Encuentra la secuencia de colores para abrir el cajón principal.", TipoDePrueba.LOGICA, "v"));
            sala3.agregar(new Prueba("Dibujo Ilógico", "Dibuja un animal que no existe y descríbelo.", TipoDePrueba.CREATIVIDAD, "v"));
            sala4.agregar(new Prueba("Riesgo Innecesario", "Pulsa un botón que dice 'NO TOCAR' para ver qué sucede.", TipoDePrueba.CAOS, "v"));
            sala5.agregar(new Prueba("El Botón del Pánico", "Hay 10 botones. Tienes que elegir uno al azar en 1 segundo.", TipoDePrueba.CAOS, "v"));

            sala1.agregar(new Prueba("La Llave Imposible", "Debes crear la forma de sacar la llave de un tubo sellado.", TipoDePrueba.CREATIVIDAD, "v"));
            sala2.agregar(new Prueba("Nombre en Clave", "Debes escribir el nombre de un objeto que viste en el Laboratorio.", TipoDePrueba.RECUERDO, "v"));
            sala3.agregar(new Prueba("El Orden del Tiempo", "Ordena 5 eventos históricos aleatorios.", TipoDePrueba.RECUERDO, "v"));
            sala4.agregar(new Prueba("Puente de Papel", "Construye un puente que soporte una moneda solo con papel.", TipoDePrueba.CREATIVIDAD, "v"));
            sala5.agregar(new Prueba("Código Maestro", "Combina la primera letra de cada respuesta anterior.", TipoDePrueba.LOGICA, "v"));

            sala1.agregar(new Prueba("Cuenta Regresiva", "Un número aleatorio aparece en la pared. Debes recordarlo.", TipoDePrueba.RECUERDO, "v"));
            sala2.agregar(new Prueba("La Decisión Rápida", "Una alarma suena. Tienes que elegir un camino sin pensarlo.", TipoDePrueba.CAOS, "v"));
            sala3.agregar(new Prueba("Candado de Sumas", "Resuelve la ecuación matemática para el candado.", TipoDePrueba.LOGICA, "v"));
            sala4.agregar(new Prueba("Puente de Papel", "Construye un puente que soporte una moneda solo con papel.", TipoDePrueba.CREATIVIDAD, "v"));
            sala5.agregar(new Prueba("Mensaje en el Espejo", "Escribe un mensaje de 5 palabras que solo pueda leerse en un espejo.", TipoDePrueba.CREATIVIDAD, "v"));
        }


        gs.getSalas().add(sala1);
        gs.getSalas().add(sala2);
        gs.getSalas().add(sala3);
        gs.getSalas().add(sala4);
        gs.getSalas().add(sala5);

        return gs;
    }


}