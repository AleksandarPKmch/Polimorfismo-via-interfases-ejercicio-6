public class listaTareaWidget extends widget implements interactivo {
    public listaTareaWidget() {
        super("W-008", "Lista de tareas", "Productividad", 352,
                "4 tareas pendientes y 4 completadas exitosamente, informe trimestral.");
    }

    @Override
    public String interactuar() {
        return "Lista de tareas abierta. Hay 4 tareas pendientes.";
    }
}
