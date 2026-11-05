import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class DashboardWindow extends JFrame {
    private final CatalogoWidgets catalogo = new CatalogoWidgets();
    private final JPanel panelWidgets = new JPanel();
    private final JLabel estado = new JLabel("10 widgets activos");
    private final JTextField campoBusqueda = new JTextField(22);

    public DashboardWindow() {
        super("Dashboard empresarial");
        configurarEstilo();
        configurarVentana();
        configurarContenido();
        mostrarWidgets(catalogo.getWidgets());
    }

    private void configurarEstilo() {
        UIManager.put("Button.arc", 10);
        UIManager.put("Component.arc", 8);
        UIManager.put("TextComponent.arc", 8);
    }

    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(760, 560));
        setSize(1100, 760);
        setLocationRelativeTo(null);
    }

    private void configurarContenido() {
        JPanel contenido = new JPanel(new BorderLayout(0, 18));
        contenido.setBorder(BorderFactory.createEmptyBorder(22, 24, 18, 24));

        JPanel encabezado = new JPanel(new BorderLayout(0, 6));
        encabezado.setOpaque(false);
        JLabel titulo = new JLabel("Dashboard empresarial");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 25f));
        titulo.setForeground(new Color(34, 48, 69));
        JLabel subtitulo = new JLabel("Panel modular de widgets");
        subtitulo.setForeground(new Color(105, 117, 133));
        encabezado.add(titulo, BorderLayout.NORTH);
        encabezado.add(subtitulo, BorderLayout.CENTER);

        panelWidgets.setOpaque(false);
        panelWidgets.setLayout(new GridLayout(0, 3, 14, 14));
        JScrollPane desplazamiento = new JScrollPane(panelWidgets);
        desplazamiento.setBorder(BorderFactory.createEmptyBorder());
        desplazamiento.getViewport().setOpaque(false);
        desplazamiento.setOpaque(false);

        contenido.add(encabezado, BorderLayout.NORTH);
        contenido.add(desplazamiento, BorderLayout.CENTER);
        contenido.add(crearBarraHerramientas(), BorderLayout.SOUTH);
        setContentPane(contenido);
    }

    private JPanel crearBarraHerramientas() {
        JPanel barra = new JPanel(new BorderLayout(10, 8));
        barra.setOpaque(false);

        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        acciones.setOpaque(false);
        JButton botonListar = new JButton("Todos");
        botonListar.addActionListener(evento -> {
            campoBusqueda.setText("");
            mostrarWidgets(catalogo.getWidgets());
            estado.setText(catalogo.getWidgets().size() + " widgets activos");
        });

        JButton botonBuscar = new JButton("Buscar por ID o nombre");
        botonBuscar.addActionListener(evento -> buscarWidgets());
        campoBusqueda.addActionListener(evento -> buscarWidgets());

        JButton botonOrdenar = new JButton("Ordenar por memoria");
        botonOrdenar.addActionListener(evento -> {
            List<widget> ordenados = catalogo.getWidgets().stream()
                    .sorted(Comparator.comparingInt(widget::getMemoriaKb))
                    .collect(Collectors.toList());
            mostrarWidgets(ordenados);
            estado.setText("Widgets ordenados por memoria (menor a mayor)");
        });

        acciones.add(botonListar);
        acciones.add(campoBusqueda);
        acciones.add(botonBuscar);
        acciones.add(botonOrdenar);
        barra.add(acciones, BorderLayout.NORTH);

        estado.setForeground(new Color(105, 117, 133));
        estado.setHorizontalAlignment(SwingConstants.LEFT);
        barra.add(estado, BorderLayout.SOUTH);
        return barra;
    }

    private void buscarWidgets() {
        String consulta = campoBusqueda.getText().trim().toLowerCase(Locale.ROOT);
        if (consulta.isEmpty()) {
            mostrarWidgets(catalogo.getWidgets());
            estado.setText("Escribe un ID o nombre para buscar");
            return;
        }

        List<widget> resultados = catalogo.getWidgets().stream()
                .filter(elemento -> elemento.getId().toLowerCase(Locale.ROOT).contains(consulta)
                        || elemento.getNombre().toLowerCase(Locale.ROOT).contains(consulta))
                .collect(Collectors.toList());
        mostrarWidgets(resultados);
        estado.setText(resultados.isEmpty()
                ? "No se encontraron widgets para \"" + campoBusqueda.getText().trim() + "\""
                : resultados.size() + " resultado(s) encontrado(s)");
    }

    private void mostrarWidgets(List<widget> widgets) {
        panelWidgets.removeAll();
        for (widget elemento : widgets) {
            JPanel contenedorTarjeta = new JPanel(new BorderLayout(0, 8));
            contenedorTarjeta.setOpaque(false);
            contenedorTarjeta.add(elemento.renderizar(), BorderLayout.CENTER);

            if (elemento instanceof interactivo accionable) {
                JButton botonAccion = new JButton("Abrir");
                botonAccion.addActionListener(evento -> JOptionPane.showMessageDialog(
                        this,
                        accionable.interactuar(),
                        elemento.getNombre(),
                        JOptionPane.INFORMATION_MESSAGE));
                contenedorTarjeta.add(botonAccion, BorderLayout.SOUTH);
            }

            panelWidgets.add(contenedorTarjeta);
        }
        panelWidgets.revalidate();
        panelWidgets.repaint();
    }
}
