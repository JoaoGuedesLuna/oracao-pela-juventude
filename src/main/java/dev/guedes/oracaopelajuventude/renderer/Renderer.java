package main.java.dev.guedes.oracaopelajuventude.renderer;

import main.java.dev.guedes.oracaopelajuventude.raffler.Raffler;
import main.java.dev.guedes.oracaopelajuventude.util.TextFormatter;

import java.util.List;

/**
 * @author João Guedes
 */
public class Renderer {

    private static final String TITLE = "ORAÇÃO PELA JUVENTUDE";
    private static final String BAR_SIGN = "=";
    public static final int WIDTH = 65;

    public static void render(Raffler raffler, List<String> participants) {
        System.out.println(BAR_SIGN.repeat(WIDTH));
        System.out.printf("|%s|%n", TextFormatter.centralizeText(TITLE, WIDTH-2));
        System.out.println(BAR_SIGN.repeat(WIDTH));
        System.out.printf("|%s|%n", " ".repeat(WIDTH-2));
        raffler.raffle(participants);
        System.out.printf("|%s|%n", " ".repeat(WIDTH-2));
        System.out.println(BAR_SIGN.repeat(WIDTH));
    }

    public static void renderPrayerPair(String participant1, String participant2) {
        String text = String.format("%s ora por %s", participant1, participant2);
        String[] wrappedText = TextFormatter.wrapText(text, WIDTH-10);
        System.out.printf("|  [*] %-" + (WIDTH-8) + "s|%n", wrappedText[0]);
        for (int i = 1; i < wrappedText.length; i++) {
            System.out.printf("|      %-" + (WIDTH-8) + "s|%n", wrappedText[i]);
        }
    }

}
