package carlos.com.findme.data.models;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuEntity implements Serializable{
    ArrayList<ComidaEntity> hoy;

    public ArrayList<ComidaEntity> getHoy() {
        return hoy;
    }

    public void setHoy(ArrayList<ComidaEntity> hoy) {
        this.hoy = hoy;
    }
}
