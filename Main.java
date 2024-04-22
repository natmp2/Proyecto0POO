package itcr.barbero;

public class Main {
    public static void main(String[] args) {
        String correo1 = "nathaniel@gmail.com";
        String correo2 = "gmail.com@";
        String correo3 = "@gmail.com";

        System.out.println("El correo " + correo1 + " es válido: " + Barbero.verificarEmail(correo1));
        System.out.println("El correo " + correo2 + " es válido: " + Barbero.verificarEmail(correo2));
        System.out.println("El correo " + correo3 + " es válido: " + Barbero.verificarEmail(correo3));

    }
}
