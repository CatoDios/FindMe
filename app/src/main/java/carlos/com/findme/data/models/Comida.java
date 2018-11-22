package carlos.com.findme.data.models;

import java.io.Serializable;

public class Comida implements Serializable {

    private String nombre;
    private String descripcion;
    private int numeroRaciones;
    private String comidaTipo;
    private String dia;
    private String inicioReserva;
    private String finReserva;

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

    public int getNumeroRaciones() {
        return numeroRaciones;
    }

    public void setNumeroRaciones(int numeroRaciones) {
        this.numeroRaciones = numeroRaciones;
    }

    public String getComidaTipo() {
        return comidaTipo;
    }

    public void setComidaTipo(String comidaTipo) {
        this.comidaTipo = comidaTipo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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
