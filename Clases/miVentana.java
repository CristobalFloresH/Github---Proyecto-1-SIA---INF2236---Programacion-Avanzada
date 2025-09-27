package Package;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionEvent;

public class miVentana extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private empresa miEmpresa;
    private JPanel panelMenu;
    private JPanel panelRegistrar;
    private JPanel panelMostrar;
    private CardLayout cardLayout;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	//Aqui se ejecuta la clase main para iniciar la empresa con los datos ya cargados

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public miVentana(empresa e) {
        this.miEmpresa = e;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        cardLayout = new CardLayout();
        contentPane = new JPanel();
        contentPane.setLayout(cardLayout);
        setContentPane(contentPane);

        // Panel Principal
        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBackground(Color.WHITE);

        JButton btnRegistro = new JButton("1. Registrarse");
        btnRegistro.setBackground(new Color(240, 240, 240));
        btnRegistro.setBounds(49, 266, 177, 23);
        panelMenu.add(btnRegistro);

        JButton btnComprar = new JButton("2. Comprar pasajes");
        btnComprar.setBackground(new Color(240, 240, 240));
        btnComprar.setBounds(49, 300, 177, 23);
        panelMenu.add(btnComprar);

        JButton btnCancelar = new JButton("3. Cancelar pasaje");
        btnCancelar.setBackground(new Color(240, 240, 240));
        btnCancelar.setBounds(49, 334, 177, 23);
        panelMenu.add(btnCancelar);

        JButton btnMostrarPasajes = new JButton("4. Mostrar pasajes");
        btnMostrarPasajes.setBackground(new Color(240, 240, 240));
        btnMostrarPasajes.setBounds(49, 366, 177, 23);
        panelMenu.add(btnMostrarPasajes);
        
        JButton btnModificarPasajes = new JButton("5. Modificar pasaje");
        btnModificarPasajes.setBackground(new Color(240, 240, 240));
        btnModificarPasajes.setBounds(49, 401, 177, 23);
        panelMenu.add(btnModificarPasajes);

        JButton btnAdministracion = new JButton("6. Administracion");
        btnAdministracion.setBackground(new Color(240, 240, 240));
        btnAdministracion.setBounds(49, 435, 177, 23);
        panelMenu.add(btnAdministracion);
        
        JButton btnMostrarUsuarios = new JButton("7. Mostrar usuarios");
        btnMostrarUsuarios.setBackground(new Color(240, 240, 240));
        btnMostrarUsuarios.setBounds(49, 469, 177, 23);
        panelMenu.add(btnMostrarUsuarios);

        JButton btnSalir = new JButton("0. Salir");
        btnSalir.setBackground(new Color(240, 240, 240));
        btnSalir.setBounds(49, 503, 89, 23);
        panelMenu.add(btnSalir);

        JLabel lblBienvenido = new JLabel("Bienvenido a +Turbus!");
        lblBienvenido.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 54));
        lblBienvenido.setBounds(64, 24, 700, 105);
        panelMenu.add(lblBienvenido);
        contentPane.add(panelMenu, "menu");
       
             

        // Panel de Registro
        panelRegistrar = new JPanel();
        panelRegistrar.setLayout(null);
        panelRegistrar.setBackground(Color.WHITE);

        JLabel lblRut = new JLabel("RUT:");
        lblRut.setBounds(50, 50, 100, 25);
        panelRegistrar.add(lblRut);

        JTextField txtRut = new JTextField();
        txtRut.setBounds(150, 50, 150, 25);
        panelRegistrar.add(txtRut);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 100, 100, 25);
        panelRegistrar.add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(150, 100, 150, 25);
        panelRegistrar.add(txtNombre);

        JLabel lblSaldo = new JLabel("Saldo:");
        lblSaldo.setBounds(50, 150, 100, 25);
        panelRegistrar.add(lblSaldo);

        JTextField txtSaldo = new JTextField();
        txtSaldo.setBounds(150, 150, 150, 25);
        panelRegistrar.add(txtSaldo);

        JButton btnGuardar = new JButton("Registrar");
        btnGuardar.setBounds(150, 200, 120, 25);
        panelRegistrar.add(btnGuardar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(50, 200, 80, 25);
        panelRegistrar.add(btnVolver);

        contentPane.add(panelRegistrar, "registrar");

        // Acciones botones menú y registro
        btnRegistro.addActionListener(e1 -> cardLayout.show(contentPane, "registrar"));
        btnVolver.addActionListener(e2 -> cardLayout.show(contentPane, "menu"));
        btnSalir.addActionListener(e3 -> System.exit(0));

        btnGuardar.addActionListener(e4 -> {
            try {
                String rut = txtRut.getText();
                String nombre = txtNombre.getText();
                String saldoStr = txtSaldo.getText();

                // Validaciones con excepciones personalizadas
                if (nombre == null || nombre.trim().isEmpty() == true || nombre.matches("[a-zA-Z ]+") == false) {
                    throw new nombreInvalidoException("El nombre solo puede contener letras y espacios.");
                }
                if (rut == null || rut.trim().isEmpty() == true || rut.matches("\\d{7,8}-[\\dkK]") == false) {
                    throw new rutInvalidoException("El RUT debe tener formato 12345678-9.");
                }

                int saldo = Integer.parseInt(saldoStr); // si falla, cae en NumberFormatException

                persona p = new persona(nombre.trim(), rut.trim(), saldo);
                miEmpresa.registrarPersona(p);

                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente!");
                txtRut.setText("");
                txtNombre.setText("");
                txtSaldo.setText("");
                cardLayout.show(contentPane, "menu");

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "El saldo debe ser un nÃºmero entero (sin puntos).");
            } catch (nombreInvalidoException nie) {
                JOptionPane.showMessageDialog(null, nie.getMessage());
            } catch (rutInvalidoException rie) {
                JOptionPane.showMessageDialog(null, rie.getMessage());
            } catch (Exception ex) { 
                // cualquier otro error no contemplado
                JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage());
            }
        });

        // Panel de Mostrar Pasajes
        panelMostrar = new JPanel();
        panelMostrar.setLayout(new BorderLayout());
        panelMostrar.setBackground(new Color(192, 192, 192));

        // Panel interno para listar pasajes
        JPanel listaPasajesPanel = new JPanel();
        listaPasajesPanel.setLayout(new BoxLayout(listaPasajesPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(listaPasajesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panelMostrar.add(scrollPane, BorderLayout.CENTER);

        JButton btnVolverMostrar = new JButton("Volver");
        panelMostrar.add(btnVolverMostrar, BorderLayout.SOUTH);
        btnVolverMostrar.addActionListener(e1 -> cardLayout.show(contentPane, "menu"));

        contentPane.add(panelMostrar, "MostrarPasajes");

        // Acción del botón mostrar pasajes
        btnMostrarPasajes.addActionListener(e2 -> {
        	try {
        		//Excepcion error al mostrar 
                listaPasajesPanel.removeAll();
                String rut = JOptionPane.showInputDialog("Ingrese el RUT de la persona:");
                persona p = miEmpresa.obtenerPersonaPorRut(rut);

                if (p == null) {
                    JOptionPane.showMessageDialog(null, "No existe persona con ese RUT.");
                } else if (p.getPasajes().isEmpty()) {
                    listaPasajesPanel.add(new JLabel("No tiene pasajes."));
                } else {
                    for (pasaje pasajeActual : p.getPasajes()) {
                        JLabel label = new JLabel(
                            "ID: " + pasajeActual.getIdPasaje() +
                            " | Destino: " + pasajeActual.getDestinoFinal() +
                            " | Salida: " + pasajeActual.getHoraSalida() +
                            " | Llegada: " + pasajeActual.getHoraLlegada() +
                            " | Asiento: " + pasajeActual.getAsiento() +
                            " | Fecha: " + pasajeActual.getFecha() +
                            " | Costo: " + pasajeActual.getCostoPasaje()
                        );
                        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                        listaPasajesPanel.add(label);
                    }
                }

                listaPasajesPanel.revalidate();
                listaPasajesPanel.repaint();
                cardLayout.show(contentPane, "MostrarPasajes");
        	} catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al mostrar pasajes: " + ex.getMessage());
            }
        });
        
        
        //Panel de Mostrar Usuarios
        JPanel panelUsuarios = new JPanel();
        panelUsuarios.setLayout(new BorderLayout());
        panelUsuarios.setBackground(new Color(200, 200, 255)); 

        // Panel interno para listar usuarios
        JPanel listaUsuariosPanel = new JPanel();
        listaUsuariosPanel.setLayout(new BoxLayout(listaUsuariosPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollUsuarios = new JScrollPane(listaUsuariosPanel);
        scrollUsuarios.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panelUsuarios.add(scrollUsuarios, BorderLayout.CENTER);

        JButton btnVolverUsuarios = new JButton("Volver");
        panelUsuarios.add(btnVolverUsuarios, BorderLayout.SOUTH);
        btnVolverUsuarios.addActionListener(e1 -> cardLayout.show(contentPane, "menu"));

        contentPane.add(panelUsuarios, "MostrarUsuarios");

        // Acción del botón mostrar usuarios
        btnMostrarUsuarios.addActionListener(e2 -> {
        	try {
        		//Excepcion de error al mostrar usuario
                listaUsuariosPanel.removeAll();

                if (miEmpresa.getPersonasPorRut().isEmpty()) {
                    listaUsuariosPanel.add(new JLabel("No hay personas registradas."));
                } else {
                    for (persona p : miEmpresa.getPersonasPorRut().values()) {
                        JLabel label = new JLabel(
                            "Nombre: " + p.getNombre() +
                            " | RUT: " + p.getRut() +
                            " | Saldo: " + p.getSaldoDisponible()
                        );
                        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                        listaUsuariosPanel.add(label);
                    }
                }

                listaUsuariosPanel.revalidate();
                listaUsuariosPanel.repaint();
                cardLayout.show(contentPane, "MostrarUsuarios");
        	} catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al mostrar usuarios: " + ex.getMessage());
            }
        });

        // Panel de Comprar Pasajes
        JPanel panelCompra = new JPanel();
        panelCompra.setLayout(new BorderLayout());
        panelCompra.setBackground(new Color(220, 220, 180));

        JPanel listaCompraPanel = new JPanel();
        listaCompraPanel.setLayout(new BoxLayout(listaCompraPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollCompra = new JScrollPane(listaCompraPanel);
        scrollCompra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panelCompra.add(scrollCompra, BorderLayout.CENTER);

        JButton btnVolverCompra = new JButton("Volver");
        panelCompra.add(btnVolverCompra, BorderLayout.SOUTH);
        btnVolverCompra.addActionListener(e1 -> cardLayout.show(contentPane, "menu"));

        contentPane.add(panelCompra, "ComprarPasajes");

        // Acción del botón comprar pasajes
        btnComprar.addActionListener(e2 -> {
        	//Excepcion de error en el asiento
        	try {
                listaCompraPanel.removeAll();

                String rutIngresado = JOptionPane.showInputDialog("Ingrese su RUT:");
                persona personaCompradora = miEmpresa.obtenerPersonaPorRut(rutIngresado);

                if (personaCompradora == null) {
                    JOptionPane.showMessageDialog(null, "No existe persona con ese RUT. Regístrese primero.");
                    return;
                }
                ArrayList<String> destinosUnicos = miEmpresa.obtenerDestinosUnicos();
                
                if (destinosUnicos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay viajes disponibles.");
                    return;
                }

                // Selección de destino
                String[] opcionesDestinos = destinosUnicos.toArray(new String[0]);
                String destinoElegido = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el destino:",
                    "Destino",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcionesDestinos,
                    opcionesDestinos[0]
                );

                if (destinoElegido == null) return; 
                
                ArrayList<viaje> viajesDelDestino = miEmpresa.obtenerViajesPorDestino(destinoElegido);

                if (viajesDelDestino.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay viajes para ese destino.");
                    return;
                }

                // Selección de viaje por horario
                String[] opcionesViajes = new String[viajesDelDestino.size()];
                for (int i = 0; i < viajesDelDestino.size(); i++) {
                    viaje v = viajesDelDestino.get(i);
                    opcionesViajes[i] = "Salida: " + v.getHoraSalida() +
                                        " | Llegada: " + v.getHoraLlegada() +
                                        " | Costo: " + v.getCostoViaje() +
                                        " | Patente: " + v.getPatente();
                }

                String viajeElegidoStr = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el viaje según su horario:",
                    "Viajes",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcionesViajes,
                    opcionesViajes[0]
                );

                if (viajeElegidoStr == null) return; 

                viaje viajeElegido = viajesDelDestino.get(0);
                for (viaje v : viajesDelDestino) {
                    String desc = "Salida: " + v.getHoraSalida() +
                                  " | Llegada: " + v.getHoraLlegada() +
                                  " | Costo: " + v.getCostoViaje() +
                                  " | Patente: " + v.getPatente();
                    if (desc.equals(viajeElegidoStr)) {
                        viajeElegido = v;
                        break;
                    }
                }

                bus busDelViaje = miEmpresa.obtenerBusPorPatente(viajeElegido.getPatente());

                // Mostrar asientos disponibles
                ArrayList<Integer> asientosDisponibles = new ArrayList<>();
                for (int asiento = 1; asiento <= busDelViaje.getCapacidad(); asiento++) {
                    if (!busDelViaje.asientoOcupado(asiento)) {
                        asientosDisponibles.add(asiento);
                    }
                }

                if (asientosDisponibles.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No quedan asientos disponibles en este bus.");
                    return;
                }

                String[] opcionesAsientos = asientosDisponibles.stream()
                        .map(String::valueOf)
                        .toArray(String[]::new);

                String asientoElegidoStr = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione un asiento:",
                    "Asientos",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcionesAsientos,
                    opcionesAsientos[0]
                );

                if (asientoElegidoStr == null) return; 
                int asientoElegido = Integer.parseInt(asientoElegidoStr);

                // Ingresar fecha
                String fechaElegida = JOptionPane.showInputDialog("Ingrese la fecha del viaje (YYYY-MM-DD):");
                if (fechaElegida == null || fechaElegida.isEmpty()) return;

                // Comprar pasaje
                boolean exito = personaCompradora.comprarPasaje(viajeElegido, busDelViaje, asientoElegido, fechaElegida);
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la compra.");
                }

                cardLayout.show(contentPane, "menu");
        	} catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Asiento inválido. Intente nuevamente.");
                return;
            }
        });
        
        btnModificarPasajes.addActionListener(e1 -> {
            try {

                String rut = JOptionPane.showInputDialog(null, "RUT del cliente:");
                if (rut == null || rut.isBlank()) return;
                
                persona cliente = miEmpresa.obtenerPersonaPorRut(rut);
                if (cliente == null) {
                    JOptionPane.showMessageDialog(null, "No existe persona con ese RUT.");
                    return;
                }

                String idStr = JOptionPane.showInputDialog(null, "ID del pasaje (ID del viaje):");
                if (idStr == null || idStr.isBlank()) return;
                int idPasaje;
                try {
                    idPasaje = Integer.parseInt(idStr);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "ID inválido.");
                    return;
                }
                boolean tieneEsePasaje = false;
                for (pasaje pa : cliente.getPasajes()) {
                    if (pa.getIdPasaje() == idPasaje) {
                        tieneEsePasaje = true;
                        break;
                    }
                }
                if (!tieneEsePasaje) {
                    JOptionPane.showMessageDialog(null, "El cliente no tiene un pasaje con ID " + idPasaje + ".");
                    return;
                }

                String asientoStr = JOptionPane.showInputDialog(null, "Nuevo asiento (vacío para mantener):");
                Integer nuevoAsiento = null;
                if (asientoStr != null && !asientoStr.isBlank()) {
                    try {
                        nuevoAsiento = Integer.valueOf(asientoStr);
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Asiento inválido.");
                        return;
                    }
                }
                String nuevaFecha = JOptionPane.showInputDialog(null, "Nueva fecha (YYYY-MM-DD, vacío para mantener):");
                if (nuevaFecha != null && nuevaFecha.isBlank()) {
                    nuevaFecha = null;
                }

                miEmpresa.modificarPasaje(rut, idPasaje, nuevoAsiento, nuevaFecha);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al modificar: " + ex.getMessage());
            }
        });
        
        btnCancelar.addActionListener(e1 -> {
            String id = JOptionPane.showInputDialog("Ingrese el ID del viaje a cancelar:");
            if (id == null || id.isBlank()) return; 

            try {
                int idViaje = Integer.parseInt(id);
                boolean ok = miEmpresa.cancelarViaje(idViaje);

                if (ok) {
                    JOptionPane.showMessageDialog(null, "Viaje " + idViaje + " cancelado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo cancelar el viaje con ID " + idViaje + ".");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID inválido, debe ser un número.");
            }
        });

    }
}
