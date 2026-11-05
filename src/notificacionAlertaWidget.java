public class notificacionAlertaWidget extends widget implements interactivo {
    public notificacionAlertaWidget() {
        super("W-009", "Notificaciones y alertas", "Sistema", 288,
                "1 alerta de prioridad alta y 2 notificaciones nuevas.");
    }

    @Override
    public String interactuar() {
        return "Centro de alertas abierto. Revisa la alerta de prioridad alta.";
    }
}
