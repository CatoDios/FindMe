package carlos.com.findme.data.models.desaparicion;

import java.io.Serializable;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Desaparecido extends RealmObject implements Serializable {
    @PrimaryKey
    private int pk;

    private String nombres;
    private String apellidos;
    private int edad;
    private float talla;
    private String color_cabello;
    private String color_piel;
    private String otros;
    private String fecha;
    private String hora;
    private double latitud;
    private double longitud;

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getTalla() {
        return talla;
    }

    public void setTalla(float talla) {
        this.talla = talla;
    }

    public String getColor_cabello() {
        return color_cabello;
    }

    public void setColor_cabello(String color_cabello) {
        this.color_cabello = color_cabello;
    }

    public String getColor_piel() {
        return color_piel;
    }

    public void setColor_piel(String color_piel) {
        this.color_piel = color_piel;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }
}
