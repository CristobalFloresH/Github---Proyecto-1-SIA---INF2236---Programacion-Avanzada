public class menuCompra {	
	System.out.println("Ingrese el destino: ");
	//mostrarDestinos();
	int destino = Integer.parseInt(br.readLine());
	
	System.out.println("Ingrese hora de salida: ");
	mostrarHorasSalida();
	int horaSalida = Integer.parseInt(br.readLine());
	
	System.out.println("Ingrese hora de llegada: ");
	mostrarHorasLlegada();
	int horaLlegada = Integer.parseInt(br.readLine());
	
	int precioTotal = calcularPrecioTotal();
	System.out.println("Precio total del viaje : " + precioTotal + "");
}
