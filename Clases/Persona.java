package Package;

import java.time.LocalDate;
import java.util.ArrayList;

public class persona {
    private String nombre;
    private String rut;
    private ArrayList<pasaje> pasajes;
    private int saldoDisponible;

    public persona(String nombre, String rut, int saldoDisponible) {
        this.nombre = nombre;
        this.rut = rut;
        this.pasajes = new ArrayList<pasaje>();
        this.saldoDisponible = saldoDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public ArrayList<pasaje> getPasajes() {
        return pasajes;
    }

    public void setPasajes(ArrayList<pasaje> pasajes) {
        this.pasajes = pasajes;
    }

    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public boolean puedePagar(int monto) {
        if (saldoDisponible >= monto) {
            return true;
        }
        return false;
    }

    //comprar pasaje con fecha 
    public boolean comprarPasaje(viaje viajeActual, bus busDelViaje, int asiento, String fecha) {
        if (busDelViaje == null) {
            return false;
        }

        if (busDelViaje.getPatente().equals(viajeActual.getPatente()) == false) {
            return false;
        }

        if (busDelViaje.asientoEnRango(asiento) == false) {
            return false;
        }

        if (busDelViaje.asientoOcupado(asiento) == true) {
            return false;
        }

        if (puedePagar(viajeActual.getCostoViaje()) == false) {
            return false;
        }

        pasaje nuevoPasaje = new pasaje(
            viajeActual.getViajeID(),
            viajeActual.getHoraLlegada(),
            viajeActual.getHoraSalida(),
            viajeActual.getDestinoFinal(),
            viajeActual.getCostoViaje(),
            asiento,
            fecha
        );

        pasajes.add(nuevoPasaje);
        saldoDisponible = saldoDisponible - viajeActual.getCostoViaje();
        busDelViaje.ocuparAsiento(asiento);
        viajeActual.agregarPasajero(rut);

        return true;
    }

    //comprar pasaje sin fecha
    public boolean comprarPasaje(viaje viajeActual, bus busDelViaje, int asiento) {
        String fechaHoy = LocalDate.now().toString();
        boolean resultado = comprarPasaje(viajeActual, busDelViaje, asiento, fechaHoy);
        return resultado;
    }
    
    public void mostrarPasajes() {
        System.out.println("Pasajes de " + nombre + " (" + rut + "):");

        if (pasajes.size() == 0) {
            System.out.println("No tiene pasajes.");
            return;
        }

        int i = 0;
        while (i < pasajes.size()) {
            pasaje pasajeActual = pasajes.get(i);

            System.out.println(
                "ID: " + pasajeActual.getIdPasaje()
                + " | Destino: " + pasajeActual.getDestinoFinal()
                + " | Salida: " + pasajeActual.getHoraSalida()
                + " | Llegada: " + pasajeActual.getHoraLlegada()
                + " | Asiento: " + pasajeActual.getAsiento()
                + " | Fecha: " + pasajeActual.getFecha()
                + " | Costo: " + pasajeActual.getCostoPasaje()
            );

            i = i + 1;
        }
    }
}
