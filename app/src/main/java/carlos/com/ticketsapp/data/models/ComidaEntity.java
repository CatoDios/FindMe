package carlos.com.ticketsapp.data.models;

import java.io.Serializable;
import java.util.ArrayList;

public class ComidaEntity implements Serializable {

    private String dia;
    private ArrayList<Comida> comidas;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public ArrayList<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(ArrayList<Comida> comidas) {
        this.comidas = comidas;
    }
}
