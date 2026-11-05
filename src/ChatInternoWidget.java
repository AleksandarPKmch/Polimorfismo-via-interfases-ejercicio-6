public class ChatInternoWidget extends widget implements interactivo {
    public ChatInternoWidget() {
        super("W-001", "Chat interno", "Comunicación", 640,
                "3 conversaciones activas. Último mensaje recibido hace 2 minutos.");
    }

    @Override
    public String interactuar() {
        return "El chat esta listo para la conversacion";
    }
}
