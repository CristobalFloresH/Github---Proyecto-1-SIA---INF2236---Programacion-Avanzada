package Package;

import java.util.ArrayList;

public class viaje {
    private int viajeID;
    private int costoViaje;
    private String patente;
    private String origen;
    private String destinoFinal;
    private String horaSalida;
    private String horaLlegada;
    private ArrayList<String> listaPasajeros;

    public viaje(int viajeID, int costoViaje, String patente, String origen, String destinoFinal, String horaSalida, String horaLlegada) {
        this.viajeID = viajeID;
        this.costoViaje = costoViaje;
        this.patente = patente;
        this.origen = origen;
        this.destinoFinal = destinoFinal;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.listaPasajeros = new ArrayList<String>();
    }

    public int getViajeID() {
        return viajeID;
    }

    public void setViajeID(int viajeID) {
        this.viajeID = viajeID;
    }

    public int getCostoViaje() {
        return costoViaje;
    }

    public void setCostoViaje(int costoViaje) {
        this.costoViaje = costoViaje;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestinoFinal() {
        return destinoFinal;
    }

    public void setDestinoFinal(String destinoFinal) {
        this.destinoFinal = destinoFinal;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public ArrayList<String> getListaPasajeros() {
        return listaPasajeros;
    }

    public void setListaPasajeros(ArrayList<String> listaPasajeros) {
        this.listaPasajeros = listaPasajeros;
    }

    public void agregarPasajero(String rutPasajero) {
        listaPasajeros.add(rutPasajero);
    }
}
