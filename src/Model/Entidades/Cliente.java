package Model.Entidades;

public class Cliente  {

    public String nombre, apellidos, cif, direccion;
    public int categoria;

    public Cliente(String nombre, String apellidos, String cif, String direccion, int categoria) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cif = cif;
        this.direccion = direccion;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "%S, %S, %S, %S, %S".formatted(nombre, apellidos, cif, direccion, categoria);
    }
}
