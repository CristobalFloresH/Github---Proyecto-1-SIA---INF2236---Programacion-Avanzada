public static void mostrarPasajes(Persona persona){
	    System.out.println("Nombre: " + persona.getNombre());
	    System.out.println("Apellido: " + persona.getApellido());
	    System.out.println("RUT: " + persona.getRut());
	    System.out.println("-----------------------");
	    System.out.println("PASAJES");
	    System.out.println("-----------------------");
	    
	    if(persona.getListaPasajes().isEmpty()) {
	    	System.out.println("Esta persona no tiene pasajes.");
	    } else {
	    	for(int i = 0; i < persona.getListaPasajes().size(); i++) {
	    		Pasaje pasaje = persona.getListaPasajes().get(i);
	            System.out.println("Viaje ID: " + pasaje.getIdPasaje());
	            System.out.println("Hora llegada: " + pasaje.getHoraLlegada());
	            System.out.println("Hora salida: " + pasaje.getHoraSalida());
	            System.out.println("Destino final: " + pasaje.getDestinoFinal());
	            System.out.println("Costo pasaje: " + pasaje.getCostoPasaje());
	            System.out.println("Asiento: " + pasaje.getAsiento());
	            System.out.println("Fecha: " + pasaje.getFecha());
	            System.out.println("-----------------------");  		
	    		}
	    }
}
