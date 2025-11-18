import enums.TipoDePrueba;
import gestoras.GestorParticipante;
import models.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

import static JSON.JsonUtiles.grabar;
import static JSON.JsonUtiles.leer;

public class Main {
    public static void main(String[] args) throws JSONException {
    /*    Participante p1=new Participante(1,"Ivan","36");
        Participante p2=new Participante(2,"Zoe","49");
        Participante p3=new Participante(3,"Carito","64");
        Equipo equipo=new Equipo(232,"nombre");
      GestorSalas salas=new GestorSalas();


        Sala s1=new Sala("alguna sala","historia1");
        Sala s2=new Sala("alguna sala","historia2");
        Sala s3=new Sala("alguna sala","historia3");

        salas.agregar(s1);
        salas.agregar(s2);
        salas.agregar(s3);


        s1.agregar(new Prueba("pruebita1","wawawa", TipoDePrueba.CAOS,1,"Respuesta"));
        s1.agregar(new Prueba("pruebita2","wawawa", TipoDePrueba.LOGICA,2,"Respuesta"));
        s1.agregar(new Prueba("pruebita3","wawawa", TipoDePrueba.CREATIVIDAD,3,"Respuesta"));



        salas.toJson();
        salas.guardarComoJson("salas.json");
*/

/*

        System.out.println(equipo.agregar(p1));
        System.out.println(equipo.agregar(p2));
        System.out.println(equipo.agregar(p3));
        GestorJuego gs=new GestorJuego(equipo,salas);



        gs.iniciarJuego();*/
        Equipo equipo=new Equipo(2,"los papuchos");
        Participante p1=new Participante(1,"Ivan","36");
        Participante p2=new Participante(2,"Zoe","49");
        Participante p3=new Participante(3,"Carito","64");
        equipo.agregar(p1);
        equipo.agregar(p2);
        equipo.agregar(p3);

        String jsonString = leer("salas");
        JSONObject json = new JSONObject(jsonString);

        GestorSalas salas = new GestorSalas();
        salas.fromJson(json);

        MenuPrincipal menu=new MenuPrincipal(equipo,salas);

        menu.mostrarMenu();

    }
}