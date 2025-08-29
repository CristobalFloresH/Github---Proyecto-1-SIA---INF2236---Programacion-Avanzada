import java.io.BufferedReader;
import java.io.IOException;


public class registrarPersonas {
	public static persona registrarNuevoPersonas(String rut, BufferedReader br) {
		System.out.println("Ingrese el nombre de la persona a registrar: ");
		String nombre = br.readLine();
		
		System.out.println("Ingrese el saldo disponible: ");
		int saldo = Integer.parseInt(br.readLine());
		
		persona nuevaPersona = new persona(nombre, rut, saldo);
		System.out.println("Cliente agregada correctamente");
		return nuevaPersona;
	}

}
