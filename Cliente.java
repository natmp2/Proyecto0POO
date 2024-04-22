
package itcr.barbero;

import java.io.Serializable;

public class Cliente implements Serializable{
    private static int consecutivo = 1;
    private int numero;
    private String nombre;
    private String email;


public Cliente(String nombre, String email) {
        this.numero = consecutivo++;
        this.nombre = nombre;
        this.email = email;
        
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



}
