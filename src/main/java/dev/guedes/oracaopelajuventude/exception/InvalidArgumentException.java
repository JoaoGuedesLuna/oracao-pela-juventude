package main.java.dev.guedes.oracaopelajuventude.exception;

/**
 * Exception for invalid arguments.
 *
 * @author João Guedes
 */
public class InvalidArgumentException extends RuntimeException {

    public InvalidArgumentException() {
        super(
                "Argumento inválido. Todos os argumentos devem ser passados juntos dentro de aspas (\" \"). " +
                "Ex: \"Alexsandra, Cassiane, Ely, João, Joyce, Lucas, Marcone, Mihay\". "
        );
    }

}
