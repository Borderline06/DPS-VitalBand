package modelo;

import java.util.Random;

public class RegistroSignos {

    public static SignoVital generarSignos() {
        Random rand = new Random();

        int pulso = 60 + rand.nextInt(40);
        int oxigeno = 95 + rand.nextInt(6);

        int sistolica = 110 + rand.nextInt(30);
        int diastolica = 70 + rand.nextInt(20);
        String presion = sistolica + "/" + diastolica;

        return new SignoVital(pulso, oxigeno, presion);
    }
}