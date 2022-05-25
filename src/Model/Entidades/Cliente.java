package Model.Entidades;

import java.util.Objects;

public class Cliente implements Comparable{

    private String nombre, apellidos, cif, direccion;
    private int categoria;

    public Cliente(String nombre, String apellidos, String cif, String direccion, int categoria) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cif = cif;
        this.direccion = direccion;
        this.categoria = categoria;
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "%S, %S, %S, %S, %S".formatted(nombre, apellidos, cif, direccion, categoria);
    }


    @Override
    public int compareTo(Object o) {
        int compare=0;
        if (o instanceof Cliente){
            Cliente cliente = (Cliente) o;
            compare = this.cif.compareTo(cliente.cif);
        }
        return compare;
    }
}
