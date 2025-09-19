package Package;

import java.util.ArrayList;

public class bus {
    private int capacidad;
    private String patente;
    private int disponibilidad;
    private int tipo;
    private ArrayList<Integer> asientosUsados;

    public bus(int capacidad, String patente, int disponibilidad, int tipo) {
        this.capacidad = capacidad;
        this.patente = patente;
        this.disponibilidad = disponibilidad;
        this.tipo = tipo;
        this.asientosUsados = new ArrayList<Integer>();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Integer> getAsientosUsados() {
        return asientosUsados;
    }

    public void setAsientosUsados(ArrayList<Integer> asientosUsados) {
        this.asientosUsados = asientosUsados;
    }

    public boolean asientoEnRango(int asiento) {
        if (asiento >= 1 && asiento <= capacidad) {
            return true;
        }
        return false;
    }

    public boolean asientoOcupado(int asiento) {
        boolean ocupado = asientosUsados.contains(asiento);
        return ocupado;
    }

    //un solo asiento
    public boolean ocuparAsiento(int asiento) {
        if (asientoEnRango(asiento) == false) {
            return false;
        }
        if (asientoOcupado(asiento) == true) {
            return false;
        }
        asientosUsados.add(asiento);
        return true;
    }

    public boolean liberarAsiento(int asiento) {
        boolean removido = asientosUsados.remove(Integer.valueOf(asiento));
        return removido;
    }

    public ArrayList<Integer> revisarAsientosOcupados() {
        return asientosUsados;
    }

    //varios
    public int ocuparAsiento(int... asientos) {
        int agregados = 0;
        int indice = 0;
        
        while (indice < asientos.length) {
            int asientoActual = asientos[indice];
            
            if (ocuparAsiento(asientoActual) == true) {
                agregados = agregados + 1;
            }
            indice = indice + 1;
        }
        return agregados;
    }   

	public void mostrarInformacion() {
	    System.out.println("---------------------------------");
	    System.out.println("Información bus con patente: " + patente);
	    System.out.println("");
	    System.out.println("Capacidad: " + capacidad);
	    System.out.println("Disponibilidad: " + disponibilidad);
	    System.out.println("Tipo: " + tipo);
	    System.out.println("Asientos Ocupados: " + asientosUsados);
	    System.out.println("---------------------------------");
	}
}
