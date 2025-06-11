package modelo;

import java.util.Random;

public class RegistroSignos {
    private static final Random rand = new Random();
    private static final double PROBABILIDAD_ALERTA = 0.1;

    public static SignoVital generarSignos() {
        int pulso = generarPulso();
        int oxigeno = generarOxigenacion();
        String presion = generarPresionArterial();
        return new SignoVital(pulso, oxigeno, presion);
    }

    private static int generarPulso() {
        if (rand.nextDouble() < PROBABILIDAD_ALERTA) {
            return rand.nextBoolean() ? 40 + rand.nextInt(20) : 150 + rand.nextInt(30);
        } else {
            return 60 + rand.nextInt(40);
        }
    }

    private static int generarOxigenacion() {
        if (rand.nextDouble() < PROBABILIDAD_ALERTA) {
            return 80 + rand.nextInt(10);
        } else {
            return 95 + rand.nextInt(6);
        }
    }

    private static String generarPresionArterial() {
        if (rand.nextDouble() < PROBABILIDAD_ALERTA) {
            int sistolica = rand.nextBoolean() ? 70 + rand.nextInt(20) : 160 + rand.nextInt(40);
            int diastolica = rand.nextBoolean() ? 40 + rand.nextInt(20) : 100 + rand.nextInt(30);
            return sistolica + "/" + diastolica;
        } else {
            int sistolica = 110 + rand.nextInt(30);
            int diastolica = 70 + rand.nextInt(20);
            return sistolica + "/" + diastolica;
        }
    }
}
