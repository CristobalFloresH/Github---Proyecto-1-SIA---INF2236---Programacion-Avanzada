package Package;

import java.util.ArrayList;
import javax.swing.*;

public class viaje {
    private int viajeID;
    private int costoViaje;
    private int costoParaEmpresa;
    private String patente;
    private String origen;
    private String destinoFinal;
    private String horaSalida;
    private String horaLlegada;
    private ArrayList<String> listaPasajeros;

    public viaje(int viajeID, int costoViaje,int costoParaEmpresa, String patente, String origen, String destinoFinal, String horaSalida, String horaLlegada) {
        this.viajeID = viajeID;
        this.costoViaje = costoViaje;
        this.costoParaEmpresa = costoParaEmpresa;
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

    public int getCostoParaEmpresa() {
		return costoParaEmpresa;
	}

	public void setCostoParaEmpresa(int costoParaEmpresa) {
		this.costoParaEmpresa = costoParaEmpresa;
	}

	public void setListaPasajeros(ArrayList<String> listaPasajeros) {
        this.listaPasajeros = listaPasajeros;
    }

    public void agregarPasajero(String rutPasajero) {
        listaPasajeros.add(rutPasajero);
    }
    
    public int getCantidadPasajeros() {
    	return listaPasajeros.size();
    }
    
    public JPanel infoViajeCompletaComoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel(""));
        panel.add(new JLabel("Información del viaje con ID: " + viajeID));
        panel.add(new JLabel(""));
        panel.add(new JLabel("Origen: " + origen));
        panel.add(new JLabel("Destino: " + destinoFinal));
        panel.add(new JLabel("Hora de salida: " + horaSalida));
        panel.add(new JLabel("Hora de llegada: " + horaLlegada));
        panel.add(new JLabel("Patente del bus: " + patente));
        panel.add(new JLabel("Costo del viaje: " + costoViaje));
        panel.add(new JLabel("Costo para la empresa: " + costoParaEmpresa));
        panel.add(new JLabel("Pasajeros registrados: " + listaPasajeros.size()));
        panel.add(new JLabel("---------------------------------"));

        return panel;
    }
}
