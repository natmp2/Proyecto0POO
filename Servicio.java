package itcr.proyecto0poo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Servicio implements Serializable {
    private static int consecutivo = 1;
    private static int duracion = 60;
    private int numero;
    private String nombre;
    public static List<Servicio> listaServicios = new ArrayList<>();

    public Servicio(String nombre) {
        this.nombre = nombre;
        this.numero = consecutivo++;
    }

    public static void crearServicio(String nombre) {
        Servicio nuevoServicio = new Servicio(nombre);
        listaServicios.add(nuevoServicio);
        System.out.println("Servicio creado exitosamente: " + nuevoServicio);
    }
    
    public static void modificarServicio(int numeroServicio, String nuevoNombre) {
    // verificar si el servicio existe
    if (numeroServicio >= 1 && numeroServicio <= listaServicios.size()) {
        Servicio servicio = listaServicios.get(numeroServicio - 1); // restar 1 para ajustar a 0-based
        servicio.setNombre(nuevoNombre);
        System.out.println("Servicio modificado exitosamente: " + servicio);
    } else {
        System.out.println("El servicio seleccionado no existe.");
        }
    }
    
    public static void borrarServicio(int numeroServicio, List<Cita> citas) {
        if (numeroServicio >= 1 && numeroServicio <= listaServicios.size()) {
            Servicio servicio = listaServicios.get(numeroServicio - 1);

            // verificar si el servicio está siendo utilizado en alguna cita
            for (Cita cita : citas) {
                if (cita.getServicio().equals(servicio)) {
                    System.out.println("No se puede eliminar el tipo de servicio porque está siendo utilizado en una cita programada.");
                    return;
                }
            }

            // si el servicio no está siendo utilizado, se elimina
            listaServicios.remove(servicio);
            System.out.println("Servicio eliminado exitosamente: " + servicio);
        } else {
            System.out.println("El servicio seleccionado no existe.");
        }
    }

    public static void consultarServicio(int numeroServicio) {
        if (numeroServicio >= 1 && numeroServicio <= listaServicios.size()) {
            Servicio servicio = listaServicios.get(numeroServicio - 1);
            System.out.println("Datos del tipo de servicio:");
            System.out.println("Número: " + servicio.getNumero());
            System.out.println("Nombre: " + servicio.getNombre());
        } else {
            System.out.println("El servicio seleccionado no existe.");
        }
    }

    public static int getConsecutivo() {
        return consecutivo;
    }

    public static void setConsecutivo(int consecutivo) {
        Servicio.consecutivo = consecutivo;
    }

    public static int getDuracion() {
        return duracion;
    }

    public static void setDuracion(int duracion) {
        Servicio.duracion = duracion;
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
