package Package;
import javax.swing.*;

public class busPremium extends bus {

    public busPremium(int capacidad, String patente, int disponibilidad, int tipo) {
        super(capacidad, patente, disponibilidad, tipo);
    }

    public JPanel infoBusComoPanel() {
        JPanel panel = super.infoBusComoPanel(); // panel base del padre
        panel.add(new JLabel("Cantidad de pisos: 1"));
        panel.add(new JLabel("---------------------------------"));
        return panel;
    }
}
