package carlos.com.findme.data.models;

import java.io.Serializable;

public class TicketEnvio implements Serializable {
    private int idTicket;
    private int numero;
    private String estado;
    private int idComida;
    private int idNt;
    private int idUsuario;

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public int getIdNt() {
        return idNt;
    }

    public void setIdNt(int idNt) {
        this.idNt = idNt;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
