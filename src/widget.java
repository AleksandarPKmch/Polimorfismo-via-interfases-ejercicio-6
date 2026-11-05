import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public abstract class widget implements renderizable {
    private final String id;
    private final String nombre;
    private final String tipo;
    private final int memoriaKb;
    private final String configuracion;

    protected widget(String id, String nombre, String tipo, int memoriaKb, String configuracion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.memoriaKb = memoriaKb;
        this.configuracion = configuracion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getMemoriaKb() {
        return memoriaKb;
    }

    public String getConfiguracion() {
        return configuracion;
    }

    @Override
    public JComponent renderizar() {
        JPanel tarjeta = new JPanel(new BorderLayout(0, 10));
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(224, 229, 236)),
                BorderFactory.createEmptyBorder(16, 16, 16, 16)));

        JLabel titulo = new JLabel(nombre);
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 16f));
        titulo.setForeground(new Color(34, 48, 69));

        JTextArea detalle = new JTextArea(configuracion);
        detalle.setEditable(false);
        detalle.setLineWrap(true);
        detalle.setWrapStyleWord(true);
        detalle.setOpaque(false);
        detalle.setForeground(new Color(86, 99, 117));
        detalle.setFont(detalle.getFont().deriveFont(13f));

        JLabel metadatos = new JLabel(id + "  ·  " + tipo + "  ·  " + memoriaKb + " KB");
        metadatos.setForeground(new Color(105, 117, 133));
        metadatos.setFont(metadatos.getFont().deriveFont(11f));

        tarjeta.add(titulo, BorderLayout.NORTH);
        tarjeta.add(detalle, BorderLayout.CENTER);
        tarjeta.add(metadatos, BorderLayout.SOUTH);
        return tarjeta;
    }
}
