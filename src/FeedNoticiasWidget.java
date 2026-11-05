public class FeedNoticiasWidget extends widget implements interactivo {
    public FeedNoticiasWidget() {
        super("W-003", "Feed de noticias", "Información", 480,
                "Noticias coorporativas y nuevos equipos en novedad");
    }

    @Override
    public String interactuar() {
        return "El feed de noticias se ha actualizado.";
    }
}
