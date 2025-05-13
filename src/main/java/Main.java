import controlador.ControladorSignos;
import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorSignos controlador = new ControladorSignos(vista);

        try {
            controlador.iniciarRegistro();
        } catch (InterruptedException e) {
            System.err.println("Error en la animación: " + e.getMessage());
        }
    }
}