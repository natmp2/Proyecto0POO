package itcr.proyecto0poo;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class HorarioAtencion implements Serializable {
    public static Map<DayOfWeek, HorarioDiario> horarioSemanal;

    public HorarioAtencion() {
        this.horarioSemanal = new HashMap<>();
        // inicializar el horario para cada día de la semana
        for (DayOfWeek day : DayOfWeek.values()) {
            this.horarioSemanal.put(day, new HorarioDiario());
        }
    }

    // métodos para establecer el horario de atención para un día específico (trabaja con hora militar)
    public void establecerHorario(DayOfWeek dia, int horaApertura, int horaCierre) {
        HorarioDiario horario = this.horarioSemanal.get(dia);
        horario.setHoraApertura(horaApertura);
        horario.setHoraCierre(horaCierre);
        this.horarioSemanal.put(dia, horario);
    }

    public int getHoraApertura(DayOfWeek dia) {
        return this.horarioSemanal.get(dia).getHoraApertura();
    }

    public int getHoraCierre(DayOfWeek dia) {
        return this.horarioSemanal.get(dia).getHoraCierre();
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
