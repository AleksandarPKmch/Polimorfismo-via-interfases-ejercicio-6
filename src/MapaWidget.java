public class MapaWidget extends widget implements interactivo {
    public MapaWidget() {
        super("W-005", "Mapa de sucursales", "Operaciones", 860,
                "Vista regional con 12 sucursales y 4 centros de distribución.");
    }

    @Override
    public String interactuar() {
        return "Mapa de sucursales: selecciona una ubicación para ver sus detalles.";
    }
}
