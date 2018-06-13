package carlos.com.ticketsapp.data.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by carlos on 12/06/2018.
 */

public class SemanaResponse implements Serializable {
    private ArrayList<ComidaEntity> lunes;
    private ArrayList<ComidaEntity> martes;
    private ArrayList<ComidaEntity> miercoles;
    private ArrayList<ComidaEntity> jueves;
    private ArrayList<ComidaEntity> viernes;
    private ArrayList<ComidaEntity> sabado;
    private ArrayList<ComidaEntity> domingo;

    public ArrayList<ComidaEntity> getLunes() {
        return lunes;
    }

    public void setLunes(ArrayList<ComidaEntity> lunes) {
        this.lunes = lunes;
    }

    public ArrayList<ComidaEntity> getMartes() {
        return martes;
    }

    public void setMartes(ArrayList<ComidaEntity> martes) {
        this.martes = martes;
    }

    public ArrayList<ComidaEntity> getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(ArrayList<ComidaEntity> miercoles) {
        this.miercoles = miercoles;
    }

    public ArrayList<ComidaEntity> getJueves() {
        return jueves;
    }

    public void setJueves(ArrayList<ComidaEntity> jueves) {
        this.jueves = jueves;
    }

    public ArrayList<ComidaEntity> getViernes() {
        return viernes;
    }

    public void setViernes(ArrayList<ComidaEntity> viernes) {
        this.viernes = viernes;
    }

    public ArrayList<ComidaEntity> getSabado() {
        return sabado;
    }

    public void setSabado(ArrayList<ComidaEntity> sabado) {
        this.sabado = sabado;
    }

    public ArrayList<ComidaEntity> getDomingo() {
        return domingo;
    }

    public void setDomingo(ArrayList<ComidaEntity> domingo) {
        this.domingo = domingo;
    }
}
