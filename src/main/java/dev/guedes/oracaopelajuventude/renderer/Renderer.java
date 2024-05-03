package main.java.dev.guedes.oracaopelajuventude.renderer;

import main.java.dev.guedes.oracaopelajuventude.raffler.Raffler;
import main.java.dev.guedes.oracaopelajuventude.util.TextFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Console text renderer class.
 *
 * @author João Guedes
 */
public class Renderer {

    private static final String TITLE = "ORAÇÃO PELA JUVENTUDE";
    private static final String BAR_SIGN = "=";
    public static final int WIDTH = 65;

    /**
     * Renders the entire table containing the information of who will pray for whom.
     *
     * @param raffler Randomizer class.
     *
     * @param participants List of participants.
     */
    public static void render(Raffler raffler, List<String> participants) {
        System.out.println(BAR_SIGN.repeat(WIDTH));
        System.out.printf("|%s|%n", TextFormatter.centralizeText(TITLE, WIDTH-2));
        System.out.println(BAR_SIGN.repeat(WIDTH));
        System.out.printf("|%s|%n", " ".repeat(WIDTH-2));
        raffler.raffle(participants);
        System.out.printf("|%s|%n", " ".repeat(WIDTH-2));
        System.out.println(BAR_SIGN.repeat(WIDTH));
        System.out.println("<pressione ENTER para encerrar>");
        new Scanner(System.in).nextLine();
    }

    /**
     * Displays on the screen the information of the selected participant who will
     * pray for the selected participant receiving prayer.
     *
     * @param participant1 Participant who will pray.
     *
     * @param participant2 Participant who will receive the prayer.
     */
    public static void renderPrayerPair(String participant1, String participant2) {
        String text = String.format("%s ora por %s", participant1, participant2);
        String[] wrappedText = TextFormatter.wrapText(text, WIDTH-10);
        System.out.printf("|  [*] %-" + (WIDTH-8) + "s|%n", wrappedText[0]);
        for (int i = 1; i < wrappedText.length; i++) {
            System.out.printf("|      %-" + (WIDTH-8) + "s|%n", wrappedText[i]);
        }
    }

}
