package Package;

import java.util.*;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.swing.*;

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
    	float cantidadPasajeros = viajeRecibido.getCantidadPasajeros();
    	
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
    
    public JScrollPane construirScrollBusesYViajesGananciaMayor(float umbral) {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        panelPrincipal.add(new JLabel("Buses con ganancia mayor a " + umbral + ":"));

        boolean alguno = false;

        for (viaje viajeActual : viajesPorId.values()) {
            float ganancia = this.obtenerGananciaViaje(viajeActual);
            ganancia *= -1; 
            
            if (ganancia > umbral || umbral == -120) {
                bus busActual = this.obtenerBusPorPatente(viajeActual.getPatente());
                
                panelPrincipal.add(Box.createVerticalStrut(10));
                panelPrincipal.add(new JLabel("Ganancia: " + ganancia));

                if (busActual != null) {
                    panelPrincipal.add(busActual.infoBusComoPanel());
                } else {
                    panelPrincipal.add(new JLabel("No se encontró el bus con patente " + viajeActual.getPatente()));
                }

                panelPrincipal.add(viajeActual.infoViajeCompletaComoPanel());
                panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10))); // separador visual
                alguno = true;
            }
        }

        if (alguno == false) {
            panelPrincipal.add(new JLabel("No hay viajes con ganancia superior al umbral."));
        }

        JScrollPane scroll = new JScrollPane(panelPrincipal);
        scroll.setPreferredSize(new Dimension(900, 600)); // ventana más ancha
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        return scroll;
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
    
    public boolean existeRut(String rut) {
        if (rut == null) return false;
        return personasPorRut.containsKey(rut.trim());
    }
    
    public boolean registrarPersonaSegura(persona personaNueva) {
        if (personaNueva == null || personaNueva.getRut() == null) {
            JOptionPane.showMessageDialog(null, "Datos inválidos.");
            return false;
        }
        String rut = personaNueva.getRut().trim();
        if (existeRut(rut)) {
            JOptionPane.showMessageDialog(null, "Ya existe una persona con el RUT " + rut + ".");
            return false;
        }
        personasPorRut.put(rut, personaNueva);
        JOptionPane.showMessageDialog(null, "Persona agregada: " + rut);
        return true;
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
	 
	 public boolean modificarPasaje(String rut, int idPasaje, Integer nuevoAsiento, String nuevaFecha) {
		    persona cliente = obtenerPersonaPorRut(rut);
		    if (cliente == null) {
		        JOptionPane.showMessageDialog(null, "No existe persona con ese RUT.");
		        return false;
		    }
		    pasaje pasajeCliente = null;
		    for (pasaje pa : cliente.getPasajes()) {
		        if (pa.getIdPasaje() == idPasaje) {
		            pasajeCliente = pa;
		            break;
		        }
		    }
		    if (pasajeCliente == null) {
		        JOptionPane.showMessageDialog(null, "El cliente no tiene un pasaje con ID " + idPasaje + ".");
		        return false;
		    }
		    viaje v = obtenerViajePorId(pasajeCliente.getIdPasaje());
		    if (v == null) {
		        JOptionPane.showMessageDialog(null, "No existe un viaje con ID " + pasajeCliente.getIdPasaje() + ".");
		        return false;
		    }
		    bus b = obtenerBusPorPatente(v.getPatente());
		    if (b == null) {
		        JOptionPane.showMessageDialog(null, "No se encontró el bus para el viaje.");
		        return false;
		    }
		    if (nuevoAsiento != null) {
		        int asientoActual = pasajeCliente.getAsiento();
		        int asientoNuevo = nuevoAsiento.intValue();

		        if (!b.asientoEnRango(asientoNuevo)) {
		            JOptionPane.showMessageDialog(null, "Asiento fuera de rango.");
		            return false;
		        }
		        if (asientoNuevo != asientoActual) {
		            if (b.asientoOcupado(asientoNuevo)) {
		                JOptionPane.showMessageDialog(null, "El asiento " + asientoNuevo + " ya está ocupado.");
		                return false;
		            }

		            b.liberarAsiento(asientoActual);
		            if (!b.ocuparAsiento(asientoNuevo)) {
		                b.ocuparAsiento(asientoActual);
		                JOptionPane.showMessageDialog(null, "No se pudo ocupar el nuevo asiento.");
		                return false;
		            }
		            pasajeCliente.setAsiento(asientoNuevo);
		        }
		    }
		    if (nuevaFecha != null) {
		        if (nuevaFecha.isBlank()) {
		            pasajeCliente.setFecha(null);
		        } else {
		            pasajeCliente.setFecha(nuevaFecha.trim());
		        }
		    }
		    JOptionPane.showMessageDialog(null, "Pasaje modificado correctamente.");
		    return true;
		}
	 
	 public boolean cancelarViaje(int idViaje) {
		    viaje viajeCancelado = viajesPorId.get(idViaje);
		    if (viajeCancelado == null) {
		        JOptionPane.showMessageDialog(null, "No existe un viaje con ID " + idViaje + ".");
		        return false;
		    }
		    bus busDelViaje = busPorPatente.get(viajeCancelado.getPatente());
		    int pasajesEliminados = 0;
		    int totalReembolsado = 0;

		    for (persona personaActual : personasPorRut.values()) {
		        ArrayList<pasaje> pasajes = personaActual.getPasajes();
		        ArrayList<pasaje> nuevosPasajes = new ArrayList<pasaje>();

		        for (pasaje p : pasajes) {
		            if (p.getIdPasaje() == idViaje) {
		                if (busDelViaje != null) {
		                    busDelViaje.liberarAsiento(p.getAsiento());
		                }
		                int nuevoSaldo = personaActual.getSaldoDisponible() + p.getCostoPasaje();
		                personaActual.setSaldoDisponible(nuevoSaldo);
		                pasajesEliminados = pasajesEliminados + 1;
		                totalReembolsado = totalReembolsado + p.getCostoPasaje();
		            } else {
		                nuevosPasajes.add(p);
		            }
		        }
		        personaActual.setPasajes(nuevosPasajes);
		    }
		    viajesPorId.remove(idViaje);

		    JOptionPane.showMessageDialog(
		        null,
		        "Viaje " + idViaje + " cancelado.\n" +
		        "Pasajes eliminados: " + pasajesEliminados + "\n" +
		        "Total reembolsado: " + totalReembolsado
		    );
		    return true;
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
	 
	 public boolean exportarReporte(String rutaArchivo) {
		    try (java.io.PrintWriter pw = new java.io.PrintWriter(
		            new java.io.OutputStreamWriter(
		                new java.io.FileOutputStream(rutaArchivo), java.nio.charset.StandardCharsets.UTF_8))) {

		        // ===== BUSES =====
		        pw.println("#BUSES");
		        int idxBus = 1;
		        for (bus b : busPorPatente.values()) {
		            String nombreBus = "Bus" + idxBus++;
		            java.util.List<Integer> au = (b.getAsientosUsados() == null) ? java.util.Collections.emptyList() : b.getAsientosUsados();
		            String asientosTxt = (au.isEmpty()) ? "0" : (au.size() + " " + au.toString());

		            pw.println(
		                nombreBus + " — " +
		                "Patente: " + nn(b.getPatente()) + ", " +
		                "Capacidad: " + b.getCapacidad() + ", " +
		                "Disponibilidad: " + b.getDisponibilidad() + ", " +
		                "Tipo: " + b.getTipo() + ", " +
		                "Asientos ocupados: " + asientosTxt
		            );
		        }
		        pw.println();

		        // ===== VIAJES =====
		        pw.println("#VIAJES");
		        for (viaje v : viajesPorId.values()) {
		            pw.println(
		                "Viaje ID " + v.getViajeID() + " — " +
		                "Origen: " + nn(v.getOrigen()) + ", " +
		                "Destino: " + nn(v.getDestinoFinal()) + ", " +
		                "Salida: " + nn(v.getHoraSalida()) + ", " +
		                "Llegada: " + nn(v.getHoraLlegada()) + ", " +
		                "Patente: " + nn(v.getPatente()) + ", " +
		                "Costo viaje: " + v.getCostoViaje() + ", " +
		                "Costo empresa: " + v.getCostoParaEmpresa() + ", " +
		                "Pasajeros: " + v.getCantidadPasajeros()
		            );
		        }
		        pw.println();

		        // ===== PERSONAS =====
		        pw.println("#PERSONAS");
		        int idxPersona = 1;
		        for (persona p : personasPorRut.values()) {
		            String nombre = (p.getNombre() != null && !p.getNombre().isEmpty()) ? p.getNombre() : ("Persona" + idxPersona++);
		            int cant = (p.getPasajes() == null) ? 0 : p.getPasajes().size();
		            pw.println(
		                nombre + " (" + nn(p.getRut()) + ") — " +
		                "Saldo: " + p.getSaldoDisponible() + ", " +
		                "Pasajes: " + cant
		            );
		        }
		        pw.println();

		        // ===== PASAJES =====
		        pw.println("#PASAJES");
		        for (persona p : personasPorRut.values()) {
		            if (p.getPasajes() == null) continue;
		            for (pasaje pa : p.getPasajes()) {
		                pw.println(
		                    "Pasaje " + pa.getIdPasaje() + " — " +
		                    "Dueño: " + nn(p.getRut()) + ", " +
		                    "Destino: " + nn(pa.getDestinoFinal()) + ", " +
		                    "Fecha: " + nn(pa.getFecha()) + ", " +
		                    "Salida: " + nn(pa.getHoraSalida()) + ", " +
		                    "Llegada: " + nn(pa.getHoraLlegada()) + ", " +
		                    "Asiento: " + pa.getAsiento() + ", " +
		                    "Costo: " + pa.getCostoPasaje()
		                );
		            }
		        }

		        pw.flush();
		        return true;
		    } catch (Exception e) {
		        System.out.println("Error al exportar reporte: " + e.getMessage());
		        return false;
		    }
		}

		private String nn(String s) {
		    return (s == null || s.isEmpty()) ? "(sin dato)" : s;
		}
		
		
		//Metodos agregar,modificar,eliminar
		public void agregarBus(bus bus) {
	        if (busPorPatente.containsKey(bus.getPatente())) {
	        	JOptionPane.showMessageDialog(null, "Ya existe un bus con patente " + bus.getPatente());
	        } else {
	        	busPorPatente.put(bus.getPatente(), bus);
	        	JOptionPane.showMessageDialog(null, "Bus con patente:"+ bus.getPatente() +"agregado ");
	        }
	    }

		public boolean eliminarBus(String patente) {
	        bus eliminado = busPorPatente.remove(patente);
	        if (eliminado != null) {
	        	JOptionPane.showMessageDialog(null, "Bus con patente " + patente + " eliminado");
	            return true;
	        } else {
	        	JOptionPane.showMessageDialog(null, "No se encontró un bus con patente " + patente);
	            return false;
	        }
	    }

		public void agregarViaje(viaje viaje) {
	        if (viajesPorId.containsKey(viaje.getViajeID())) {
	        	JOptionPane.showMessageDialog(null, "Ya existe un viaje con id " + viaje.getViajeID());
	        } else {
	        	viajesPorId.put(viaje.getViajeID(), viaje);
	        	JOptionPane.showMessageDialog(null, "Viaje agregado: " + viaje.getViajeID());
	        }
	    }
	   

		public boolean eliminarViaje(int viajeId) {
	        viaje eliminado = viajesPorId.remove(viajeId);
	        if (eliminado != null) {
	        	JOptionPane.showMessageDialog(null, "Viaje eliminado: " + viajeId);
	            return true;
	        } else {
	        	JOptionPane.showMessageDialog(null, "No se encontró un viaje con id " + viajeId);
	            return false;
	        }
	    }
	   
		public void modificarViaje(int id, int nuevoCosto, String nuevaPatente,String nuevoOrigen, String nuevoDestino,String nuevaSalida, String nuevaLlegada) {
	        viaje viaje = viajesPorId.get(id);
	        if (viaje != null) {
	            viaje.setCostoViaje(nuevoCosto);
	            viaje.setPatente(nuevaPatente);
	            viaje.setOrigen(nuevoOrigen);
	            viaje.setDestinoFinal(nuevoDestino);
	            viaje.setHoraSalida(nuevaSalida);
	            viaje.setHoraLlegada(nuevaLlegada);
	            JOptionPane.showMessageDialog(null, "Viaje modificado: " + id);
	        } else {
	        	JOptionPane.showMessageDialog(null, "No se encontró un viaje con ID " + id);
	        }
	    }
		public void agregarPersona(persona persona) {
	        if (personasPorRut.containsKey(persona.getRut())) {
	        	JOptionPane.showMessageDialog(null, "Ya existe una persona con ese RUT.");
	        } else {
	        	personasPorRut.put(persona.getRut(), persona);
	        	JOptionPane.showMessageDialog(null, "Persona agregada: " + persona.getRut());
	        }
	    }

		public boolean eliminarPersona(String rut) {
	        persona eliminada = personasPorRut.remove(rut);
	        if (eliminada != null) {
	        	JOptionPane.showMessageDialog(null, "Persona eliminada: " + rut);
	            return true;
	        } else {
	        	JOptionPane.showMessageDialog(null, "No se encontró persona con ese RUT.");
	            return false;
	        }
	    }
		public void modificarPersona(String rut, String nuevoNombre, int nuevoSaldo) {
			persona  persona = personasPorRut.get(rut);
		        if (persona != null) {
		            persona.setNombre(nuevoNombre);
		            persona.setSaldoDisponible(nuevoSaldo);
		            JOptionPane.showMessageDialog(null, "Persona modificada");
		        } else {
		        	JOptionPane.showMessageDialog(null, "No se encontró persona con ese RUT.");
		    }
		}
		
		public JScrollPane mostrarBusesComoScroll() {
		    JPanel panel = new JPanel();
		    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		    if (busPorPatente.isEmpty()) {
		        panel.add(new JLabel("No hay buses registrados."));
		    } else {
		        for (bus b : busPorPatente.values()) {
		            JLabel label = new JLabel(
		                "Patente: " + b.getPatente() +
		                " | Capacidad: " + b.getCapacidad() +
		                " | Disponibilidad: " + b.getDisponibilidad() +
		                " | Tipo: " + b.getTipo() +
		                " | Asientos ocupados: " + b.getAsientosUsados()
		            );
		            label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		            panel.add(label);
		        }
		    }

		    JScrollPane scroll = new JScrollPane(panel);
		    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		    return scroll;
		}

		
		public JScrollPane mostrarViajesComoScroll() {
		    JPanel panel = new JPanel();
		    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		    if (viajesPorId.isEmpty()) {
		        panel.add(new JLabel("No hay viajes registrados."));
		    } else {
		        for (viaje v : viajesPorId.values()) {
		            JLabel label = new JLabel(
		                "ID: " + v.getViajeID() +
		                " | Origen: " + v.getOrigen() +
		                " | Destino: " + v.getDestinoFinal() +
		                " | Salida: " + v.getHoraSalida() +
		                " | Llegada: " + v.getHoraLlegada() +
		                " | Patente: " + v.getPatente() +
		                " | Costo: " + v.getCostoViaje() +
		                " | Costo Empresa: " + v.getCostoParaEmpresa() +
		                " | Pasajeros: " + v.getCantidadPasajeros()
		            );
		            label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		            panel.add(label);
		        }
		    }

		    JScrollPane scroll = new JScrollPane(panel);
		    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		    return scroll;
		}

}
