package Package;

public class busComun extends bus {

    public busComun(int capacidad, String patente, int disponibilidad, int tipo) {
        super(capacidad, patente, disponibilidad, tipo);
    }

    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Cantidad de pisos: 1");
        System.out.println("---------------------------------");
    }
}
