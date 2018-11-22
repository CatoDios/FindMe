package carlos.com.findme.data.models;

import java.io.Serializable;

/**
 * Created by carlos on 16/06/2018.
 */

public class ValidarEntity implements Serializable {
    int estado;
    String mensaje;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
