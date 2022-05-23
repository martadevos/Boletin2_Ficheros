package Controller;

import Model.Entidades.Cliente;

import java.io.*;
import java.lang.reflect.Array;
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

    public static void consultarElementoPorApellidos(File fichero, String apellido) {
        BufferedReader leer = null;
        String cliente;
        try {
            leer = new BufferedReader(new FileReader(fichero));
            cliente = leer.readLine();
            while (cliente != null) {
                if (Objects.equals(cliente.split(", ")[1], apellido.toUpperCase())) {
                    System.out.println(cliente);
                } else {
                    System.out.println("cliente no encontrado");
                }
                cliente = leer.readLine();
            }
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
    public static String buscarElementoPorApellidos(File fichero, String apellido) {
        BufferedReader leer = null;
        String cliente;
        ArrayList <String> devolver = new ArrayList<>();
        boolean salir= false;
        try {
            leer = new BufferedReader(new FileReader(fichero));
            cliente = leer.readLine();
            while (cliente != null && !salir) {
                if (Objects.equals(cliente.split(", ")[1], apellido.toUpperCase())) {
                    devolver.add(cliente);
                    salir = true;
                } else {
                    devolver.add("cliente no encontrado");
                }
                cliente = leer.readLine();
            }
            return devolver;
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

}
