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
        this.setPersonasPorRut(new HashMap<String, persona>());
    }

    public void registrarBus(bus busNuevo) {
    	busPorPatente.put(busNuevo.getPatente(), busNuevo);
    }

    public void registrarViaje(viaje viajeNuevo) {
        viajesPorId.put(viajeNuevo.getViajeID(), viajeNuevo);
    }
    
    public void registrarPersona(persona personaNueva) {
    	getPersonasPorRut().put(personaNueva.getRut(), personaNueva);
    }

    public bus obtenerBusPorPatente(String patente) {
        return busPorPatente.get(patente);
    }

    public viaje obtenerViajePorId(int id) {
        return viajesPorId.get(id);
    }
    
    public persona obtenerPersonaPorRut(String rut) {
        return getPersonasPorRut().get(rut);
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
        
        if (getPersonasPorRut().containsKey(rutIngresado) == true) {
            System.out.println("Ya existe una persona con ese RUT.");
            return;
        }
        
        System.out.println("Ingrese su nombre: ");
        String nombreIngresado = br.readLine();

    	System.out.println("Ingrese su saldo disponible: (Formato: 10.000");
    	int saldo = Integer.parseInt(br.readLine());
    		
    	persona nuevaPersona = new persona(nombreIngresado, rutIngresado, saldo);
    	System.out.println("Cliente agregado correctamente");
    	this.registrarPersona(nuevaPersona);
    }

    public void mostrarPersonas() {
        if (getPersonasPorRut().isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }

        System.out.println("Personas registradas en la empresa:");
        System.out.println("-----------------------------------");

        for (persona personaActual : getPersonasPorRut().values()) {
            System.out.println(
                "Nombre: " + personaActual.getNombre()
                + " | RUT: " + personaActual.getRut()
                + " | Saldo: " + personaActual.getSaldoDisponible()
            );
        }
    }
    
    public float obtenerGananciaViaje(viaje viajeRecibido) {
    	
    	float costoViajeParaEmpresa = viajeRecibido.getCostoParaEmpresa();
    	float costoPorPasajero = viajeRecibido.getCostoViaje();
    	float cantidadPasajeros = viajeRecibido.getCantidadPsajeros();
    	
    	return (float) (costoViajeParaEmpresa - (costoPorPasajero * cantidadPasajeros));
    }
    
    public void obtenerGananciaTodosViajes() throws IOException {
    	float gananciaTotal = 0;
    	float cantidadViajes = 0;
        for (viaje viajeActual : viajesPorId.values()) {
        	gananciaTotal += this.obtenerGananciaViaje(viajeActual);
        	cantidadViajes++;
        }

       System.out.println("+Turbus en " + cantidadViajes + "a generado una ganancia de " + gananciaTotal);
    }
    
    public void mostrarBusesGananciaMayor(float umbral) throws IOException {
    	
    	System.out.println("Buses con ganancia mayor a " + umbral +":");
    	String patenteActual;
    	bus busActual;
    	
    	for (viaje viajeActual : viajesPorId.values()) {
  
    		if (this.obtenerGananciaViaje(viajeActual) > umbral) {
    			patenteActual = viajeActual.getPatente();
    			busActual = this.obtenerBusPorPatente(patenteActual);
    			busActual.mostrarInformacion();
    		}
    	}
    }
    
    public void mostrarPasajesDePersonaPorRut() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el RUT de la persona: ");
        String rutIngresado = reader.readLine();

        persona personaEncontrada = getPersonasPorRut().get(rutIngresado);

        if (personaEncontrada == null) {
            System.out.println("No existe persona con ese RUT.");
            return;
        }

        personaEncontrada.mostrarPasajes();
    }
    
    public ArrayList<String> obtenerDestinosUnicos() {
        ArrayList<String> destinosUnicos = new ArrayList<String>();

        for (viaje viajeActual : viajesPorId.values()) { //segun google esto es como un "por cada"
        	
            String destino = viajeActual.getDestinoFinal();
            
            if (destinosUnicos.contains(destino) == false) {
                destinosUnicos.add(destino);
            }
        }

        return destinosUnicos;
    }
    
	 public ArrayList<viaje> obtenerViajesPorDestino(String destino) {
	    ArrayList<viaje> viajesDelDestino = new ArrayList<viaje>();

        for (viaje viajeActual : viajesPorId.values()) {
        	
            if (viajeActual.getDestinoFinal().equals(destino) == true) {
            	
                viajesDelDestino.add(viajeActual);
            }
        }

        return viajesDelDestino;
    }
    
	 public Map<String, persona> getPersonasPorRut() {
		return personasPorRut;
	}

	 public void setPersonasPorRut(Map<String, persona> personasPorRut) {
		this.personasPorRut = personasPorRut;
	 }

	 public void menuCompra() throws IOException {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		    // 1) identificar persona
		    System.out.println("Ingrese su RUT: ");
		    String rutIngresado = br.readLine();

		    persona personaCompradora = getPersonasPorRut().get(rutIngresado);
		    if (personaCompradora == null) {
		        System.out.println("No existe persona con ese RUT. Regístrese primero.");
		        return;
		    }

		    // 2) destinos únicos 
		    ArrayList<String> destinosUnicos = obtenerDestinosUnicos();
		    if (destinosUnicos.size() == 0) {
		        System.out.println("No hay viajes disponibles.");
		        return;
		    }

		    System.out.println("Ingrese el destino:");
		    int i = 0;
		    while (i < destinosUnicos.size()) {
		        System.out.println((i + 1) + ". " + destinosUnicos.get(i));
		        i = i + 1;
		    }

		    int opcionDestino = Integer.parseInt(br.readLine());
		    if (opcionDestino < 1 || opcionDestino > destinosUnicos.size()) {
		        System.out.println("Opción de destino inválida.");
		        return;
		    }
		    String destinoElegido = destinosUnicos.get(opcionDestino - 1);

		    // 3) viajes por destino 
		    ArrayList<viaje> viajesDelDestino = obtenerViajesPorDestino(destinoElegido);
		    if (viajesDelDestino.size() == 0) {
		        System.out.println("No hay viajes para ese destino.");
		        return;
		    }

		    System.out.println("Ingrese el viaje según su horario de salida:");
		    int j = 0;
		    while (j < viajesDelDestino.size()) {
		        viaje viajeActual = viajesDelDestino.get(j);
		        System.out.println(
		            (j + 1) + ". " +
		            "Salida: " + viajeActual.getHoraSalida() +
		            " | Llegada: " + viajeActual.getHoraLlegada() +
		            " | Costo: " + viajeActual.getCostoViaje() +
		            " | Patente bus: " + viajeActual.getPatente()
		        );
		        j = j + 1;
		    }

		    int opcionViaje = Integer.parseInt(br.readLine());
		    if (opcionViaje < 1 || opcionViaje > viajesDelDestino.size()) {
		        System.out.println("Opción de viaje inválida.");
		        return;
		    }
		    viaje viajeElegido = viajesDelDestino.get(opcionViaje - 1);

		    // 4) bus y asientos disponibles
		    bus busDelViaje = busPorPatente.get(viajeElegido.getPatente());
		    if (busDelViaje == null) {
		        System.out.println("No se encontró el bus para este viaje.");
		        return;
		    }

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

		    System.out.println("Ingrese el asiento que desea:");
		    int asientoElegido = Integer.parseInt(br.readLine());

		    if (busDelViaje.asientoEnRango(asientoElegido) == false) {
		        System.out.println("Asiento fuera de rango.");
		        return;
		    }
		    if (asientosDisponibles.contains(asientoElegido) == false) {
		        System.out.println("Ese asiento no está disponible.");
		        return;
		    }

		    // 5) fecha y precio
		    System.out.println("Ingrese la fecha del viaje (YYYY-MM-DD):");
		    String fechaElegida = br.readLine();
		    
		    if (fechaElegida != null && fechaElegida.isBlank()) {
		    	fechaElegida = null;
		    }

		    int precioTotal = viajeElegido.getCostoViaje();
		    System.out.println("Precio total del viaje: " + precioTotal);

		    // 6) comprar
		    boolean compraOk = personaCompradora.comprarPasaje(viajeElegido, busDelViaje, asientoElegido, fechaElegida);
		    if (compraOk == true) {
		        System.out.println("Compra realizada con éxito.");
		    } else {
		        System.out.println("No se pudo realizar la compra.");
		    }
		}
}
