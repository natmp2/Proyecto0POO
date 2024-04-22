
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

@Override
public String toString(){
    return "";
}
        
}
