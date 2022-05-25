import Controller.GestionClientes;
import Model.Entidades.Cliente;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File ficheroClientes = new File("src/Archivos/CLIENTES.txt");
        File ficheroModif = new File("src/Archivos/MODIFICACIONES.txt");
        Cliente cliente = new Cliente("Juan", "Perez Gómez", "1234", "patata", 1);
        //GestionClientes.altaCliente(ficheroClientes, cliente);
        //GestionClientes.altaCliente(ficheroClientes, cliente);
        //GestionClientes.altaCliente(ficheroClientes, cliente);
        //System.out.println(GestionClientes.buscarElementoPorApellidos(ficheroClientes, "Pere Gómez"));
        GestionClientes.realizarModificaciones(ficheroClientes, ficheroModif);
    }
}
