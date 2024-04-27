package itcr.proyecto0poo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Cita implements Serializable {
    private static int consecutivo = 1;
    private boolean confirmacion;
    private int hora;
    private LocalDate fecha;
    private Cliente cliente;
    private Servicio servicio;

    public Cita(LocalDate fecha, int hora, Servicio servicio, boolean confirmacion, Cliente cliente) {
        this.fecha = fecha;
        this.hora = hora;
        this.confirmacion = confirmacion;
        this.cliente = cliente;
        this.servicio = servicio;
    }

    public boolean crearCita(LocalDate fecha, int hora, Cliente cliente, Servicio servicio, List<Cita> citas) {
        // verificar si la fecha está dentro del horario de atención
        if (!esDiaLaboral(fecha)) {
            System.out.println("La fecha está fuera del horario de atención.");
            return false;
        }

        // verificar si la hora está dentro del horario de atención
        if (!esHoraValida(hora)) {
            System.out.println("La hora no está dentro del horario de atención.");
            return false;
        }

        // verificar si la hora ya está ocupada por otra cita
        for (Cita cita : citas) {
            if (cita.getFecha().equals(fecha) && cita.getHora() == hora) {
                System.out.println("La hora ya está ocupada por otra cita.");
                return false;
            }
        }

        // Si pasa todas las verificaciones, se crea la cita
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.servicio = servicio;
        return true;
    }

    public boolean modificarCita(int nuevaHora, LocalDate nuevaFecha, Servicio nuevoServicio) {
        // Verificar si la nueva fecha y hora están dentro del horario de atención
        if (!esDiaLaboral(nuevaFecha) || !esHoraValida(nuevaHora)) {
            System.out.println("La nueva fecha o hora no están dentro del horario de atención.");
            return false;
        }

        // Actualizar la cita con los nuevos datos
        this.fecha = nuevaFecha;
        this.hora = nuevaHora;
        this.servicio = nuevoServicio;
        return true;
    }
    
    public void consultarCita() {
        System.out.println("Información de la cita:");
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
        System.out.println("Cliente: " + cliente); 
        System.out.println("Servicio: " + servicio);
        System.out.println("Confirmación: " + (confirmacion ? "Confirmada" : "Pendiente")); // el ? es para evaluar booleanos
    }
    
    public void borrarCita() {
        // eliminar la referencia a la cita, dejamos que el recolector de basura de Java se encargue de liberar la memoria
        this.fecha = null;
        this.hora = 0;
        this.cliente = null;
        this.servicio = null;
    }

    private boolean esDiaLaboral(LocalDate fecha) {
        // implementar la lógica para verificar si la fecha está dentro del horario de atención
        // este es ejemplo, cambiar luego según horario
        return fecha.getDayOfWeek().getValue() >= 1 && fecha.getDayOfWeek().getValue() <= 5;
    }

    private boolean esHoraValida(int hora) {
        // implementar la lógica para verificar si la hora está dentro del horario de atención
        // este es ejemplo, cambiar luego según horario
        return hora >= 8 && hora <= 17;
    }
    public static int getConsecutivo() {
        return consecutivo;
    }

    public static void setConsecutivo(int consecutivo) {
        Cita.consecutivo = consecutivo;
    }

    public boolean isConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(boolean confirmacion) {
        this.confirmacion = confirmacion;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
        
}
