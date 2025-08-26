Scanner sc = new Scanner(System.in);
	
System.out.println("Ingrese la accion a realizar (1-2-3-4)");
System.out.println("1. Mostrar todos los pasajes");
System.out.println("2. Agregar pasaje a una persona");
System.out.println("3. Salir");
int opcion = sc.nextInt();

switch(opcion) {
    case 1:
    mostrarPasajes(persona);
	  break;
    case 2:
	  agregarPasaje(persona, pasaje)			
    case 3:
	  System.out.println("Saliendo...");
	  break;			
}
