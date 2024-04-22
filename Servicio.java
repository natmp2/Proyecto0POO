
package itcr.barbero;

import java.io.Serializable;


public class Servicio implements Serializable{
    private static int consecutivo = 1;
    private static int duracion = 60;
    private int numero;
    private String nombre;

public Servicio(String nombre){
    this.nombre = nombre; 
    this.numero = consecutivo++;
}

    
    
    
}
