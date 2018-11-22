package carlos.com.findme.data.models;

import java.io.Serializable;

/**
 * Created by carlos on 12/06/2018.
 */

public class Semana_card implements Serializable {
    private String dia;
    private String almuerzo;
    private String desayuno;
    private String cena;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(String almuerzo) {
        this.almuerzo = almuerzo;
    }

    public String getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(String desayuno) {
        this.desayuno = desayuno;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }
}
