package vista;

import modelo.SignoVital;

public class VistaConsola {

    public void mostrarSignos(SignoVital signos) {
        System.out.println("----- REGISTRO DE SIGNOS VITALES -----");
        System.out.println("Pulso cardiaco: " + signos.getPulsoCardiaco() + " lpm");
        System.out.println("Oxigenación: " + signos.getOxigenacion() + "%");
        System.out.println("Presión arterial: " + signos.getPresionArterial());
        System.out.println("--------------------------------------");
    }
}