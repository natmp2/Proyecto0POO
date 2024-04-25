package itcr.proyecto0poo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // pruebas metodos horarios, cita y servicios
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
        // Creamos algunos servicios
        Servicio.crearServicio("Corte de cabello");
        Servicio.crearServicio("Manicura");
        Servicio.crearServicio("Pedicura");

        // Mostrar los servicios creados
        System.out.println("Servicios creados:");
        for (Servicio servicio : Servicio.listaServicios) {
            System.out.println("Número: " + servicio.getNumero() + ", Nombre: " + servicio.getNombre());
        }

        // Consultar un servicio
        System.out.println("\nConsultar servicio:");
        Servicio.consultarServicio(1); // Consultar el primer servicio creado

        // Creamos un cliente
        Cliente cliente1 = new Cliente();
        cliente1.crearCliente("Juan Pérez", "juan@example.com", "8888-8888");
        cliente1.consultarCliente(1);
        


        // Creamos una lista de citas
        List<Cita> citas = new ArrayList<>();
        LocalDate fechaCita = LocalDate.of(2024, 4, 30);
        int horaCita = 10;
        Servicio servicioCita = Servicio.listaServicios.get(0); // Tomamos el primer servicio de la lista
        Cita cita1 = new Cita(fechaCita, horaCita, servicioCita, false, cliente1);
        cita1.crearCita(fechaCita, horaCita, cliente1, servicioCita, citas);
        cita1.consultarCita();
    }

}
