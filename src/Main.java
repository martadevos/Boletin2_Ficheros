import Controller.GestionClientes;
import Model.Entidades.Cliente;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File ficheroClientes = new File("C:/Users/mdevos/Desktop/Boletin2_Ficheros/src/Archivos/CLIENTES.txt");
        Cliente cliente = new Cliente("Juan", "Perez Gómez", "1234", "patata", 1);
        //GestionClientes.altaCliente(ficheroClientes, cliente);
        //GestionClientes.altaCliente(ficheroClientes, cliente);
        //GestionClientes.altaCliente(ficheroClientes, cliente);
        GestionClientes.consultarElementoPorApellidos(ficheroClientes, "Perez Gómez");
    }
}
