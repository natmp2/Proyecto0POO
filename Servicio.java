package itcr.proyecto0poo;

import java.io.Serializable;

public class Servicio implements Serializable {
    private static int consecutivo = 1;
    private int numero;
    private String nombre;

    public Servicio(String nombre) {
        this.nombre = nombre;
        this.numero = consecutivo++;
    }

    public void crearServicio(String nombre) {
        Servicio nuevoServicio = new Servicio(nombre);
        System.out.println("Servicio creado exitosamente: " + nuevoServicio);
    }
    
    public void modificarServicio(String nuevoNombre) {
        this.nombre = nuevoNombre;
        System.out.println("Servicio modificado exitosamente: " + this);
    }
    
    public void borrarServicio() {
        System.out.println("Servicio eliminado exitosamente: " + this);
    }

    public void consultarServicio() {
        System.out.println("Datos del tipo de servicio:");
        System.out.println("Número: " + this.numero);
        System.out.println("Nombre: " + this.nombre);
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
