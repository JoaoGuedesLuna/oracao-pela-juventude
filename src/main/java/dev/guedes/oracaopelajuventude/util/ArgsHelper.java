package main.java.dev.guedes.oracaopelajuventude.util;

import main.java.dev.guedes.oracaopelajuventude.exception.InvalidArgumentException;
import main.java.dev.guedes.oracaopelajuventude.exception.NoArgumentsException;
import java.util.Arrays;
import java.util.List;

/**
 * @author João Guedes
 */
public class ArgsHelper {

    public static List<String> getParticipants(String[] args) {
        if (args.length == 0) {
            throw new NoArgumentsException();
        }
        if (args.length > 1) {
            throw new InvalidArgumentException();
        }
        List<String> participants = Arrays.stream(args[0].split(",")).peek(s -> {
            if (s.isBlank()) {
                throw new InvalidArgumentException();
            }
        }).map(String::trim).distinct().toList();
        if (participants.isEmpty()) {
            throw new NoArgumentsException();
        }
        return participants;
    }

}
