package vista;

import modelo.SignoVital;
import java.awt.Toolkit;

public class VistaConsola {
    private static final String RESET = "\u001B[0m";
    private static final String ROJO = "\u001B[31m";

    private void mostrarBarraProgreso(String mensaje) throws InterruptedException {
        System.out.print(mensaje + " [");
        for (int i = 0; i <= 30; i++) {
            System.out.print((i == 30) ? "=>" : "=");
            Thread.sleep(150);
        }
        System.out.println("] 100%");
    }

    private void verificarAlertaPulso(SignoVital signos) throws InterruptedException {
        if (signos.getPulsoCardiaco() < 60 || signos.getPulsoCardiaco() > 100) {
            simularLlamadaEmergencia("Contactando emergencias...");
        }
    }

    private void verificarAlertaOxigenacion(SignoVital signos) throws InterruptedException {
        if (signos.getOxigenacion() < 95) {
            simularLlamadaEmergencia("Llamando a cuidador...");
        }
    }

    private void verificarAlertaPresion(SignoVital signos) throws InterruptedException {
        String[] presion = signos.getPresionArterial().split("/");
        int sistolica = Integer.parseInt(presion[0]);
        int diastolica = Integer.parseInt(presion[1]);

        if (sistolica < 90 || sistolica > 140 || diastolica < 60 || diastolica > 90) {
            simularLlamadaEmergencia("Llamando a contacto de emergencia...");
        }
    }

    private void simularLlamadaEmergencia(String mensaje) throws InterruptedException {
        Toolkit.getDefaultToolkit().beep();
        System.out.print(ROJO + "\n" + mensaje + " Procesando");

        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            System.out.print(".");
        }

        Thread.sleep(1000);
        System.out.println("\nRespuesta recibida: 'En camino'" + RESET);
    }

    public void mostrarSignos(SignoVital signos) throws InterruptedException {
        System.out.println("\n----- REGISTRO DE SIGNOS VITALES -----");

        // Pulso Cardiaco
        System.out.println("\nPulso Cardiaco. Analizando...");
        mostrarBarraProgreso("Progreso");
        System.out.println("Resultado: " + signos.getPulsoCardiaco() + " lpm");
        verificarAlertaPulso(signos);

        // Oxigenación
        System.out.println("\nOxigenación. Analizando...");
        mostrarBarraProgreso("Progreso");
        System.out.println("Resultado: " + signos.getOxigenacion() + "%");
        verificarAlertaOxigenacion(signos);

        // Presión Arterial
        System.out.println("\nPresión Arterial. Analizando...");
        mostrarBarraProgreso("Progreso");
        System.out.println("Resultado: " + signos.getPresionArterial());
        verificarAlertaPresion(signos);

        System.out.println("\n--------------------------------------");
    }
}