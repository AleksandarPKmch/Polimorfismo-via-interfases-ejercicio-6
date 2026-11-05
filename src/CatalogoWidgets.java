import java.util.ArrayList;
import java.util.List;

public class CatalogoWidgets {
    private final List<widget> widgets = new ArrayList<>();

    public CatalogoWidgets() {
        widgets.add(new ChatInternoWidget());
        widgets.add(new ContadorKPIWidget());
        widgets.add(new FeedNoticiasWidget());
        widgets.add(new GraficoMetricasWidget());
        widgets.add(new MapaWidget());
        widgets.add(new calendarioWidget());
        widgets.add(new climaWidget());
        widgets.add(new listaTareaWidget());
        widgets.add(new notificacionAlertaWidget());
        widgets.add(new relojWidget());
    }

    public List<widget> getWidgets() {
        return List.copyOf(widgets);
    }
}
