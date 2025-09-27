package Package;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.SwingUtilities;
import javax.swing.JFileChooser;

public class Main {

    private static final String FILE_NAME = "data.txt";

    public static void main(String[] args) {
        try {
            empresa emp = new empresa();

            // 1) Rutas candidatas (portables y en orden de preferencia)
            Path[] RUTAS = new Path[] {
                Paths.get(System.getProperty("user.home"), "OneDrive", "Escritorio", FILE_NAME), 
                Paths.get(System.getProperty("user.home"), "Desktop", FILE_NAME),                
                Paths.get(System.getProperty("user.home"), "Escritorio", FILE_NAME),            
                Paths.get("data", FILE_NAME)                                                    
            };

            // 2) Elegir origen de lectura (el primero que exista)
            Path origen = null;
            for (Path p : RUTAS) if (Files.exists(p)) { origen = p; break; }

            // 3) Elegir destino de escritura (el primero de la lista, creando carpeta si hace falta)
            Path destino = RUTAS[0];
            if (destino.getParent() != null) Files.createDirectories(destino.getParent());
            
         // 3.5) Permitir elegir ruta y USARLA SIEMPRE (ignorando rutas default)
            Path sugerido = (origen != null) ? origen : destino;
            Path elegido = seleccionarRutaConChooser(sugerido);
            if (elegido != null) {
                if (elegido.getParent() != null) Files.createDirectories(elegido.getParent());

                // Forzamos que NO se use una ruta default previa:
                origen = null; // <- clave: anulamos cualquier origen anterior

                // Si el archivo elegido ya existe, lo usamos para leer;
                // si no existe, no cargamos (bootstrap) y luego guardaremos ahí mismo.
                if (Files.exists(elegido)) {
                    origen = elegido;
                }

                // SIEMPRE escribiremos en el archivo elegido
                destino = elegido;
            }

            // 4) Cargar o bootstrap
            if (origen != null) {
                System.out.println("Cargando desde: " + origen.toAbsolutePath());
                cargarTodoDesdeArchivoUnico(emp, origen.toString());
                destino = origen; // guardamos donde leímos
            } else {
                System.out.println("No existe data.txt; creando en: " + destino.toAbsolutePath());
                bootstrapChico(emp);
                guardarTodoEnArchivoUnico(emp, destino.toString());
            }

            // 5) Guardar SIEMPRE al salir
            final Path savePath = destino;
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try { guardarTodoEnArchivoUnico(emp, savePath.toString());
                } catch (Exception ignored) {
                	
                }
            }));


            SwingUtilities.invokeLater(() -> {
                miVentana frame = new miVentana(emp);
                frame.setVisible(true);
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* ==================== BOOTSTRAP MIN ==================== */
    private static void bootstrapChico(empresa emp) {
        persona p1 = new persona("Cristobal Silva", "12345678-9", 25000);
        persona p2 = new persona("Diego Cortez", "21928894-9", 30000);
        persona p3 = new persona("Mauri Torres", "11122233-4", 2000);

        bus b1 = new bus(30, "HP*DS*20", 1, 1);
        bus b2 = new bus(45, "JK*TH*53", 2, 3);
        bus b3 = new bus(20, "LM*TG*90", 3, 2);

        viaje v1 = new viaje(101, 10000, 120000, b1.getPatente(), "El Quisco", "Santiago", "10:30", "13:00");
        viaje v2 = new viaje(102, 20000, 250000, b2.getPatente(), "Santiago", "Quilpue", "08:30", "12:00");
        viaje v3 = new viaje(103,  5000,  80000,  b3.getPatente(), "El Tabo", "San Antonio", "07:30", "08:00");

        emp.registrarPersona(p1); emp.registrarPersona(p2); emp.registrarPersona(p3);
        emp.registrarBus(b1); emp.registrarBus(b2); emp.registrarBus(b3);
        emp.registrarViaje(v1); emp.registrarViaje(v2); emp.registrarViaje(v3);

        p1.comprarPasaje(v1, b1, 12, "2025-08-30");
        p2.comprarPasaje(v2, b2,  1, "2025-09-05");
        p3.comprarPasaje(v3, b3, 19, "2025-07-12");
    }

    /* ==================== CARGA ==================== */
    private static boolean cargarTodoDesdeArchivoUnico(empresa emp, String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            String seccion = "";
            for (String raw : lines) {
                String line = raw.trim();
                if (line.isEmpty() || line.startsWith("//")) {
                    String lower = line.toLowerCase();
                    if (lower.startsWith("// personas")) seccion = "personas";
                    else if (lower.startsWith("// buses")) seccion = "buses";
                    else if (lower.startsWith("// viajes")) seccion = "viajes";
                    else if (lower.startsWith("// pasajes")) seccion = "pasajes";
                    continue;
                }
                switch (seccion) {
                    case "personas": parsePersona(emp, line); break;
                    case "buses":    parseBus(emp, line); break;
                    case "viajes":   parseViaje(emp, line); break;
                    case "pasajes":  parsePasaje(emp, line); break;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error cargando " + path + ": " + e.getMessage());
            return false;
        }
    }

    private static void parsePersona(empresa emp, String line) {
        List<String> p = splitCampos(line);
        emp.registrarPersona(new persona(descomillar(p.get(0).trim()), p.get(1).trim(),
                Integer.parseInt(p.get(2).trim().replace(".", "").replace(",", ""))));
    }

    private static void parseBus(empresa emp, String line) {
        List<String> p = splitCampos(line);
        bus b = new bus(Integer.parseInt(p.get(1).trim()), p.get(0).trim(), 1, Integer.parseInt(p.get(2).trim()));
        if (p.size() >= 4 && !p.get(3).trim().isEmpty())
            for (String s : p.get(3).split("\\|")) { String t = s.trim(); if (!t.isEmpty()) b.ocuparAsiento(Integer.parseInt(t)); }
        emp.registrarBus(b);
    }

    private static void parseViaje(empresa emp, String line) {
        List<String> p = splitCampos(line);
        emp.registrarViaje(new viaje(
            Integer.parseInt(p.get(0).trim()), Integer.parseInt(p.get(1).trim()), Integer.parseInt(p.get(2).trim()),
            p.get(3).trim(), p.get(4).trim(), p.get(5).trim(), p.get(6).trim(), p.get(7).trim()
        ));
    }

    private static void parsePasaje(empresa emp, String line) {
        List<String> p = splitCampos(line);
        String rut = p.get(0).trim();
        int idViaje = Integer.parseInt(p.get(1).trim());
        int asiento = Integer.parseInt(p.get(2).trim());
        String fecha = p.size() >= 4 ? p.get(3).trim() : null;

        persona per = emp.obtenerPersonaPorRut(rut);
        viaje v = emp.obtenerViajePorId(idViaje);
        if (per == null || v == null) return;
        bus b = emp.obtenerBusPorPatente(v.getPatente());
        if (b == null) return;

        per.getPasajes().add(new pasaje(v.getViajeID(), v.getHoraLlegada(), v.getHoraSalida(),
                v.getDestinoFinal(), v.getCostoViaje(), asiento, (fecha == null || fecha.isBlank())
                ? java.time.LocalDate.now().toString() : fecha));
        if (!b.asientoOcupado(asiento)) b.ocuparAsiento(asiento);
        v.agregarPasajero(rut);
    }

    /* ==================== GUARDADO ==================== */
    private static void guardarTodoEnArchivoUnico(empresa emp, String path) throws IOException {
        List<String> out = new ArrayList<>();
        out.add("// personas");
        for (persona p : emp.getPersonasPorRut().values()) out.add(formatearPersona(p));
        out.add(""); out.add("// buses");
        for (bus b : recolectarBuses(emp)) out.add(formatearBus(b));
        out.add(""); out.add("// viajes");
        for (viaje v : recolectarViajes(emp)) out.add(formatearViaje(v));
        out.add(""); out.add("// pasajes");
        for (persona p : emp.getPersonasPorRut().values())
            for (pasaje pa : p.getPasajes()) out.add(formatearPasaje(p.getRut(), pa));
        out.add("");

        Path target = Paths.get(path);
        if (target.getParent() != null) Files.createDirectories(target.getParent());
        Files.write(target, out);
        System.out.println("Guardado en: " + target.toAbsolutePath());
    }

    private static List<bus> recolectarBuses(empresa emp) {
        Map<String, bus> mapa = new LinkedHashMap<>();
        for (viaje v : recolectarViajes(emp)) {
            bus b = emp.obtenerBusPorPatente(v.getPatente());
            if (b != null) mapa.putIfAbsent(b.getPatente(), b);
        }
        return new ArrayList<>(mapa.values());
    }

    private static List<viaje> recolectarViajes(empresa emp) {
        Set<Integer> vistos = new HashSet<>();
        List<viaje> lista = new ArrayList<>();
        for (String d : emp.obtenerDestinosUnicos())
            for (viaje v : emp.obtenerViajesPorDestino(d))
                if (vistos.add(v.getViajeID())) lista.add(v);
        return lista;
    }

    /* ==================== TXT utils mini ==================== */
    private static List<String> splitCampos(String line) {
        List<String> out = new ArrayList<>(); StringBuilder cur = new StringBuilder(); boolean q = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') { q = !q; cur.append(c); }
            else if (c == ',' && !q) { out.add(cur.toString().trim()); cur.setLength(0); }
            else cur.append(c);
        }
        if (cur.length() > 0) out.add(cur.toString().trim());
        return out;
    }
    private static String descomillar(String s) {
        String t = s.trim(); return t.length() >= 2 && t.startsWith("\"") && t.endsWith("\"") ? t.substring(1, t.length()-1) : t;
    }
    private static String formatearPersona(persona p) {
        String n = p.getNombre(); String q = n.contains(" ") ? "\"" + n + "\"" : n;
        return q + ", " + p.getRut() + ", " + p.getSaldoDisponible();
    }
    private static String formatearBus(bus b) {
        String as = b.getAsientosUsados().isEmpty() ? "" : join(b.getAsientosUsados(), "|");
        return b.getPatente() + ", " + b.getCapacidad() + ", " + b.getTipo() + ", " + as;
    }
    private static String formatearViaje(viaje v) {
        return v.getViajeID() + ", " + v.getCostoViaje() + ", " + v.getCostoParaEmpresa() + ", " +
               v.getPatente() + ", " + v.getOrigen() + ", " + v.getDestinoFinal() + ", " +
               v.getHoraSalida() + ", " + v.getHoraLlegada();
    }
    private static String formatearPasaje(String rut, pasaje pa) {
        return rut + ", " + pa.getIdPasaje() + ", " + pa.getAsiento() + ", " + (pa.getFecha() == null ? "" : pa.getFecha());
    }
    private static String join(List<Integer> nums, String sep) {
        StringBuilder sb = new StringBuilder(); for (int i = 0; i < nums.size(); i++) { if (i>0) sb.append(sep); sb.append(nums.get(i)); }
        return sb.toString();
    }
    
    private static Path seleccionarRutaConChooser(Path sugerido) {
        final Path[] resultado = new Path[1];
        Runnable r = () -> {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Selecciona dónde guardar/leer " + FILE_NAME);

            if (sugerido != null) {
                if (sugerido.getParent() != null) {
                    fc.setCurrentDirectory(sugerido.getParent().toFile());
                }
                fc.setSelectedFile(sugerido.toFile());
            } else {
                fc.setSelectedFile(new java.io.File(FILE_NAME));
            }

            int op = fc.showSaveDialog(null); // usa Save para permitir escribir si no existe
            if (op == JFileChooser.APPROVE_OPTION) {
                resultado[0] = fc.getSelectedFile().toPath();
            }
        };

        try {
            if (SwingUtilities.isEventDispatchThread()) r.run();
            else javax.swing.SwingUtilities.invokeAndWait(r);
        } catch (Exception ignore) { }

        return resultado[0];
    }
}
