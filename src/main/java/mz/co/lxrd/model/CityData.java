package mz.co.lxrd.model;

public class CityData {
    private String nome;
    private String pais;
    private double latitude;
    private double longitude;

    public CityData(String nome, String pais, double latitude, double longitude) {
        this.nome = nome;
        this.pais = pais;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
