package carlos.com.ticketsapp.data.models;

/**
 * Created by kath on 09/04/18.
 */

public class UserEntity {

    private String correo;
    private String contraseña;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
