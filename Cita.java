
package itcr.barbero;
import java.io.Serializable;
import java.time.LocalDate;


public class Cita implements Serializable{
    private static int consecutivo = 1; 
    private boolean confirmacion; 
    private int hora; 
    private LocalDate fecha;
    private Cliente cliente; 
    private Servicio servicio; 
    
public Cita (LocalDate fecha, int hora, Servicio servicio, boolean confirmacion, Cliente cliente ){
    this.fecha = LocalDate.now();
    this.hora = hora;
    this.confirmacion = confirmacion;
    this.cliente = cliente;
    this.servicio = servicio;
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



@Override
public String toString(){
    return "";
}
        
}
