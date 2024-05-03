package main.java.dev.guedes.oracaopelajuventude.raffler;

import java.util.List;

/**
 * Randomizer interface.
 *
 * @author João Guedes
 */
public interface Raffler {

    /**
     * Randomly selects who will pray for whom from a list of participants.
     *
     * @param participants The list of participants.
     */
    void raffle(List<String> participants);

}
