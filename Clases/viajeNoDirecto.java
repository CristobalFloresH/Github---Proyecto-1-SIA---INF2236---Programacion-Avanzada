package Package;

public class viajeNoDirecto extends viaje {

    public viajeNoDirecto(int viajeID, int costoViaje, int costoParaEmpresa, String patente, String origen, String destinoFinal, String horaSalida, String horaLlegada) {
        super(viajeID, costoViaje, costoParaEmpresa, patente, origen, destinoFinal, horaSalida, horaLlegada);
    }

    public void mostrarInformacionViajeCompleta() {
        super.mostrarInformacionViajeCompleta();
        System.out.println("Tipo de viaje: No Directo");
        System.out.println("---------------------------------");
    }
}
