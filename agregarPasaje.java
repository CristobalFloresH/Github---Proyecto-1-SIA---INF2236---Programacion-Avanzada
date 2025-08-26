public static void agregarPasaje(Persona persona, int idPasaje, String horaLlegada, String horaSalida,
        String destinoFinal, int costoPasaje, int asiento, String fecha) {
	
	if(persona.getSaldo() >= costoPasaje) {    
		Pasaje pasaje = anadirPasaje(idPasaje, horaLlegada, horaSalida, destinoFinal, costoPasaje, asiento, fecha);
	
		int largo = persona.getListaPasajes().length;
		Pasaje[] nuevosPasajes = new Pasaje[largo + 1];
	
		for(int i = 0; i < largo; i++) {
			nuevosPasajes[i] = persona.getListaPasajes()[i];
		}
		nuevosPasajes[largo] = pasaje;
		persona.setListaPasajes(nuevosPasajes);

		persona.setSaldo(persona.getSaldo() - costoPasaje);
	
		System.out.println("Pasaje agregado correctamente.");        
		} else {
		System.out.println("No tienes saldo suficiente para comprar este pasaje.");
	}
}
