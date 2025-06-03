package lt.esdc.shapes.exception;

public class ConeException extends Exception {

    public ConeException() {
        super("Ошибка в проекте конуса");
    }

    public ConeException(String message) {
        super(message);
    }

    public ConeException(Throwable cause) {
        super(cause);
    }

    public ConeException(String message, Throwable cause) {
        super(message, cause);
    }
}
