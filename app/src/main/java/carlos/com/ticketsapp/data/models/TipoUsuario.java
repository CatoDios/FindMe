package carlos.com.ticketsapp.data.models;

import java.io.Serializable;
import java.util.ArrayList;

public class TipoUsuario implements Serializable{

    public Integer idTu;
    public String nombreTu;
    public ArrayList<Object> comidaList = null;

    public Integer getIdTu() {
        return idTu;
    }

    public void setIdTu(Integer idTu) {
        this.idTu = idTu;
    }

    public String getNombreTu() {
        return nombreTu;
    }

    public void setNombreTu(String nombreTu) {
        this.nombreTu = nombreTu;
    }

    public ArrayList<Object> getComidaList() {
        return comidaList;
    }

    public void setComidaList(ArrayList<Object> comidaList) {
        this.comidaList = comidaList;
    }
}
