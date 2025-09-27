package Package;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class viajeNoDirecto extends viaje {

    public viajeNoDirecto(int viajeID, int costoViaje, int costoParaEmpresa, String patente, String origen,
                        String destinoFinal, String horaSalida, String horaLlegada) {
        super(viajeID, costoViaje, costoParaEmpresa, patente, origen, destinoFinal, horaSalida, horaLlegada);
    }

    public JPanel infoViajeCompletaComoPanel() {
        JPanel panel = super.infoViajeCompletaComoPanel();
        panel.add(new JLabel("Tipo de viaje: No Directo"));
        panel.add(new JLabel("---------------------------------"));
        return panel;
    }
}
