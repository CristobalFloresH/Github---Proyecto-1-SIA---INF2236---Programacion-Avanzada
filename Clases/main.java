package Package;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        persona persona1 = new persona("Cristobal", "12345678-9", 25000);
        persona persona2 = new persona("Diego", "98765432-1", 10000);
        persona persona3 = new persona("Mauri", "11122233-4", 2000);

        bus bus1 = new bus(30, "HP*DS*20", 1, 1);
        bus bus2 = new bus(45, "JK*TH*53", 2, 3);
        bus bus3 = new bus(20, "LM*TG*90", 3, 2);

        viaje viaje1 = new viaje(25, 10000, 120000 ,bus1.getPatente(), "El Quisco", "Santiago", "10:30", "13:00");
        viaje viaje2 = new viaje(40, 20000, 250000, bus2.getPatente(), "Santiago", "Quilpue", "08:30", "12:00");
        viaje viaje3 = new viaje(15,  5000, 80000, bus3.getPatente(), "El Tabo", "San Antonio", "07:30", "08:00");

        empresa empresaBuses = new empresa();
        
        empresaBuses.registrarBus(bus1);
        empresaBuses.registrarBus(bus2);
        empresaBuses.registrarBus(bus3);
        
        empresaBuses.registrarViaje(viaje1);
        empresaBuses.registrarViaje(viaje2);
        empresaBuses.registrarViaje(viaje3);
        
        empresaBuses.registrarPersona(persona1);
        empresaBuses.registrarPersona(persona2);
        empresaBuses.registrarPersona(persona3);

        bus busDeViaje1 = empresaBuses.obtenerBusPorPatente(viaje1.getPatente());
        persona1.comprarPasaje(viaje1, busDeViaje1, 12, "2025-08-30");

        bus busDeViaje2 = empresaBuses.obtenerBusPorPatente(viaje2.getPatente());
        persona2.comprarPasaje(viaje2, busDeViaje2, 1);

        bus busDeViaje3 = empresaBuses.obtenerBusPorPatente(viaje3.getPatente());
        persona3.comprarPasaje(viaje3, busDeViaje3, 19, "2025-07-12");

        empresaBuses.menuPrincipal();
    }
}
