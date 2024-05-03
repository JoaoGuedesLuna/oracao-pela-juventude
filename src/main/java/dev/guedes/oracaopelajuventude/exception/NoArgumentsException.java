package main.java.dev.guedes.oracaopelajuventude.exception;

/**
 * Exception for missing argument.
 *
 * @author João Guedes
 */
public class NoArgumentsException extends RuntimeException{

    public NoArgumentsException() {
        super(
                "Algum argumento deve ser passado. " +
                "Ex: \"Alexsandra, Cassiane, Ely, João, Joyce, Lucas, Marcone, Mihay\". " +
                "A lista de nomes deve estar dentro das aspas (\" \"). " +
                "Cada nome deve ser separado por vírgula. " +
                "Nomes compostos são aceitos."
        );
    }

}
