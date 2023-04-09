package main.java.std.guedes.oracaopelajuventude;

import static main.java.std.guedes.oracaopelajuventude.util.Draw.drawPrayer;
import java.util.List;
import java.util.ArrayList;

/**
 * @author João Guedes.
 */
public class OracaoPelaJuventudeRun {

    public static void main(String[] args) {
        System.out.println("✝ ✝ ✝ ORAÇÃO PELA JUVENTUDE ✝ ✝ ✝\n");
        List<String> oracaoPelaJuventude = new ArrayList<>() { {
            add("Alexsandra");
            add("Cassiane");
            add("Ely");
            add("João");
            add("Joyce");
            add("Lucas");
            add("Marcone");
            add("Mihay");
        } };
        drawPrayer(oracaoPelaJuventude);
        System.out.println("\n✝ ✝ ✝ ✝ ✝ ✝ ✝ ✝ ✝ ✝ ✝ ✝ ✝");
    }

}
