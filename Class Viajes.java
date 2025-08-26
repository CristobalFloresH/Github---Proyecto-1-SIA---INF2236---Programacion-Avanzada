package primerProyectoJava;
import java.util.ArrayList;

public class Viajes {
	private int viajeID;
	private int costoViaje;
	private String patente; /*private Bus bus;*/
	private String destinoFinal;
	private String horaLlegada;
	private String horaSalida;
	private ArrayList<String> listaPasajeros;
	
    // Constructor
    public Viajes(int viajeID, int costoViaje, String patente, String destinoFinal, String horaSalida, String horaLlegada) {
        this.viajeID = viajeID;
        this.costoViaje = costoViaje;
        this.patente = patente;
        this.destinoFinal = destinoFinal;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.listaPasajeros = new ArrayList<>();
    }
    
    // Getters
    public int getViajeID() {
        return viajeID;
    }

    public int getCostoViaje() {
        return costoViaje;
    }

    public String getPatente() {
        return patente;
    }

    public String getDestinoFinal() {
        return destinoFinal;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public ArrayList<String> getListaPasajeros() {
        return listaPasajeros;
    }

    // Setters
    public void setViajeID(int viajeID) {
        this.viajeID = viajeID;
    }

    public void setCostoViaje(int costoViaje) {
        this.costoViaje = costoViaje;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setDestinoFinal(String destinoFinal) {
        this.destinoFinal = destinoFinal;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
}
