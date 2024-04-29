package itcr.barbero;

import java.io.Serializable;

public class Servicio implements Serializable {
    private static int consecutivo = 1;
    private int numero;
    private String nombre;

    public Servicio(String nombre) {
        this.nombre = nombre;
        this.numero = consecutivo++;
    }
    
    public static int getConsecutivo() {
        return consecutivo;
    }

    public static void setConsecutivo(int consecutivo) {
        Servicio.consecutivo = consecutivo;
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
    
    @Override
    public String toString() {
        return "Número: " + this.numero + ", Nombre: " + this.nombre;
    }
}
