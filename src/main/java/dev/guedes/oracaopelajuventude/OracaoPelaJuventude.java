package main.java.dev.guedes.oracaopelajuventude;

import main.java.dev.guedes.oracaopelajuventude.raffler.PrayerPairRaffler;
import main.java.dev.guedes.oracaopelajuventude.renderer.Renderer;
import main.java.dev.guedes.oracaopelajuventude.util.ArgsHelper;
import java.util.List;

/**
 * Facade class.
 *
 * @author João Guedes
 */
public class OracaoPelaJuventude {

    public static void run(String[] args) {
        List<String> participants = ArgsHelper.getParticipants(args);
        OracaoPelaJuventude.render(participants);
    }

    private static void render(List<String> participants) {
        Renderer.render(new PrayerPairRaffler(), participants);
    }

}
