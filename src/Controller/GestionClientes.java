package Controller;

import Model.Entidades.Cliente;

import java.io.*;
import java.util.*;

public class GestionClientes {
    public static void altaCliente(File fichero, Cliente cliente) {
        BufferedWriter escribir = null;
        try {
            escribir = new BufferedWriter(new FileWriter(fichero, true));
            escribir.write(cliente.toString());
            escribir.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (escribir != null) {
                    escribir.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo de escritura.");
            }
        }
    }

    public static void consultarElementoPorApellidos(File fichero, String apellidos) {
        /*BufferedReader leer = null;
        String cliente;
        try {
            leer = new BufferedReader(new FileReader(fichero));
            cliente = leer.readLine();
            do{
                if (Objects.equals(cliente.split(", ")[1], apellidos.toUpperCase())) {
                    System.out.println(cliente);
                } else {
                    System.out.println("Cliente no encontrado");
                }
                cliente = leer.readLine();
            }while (cliente != null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (leer != null) {
                    leer.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo de lectura.");
            }
        }*/
        System.out.println(buscarElementoPorApellidos(fichero, apellidos));
    }

    public static String buscarElementoPorApellidos(File fichero, String apellidos) {
        BufferedReader leer = null;
        String cliente;
        boolean salir= false;
        try {
            leer = new BufferedReader(new FileReader(fichero));
             do{
                cliente = leer.readLine();
                if (cliente != null) {
                    salir = Objects.equals(cliente.split(", ")[1], apellidos.toUpperCase());
                }
            }while (!salir && cliente != null);
             if (cliente == null){
                 cliente = "Cliente no encontrado";
             }
            return cliente;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (leer != null) {
                    leer.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo de lectura.");
            }
        }
    }

    public static void consultarElementoPorCIF(File fichero, String cif) {
        System.out.println(buscarElementoPorCIF(fichero, cif));
    }

    public static String buscarElementoPorCIF(File fichero, String cif) {
        BufferedReader leer = null;
        String cliente;
        boolean salir= false;
        try {
            leer = new BufferedReader(new FileReader(fichero));
            do{
                cliente = leer.readLine();
                if (cliente != null) {
                    salir = Objects.equals(cliente.split(", ")[2], cif.toUpperCase());
                }
            }while (!salir && cliente != null);
            if (cliente == null){
                cliente = "Cliente no encontrado";
            }
            return cliente;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (leer != null) {
                    leer.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo de lectura.");
            }
        }
    }

    public static void insertarModificacionCliente(File fichero, Cliente cliente){
        altaCliente(fichero, cliente);
    }

    public static void realizarModificaciones(File clientes, File modificaciones){

    }
}
