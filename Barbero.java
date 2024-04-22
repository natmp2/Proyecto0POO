package itcr.barbero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Barbero implements Serializable {
    private ArrayList<Cliente> listaClientes;
    private HashMap<Cliente, ArrayList<Cita>> listaCitas;
    private ArrayList<Servicio> listaServicios; 
    
    public Barbero(){
    
    }
    
    public static final Pattern REGEX_CORREO = 
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean verificarEmail (String email) {
        Matcher matcher = REGEX_CORREO.matcher(email);
        return matcher.matches();
    }
}
