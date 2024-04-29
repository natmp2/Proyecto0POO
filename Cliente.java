package itcr.barbero;

import java.io.Serializable;

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
