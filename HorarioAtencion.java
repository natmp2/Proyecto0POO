
package itcr.barbero;

import java.io.Serializable;
import java.time.LocalDate;

public class HorarioAtencion implements Serializable{
    private LocalDate fecha;
    private int horaApertura;
    private int horaCierre;

public HorarioAtencion(LocalDate fecha, int horaApertura, int horaCierre){
    this.fecha = LocalDate.now();
    this.horaApertura = horaApertura;
    this.horaCierre = horaCierre; 
}
    
    
    
    
    
}
