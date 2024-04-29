package itcr.barbero;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Barbero implements Serializable {
    private ArrayList<Cliente> listaClientes;
    private HashMap<Cliente, ArrayList<Cita>> listaCitas;
    private ArrayList<Servicio> listaServicios;
    private Map<DayOfWeek, HorarioAtencion.HorarioDiario> horarioSemanal;
    
    public Barbero(){
        horarioSemanal = new HashMap<>();
        listaServicios = new ArrayList<>();
    }
    
    public void crearServicio(String nombre) {
        Servicio nuevoServicio = new Servicio(nombre);
        listaServicios.add(nuevoServicio);
        System.out.println("Servicio creado exitosamente: " + nuevoServicio + "con el numero: " + nuevoServicio.getNumero());
    }
    
    
    public void modificarServicio(String viejoServicio, String nuevoServicio) {
        for (Servicio servicio : listaServicios){
            if (servicio.getNombre().equals(viejoServicio)){
                servicio.setNombre(nuevoServicio);
                System.out.println("Servicio modificado exitosamente: " + servicio + "con el numero: " + servicio.getNumero());
                return;
            }
        }
        System.out.println("no se encontró un servicio con ese nombre");
    }
    
    
    public void borrarServicio(String nombre) {
        for (Servicio servicio : listaServicios) {
            if (servicio.getNombre().equals(nombre)){
                listaServicios.remove(servicio);
                System.out.println("Servicio " + servicio + "con el numero: " + servicio.getNumero() + "ha sido eliminado con exito ");
                return;
            }
        }
        System.out.println("no se encontró un servicio con ese nombre");
    }
    
    
    public void consultarServicios() {
        System.out.println("Nombres y numeros de los servicios creados: \n");
        for (Servicio servicio : listaServicios){
            System.out.println(servicio + "\t");
            System.out.println(servicio.getNumero());
            System.out.println("\n");
                                  
        }
    }
    
    public static final Pattern REGEX_CORREO = 
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean verificarEmail (String email) {
        Matcher matcher = REGEX_CORREO.matcher(email);
        return matcher.matches();
    }
    
    public void setHorarioSemanal(Map<DayOfWeek, HorarioAtencion.HorarioDiario> horarioSemanal){
        this.horarioSemanal = horarioSemanal;
    }
    
    
}
