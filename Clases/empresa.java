package Package;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class empresa {
    private Map<String, bus> busPorPatente;
    private Map<Integer, viaje> viajesPorId;
    private Map<String, persona> personasPorRut;

    public empresa() {
        this.busPorPatente = new HashMap<String, bus>();
        this.viajesPorId = new HashMap<Integer, viaje>();
        this.personasPorRut = new HashMap<String, persona>();
    }

    public void registrarBus(bus busNuevo) {
    	busPorPatente.put(busNuevo.getPatente(), busNuevo);
    }

    public void registrarViaje(viaje viajeNuevo) {
        viajesPorId.put(viajeNuevo.getViajeID(), viajeNuevo);
    }
    
    public void registrarPersona(persona personaNueva) {
    	personasPorRut.put(personaNueva.getRut(), personaNueva);
    }

    public bus obtenerBusPorPatente(String patente) {
        return busPorPatente.get(patente);
    }

    public viaje obtenerViajePorId(int id) {
        return viajesPorId.get(id);
    }
    
    public persona obtenerPersonaPorRut(String rut) {
        return personasPorRut.get(rut);
    }
    
    public void menuPrincipal() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int menuAbrir = -1;
    	
    	while(menuAbrir != 0) {
    	
    		System.out.println("¡Bienvenido a +Turbus!");
        	System.out.println("");
        	System.out.println("¿Que quieres hacer?");
        	System.out.println("----------------------------------");
        	System.out.println("OPCIONES");
        	System.out.println("----------------------------------");
        	System.out.println("1.Registrarse");
        	System.out.println("2.Comprar pasajes");
        	System.out.println("3.Cancelar pasaje");
        	System.out.println("4.Mostrar pasajes por rut");
        	System.out.println("5.Mostrar usuarios por rut");
        	System.out.println("0.Salir");
        	
        	menuAbrir = Integer.parseInt(br.readLine());
    		
	    switch(menuAbrir){
	    	case 1:
	    		System.out.println("Registro de usuario.");
	    		registrarUsuario();
	    		break;		
	    	case 2:
	    		menuCompra();
	    		break;
	    			
	    	case 3:
	    		System.out.println("Por ahora no tenemos esta funcion disponible, intenta mas tarde (cancelar)");
	    		break;
	    			
	    	case 4:
	    		mostrarPasajesDePersonaPorRut();
	    		break;
	    		
	    	case 5:
	    		mostrarPersonas();
	    		break;
	    		
	    	case 0:
	    		System.out.print("Saliendo de +Turbus...");
	    		break;
	    	}
    	}
    }
   

    public void registrarUsuario() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese su RUT: (Formato: 123456789-0)");
        String rutIngresado = br.readLine();
        
        System.out.println("Ingrese su nombre: ");
        String nombreIngresado = br.readLine();

    	System.out.println("Ingrese su saldo disponible: (Formato: 10.000");
    	int saldo = Integer.parseInt(br.readLine());
    		
    	persona nuevaPersona = new persona(nombreIngresado, rutIngresado, saldo);
    	System.out.println("Cliente agregado correctamente");
    	this.registrarPersona(nuevaPersona);
    }

    public void mostrarPersonas() {
        if (personasPorRut.isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }

        System.out.println("Personas registradas en la empresa:");
        System.out.println("-----------------------------------");

        for (persona personaActual : personasPorRut.values()) {
            System.out.println(
                "Nombre: " + personaActual.getNombre()
                + " | RUT: " + personaActual.getRut()
                + " | Saldo: " + personaActual.getSaldoDisponible()
            );
        }
    }
    
    public void mostrarPasajesDePersonaPorRut() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el RUT de la persona: ");
        String rutIngresado = reader.readLine();

        persona personaEncontrada = personasPorRut.get(rutIngresado);

        if (personaEncontrada == null) {
            System.out.println("No existe persona con ese RUT.");
            return;
        }

        personaEncontrada.mostrarPasajes();
    }
    
    public void menuCompra() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1) identificamos a la persona
        System.out.println("Ingrese su RUT: ");
        String rutIngresado = br.readLine();

        persona personaCompradora = personasPorRut.get(rutIngresado);
        if (personaCompradora == null) {
            System.out.println("No existe persona con ese RUT. Regístrese primero.");
            return;
        }

        // 2) creamos una lista que tenga los destinos unicos
        ArrayList<viaje> listaViajes = new ArrayList<viaje>();
        Collection<viaje> valores = viajesPorId.values();
        for (viaje viajeActual : valores) {
            listaViajes.add(viajeActual);
        }

        ArrayList<String> destinosUnicos = new ArrayList<String>();
        int i = 0;
        while (i < listaViajes.size()) {
            viaje viajeActual = listaViajes.get(i);
            String destino = viajeActual.getDestinoFinal();
            if (destinosUnicos.contains(destino) == false) {
                destinosUnicos.add(destino);
            }
            i = i + 1;
        }

        if (destinosUnicos.size() == 0) {
            System.out.println("No hay viajes disponibles.");
            return;
        }

        // 3) mostramos estos destinos y nos aseguramos que no se salga de rango
        System.out.println("Ingrese el destino:");
        int j = 0;
        while (j < destinosUnicos.size()) {
            System.out.println((j + 1) + ". " + destinosUnicos.get(j));
            j = j + 1;
        }

        int opcionDestino = Integer.parseInt(br.readLine());
        if (opcionDestino < 1 || opcionDestino > destinosUnicos.size()) {
            System.out.println("Opción de destino inválida.");
            return;
        }
        String destinoElegido = destinosUnicos.get(opcionDestino - 1);

        // 4) filtramos por ese destino y mostramos
        ArrayList<viaje> viajesDelDestino = new ArrayList<viaje>();
        int k = 0;
        while (k < listaViajes.size()) {
            viaje viajeActual = listaViajes.get(k);
            if (viajeActual.getDestinoFinal().equals(destinoElegido) == true) {
                viajesDelDestino.add(viajeActual);
            }
            k = k + 1;
        }

        if (viajesDelDestino.size() == 0) {
            System.out.println("No hay viajes para ese destino.");
            return;
        }

        System.out.println("Ingrese el viaje según su horario de salida:");
        int h = 0;
        while (h < viajesDelDestino.size()) {
            viaje viajeActual = viajesDelDestino.get(h);
            System.out.println(
                (h + 1) + ". " +
                "Salida: " + viajeActual.getHoraSalida() +
                " | Llegada: " + viajeActual.getHoraLlegada() +
                " | Costo: " + viajeActual.getCostoViaje() +
                " | Patente bus: " + viajeActual.getPatente()
            );
            h = h + 1;
        }

        int opcionViaje = Integer.parseInt(br.readLine());
        if (opcionViaje < 1 || opcionViaje > viajesDelDestino.size()) {
            System.out.println("Opción de viaje inválida.");
            return;
        }
        viaje viajeElegido = viajesDelDestino.get(opcionViaje - 1);

        // 5) obtenemos informacion del bus del viaje y mostramos los asientos disponibles
        bus busDelViaje = busPorPatente.get(viajeElegido.getPatente());

        System.out.println("Asientos disponibles:");
        ArrayList<Integer> asientosDisponibles = new ArrayList<Integer>();
        int asientoCandidato = 1;
        while (asientoCandidato <= busDelViaje.getCapacidad()) {
            if (busDelViaje.asientoOcupado(asientoCandidato) == false) {
                asientosDisponibles.add(asientoCandidato);
            }
            asientoCandidato = asientoCandidato + 1;
        }

        if (asientosDisponibles.size() == 0) {
            System.out.println("No quedan asientos disponibles en este bus.");
            return;
        }

        int t = 0;
        while (t < asientosDisponibles.size()) {
            System.out.print(asientosDisponibles.get(t) + " ");
            t = t + 1;
        }
        System.out.println("");
        //5.5) usamos funciones para asegurarnos que el asiento sea valido
        System.out.println("Ingrese el asiento que desea:");
        int asientoElegido = Integer.parseInt(br.readLine());

        if (busDelViaje.asientoEnRango(asientoElegido) == false) {
            System.out.println("Asiento fuera de rango.");
            return;
        }
        if (busDelViaje.asientoOcupado(asientoElegido) == true) {
            System.out.println("Asiento ocupado. Intente con otro.");
            return;
        }

        // 6) preguntamos la fecha
        System.out.println("Ingrese la fecha del viaje (YYYY-MM-DD):");
        String fechaElegida = br.readLine();

        // 7) preico
        int precioTotal = viajeElegido.getCostoViaje();
        System.out.println("Precio total del viaje: " + precioTotal);

        // 8) compramos
        if (personaCompradora.comprarPasaje(viajeElegido, busDelViaje, asientoElegido, fechaElegida) == true) {
            System.out.println("Compra realizada con éxito.");
        } else {
            System.out.println("No se pudo realizar la compra.");
        }
    }
}
