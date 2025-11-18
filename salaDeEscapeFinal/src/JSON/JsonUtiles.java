// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package JSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

public class JsonUtiles {
    public JsonUtiles() {
    }

    public static void grabar(JSONArray jsonArray, String archivo) {
        try {
            FileWriter file = new FileWriter(archivo);
            file.write(jsonArray.toString(4));
            file.close();
        } catch (JSONException | IOException var3) {
            var3.printStackTrace();
        }

    }

    public static JSONTokener leerUnJson(String archivo) {
        JSONTokener tokener = null;

        try {
            tokener = new JSONTokener(new FileReader(archivo));
        } catch (FileNotFoundException var3) {
            var3.printStackTrace();
        }

        return tokener;
    }

    public static String leer(String archivo) {
        String contenido = "";

        try {
            contenido = new String(Files.readAllBytes(Paths.get(archivo + ".json")));
        } catch (IOException var3) {
            var3.printStackTrace();
        }

        return contenido;
    }
}
