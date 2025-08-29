package Package;

public class pasaje {
    private int idPasaje;
    private String horaLlegada;
    private String horaSalida;
    private String destinoFinal;
    private int costoPasaje;
    private int asiento;
    private String fecha;

    public pasaje(int idPasaje, String horaLlegada, String horaSalida, String destinoFinal, int costoPasaje, int asiento, String fecha) {
        this.idPasaje = idPasaje;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.destinoFinal = destinoFinal;
        this.costoPasaje = costoPasaje;
        this.asiento = asiento;
        this.fecha = fecha;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getDestinoFinal() {
        return destinoFinal;
    }

    public void setDestinoFinal(String destinoFinal) {
        this.destinoFinal = destinoFinal;
    }

    public int getCostoPasaje() {
        return costoPasaje;
    }

    public void setCostoPasaje(int costoPasaje) {
        this.costoPasaje = costoPasaje;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
