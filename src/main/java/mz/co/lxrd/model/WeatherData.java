package mz.co.lxrd.model;

public class WeatherData  {
    private double temperatura;
    private int humidade;
    private double velocidadeVento;
    private String horaConsulta;

    public WeatherData(double temperatura, int humidade, double velocidadeVento, String horaConsulta) {
        this.temperatura = temperatura;
        this.humidade = humidade;
        this.velocidadeVento = velocidadeVento;
        this.horaConsulta = horaConsulta;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getHumidade() {
        return humidade;
    }

    public void setHumidade(int humidade) {
        this.humidade = humidade;
    }

    public double getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(double velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }
}
