
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(int horaApertura) {
        this.horaApertura = horaApertura;
    }

    public int getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(int horaCierre) {
        this.horaCierre = horaCierre;
    }
    

    
    
    
}
