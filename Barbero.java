package itcr.barbero;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Barbero implements Serializable {
    private Map<DayOfWeek, HorarioAtencion.HorarioDiario> horarioSemanal;
    private ArrayList<Cliente> listaClientes;
    private HashMap<Cliente, ArrayList<Cita>> listaCitas;
    private ArrayList<Servicio> listaServicios;
    
    public Barbero(){
        horarioSemanal = new HashMap<>();
        for (DayOfWeek day : DayOfWeek.values()){
            horarioSemanal.put(day, HorarioAtencion.obtenerHorarioDiario());
        }
        listaServicios = new ArrayList<>();
        listaClientes = new ArrayList<>();
    }
    
    public Cliente busquedaCliente(int numero){ // en vez de implementar for's en cada metodo se implementa esta que retorna cliente si hay y sino, null '
        // es basicamente lo que habria en cada uno de los metodos de cliente 
        for (Cliente cliente : listaClientes){
            if (cliente.getNumero() == numero){
                return cliente;
            }
        }
        return null;
    }
    
    public Servicio busquedaServicio(int numero){
        for (Servicio servicio : listaServicios){
            if (servicio.getNumero() == numero){
                return servicio;
            }
        }
        return null;
    }
    
    public int crearCliente(String nombre, String email, String telefono){
        if (!verificarEmail(email)) {
            System.out.println("el email no es valido");
            return 0;
        }
        
        if (!validarTelefono(telefono)){
            System.out.println("el telefono no es valido");
            return 0;
        }
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setEmail(email);
        nuevoCliente.setTelefono(telefono);
        listaClientes.add(nuevoCliente);
        System.out.println("cliente: " + nombre + "ha sido creado con el numero: " + nuevoCliente.getNumero());
        return nuevoCliente.getNumero();
    }
    
    public void modificarCliente(int numeroCliente, String nuevoNombre, String nuevoEmail, String nuevoTelefono){
        Cliente cliente = busquedaCliente(numeroCliente);
            if (cliente == null) {
                System.out.println("no se encontró un cliente con ese numero");
                return;
            }
            
            if (!verificarEmail(nuevoEmail)){
                System.out.println("el email no es valido");
                return;
            }
            
            if (!validarTelefono(nuevoTelefono)){
                System.out.println("el telefono no es valido");
                return;
            }
            
            cliente.setNombre(nuevoNombre);
            cliente.setEmail(nuevoEmail);
            cliente.setTelefono(nuevoTelefono);
            System.out.println("el cliente con numero: " + cliente.getNumero() + "ha sido modificado con exito");
            }
        
       
    public void borrarCliente(int numeroCliente){
        Cliente cliente = busquedaCliente(numeroCliente);
            if (cliente == null) {
                System.out.println("no se encontró un cliente con ese numero");
                return;
            }
        listaClientes.remove(cliente);
        System.out.println("se ha eliminado el cliente con numero " + numeroCliente);
        
    }
        
    public void consultarCliente(int numeroCliente){ 
        Cliente cliente = busquedaCliente(numeroCliente);
            if (cliente == null) {
                System.out.println("no se encontró un cliente con ese numero");
                return;
            }
            System.out.println("Informacion del cliente: \n");
            System.out.println("Nombre del cliente: " + cliente.getNombre());
            System.out.println("Numero del cliente: " + cliente.getNumero());
            System.out.println("Email del cliente: " + cliente.getEmail());
            System.out.println("Telefono del cliente: " + cliente.getTelefono());
            
    }
    
    public void establecerHorario(DayOfWeek dia, int horaApertura, int horaCierre){
        HorarioAtencion.HorarioDiario horario = horarioSemanal.get(dia);
        horario.setHoraApertura(horaApertura);
        horario.setHoraCierre(horaCierre);
    }
    
    public void crearServicio(String nombre) {
        Servicio nuevoServicio = new Servicio(nombre);
        listaServicios.add(nuevoServicio);
        System.out.println("Servicio creado exitosamente: " + nuevoServicio + "con el numero: " + nuevoServicio.getNumero());
    }
    
    
    public void modificarServicio(int numeroServicio, String nuevoServicio) {
        Servicio servicio = busquedaServicio(numeroServicio);
        if (servicio == null){
            System.out.println("no se encontró un servicio con ese nombre");
            return;
        }
        
        servicio.setNombre(nuevoServicio);
        System.out.println("Servicio: " + servicio + "con el numero: " + servicio.getNumero() + "ha sido modificado con exito");
    }
        
    
    public void borrarServicio(int numeroServicio) {
        Servicio servicio = busquedaServicio(numeroServicio);
        if (servicio == null){
            System.out.println("no se encontró un servicio con ese nombre");
            return;
        }
        
        listaServicios.remove(servicio);
        System.out.println("Servicio " + servicio + "con el numero: " + servicio.getNumero() + "ha sido eliminado con exito ");  
    }

    
    
    public void consultarServicios() {
        System.out.println("Nombres y numeros de los servicios creados: \n");
        for (Servicio servicio : listaServicios){
            System.out.println(servicio + "\t");
            System.out.println(servicio.getNumero());
            System.out.println("\n");
                                  
        }
    }
    
    ////////
    // aqui inicia el codigo sacado de https://stackoverflow.com/questions/8204680/java-regex-email 
    public static final Pattern REGEX_CORREO = 
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean verificarEmail (String email) {
        Matcher matcher = REGEX_CORREO.matcher(email);
        return matcher.matches();
    }
    // aqui termina el codigo 
    /////////
    
    
    
    private boolean validarTelefono(String telefono) {
        // Eliminar espacios en blanco y guiones para simplificar la validación
        telefono = telefono.replaceAll("\\s|-", "");

        // Verificar si la longitud del número de teléfono es correcta (8 dígitos)
        if (telefono.length() != 8) {
            return false;
        }
        // Verificar que cada carácter sea un dígito numérico
        for (char c : telefono.toCharArray()) {
            if (!Character.isDigit(c) && c != '(' && c != ')') {
                return false;
            }
        }
        // Si pasa todas las validaciones, el número de teléfono es válido
        return true;
    }
      
    
    public void setHorarioSemanal(Map<DayOfWeek, HorarioAtencion.HorarioDiario> horarioSemanal){
        this.horarioSemanal = horarioSemanal;
    }
    
}
