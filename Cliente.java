package itcr.proyecto0poo;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Cliente implements Serializable {
    private static int consecutivo = 1;
    private int numero;
    private String nombre;
    private String email;
    private String telefono;

    public Cliente() {
        // Constructor predeterminado
        this.numero = consecutivo++;
    }

    // Métodos de creación, modificación, borrado y consulta de cliente
    public void crearCliente(String nombre, String email, String telefono) {
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

        // Crear el cliente con los datos proporcionados
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;

        System.out.println("Cliente creado exitosamente.");
    }

    public void modificarCliente(String nuevoNombre, String nuevoEmail, String nuevoTelefono) {
        // Verificar si los nuevos datos son válidos
        if (!validarEmail(nuevoEmail) || !validarTelefono(nuevoTelefono)) {
            System.out.println("Los datos modificados no son válidos.");
            return;
        }

        // Actualizar los datos del cliente
        this.nombre = nuevoNombre;
        this.email = nuevoEmail;
        this.telefono = nuevoTelefono;

        System.out.println("Los datos del cliente han sido actualizados correctamente.");
    }

    public void borrarCliente() {
        // Simplemente reseteamos los valores de los atributos
        this.nombre = null;
        this.email = null;
        this.telefono = null;

        System.out.println("El cliente ha sido eliminado del sistema correctamente.");
    }

    public void consultarCliente() {
        // Mostrar la información del cliente
        System.out.println("Información del cliente:");
        System.out.println("Número: " + this.numero);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Email: " + this.email);
        System.out.println("Teléfono: " + this.telefono);
    }

    // Métodos auxiliares de validación
    private boolean validarEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

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

    // Getters y setters
    public static int getConsecutivo() {
        return consecutivo;
    }

    public static void setConsecutivo(int consecutivo) {
        Cliente.consecutivo = consecutivo;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Email: " + this.email + ", Teléfono: " + this.telefono;
    }
}
