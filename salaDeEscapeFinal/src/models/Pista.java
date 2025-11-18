// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package models;

import interfaces.IToJson;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class Pista implements IToJson<Pista> {
    private Integer id;
    private String texto;

    public Pista(Integer id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public Pista(Integer id) {
        this.id = id;
        this.texto = "";
    }

    public Pista() {
        this.id = -1;
        this.texto = "";
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean equals(Object o) {
        if (o instanceof Pista pista) {
            return Objects.equals(this.id, pista.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    public String toString() {
        return "Pista{id=" + this.id + ", texto='" + this.texto + "'}";
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        try {
            json.put("id", this.id);
            json.put("texto", this.texto);
        } catch (JSONException var3) {
            var3.printStackTrace();
        }

        return json;
    }
}
