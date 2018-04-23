package carlos.com.ticketsapp.data.models;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by kath on 09/04/18.
 */

public class UserEntity implements Serializable {

    public Integer idUsuario;
    public String nombres;
    public String apePat;
    public String apeMat;
    public String codigo;
    public String dni;
    public String user;
    public String password;
    public String telefono;
    public String estado;
    public ArrayList<Object> aplicarSancionList = null;
    public ArrayList<Object> ticketList = null;
    public TipoUsuario tipoUsuario;


    public UserEntity() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApePat() {
        return apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Object> getAplicarSancionList() {
        return aplicarSancionList;
    }

    public void setAplicarSancionList(ArrayList<Object> aplicarSancionList) {
        this.aplicarSancionList = aplicarSancionList;
    }

    public ArrayList<Object> getTicketList() {
        return ticketList;
    }

    public void setTicketList(ArrayList<Object> ticketList) {
        this.ticketList = ticketList;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
