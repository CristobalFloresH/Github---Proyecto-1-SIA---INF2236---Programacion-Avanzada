package Package;

import java.util.ArrayList;

public class persona{
	private String nombre;
	private String rut;
	private ArrayList<pasaje> pasajes;
	private int saldoDisponible;
	

	public persona(String nombre, String rut, int saldoDisponible) {
        this.nombre = nombre;
        this.rut = rut;
        this.pasajes = new ArrayList<>();
        this.saldoDisponible = saldoDisponible;
	}
	

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public ArrayList<pasaje> getPasajes() {
        return pasajes;
    }

    public int getSaldoDisponible() {
        return saldoDisponible;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
    
    public void comprarPasaje(viaje viaje, int asiento, String Fecha) {
    	pasaje nuevo = new pasaje(viaje.getViajeID(), viaje.getHoraLlegada(), viaje.getHoraSalida(), viaje.getOrigen(), viaje.getDestinoFinal(), viaje.getCostoViaje(), asiento, Fecha);
    	pasajes.add(nuevo);
    }
}

