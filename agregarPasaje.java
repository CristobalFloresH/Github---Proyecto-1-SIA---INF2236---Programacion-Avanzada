public static void agregarPasaje(Persona persona, Pasaje pasaje) {
	if(persona.getSaldo() >= costoPasaje) {    
		Pasaje pasaje = anadirPasaje(Pasaje pasaje);
		persona.setSaldo(persona.getSaldo() - costoPasaje);
		System.out.println("Pasaje agregado correctamente.");        
		} else {
		System.out.println("No tienes saldo suficiente para comprar este pasaje.");
	}
}
