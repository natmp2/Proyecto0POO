package itcr.proyecto0poo;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de HorarioAtencion
        HorarioAtencion horario = new HorarioAtencion();

        // Establecer horarios de atención para diferentes días de la semana
        horario.establecerHorario(DayOfWeek.MONDAY, 8, 17);
        horario.establecerHorario(DayOfWeek.TUESDAY, 9, 18);
        horario.establecerHorario(DayOfWeek.WEDNESDAY, 9, 18);
        horario.establecerHorario(DayOfWeek.THURSDAY, 8, 16);
        horario.establecerHorario(DayOfWeek.FRIDAY, 8, 16);

        // Consultar los horarios de atención para algunos días de la semana
        System.out.println("Horario de atención para el lunes:");
        System.out.println("Apertura: " + horario.getHoraApertura(DayOfWeek.MONDAY));
        System.out.println("Cierre: " + horario.getHoraCierre(DayOfWeek.MONDAY));

        System.out.println("\nHorario de atención para el viernes:");
        System.out.println("Apertura: " + horario.getHoraApertura(DayOfWeek.FRIDAY));
        System.out.println("Cierre: " + horario.getHoraCierre(DayOfWeek.FRIDAY));

        // Crear algunos servicios
        Servicio servicio1 = new Servicio("Corte de cabello");
        Servicio servicio2 = new Servicio("Corte de cabello y barba");
        Servicio servicio3 = new Servicio("Teñir cabello");

        // Mostrar los servicios creados
        System.out.println("\nServicios creados:");
        servicio1.consultarServicio();
        servicio2.consultarServicio();
        servicio3.consultarServicio();

        // Consultar un servicio específico
        System.out.println("\nConsultar servicio:");
        servicio1.consultarServicio();

        // Crear un cliente
        Cliente cliente1 = new Cliente();
        cliente1.crearCliente("Juan López", "juan@example.com", "8888-8888");

        // Crear una cita con el cliente y el servicio
        LocalDate fechaCita = LocalDate.of(2024, 4, 30);
        int horaCita = 10;
        Cita cita1 = new Cita(fechaCita, horaCita, servicio1, false, cliente1);
        cita1.consultarCita();
    }
}
