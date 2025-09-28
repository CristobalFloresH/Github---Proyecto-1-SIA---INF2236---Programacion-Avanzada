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
        btnRegistro.setBounds(49, 266, 218, 23);
        panelMenu.add(btnRegistro);

        JButton btnComprar = new JButton("2. Comprar pasajes");
        btnComprar.setBackground(new Color(240, 240, 240));
        btnComprar.setBounds(49, 300, 218, 23);
        panelMenu.add(btnComprar);

        JButton btnCancelar = new JButton("3. Cancelar pasaje");
        btnCancelar.setBackground(new Color(240, 240, 240));
        btnCancelar.setBounds(49, 334, 218, 23);
        panelMenu.add(btnCancelar);

        JButton btnMostrarPasajes = new JButton("4. Mostrar pasajes");
        btnMostrarPasajes.setBackground(new Color(240, 240, 240));
        btnMostrarPasajes.setBounds(49, 366, 218, 23);
        panelMenu.add(btnMostrarPasajes);
        
        JButton btnModificarPasajes = new JButton("5. Modificar pasaje");
        btnModificarPasajes.setBackground(new Color(240, 240, 240));
        btnModificarPasajes.setBounds(49, 401, 218, 23);
        panelMenu.add(btnModificarPasajes);

        JButton btnAdministracion = new JButton("7. Administracion de datos");
        btnAdministracion.setBackground(new Color(240, 240, 240));
        btnAdministracion.setBounds(49, 435, 218, 23);
        panelMenu.add(btnAdministracion);

        JButton btnSalir = new JButton("0. Salir");
        btnSalir.setBackground(new Color(240, 240, 240));
        btnSalir.setBounds(49, 469, 89, 23);
        panelMenu.add(btnSalir);

        JLabel lblBienvenido = new JLabel("Bienvenido a +Turbus!");
        lblBienvenido.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 54));
        lblBienvenido.setBounds(64, 24, 700, 105);
        panelMenu.add(lblBienvenido);
        contentPane.add(panelMenu, "menu");
        
      //|| SEGUNDO PANEL, ADMINISTRACION DE DATOS||
      //|| SEGUNDO PANEL, ADMINISTRACION DE DATOS||
      //|| SEGUNDO PANEL, ADMINISTRACION DE DATOS||
        
        JPanel panelAdmin = new JPanel();
        panelAdmin.setLayout(null);
        panelAdmin.setBackground(new Color(255, 255, 255));

        JLabel lblAdmin = new JLabel("Panel de administración de datos");
        lblAdmin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 40));
        lblAdmin.setBounds(22, 11, 718, 101);
        panelAdmin.add(lblAdmin);
        
		JButton btnInformacionBuses = new JButton("1. Mostrar informacion buses");
		btnInformacionBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInformacionBuses.setBackground(new Color(240, 240, 240));
		btnInformacionBuses.setBounds(22, 196, 220, 23);
		panelAdmin.add(btnInformacionBuses);
		
		JButton btnAgregarBuses = new JButton("2. Agregar Buses");
		btnAgregarBuses.setBackground(new Color(240, 240, 240));
		btnAgregarBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregarBuses.setBounds(22, 230, 220, 23);
		panelAdmin.add(btnAgregarBuses);
		
		JButton btnModificarBuses = new JButton("3. Modificar Buses");
		btnModificarBuses.setBackground(new Color(240, 240, 240));
		btnModificarBuses.setBounds(22, 264, 220, 23);
		panelAdmin.add(btnModificarBuses);
		
		
		JButton btnEliminarBuses = new JButton("4. Eliminar Buses");
		btnEliminarBuses.setBackground(new Color(240, 240, 240));
		btnEliminarBuses.setBounds(22, 298, 220, 23);
		panelAdmin.add(btnEliminarBuses);
		
        JButton btnExportarTxt = new JButton("5. Exportar reporte");
        btnExportarTxt.setBackground(new Color(240, 240, 240));
        btnExportarTxt.setBounds(22, 332, 220, 23);
        panelAdmin.add(btnExportarTxt);
		
		JButton btnMostrarInformacionViajes = new JButton("6. Mostrar Informacion Viajes");
		btnMostrarInformacionViajes.setBackground(new Color(240, 240, 240));
		btnMostrarInformacionViajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMostrarInformacionViajes.setBounds(260, 196, 220, 23);
		panelAdmin.add(btnMostrarInformacionViajes);
		
		JButton btnAgregarViajes = new JButton("7. Agregar Viajes");
		btnAgregarViajes.setBackground(new Color(240, 240, 240));
		btnAgregarViajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregarViajes.setBounds(260, 230, 220, 23);
		panelAdmin.add(btnAgregarViajes);
        
		JButton BtnModificarViajes = new JButton("8. Modificar Viajes");
		BtnModificarViajes.setBackground(new Color(240, 240, 240));
		BtnModificarViajes.setBounds(260, 266, 220, 23);
		panelAdmin.add(BtnModificarViajes);
		
		JButton btnEliminarViajes = new JButton("9. Eliminar Viajes");
		btnEliminarViajes.setBackground(new Color(240, 240, 240));
		btnEliminarViajes.setBounds(260, 300, 220, 23);
		panelAdmin.add(btnEliminarViajes);

		
        JButton btnUmbralBusesViajes = new JButton("10. Umbral Ganancias");
        btnUmbralBusesViajes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnUmbralBusesViajes.setBackground(new Color(240, 240, 240));
        btnUmbralBusesViajes.setBounds(260, 334, 220, 23);
        panelAdmin.add(btnUmbralBusesViajes);
	
        JButton btnMostrarUsuarios = new JButton("11. Mostrar usuarios");
        btnMostrarUsuarios.setBackground(new Color(240, 240, 240));
        btnMostrarUsuarios.setBounds(490, 196, 220, 23);
        panelAdmin.add(btnMostrarUsuarios);
        
		JButton btnAgregarUsuarios = new JButton("12. Agregar Usuarios");
		btnAgregarUsuarios.setBackground(new Color(240, 240, 240));
		btnAgregarUsuarios.setBounds(490, 230, 220, 23);
		panelAdmin.add(btnAgregarUsuarios);
		
		JButton btnNewButton = new JButton("13. Modificar Usuarios");
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setBounds(490, 266, 220, 23);
		panelAdmin.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("14. Eliminar Usuarios");
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.setBounds(490, 300, 220, 23);
		panelAdmin.add(btnNewButton_1);
		
        
     // Botón Volver al menú principal
        JButton btnVolverAdmin = new JButton("0. Volver");
        btnVolverAdmin.setBackground(new Color(240, 240, 240));
        btnVolverAdmin.setBounds(260, 379, 220, 23);
        panelAdmin.add(btnVolverAdmin);
        
		contentPane.add(panelAdmin, "administracion");
		
		JButton btnBuscarGeneral = new JButton("15. Buscar General");
		btnBuscarGeneral.setBackground(new Color(240, 240, 240));
		btnBuscarGeneral.setBounds(490, 334, 220, 23);
		panelAdmin.add(btnBuscarGeneral);
	
		
		// Navegación: menú principal -> administración
		btnAdministracion.addActionListener(e1 -> cardLayout.show(contentPane, "administracion"));
		btnVolverAdmin.addActionListener(e3 -> cardLayout.show(contentPane, "menu"));

             

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

                if (nombre == null || nombre.isEmpty() || !nombre.matches("[a-zA-Z ]+")) {
                    throw new nombreInvalidoException("El nombre solo puede contener letras y espacios.");
                }
                if (rut == null || rut.isEmpty() || !rut.matches("\\d{7,8}-[\\dkK]")) {
                    throw new rutInvalidoException("El RUT debe tener formato 12345678-9.");
                }

                int saldo = Integer.parseInt(saldoStr); 

 
                if (miEmpresa.existeRut(rut)) {
                    JOptionPane.showMessageDialog(null, "Ya existe una persona con el RUT " + rut + ".");
                    return;
                }

                persona p = new persona(nombre, rut, saldo);
                miEmpresa.registrarPersona(p);

                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente!");
                txtRut.setText("");
                txtNombre.setText("");
                txtSaldo.setText("");
                cardLayout.show(contentPane, "menu");

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "El saldo debe ser un número entero (sin puntos).");
            } catch (nombreInvalidoException nie) {
                JOptionPane.showMessageDialog(null, nie.getMessage());
            } catch (rutInvalidoException rie) {
                JOptionPane.showMessageDialog(null, rie.getMessage());
            } catch (Exception ex) {
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
        btnVolverUsuarios.addActionListener(e1 -> cardLayout.show(contentPane, "administracion"));

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


        btnExportarTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setDialogTitle("Guardar reporte (legible)");
                fc.setSelectedFile(new java.io.File("reporte.txt"));
                int r = fc.showSaveDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    String path = fc.getSelectedFile().getAbsolutePath();
                    boolean ok = miEmpresa.exportarReporte(path);
                    if (ok) {
                        JOptionPane.showMessageDialog(null, "Reporte exportado en:\n" + path);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo exportar el reporte.");
                    }
                }
            }
        });
        
        btnUmbralBusesViajes.addActionListener(e3 -> {
            try {
                String texto = JOptionPane.showInputDialog("Ingrese el umbral de ganancias");
                if (texto == null || texto.isEmpty() == true) {
                    JOptionPane.showMessageDialog(this, "Ingrese un umbral (número).");
                    return;
                }

                float umbral = Float.parseFloat(texto.replace(",", "."));


                JScrollPane scroll = miEmpresa.construirScrollBusesYViajesGananciaMayor(umbral);
                JOptionPane.showMessageDialog(this, scroll, "Reporte de Ganancias", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "El umbral debe ser un número (usa punto o coma).");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage());
            }
        });
        
     // ==== BUSES ====

     // 1) Agregar Bus
     btnAgregarBuses.addActionListener(e1 -> {
         try {
             String patente = JOptionPane.showInputDialog(this, "Patente del bus:");
             if (patente == null || patente.isBlank()) return;

             String capacidadStr = JOptionPane.showInputDialog(this, "Capacidad (entero):");
             if (capacidadStr == null || capacidadStr.isBlank()) return;
             int capacidad = Integer.parseInt(capacidadStr);

             String disponibilidadStr = JOptionPane.showInputDialog(this, "Disponibilidad (entero):");
             if (disponibilidadStr == null || disponibilidadStr.isBlank()) return;
             int disponibilidad = Integer.parseInt(disponibilidadStr);

             String tipoStr = JOptionPane.showInputDialog(this, "Tipo (entero):");
             if (tipoStr == null || tipoStr.isBlank()) return;
             int tipo = Integer.parseInt(tipoStr);

             bus nuevoBus = new bus(capacidad, patente, disponibilidad, tipo);
             miEmpresa.agregarBus(nuevoBus);
         } catch (NumberFormatException ex) {
             JOptionPane.showMessageDialog(this, "Valores numéricos inválidos.");
         }
     });

     // 2) Modificar Bus
     btnModificarBuses.addActionListener(e1 -> {
         try {
             String patente = JOptionPane.showInputDialog(this, "Patente del bus a modificar:");
             if (patente == null || patente.isBlank()) return;

             bus busExistente = miEmpresa.obtenerBusPorPatente(patente);
             if (busExistente == null) {
                 JOptionPane.showMessageDialog(this, "No se encontró un bus con esa patente.");
                 return;
             }

             String capacidadStr = JOptionPane.showInputDialog(this, "Nueva capacidad (entero):", busExistente.getCapacidad());
             if (capacidadStr == null || capacidadStr.isBlank()) return;
             int capacidad = Integer.parseInt(capacidadStr);

             String disponibilidadStr = JOptionPane.showInputDialog(this, "Nueva disponibilidad (entero):", busExistente.getDisponibilidad());
             if (disponibilidadStr == null || disponibilidadStr.isBlank()) return;
             int disponibilidad = Integer.parseInt(disponibilidadStr);

             String tipoStr = JOptionPane.showInputDialog(this, "Nuevo tipo (entero):", busExistente.getTipo());
             if (tipoStr == null || tipoStr.isBlank()) return;
             int tipo = Integer.parseInt(tipoStr);

             busExistente.setCapacidad(capacidad);
             busExistente.setDisponibilidad(disponibilidad);
             busExistente.setTipo(tipo);

             JOptionPane.showMessageDialog(this, "Bus modificado: " + patente);
         } catch (NumberFormatException ex) {
             JOptionPane.showMessageDialog(this, "Valores numéricos inválidos.");
         }
     });

     // 3) Eliminar Bus
     btnEliminarBuses.addActionListener(e1 -> {
         String patente = JOptionPane.showInputDialog(this, "Patente del bus a eliminar:");
         if (patente == null || patente.isBlank()) return;
         miEmpresa.eliminarBus(patente);
     });


     // ==== VIAJES ====

     // 4) Agregar Viaje
     btnAgregarViajes.addActionListener(e1 -> {
         try {
             String idStr = JOptionPane.showInputDialog(this, "ID del viaje (entero):");
             if (idStr == null || idStr.isBlank()) return;
             int idViaje = Integer.parseInt(idStr);

             String costoViajeStr = JOptionPane.showInputDialog(this, "Costo del viaje (entero):");
             if (costoViajeStr == null || costoViajeStr.isBlank()) return;
             int costoViaje = Integer.parseInt(costoViajeStr);

             String costoEmpresaStr = JOptionPane.showInputDialog(this, "Costo para la empresa (entero):");
             if (costoEmpresaStr == null || costoEmpresaStr.isBlank()) return;
             int costoEmpresa = Integer.parseInt(costoEmpresaStr);

             String patenteBus = JOptionPane.showInputDialog(this, "Patente del bus:");
             if (patenteBus == null || patenteBus.isBlank()) return;

             String origen = JOptionPane.showInputDialog(this, "Origen:");
             if (origen == null || origen.isBlank()) return;

             String destino = JOptionPane.showInputDialog(this, "Destino:");
             if (destino == null || destino.isBlank()) return;

             String horaSalida = JOptionPane.showInputDialog(this, "Hora de salida (HH:MM):");
             if (horaSalida == null || horaSalida.isBlank()) return;

             String horaLlegada = JOptionPane.showInputDialog(this, "Hora de llegada (HH:MM):");
             if (horaLlegada == null || horaLlegada.isBlank()) return;

             viaje nuevoViaje = new viaje(idViaje, costoViaje, costoEmpresa,
                                          patenteBus, origen, destino,
                                          horaSalida, horaLlegada);
             miEmpresa.agregarViaje(nuevoViaje);
         } catch (NumberFormatException ex) {
             JOptionPane.showMessageDialog(this, "Valores numéricos inválidos.");
         }
     });

     // 5) Modificar Viaje
     BtnModificarViajes.addActionListener(e1 -> {
         try {
             String idStr = JOptionPane.showInputDialog(this, "ID del viaje a modificar:");
             if (idStr == null || idStr.isBlank()) return;
             int idViaje = Integer.parseInt(idStr);

             viaje viajeExistente = miEmpresa.obtenerViajePorId(idViaje);
             if (viajeExistente == null) {
                 JOptionPane.showMessageDialog(this, "No se encontró un viaje con ID " + idViaje);
                 return;
             }

             String nuevoCostoStr = JOptionPane.showInputDialog(this, "Nuevo costo (entero):", viajeExistente.getCostoViaje());
             if (nuevoCostoStr == null || nuevoCostoStr.isBlank()) return;
             int nuevoCosto = Integer.parseInt(nuevoCostoStr);

             String nuevaPatente = JOptionPane.showInputDialog(this, "Nueva patente:", viajeExistente.getPatente());
             if (nuevaPatente == null || nuevaPatente.isBlank()) return;

             String nuevoOrigen = JOptionPane.showInputDialog(this, "Nuevo origen:", viajeExistente.getOrigen());
             if (nuevoOrigen == null || nuevoOrigen.isBlank()) return;

             String nuevoDestino = JOptionPane.showInputDialog(this, "Nuevo destino:", viajeExistente.getDestinoFinal());
             if (nuevoDestino == null || nuevoDestino.isBlank()) return;

             String nuevaSalida = JOptionPane.showInputDialog(this, "Nueva hora de salida (HH:MM):", viajeExistente.getHoraSalida());
             if (nuevaSalida == null || nuevaSalida.isBlank()) return;

             String nuevaLlegada = JOptionPane.showInputDialog(this, "Nueva hora de llegada (HH:MM):", viajeExistente.getHoraLlegada());
             if (nuevaLlegada == null || nuevaLlegada.isBlank()) return;

             miEmpresa.modificarViaje(idViaje, nuevoCosto, nuevaPatente,
                                      nuevoOrigen, nuevoDestino,
                                      nuevaSalida, nuevaLlegada);
         } catch (NumberFormatException ex) {
             JOptionPane.showMessageDialog(this, "ID o costo inválido.");
         }
     });

     // 6) Eliminar Viaje
     btnEliminarViajes.addActionListener(e1 -> {
         try {
             String idStr = JOptionPane.showInputDialog(this, "ID del viaje a eliminar:");
             if (idStr == null || idStr.isBlank()) return;
             int idViaje = Integer.parseInt(idStr);
             miEmpresa.eliminarViaje(idViaje);
         } catch (NumberFormatException ex) {
             JOptionPane.showMessageDialog(this, "ID inválido.");
         }
     });


     // ==== PERSONAS ====

     // 7) Agregar Persona
     btnAgregarUsuarios.addActionListener(e1 -> {
         try {
             String rut = JOptionPane.showInputDialog(this, "RUT (12345678-9):");
             if (rut == null || rut.isBlank()) return;

             String nombre = JOptionPane.showInputDialog(this, "Nombre:");
             if (nombre == null || nombre.isBlank()) return;

             String saldoStr = JOptionPane.showInputDialog(this, "Saldo (entero):");
             if (saldoStr == null || saldoStr.isBlank()) return;
             int saldo = Integer.parseInt(saldoStr);

             persona nuevaPersona = new persona(nombre, rut, saldo);
             miEmpresa.agregarPersona(nuevaPersona);
         } catch (NumberFormatException ex) {
             JOptionPane.showMessageDialog(this, "Saldo inválido.");
         }
     });

     // 8) Modificar Persona
     btnNewButton.addActionListener(e1 -> { // "13. Modificar Usuarios"
         try {
             String rut = JOptionPane.showInputDialog(this, "RUT de la persona a modificar:");
             if (rut == null || rut.isBlank()) return;

             persona personaExistente = miEmpresa.obtenerPersonaPorRut(rut);
             if (personaExistente == null) {
                 JOptionPane.showMessageDialog(this, "No se encontró persona con ese RUT.");
                 return;
             }

             String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo nombre:", personaExistente.getNombre());
             if (nuevoNombre == null || nuevoNombre.isBlank()) return;

             String nuevoSaldoStr = JOptionPane.showInputDialog(this, "Nuevo saldo (entero):", personaExistente.getSaldoDisponible());
             if (nuevoSaldoStr == null || nuevoSaldoStr.isBlank()) return;
             int nuevoSaldo = Integer.parseInt(nuevoSaldoStr);

             miEmpresa.modificarPersona(rut, nuevoNombre, nuevoSaldo);
         } catch (NumberFormatException ex) {
             JOptionPane.showMessageDialog(this, "Saldo inválido.");
         }
     });

     //Eliminar Persona
     btnNewButton_1.addActionListener(e1 -> { //
         String rut = JOptionPane.showInputDialog(this, "RUT de la persona a eliminar:");
         if (rut == null || rut.isBlank()) return;
         miEmpresa.eliminarPersona(rut);
     });

     btnInformacionBuses.addActionListener(e1 -> {
    	    JScrollPane scroll = miEmpresa.mostrarBusesComoScroll();
    	    JOptionPane.showMessageDialog(this, scroll, "Buses", JOptionPane.INFORMATION_MESSAGE);
    	});

    btnMostrarInformacionViajes.addActionListener(e1 -> {
    	    JScrollPane scroll = miEmpresa.mostrarViajesComoScroll();
    	    JOptionPane.showMessageDialog(this, scroll, "Viajes", JOptionPane.INFORMATION_MESSAGE);
    	});
    
    //Busqueda general
    btnBuscarGeneral.addActionListener(e1 -> {
        try {
            String[] opciones = {"Persona por RUT", "Bus por patente", "Viaje por ID", "Pasaje (RUT + ID viaje)"};
            String tipo = (String) JOptionPane.showInputDialog( null, "¿Qué quieres buscar?", "Buscar", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
            if (tipo == null) return;

            switch (tipo) {
                case "Persona por RUT": {
                    String rut = JOptionPane.showInputDialog("RUT:");
                    if (rut == null || rut.isBlank()) return;
                    persona p = miEmpresa.obtenerPersonaPorRut(rut);
                    if (p == null) {
                        JOptionPane.showMessageDialog(null, "No se encontró persona con RUT " + rut + ".");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Persona encontrada\n" +
                                "Nombre: " + p.getNombre() + "\n" +
                                "RUT: " + p.getRut() + "\n" +
                                "Saldo: " + p.getSaldoDisponible() + "\n" +
                                "Pasajes: " + p.getPasajes().size());
                    }
                    break;
                }
                case "Bus por patente": {
                    String patente = JOptionPane.showInputDialog("Patente:");
                    if (patente == null || patente.isBlank()) return;
                    bus b = miEmpresa.obtenerBusPorPatente(patente);
                    if (b == null) {
                        JOptionPane.showMessageDialog(null, "No se encontró bus con patente " + patente + ".");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Bus encontrado\n" +
                                "Patente: " + b.getPatente() + "\n" +
                                "Capacidad: " + b.getCapacidad() + "\n" +
                                "Tipo: " + b.getTipo() + "\n" +
                                "Asientos ocupados: " + b.getAsientosUsados());
                    }
                    break;
                }
                case "Viaje por ID": {
                    String idStr = JOptionPane.showInputDialog("ID del viaje:");
                    if (idStr == null || idStr.isBlank()) return;
                    int id;
                    try { 
                    	id = Integer.parseInt(idStr); 
                    	}
                    catch (NumberFormatException nfe) { 
                    	JOptionPane.showMessageDialog(null, "ID inválido."); 
                    	return; 
                    	}

                    viaje v = miEmpresa.obtenerViajePorId(id);
                    if (v == null) {
                        JOptionPane.showMessageDialog(null, "No se encontró viaje con ID " + id + ".");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Viaje encontrado\n" +
                                "ID: " + v.getViajeID() + "\n" +
                                "Origen: " + v.getOrigen() + "\n" +
                                "Destino: " + v.getDestinoFinal() + "\n" +
                                "Salida: " + v.getHoraSalida() + "\n" +
                                "Llegada: " + v.getHoraLlegada() + "\n" +
                                "Patente: " + v.getPatente() + "\n" +
                                "Costo: " + v.getCostoViaje());
                    }
                    break;
                }
                case "Pasaje (RUT + ID viaje)": {
                    String rut = JOptionPane.showInputDialog("RUT del cliente:");
                    if (rut == null || rut.isBlank()) return;
                    persona p = miEmpresa.obtenerPersonaPorRut(rut);
                    if (p == null) { JOptionPane.showMessageDialog(null, "No existe persona con ese RUT."); return; }

                    String idStr = JOptionPane.showInputDialog("ID del viaje del pasaje:");
                    if (idStr == null || idStr.isBlank()) return;
                    int id;
                    try {
                    	id = Integer.parseInt(idStr); 
                    	}
                    catch (NumberFormatException nfe) {
                    	JOptionPane.showMessageDialog(null, "ID inválido.");
                    	return; 
                    	}

                    pasaje encontrado = null;
                    for (pasaje pa : p.getPasajes()) {
                        if (pa.getIdPasaje() == id) { 
                        	encontrado = pa; 
                        	break; 
                        	}
                    }
                    if (encontrado == null) {
                        JOptionPane.showMessageDialog(null, "Ese cliente no tiene un pasaje con ID " + id + ".");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Pasaje encontrado\n" +
                                "ID viaje: " + encontrado.getIdPasaje() + "\n" +
                                "Destino: " + encontrado.getDestinoFinal() + "\n" +
                                "Salida: " + encontrado.getHoraSalida() + "\n" +
                                "Llegada: " + encontrado.getHoraLlegada() + "\n" +
                                "Fecha: " + encontrado.getFecha() + "\n" +
                                "Asiento: " + encontrado.getAsiento() + "\n" +
                                "Costo: " + encontrado.getCostoPasaje());
                    }
                    break;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en búsqueda: " + ex.getMessage());
        }
    });

    
         
    }
    
}
