package carlos.com.findme.data.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Respuesta implements Serializable{
    private ArrayList<RetornoEntity> dato;

    public ArrayList<RetornoEntity> getDato() {
        return dato;
    }

    public void setDato(ArrayList<RetornoEntity> dato) {
        this.dato = dato;
    }
}
