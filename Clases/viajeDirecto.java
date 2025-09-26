package Package;

public class viajeDirecto extends viaje {

    public viajeDirecto(int viajeID, int costoViaje, int costoParaEmpresa, String patente, String origen, String destinoFinal, String horaSalida, String horaLlegada) {
        super(viajeID, costoViaje, costoParaEmpresa, patente, origen, destinoFinal, horaSalida, horaLlegada);
    }

    public void mostrarInformacionViajeCompleta() {
        super.mostrarInformacionViajeCompleta();
        System.out.println("Tipo de viaje: Directo");
        System.out.println("---------------------------------");
    }
}
