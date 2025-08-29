import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class menuPasaje {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Ingrese su rut: ");
		String rut = br.readLine();
		
		Persona buscada = new Persona(rut, "X", 0);
		if(!pasajeros.contains(buscada)) {
			System.out.println("Antes de escoger alguna opcion, porfavor registrese a continuacion");
			System.out.println("");
		}	
		
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
		System.out.println("5.Salir");
		int menuAbrir = Integer.parseInt(br.readLine());
		
		switch(menuAbrir){
		case 1:
			registrarCliente(rut);
			break;		
		case 2:
			comprarPasajes(rut);
			break;
			
		case 3:
			System.out.println("Por ahora no tenemos esta funcion disponible, intenta mas tarde");
			break;
			
		case 4:
			mostrarPasajes(rut);
			break;
			
		case 5:
			break;
		}
	}
}
