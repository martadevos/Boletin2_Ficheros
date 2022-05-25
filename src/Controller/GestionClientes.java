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
        boolean salir = false;
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

    public static void insertarModificacionCliente(File modificaciones, Cliente cliente){
        altaCliente(modificaciones, cliente);
    }

    public static void realizarModificaciones(File clientes, File modificaciones){
        BufferedReader leerClientes = null;
        BufferedReader leerModificaciones = null;
        BufferedWriter clientesModif = null;
        String cliente, clienteModif;
        String[] clienteSeparado;
        Cliente objCliente = new Cliente(), objClienteModif = new Cliente();
        boolean salir= false;
        try {
            leerClientes = new BufferedReader(new FileReader(clientes));
            clientesModif = new BufferedWriter(new FileWriter("src/Archivos/clientesModif.txt"));
            cliente = leerClientes.readLine();
            while (cliente != null){
                clienteSeparado = cliente.split(", ");
                objCliente.setNombre(clienteSeparado[0]);
                objCliente.setApellidos(clienteSeparado[1]);
                objCliente.setCif(clienteSeparado[2]);
                objCliente.setDireccion(clienteSeparado[3]);
                objCliente.setCategoria(Integer.parseInt(clienteSeparado[4]));
                leerModificaciones = new BufferedReader(new FileReader(modificaciones));
                clienteModif = leerModificaciones.readLine();
                while (clienteModif != null) {
                    clienteSeparado = clienteModif.split(", ");
                    objClienteModif.setNombre(clienteSeparado[0]);
                    objClienteModif.setApellidos(clienteSeparado[1]);
                    objClienteModif.setCif(clienteSeparado[2]);
                    objClienteModif.setDireccion(clienteSeparado[3]);
                    objClienteModif.setCategoria(Integer.parseInt(clienteSeparado[4]));
                    if (objCliente.compareTo(objClienteModif) == 0){
                       clientesModif.write(clienteModif);
                        clientesModif.newLine();
                        salir = true;
                    }
                    clienteModif = leerModificaciones.readLine();
                }
                leerModificaciones.close();
                if (objCliente.compareTo(objClienteModif) != 0 && !salir){
                    clientesModif.write(cliente);
                    clientesModif.newLine();
                }
                salir = false;
                cliente = leerClientes.readLine();
            }
            File ficheroModif = new File("src/Archivos/clientesModif.txt");
            boolean res = ficheroModif.renameTo(clientes);
            if (res) {
                clientes.delete();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (leerClientes != null) {
                    leerClientes.close();
                }
                if (leerModificaciones != null) {
                    leerModificaciones.close();
                }
                if (clientesModif != null) {
                    clientesModif.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo de lectura.");
            }
        }
    }
    public static void insertarBajaCliente(File bajas, Cliente cliente){
        altaCliente(bajas, cliente);
    }

    public static void realizarBajas(File clientes, File bajas){
        BufferedReader leerClientes = null;
        BufferedReader leerModificaciones = null;
        BufferedWriter ficheroNuevo = null;
        String cliente, clienteModif;
        String[] clienteSeparado;
        Cliente objCliente = new Cliente(), objClienteModif = new Cliente();
        try {
            leerClientes = new BufferedReader(new FileReader(clientes));
            ficheroNuevo = new BufferedWriter(new FileWriter("src/Archivos/ficheroNuevo.txt"));
            cliente = leerClientes.readLine();
            while (cliente != null){
                clienteSeparado = cliente.split(", ");
                objCliente.setNombre(clienteSeparado[0]);
                objCliente.setApellidos(clienteSeparado[1]);
                objCliente.setCif(clienteSeparado[2]);
                objCliente.setDireccion(clienteSeparado[3]);
                objCliente.setCategoria(Integer.parseInt(clienteSeparado[4]));
                leerModificaciones = new BufferedReader(new FileReader(bajas));
                clienteModif = leerModificaciones.readLine();
                while (clienteModif != null) {
                    clienteSeparado = clienteModif.split(", ");
                    objClienteModif.setNombre(clienteSeparado[0]);
                    objClienteModif.setApellidos(clienteSeparado[1]);
                    objClienteModif.setCif(clienteSeparado[2]);
                    objClienteModif.setDireccion(clienteSeparado[3]);
                    objClienteModif.setCategoria(Integer.parseInt(clienteSeparado[4]));
                    if (objCliente.compareTo(objClienteModif) != 0){
                        ficheroNuevo.write(cliente);
                        ficheroNuevo.newLine();
                    }
                    clienteModif = leerModificaciones.readLine();
                }
                leerModificaciones.close();
                cliente = leerClientes.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (leerClientes != null) {
                    leerClientes.close();
                }
                if (leerModificaciones != null) {
                    leerModificaciones.close();
                }
                if (ficheroNuevo != null) {
                    ficheroNuevo.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo de lectura.");
            }
        }
    }
}
