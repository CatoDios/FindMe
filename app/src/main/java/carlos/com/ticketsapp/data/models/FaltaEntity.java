package carlos.com.ticketsapp.data.models;

import java.io.Serializable;

/**
 * Created by carlos on 12/06/2018.
 */

public class FaltaEntity implements Serializable {
    private String nombreSancion;
    private String inicio;
    private String fin;

    public String getNombreSancion() {
        return nombreSancion;
    }

    public void setNombreSancion(String nombreSancion) {
        this.nombreSancion = nombreSancion;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}
