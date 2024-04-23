package itcr.proyecto0poo;

import java.util.Scanner;

// prueba Clase "Cliente"
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Cliente
        Cliente cliente = new Cliente();
        
        // Probar creación de clientes
        cliente.crearCliente("Nathaniel Motykiewicz", "natmp@hotmail.com", "8682-2817");
        cliente.crearCliente("Felipe Benavides", "felibs@gmail.com", "84448426");

        // Imprimir los clientes actuales
        cliente.imprimirClientes();

        // Probar modificación de un cliente
        System.out.println("\nIngrese el número del cliente que desea modificar:");
        Scanner scanner = new Scanner(System.in);
        int numeroModificar = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer del scanner
        System.out.println("\nIngrese el nuevo nombre del cliente:");
        String nuevoNombre = scanner.nextLine();
        System.out.println("Ingrese el nuevo email del cliente:");
        String nuevoEmail = scanner.nextLine();
        System.out.println("Ingrese el nuevo teléfono del cliente:");
        String nuevoTelefono = scanner.nextLine();
        cliente.modificarCliente(numeroModificar, nuevoNombre, nuevoEmail, nuevoTelefono);

        // Imprimir los clientes después de la modificación
        cliente.imprimirClientes();

        // Probar consultar un cliente
        System.out.println("\nIngrese el número del cliente que desea consultar:");
        int numeroConsultar = scanner.nextInt();
        cliente.consultarCliente(numeroConsultar);

        // Probar borrar de un cliente
        System.out.println("\nIngrese el número del cliente que desea borrar:");
        int numeroBorrar = scanner.nextInt();
        cliente.borrarCliente(numeroBorrar);

        // Imprimir los clientes después de borrar
        cliente.imprimirClientes();
    }
}


