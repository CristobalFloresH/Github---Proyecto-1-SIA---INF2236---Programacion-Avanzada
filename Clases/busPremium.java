package Package;

public class busPremium extends bus {

    public busPremium(int capacidad, String patente, int disponibilidad, int tipo) {
        super(capacidad, patente, disponibilidad, tipo);
    }
    
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Cantidad de pisos: 2");
        System.out.println("Asientos Reclinables: Si");
        System.out.println("---------------------------------");
    }
}
