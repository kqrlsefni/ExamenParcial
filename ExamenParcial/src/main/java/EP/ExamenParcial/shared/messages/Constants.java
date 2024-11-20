package EP.ExamenParcial.shared.messages;

public class Constants {
    public final static String ITEM_FOUND = "Item encontrado";
    public final static String ITEMS_FOUND = "Items encontrados";
    public final static String ITEM_NOT_FOUND = "Item no encontrado";
    public final static String ITEM_CREATED = "Item creado";
    public final static String ITEM_UPDATED = "Item actualizado";
    public final static String ITEM_DELETED = "Item eliminado";
    public final static String ERROR_INVALID_DATA = "Error en los parametros de ingreso del Item";
    public final static String ERROR_DATA_NOMBRE = "El dato 'nombre' no debe ser vacio ni mayor a 100 caracteres";
    public final static String ERROR_DATA_NOTA = "El dato 'nota' debe de ser de 0-20";
    public final static String ERROR_DATA_ID = "Error al identificar el item";
    public final static String EMPTY_DATA = "No existen datos registrados";
    public final static String SERVICE_UNAVAILABLE = "El servicio no esta disponible temporalmente";

    public final static int CODE_NOT_FOUND = 404;
    public final static int CODE_OK = 200;
    public final static int CODE_CREATED = 201;
    public final static int CODE_BAD_REQUEST = 400;
    public final static int CODE_NO_CONTENT = 204;
    public final static int CODE_SERVICE_UNAVAILABLE = 503;

    public final static int MAX_NOTA = 20;
    public final static int MIN_NOTA = 0;
    public final static int MAX_NOMBRE_LENGTH = 100;


}
