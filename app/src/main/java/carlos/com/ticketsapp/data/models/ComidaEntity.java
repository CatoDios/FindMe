package carlos.com.ticketsapp.data.models;

import java.io.Serializable;
import java.util.ArrayList;

public class ComidaEntity implements Serializable {

    private int idComida;
    private String nombre;
    private String descripcion;
    private int numRaciones;
    private String dia;
    private String comidaTipo;
    private String inicioReserva;
    private String finReserva;

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumRaciones() {
        return numRaciones;
    }

    public void setNumRaciones(int numRaciones) {
        this.numRaciones = numRaciones;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getComidaTipo() {
        return comidaTipo;
    }

    public void setComidaTipo(String comidaTipo) {
        this.comidaTipo = comidaTipo;
    }

    public String getInicioReserva() {
        return inicioReserva;
    }

    public void setInicioReserva(String inicioReserva) {
        this.inicioReserva = inicioReserva;
    }

    public String getFinReserva() {
        return finReserva;
    }

    public void setFinReserva(String finReserva) {
        this.finReserva = finReserva;
    }
}
