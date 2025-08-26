public static void agregarPasaje(Persona persona, Viaje viaje) {
	if(persona.getSaldo() >= viaje.getCostoViaje()) {    
		Pasaje pasaje = anadirPasaje(viaje.getViajeID, viaje.getAsiento, viaje.getFecha);
		persona.setSaldo(persona.getSaldo() - viaje.getCostoViaje());
		System.out.println("Pasaje agregado correctamente.");        
		} else {
		System.out.println("No tienes saldo suficiente para comprar este pasaje.");
	}
}
