package controlador;

import modelo.RegistroSignos;
import modelo.SignoVital;
import vista.VistaConsola;

public class ControladorSignos {
    private VistaConsola vista;

    public ControladorSignos(VistaConsola vista) {
        this.vista = vista;
    }

    public void iniciarRegistro() throws InterruptedException {
        SignoVital signos = RegistroSignos.generarSignos();
        vista.mostrarSignos(signos);
    }
}