package itcr.barbero;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

public class Barbero implements Serializable {
    private Map<DayOfWeek, HorarioAtencion.HorarioDiario> horarioSemanal;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Cita> listaCitas;
    private HashMap<Cliente, ArrayList<Cita>> listaClienteCitas;
    private ArrayList<Servicio> listaServicios;
    private ArrayList<String> listaEspera;
    
    public Barbero(){
        horarioSemanal = new HashMap<>();
        for (DayOfWeek day : DayOfWeek.values()){
            horarioSemanal.put(day, HorarioAtencion.obtenerHorarioDiario());
        }
        listaServicios = new ArrayList<>();
        listaClientes = new ArrayList<>();
        listaCitas = new ArrayList<>();
        listaEspera = new ArrayList<>();
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
    
    public Cita busquedaCita(int numero){
        for (Cita cita : listaCitas){
            if (cita.getNumero() == numero){
                return cita;
            }
            
        }
        return null;
    }
    
    // metodos para las citas
    private boolean esDiaLaboral(LocalDate fecha) {
        // implementar la lógica para verificar si la fecha está dentro del horario de atención
        // este es ejemplo, cambiar luego según horario
        return fecha.getDayOfWeek().getValue() >= 1 && fecha.getDayOfWeek().getValue() <= 5;
    }

    private boolean esHoraValida(int hora, int horaApertura, int horaCierre) {
        // implementar la lógica para verificar si la hora está dentro del horario de atención
        // este es ejemplo, cambiar luego según horario
        return hora >= horaApertura && hora <= horaCierre;
    }
    
    public void crearCita(LocalDate fecha, int hora, Servicio servicio, boolean confirmacion, Cliente cliente){
        HorarioAtencion.HorarioDiario horarioDiario = horarioSemanal.get(fecha.getDayOfWeek()); 
        // creamos una instancia de horariodiario en horarioatencion para poder sacar las horas de apertura y cierre para los dias de la semana del horario semanal 
        if (!esDiaLaboral(fecha)){
            System.out.println("la fecha ingresada no es parte del horario de atencion");
            return;
        }
        
        if (!esHoraValida(hora,horarioDiario.getHoraApertura(),horarioDiario.getHoraCierre())){
            System.out.println("la hora ingresada no es parte del horario de atencion");
            return;
        }
        for (Cita cita : listaCitas){ // no podemos usar el metodo de busqueda de cita si no sabemos el numero de la cita que vamos a crear
            if (cita.getFecha().equals(fecha) && cita.getHora() == hora){
                System.out.println("la hora ingresada no es parte del horario de atencion");
                return;
            }
        }
        
        Cita nuevaCita = new Cita(fecha, hora, servicio, false, cliente);
        listaCitas.add(nuevaCita);
        System.out.println("la cita: " + nuevaCita + "con numero: " + nuevaCita.getNumero() + "ha sido creada con exito");
    }
   
    
    public void modificarCita(int numeroCita, LocalDate nuevaFecha, int nuevaHora, Servicio nuevoServicio, Cliente nuevoCliente){
        Cita cita = busquedaCita(numeroCita);
        if (cita == null) {
            System.out.println("No se encontró una cita con ese numero");
            return;
        }
        cita.setFecha(nuevaFecha);
        cita.setHora(nuevaHora);
        cita.setServicio(nuevoServicio);
        cita.setConfirmacion(false);
        cita.setCliente(nuevoCliente);
        
    }
        
    public void confirmarCita(int numeroCita){
       Cita cita = busquedaCita(numeroCita);
        if (cita == null) {
            System.out.println("No se encontró una cita con ese numero");
            return;
        }
        
        cita.setConfirmacion(true);
        System.out.println("La cita con numero" + cita.getNumero() + "ya se encuentra confirmada");
    }
    
    public void borrarCita(int numeroCita){
        Cita cita = busquedaCita(numeroCita);
        if (cita == null) {
            System.out.println("No se encontró una cita con ese numero");
            return;
        }
        listaCitas.remove(cita);
        System.out.println("se ha eliminado la cita nuemero" + numeroCita + "con exito.");
        
    }
    
    public void consultarCita(){
        System.out.println("Citas actuales");
        for (Cita cita : listaCitas){
            System.out.println(cita);
        }
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
    
    public List<Servicio> verListaServicios(){
        return listaServicios;
    }
    
    public List<Cita> verListaCitas(){
        return listaCitas;
    }
    
    public List<Cliente> verListaClientes(){
        return listaClientes;
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
    
    public void agregarListaEspera(String nombreCliente) {
        listaEspera.add(nombreCliente);
        System.out.println("Cliente " + nombreCliente + " agregado a la lista de espera.");
    }

    public void borrarDeListaEspera(String nombreCliente) {
        if (listaEspera.remove(nombreCliente)) {
            System.out.println("Cliente " + nombreCliente + " eliminado de la lista de espera.");
        } else {
            System.out.println("El cliente " + nombreCliente + " no se encontró en la lista de espera.");
        }
    }

    public void mostrarListaEspera() {
        System.out.println("Lista de espera:");
        if (listaEspera.isEmpty()) {
            System.out.println("La lista de espera está vacía.");
        } else {
            for (String nombreCliente : listaEspera) {
                System.out.println(nombreCliente);
            }
        }
    }
    
      
//    public void EnviarEmailConfirmacion(Cliente cliente, Cita cita) {
//        String correoEnviador = "barberojavatest@gmail.com"; // Reemplazar con correo electrónico de prueba
//        String claveAplicacion = "coqv drcb mtxv yplk"; // Reemplazar con tu clave de aplicación generada
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com"); // Cambia si usas otro proveedor de correo
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(correoEnviador, claveAplicacion);
//            }
//        });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(correoEnviador));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(cliente.getEmail()));
//            message.setSubject("Confirmación de cita");
//            message.setText("Estimado cliente " + cliente.getNombre() + ","
//                    + "\n\nEsta es una confirmación de su cita programada para el "
//                    + cita.getFecha() + " a las " + cita.getHora() + " horas."
//                    + "\n\nPor favor, responda a este correo para confirmar su asistencia."
//                    + "\n\nSaludos cordiales,\nEquipo de Barberos");
//
//            Transport.send(message);
//
//            System.out.println("Correo de confirmación enviado a " + cliente.getEmail());
//            cita.setConfirmacion(true);
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }


//    
//    public void obtenerCalendarioCitas(int opcionVisualizacion, LocalDate fechaInicio) {
//        // pendiente
//    }
//    
    
    
    // no me acuerdo muy bien porque habia implementado esto, al rato lo podemos borrar 
//    public void setHorarioSemanal(Map<DayOfWeek, HorarioAtencion.HorarioDiario> horarioSemanal){
//        this.horarioSemanal = horarioSemanal;
//    }
    
}
