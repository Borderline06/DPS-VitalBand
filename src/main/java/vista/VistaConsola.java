package vista;

import modelo.SignoVital;
import java.awt.Toolkit;

public class VistaConsola {

    // Colores ANSI
    private static final String RESET = "\u001B[0m";
    private static final String ROJO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String CELESTE = "\u001B[36m";
    private static final String BLANCO = "\u001B[37m";

    private void mostrarBarraProgreso(String mensaje) throws InterruptedException {
        System.out.print(CELESTE + mensaje + " [" + RESET);
        for (int i = 0; i <= 30; i++) {
            System.out.print(CELESTE + ((i == 30) ? "=>" : "=") + RESET);
            Thread.sleep(50); // Velocidad reducida para mejor UX
        }
        System.out.println(CELESTE + "] 100%" + RESET);
    }

    private void verificarAlertaPulso(SignoVital signos) throws InterruptedException {
        int pulso = signos.getPulsoCardiaco();
        if (pulso < 60 || pulso > 100) {
            simularLlamadaEmergencia("Pulso cardíaco fuera de rango. Contactando emergencias...");
        } else {
            System.out.println(VERDE + "Pulso dentro de los valores normales." + RESET);
        }
    }

    private void verificarAlertaOxigenacion(SignoVital signos) throws InterruptedException {
        int oxi = signos.getOxigenacion();
        if (oxi < 95) {
            simularLlamadaEmergencia("Nivel de oxigenación bajo. Llamando a cuidador...");
        } else {
            System.out.println(VERDE + "Oxigenación en nivel óptimo." + RESET);
        }
    }

    private void verificarAlertaPresion(SignoVital signos) throws InterruptedException {
        String[] presion = signos.getPresionArterial().split("/");
        int sistolica = Integer.parseInt(presion[0]);
        int diastolica = Integer.parseInt(presion[1]);

        if (sistolica < 90 || sistolica > 140 || diastolica < 60 || diastolica > 90) {
            simularLlamadaEmergencia("Presión arterial fuera de parámetros. Llamando a contacto de emergencia...");
        } else {
            System.out.println(VERDE + "Presión arterial estable." + RESET);
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
        System.out.println(CELESTE + "\n====================================");
        System.out.println("|     MONITOREO DE SIGNOS VITALES    |");
        System.out.println("====================================" + RESET);

        // Pulso Cardiaco
        System.out.println(BLANCO + "\nPulso Cardíaco. Analizando..." + RESET);
        mostrarBarraProgreso("Progreso");
        System.out.println("Resultado: " + BLANCO + signos.getPulsoCardiaco() + " lpm" + RESET);
        verificarAlertaPulso(signos);

        // Oxigenación
        System.out.println(BLANCO + "\nOxigenación. Analizando..." + RESET);
        mostrarBarraProgreso("Progreso");
        System.out.println("Resultado: " + BLANCO + signos.getOxigenacion() + "%" + RESET);
        verificarAlertaOxigenacion(signos);

        // Presión Arterial
        System.out.println(BLANCO + "\nPresión Arterial. Analizando..." + RESET);
        mostrarBarraProgreso("Progreso");
        System.out.println("Resultado: " + BLANCO + signos.getPresionArterial() + RESET);
        verificarAlertaPresion(signos);

        System.out.println(CELESTE + "\n====================================\n" + RESET);
    }
}
