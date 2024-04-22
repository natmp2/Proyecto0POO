
package itcr.barbero;

import java.io.Serializable;

public class Cliente implements Serializable{
    private static int consecutivo = 1;
    private int numero;
    private String nombre;
    private String email;


public Cliente(String nombre, String email) {
        this.numero = consecutivo++;
        this.nombre = nombre;
        this.email = email;
        
    }

}
