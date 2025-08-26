package primerProyectoJava;

public class Pasaje{
    private int idPasaje;
    private String horaLlegada;
    private String horaSalida;
    private String destinoFinal;
    private int costoPasaje;
    private int asiento;
    private String fecha; 
    
    // Constructor
    public Pasaje(int idPasaje, String horaLlegada, String horaSalida, String destinoFinal, int costoPasaje, int asiento, String fecha) {
        this.idPasaje = idPasaje;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.destinoFinal = destinoFinal;
        this.costoPasaje = costoPasaje;
        this.asiento = asiento;
        this.fecha = fecha;
    }

    // Getters
    public int getIdPasaje() {
        return idPasaje;
    }
    public String getHoraLlegada() {
        return horaLlegada;
    }
    public String getHoraSalida() {
        return horaSalida;
    }
    public String getDestinoFinal() {
        return destinoFinal;
    }
    public int getCostoPasaje() {
        return costoPasaje;
    }
    public int getAsiento() {
        return asiento;
    }
    public String getFecha() {
        return fecha;
    }

    // Setters
    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }
    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
    public void setDestinoFinal(String destinoFinal) {
        this.destinoFinal = destinoFinal;
    }
    public void setCostoPasaje(int costoPasaje) {
        this.costoPasaje = costoPasaje;
    }
    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
