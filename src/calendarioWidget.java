public class calendarioWidget extends widget implements interactivo {
    public calendarioWidget() {
        super("W-006", "Calendario", "Organización", 400,
                "Próximo evento: reunión de planificación, hoy a las 15:00.");
    }

    @Override
    public String interactuar() {
        return "Calendario abierto. Tienes 3 eventos próximos. los cuaes son: Invadir Peru, reestablecer KKK, dominar la clase de yoga";
    }
}
