import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lector {

    public Map<String, Bus> cargarBusesDesdeTxt(String rutaArchivo) {
        // Inicializa el mapa que contendrá todos los buses
        Map<String, Bus> mapaBuses = new HashMap<>();
        
        // Convierte la String de la ruta a un objeto Path para usar Java NIO, para obtener ruta del archivo
        Path archivoPath = Paths.get(rutaArchivo); 
        
        try {
            // Lee todas las líneas del archivo de una vez (ideal para archivos pequeños/medianos)
            List<String> lineas = Files.readAllLines(archivoPath);
            
            // Itera sobre cada línea leída del archivo
            for (String linea : lineas) {
                // Usamos la clase Scanner para parsear los datos de cada línea
                // El delimitador de los datos es la coma (",")
                try (Scanner scanner = new Scanner(linea).useDelimiter(",")) {
                    int capacidad = scanner.nextInt();
                    String patente = scanner.next().trim(); // Usamos .trim() por si hay espacios
                    int disponibilidad = scanner.nextInt();
                    int tipo = scanner.nextInt();
                    
                    ArrayList<Integer> asientosUsados = new ArrayList<>();
                    // Mientras haya más enteros disponibles en el resto de la línea,
                    // los agregamos a la lista de asientos usados.
                    while (scanner.hasNextInt()) {
                        asientosUsados.add(scanner.nextInt());
                    }
                    Bus bus = new Bus(capacidad, patente, disponibilidad, tipo, asientosUsados);
                    mapaBuses.put(patente, bus); // La clave del mapa es la patente
                    
                } catch (Exception e) {
                    System.err.println("Error al parsear la línea: '" + linea + "'. Detalles: " + e.getMessage());
                }
            }
            
        } catch (IOException e) {
            // Manejo de errores de archivo (e.g., el archivo no existe o no se puede leer)
            System.err.println("ERROR: No se pudo leer el archivo en la ruta: " + rutaArchivo);
            e.printStackTrace();
        }
        
        return mapaBuses;
    }


/// main prueba 
public static void main(String[] args) {
        Lector lector = new Lector();
        // "buses.txt" debe estar en el directorio raíz del proyecto ***importantisimo 
        Map<String, Bus> miMapaBuses = lector.cargarBusesDesdeTxt("buses.txt"); 
        System.out.println("\n--- Buses cargados exitosamente ---");
        for (Bus bus : miMapaBuses.values()) {
            System.out.println(bus);
        }
    }
}




public Map<Integer, Viaje> cargarViajesDesdeTxt(String rutaArchivo) {
        Map<Integer, Viaje> mapaViajes = new HashMap<>();
        Path archivoPath = Paths.get(rutaArchivo);

        try {
            List<String> lineas = Files.readAllLines(archivoPath);

            for (String linea : lineas) {
                try (Scanner scanner = new Scanner(linea).useDelimiter(",")) {
                    int viajeID = scanner.nextInt();
                    int costoViaje = scanner.nextInt();
                    int costoParaEmpresa = scanner.nextInt();
                    String patente = scanner.next().trim();
                    String origen = scanner.next().trim();
                    String destinoFinal = scanner.next().trim();
                    String horaSalida = scanner.next().trim();
                    String horaLlegada = scanner.next().trim();

                    ArrayList<String> listaPasajeros = new ArrayList<>();
                    while (scanner.hasNext()) {
                        listaPasajeros.add(scanner.next().trim());
                    }

                    Viaje viaje = new Viaje(viajeID, costoViaje, costoParaEmpresa,
                                            patente, origen, destinoFinal,
                                            horaSalida, horaLlegada, listaPasajeros);

                    mapaViajes.put(viajeID, viaje);

                } catch (Exception e) {
                    System.err.println("Error al parsear la línea: '" + linea + "'. Detalles: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("ERROR: No se pudo leer el archivo en la ruta: " + rutaArchivo);
            e.printStackTrace();
        }

        return mapaViajes;
    }

    // Main de prueba
    public static void main(String[] args) {
        Lector lector = new Lector();
        Map<Integer, Viaje> mapaViajes = lector.cargarViajesDesdeTxt("viajes.txt");

        System.out.println("Viajes cargados exitosamente");
        for (Viaje v : mapaViajes.values()) {
            System.out.println(v);
        }
    }
}

 public Map<String, Persona> cargarPersonasDesdeTxt(String rutaArchivo) {
        Map<String, Persona> mapaPersonas = new HashMap<>();
        Path archivoPath = Paths.get(rutaArchivo);

        try {
            List<String> lineas = Files.readAllLines(archivoPath);

            for (String linea : lineas) {
                try (Scanner scanner = new Scanner(linea).useDelimiter(",")) {
                    String nombre = scanner.next().trim();
                    String rut = scanner.next().trim();
                    int saldoDisponible = scanner.nextInt();

                    ArrayList<Pasaje> pasajes = new ArrayList<>();
                    // Cada pasaje ocupa 7 campos: id, horaLlegada, horaSalida, destino, costo, asiento, fecha
                    while (scanner.hasNext()) {
                        int idPasaje = scanner.nextInt();
                        String horaLlegada = scanner.next().trim();
                        String horaSalida = scanner.next().trim();
                        String destinoFinal = scanner.next().trim();
                        int costoPasaje = scanner.nextInt();
                        int asiento = scanner.nextInt();
                        String fecha = scanner.next().trim();

                        Pasaje pasaje = new Pasaje(idPasaje, horaLlegada, horaSalida,
                                                   destinoFinal, costoPasaje, asiento, fecha);
                        pasajes.add(pasaje);
                    }

                    Persona persona = new Persona(nombre, rut, pasajes, saldoDisponible);
                    mapaPersonas.put(rut, persona);

                } catch (Exception e) {
                    System.err.println("Error al parsear la línea: '" + linea + "'. Detalles: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("ERROR: No se pudo leer el archivo en la ruta: " + rutaArchivo);
            e.printStackTrace();
        }

        return mapaPersonas;
    }

    // Main de prueba
    public static void main(String[] args) {
        Lector lector = new Lector();
        Map<String, Persona> mapaPersonas = lector.cargarPersonasDesdeTxt("personas.txt");

        System.out.println("\n--- Personas cargadas exitosamente ---");
        for (Persona p : mapaPersonas.values()) {
            System.out.println(p);
        }
    }
}
