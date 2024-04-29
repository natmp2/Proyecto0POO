package itcr.barbero;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class HorarioAtencion implements Serializable {
    public static Map<DayOfWeek, HorarioDiario> horarioSemanal;

    public HorarioAtencion() {
        HorarioAtencion.horarioSemanal = new HashMap<>(); // inicializar el horario para cada día de la semana
        for (DayOfWeek day : DayOfWeek.values()) {
            HorarioAtencion.horarioSemanal.put(day, new HorarioDiario());
        }
    }

    public int getHoraApertura(DayOfWeek dia) {
        return HorarioAtencion.horarioSemanal.get(dia).getHoraApertura();
    }

    public int getHoraCierre(DayOfWeek dia) {
        return HorarioAtencion.horarioSemanal.get(dia).getHoraCierre();
    }

    public static HorarioDiario obtenerHorarioDiario() {
            return new HorarioDiario(); // para poder utilizarlo desde la clase controladora
        }
    
    // clase interna para representar el horario diario
    public static class HorarioDiario implements Serializable {
        private int horaApertura;
        private int horaCierre;
        
        
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
}
