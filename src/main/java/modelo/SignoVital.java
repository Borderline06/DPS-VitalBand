package modelo;

public class SignoVital {
    private int pulsoCardiaco;
    private int oxigenacion;
    private String presionArterial;

    public SignoVital(int pulsoCardiaco, int oxigenacion, String presionArterial) {
        this.pulsoCardiaco = pulsoCardiaco;
        this.oxigenacion = oxigenacion;
        this.presionArterial = presionArterial;
    }

    public int getPulsoCardiaco() {
        return pulsoCardiaco;
    }

    public int getOxigenacion() {
        return oxigenacion;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPulsoCardiaco(int pulsoCardiaco) {
        this.pulsoCardiaco = pulsoCardiaco;
    }
}
