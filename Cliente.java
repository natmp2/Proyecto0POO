package itcr.proyecto0poo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Cliente implements Serializable{
    private ArrayList<Cliente> listaClientes;

    public Cliente() {
        listaClientes = new ArrayList<>();
    }
    private static int consecutivo = 1;
    private int numero;
    private String nombre;
    private String email;
    private String telefono;


public Cliente(String nombre, String email) {
        this.numero = consecutivo++;
        this.nombre = nombre;
        this.email = email;
        
    }

    public void crearCliente(String nombre, String email, String telefono) {
        // Verificar si el email ya está en uso
        if (existeCliente(email)) {
            System.out.println("El cliente especificado ya se encuentra en el sistema.");
            return;
        }

        // Verificar si el email es válido
        if (!validarEmail(email)) {
            System.out.println("El email proporcionado no es válido.");
            return;
        }

        // Verificar si el número de teléfono es válido
        if (!validarTelefono(telefono)) {
            System.out.println("El número de teléfono proporcionado no es válido.");
            return;
        }

        // Crear el cliente y almacenarlo en el sistema
        Cliente nuevoCliente = new Cliente(nombre, email);
        nuevoCliente.setTelefono(telefono);
        listaClientes.add(nuevoCliente);

        System.out.println("Cliente creado exitosamente.");
    }

    private boolean existeCliente(String email) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

     // Función auxiliar para validar el formato del email
    private boolean validarEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Función auxiliar para validar el formato del número de teléfono
    private boolean validarTelefono(String telefono) {
        // Eliminar espacios en blanco y guiones para simplificar la validación
        telefono = telefono.replaceAll("\\s|-", "");

        // Verificar si la longitud del número de teléfono es correcta (8 dígitos)
        if (telefono.length() != 8) {
            return false;
        }

        // Verificar que cada carácter sea un dígito numérico
        for (char c : telefono.toCharArray()) {
            if (!Character.isDigit(c) && c != '(' && c != ')') {
                return false;
            }
        }

        // Si pasa todas las validaciones, el número de teléfono es válido
        return true;
    }
    
    public void modificarCliente(int numeroCliente, String nuevoNombre, String nuevoEmail, String nuevoTelefono) {
    // Buscar el cliente por su número
    Cliente clienteAModificar = null;
    for (Cliente cliente : listaClientes) {
        if (cliente.getNumero() == numeroCliente) {
            clienteAModificar = cliente;
            break;
        }
    }

    // Verificar si se encontró el cliente
    if (clienteAModificar == null) {
        System.out.println("El cliente especificado no se encuentra en el sistema.");
        return;
    }

    // Verificar si los nuevos datos son válidos
    if (!validarEmail(nuevoEmail) || !validarTelefono(nuevoTelefono)) {
        System.out.println("Los datos modificados no son válidos.");
        return;
    }

    // Actualizar los datos del cliente
    clienteAModificar.setNombre(nuevoNombre);
    clienteAModificar.setEmail(nuevoEmail);
    clienteAModificar.setTelefono(nuevoTelefono);

    System.out.println("Los datos del cliente han sido actualizados correctamente.");
    }
    
    public void borrarCliente(int numeroCliente) {
        // Buscar el cliente por su número
        Cliente clienteABorrar = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getNumero() == numeroCliente) {
                clienteABorrar = cliente;
                break;
            }
        }

        // Verificar si se encontró el cliente
        if (clienteABorrar == null) {
            System.out.println("El cliente especificado no se encuentra en el sistema.");
            return;
        }

        // Verificar si el cliente tiene citas programadas en el futuro o está en la lista de espera
        // Falta implementar la logica de cita para hacer esto

        // Eliminar al cliente de la lista de clientes
        listaClientes.remove(clienteABorrar);

        System.out.println("El cliente ha sido eliminado del sistema correctamente.");
    }

    public void consultarCliente(int numeroCliente) {
        // Buscar el cliente por su número
        Cliente clienteAConsultar = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getNumero() == numeroCliente) {
                clienteAConsultar = cliente;
                break;
            }
        }

        // Verificar si se encontró el cliente
        if (clienteAConsultar == null) {
            System.out.println("El cliente especificado no se encuentra en el sistema.");
            return;
        }

        // Mostrar la información del cliente
        System.out.println("Información del cliente:");
        System.out.println("Número: " + clienteAConsultar.getNumero());
        System.out.println("Nombre: " + clienteAConsultar.getNombre());
        System.out.println("Email: " + clienteAConsultar.getEmail());
        System.out.println("Teléfono: " + clienteAConsultar.getTelefono());
    }

    public static int getConsecutivo() {
        return consecutivo;
    }

    public static void setConsecutivo(int consecutivo) {
        Cliente.consecutivo = consecutivo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    // Método para imprimir la lista de clientes (solo para pruebas, quitar al implementar interfaz)
    public void imprimirClientes() {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println("Número: " + cliente.getNumero());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println("------------------------------------");
        }
    }
}
