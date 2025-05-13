package vista;

import modelo.SignoVital;

public class VistaConsola {
    private void mostrarBarraProgreso(String mensaje) throws InterruptedException {
        System.out.print(mensaje + " [");
        for (int i = 0; i <= 30; i++) {
            System.out.print((i == 30) ? "=>" : "=");
            Thread.sleep(150);
        }
        System.out.println("] 100%");
    }

    public void mostrarSignos(SignoVital signos) throws InterruptedException {
        System.out.println("\n----- REGISTRO DE SIGNOS VITALES -----");

        System.out.println("\nPulso Cardiaco. Analizando...");
        mostrarBarraProgreso("Progreso");
        System.out.println("Resultado: " + signos.getPulsoCardiaco() + " lpm");

        System.out.println("\nOxigenación. Analizando...");
        mostrarBarraProgreso("Progreso");
        System.out.println("Resultado: " + signos.getOxigenacion() + "%");

        System.out.println("\nPresión Arterial. Analizando...");
        mostrarBarraProgreso("Progreso");
        System.out.println("Resultado: " + signos.getPresionArterial());

        System.out.println("\n--------------------------------------");
    }
}