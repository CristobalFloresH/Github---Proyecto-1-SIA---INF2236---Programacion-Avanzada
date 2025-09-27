package Package;
import javax.swing.*;

public class viajeDirecto extends viaje {

    public viajeDirecto(int viajeID, int costoViaje, int costoParaEmpresa, String patente, String origen,
                        String destinoFinal, String horaSalida, String horaLlegada) {
        super(viajeID, costoViaje, costoParaEmpresa, patente, origen, destinoFinal, horaSalida, horaLlegada);
    }

    public JPanel infoViajeCompletaComoPanel() {
        JPanel panel = super.infoViajeCompletaComoPanel();
        panel.add(new JLabel("Tipo de viaje: Directo"));
        panel.add(new JLabel("---------------------------------"));
        return panel;
    }
}
