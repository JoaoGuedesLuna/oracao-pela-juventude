package main.java.std.guedes.oracaopelajuventude.util;

import main.java.std.guedes.oracaopelajuventude.model.Christian;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe que disponibiliza um método que sorteia, em uma lista, quem vai orar por quem.
 * 
 * @author João Guedes.
 */
public class Draw {

    /**
     * Método que sorteia, em uma lista, quem vai orar por quem.
     *
     * @param names lista de nomes que serão sorteados.
     */
    public static void drawPrayer(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia!");
        }
        if (names.size() == 1) {
            System.out.println("🙏" + names.get(0) + " ora por si mesmo.");
            return;
        }
        ArrayList<Christian> christians = Draw.toChristiansList(names);
        Draw.drawPrayer(christians);
    }

    /**
     * Método que sorteia, em uma lista de cristãos, quem vai orar por quem. Esse método so fará o
     * sorteio se a lista contiver pelo menos dois elementos.
     *
     * @param christians lista de cristãos que serão sorteados.
     */
    private static void drawPrayer(ArrayList<Christian> christians) {
        if (christians.size() > 3) {
            Christian whoPray, whoReceivesThePrayer;
            int indexWhoPray, indexWhoReceivesThePrayer;
            Random random = new Random();
            do {
                do {
                    indexWhoPray = random.nextInt(christians.size());
                    whoPray = christians.get(indexWhoPray);
                } while (whoPray.getPrayed());
                if (whoPray.getReceivedPrayer()) {
                    christians.remove(whoPray);
                    indexWhoPray = -1;
                }
                do {
                    indexWhoReceivesThePrayer = random.nextInt(christians.size());
                    whoReceivesThePrayer = christians.get(indexWhoReceivesThePrayer);
                } while (whoReceivesThePrayer.getReceivedPrayer() || indexWhoPray == indexWhoReceivesThePrayer);
                if (whoReceivesThePrayer.getPrayed()) {
                    christians.remove(whoReceivesThePrayer);
                }
                whoPray.pray(whoReceivesThePrayer);
            } while (christians.size() > 3);
        }
        if (christians.size() == 3) {
            Draw.drawWithThree(christians);
            return;
        }
        if (christians.size() == 2) {
            Draw.drawWithTwo(christians);
        }
    }

    /**
     * Método que determina, em uma lista contendo apenas dois cristãos, quem vai orar por quem.
     * Caso a lista passada como parâmetro tenha tamanho diferente de dois será lançada uma exceção.
     *
     * @param christians lista contendo apenas dois cristãos.
     */
    private static void drawWithTwo(ArrayList<Christian> christians) {
        if (christians.size() != 2) {
            throw new IllegalArgumentException("Tamanho da lista é diferente de 2!");
        }
        Christian christian1 = christians.get(0);
        Christian christian2 = christians.get(1);
        if (!christian1.getPrayed() && !christian2.getPrayed()) {
            christian1.pray(christian2);
            christian2.pray(christian1);
        }
        else if (christian1.getPrayed()) {
            christian2.pray(christian1);
        }
        else {
            christian1.pray(christian2);
        }
    }

    /**
     * Método que determina, em uma lista contendo apenas três cristãos, quem vai orar por quem.
     * Caso a lista passada como parâmetro tenha tamanho diferente de três será lançada uma exceção.
     *
     * @param christians lista contendo apenas três cristãos.
     */
    private static void drawWithThree(ArrayList<Christian> christians) {
        if (christians.size() != 3) {
            throw new IllegalArgumentException("Tamanho da lista é diferente de 3!");
        }
        Christian christian1 = christians.get(0);
        Christian christian2 = christians.get(1);
        Christian christian3 = christians.get(2);
        if (!christian1.getPrayed() && !christian2.getPrayed() && !christian3.getPrayed()) {
            if (Math.random() < 0.5) {
                christian1.pray(christian3);
                christian3.pray(christian2);
                christian2.pray(christian1);
            }
            else {
                christian1.pray(christian2);
                christian2.pray(christian3);
                christian3.pray(christian1);
            }
            return;
        }
        Christian neitherPrayedNorReceivedPrayer = null;
        Christian alreadyPrayed = null;
        Christian alreadyReceivedPrayer = null;
        for (Christian christian : christians) {
            if (christian.getPrayed()) {
                alreadyPrayed = christian;
            }
            else if (christian.getReceivedPrayer()) {
                alreadyReceivedPrayer = christian;
            }
            else {
                neitherPrayedNorReceivedPrayer = christian;
            }
        }
        neitherPrayedNorReceivedPrayer.pray(alreadyPrayed);
        alreadyReceivedPrayer.pray(neitherPrayedNorReceivedPrayer);
    }

    /**
     * Método que converte uma lista de nomes (String) em uma lista de Cristãos (Christians).
     *
     * @param names lista de nomes que será convertida.
     *
     * @return lista de cristãos.
     */
    private static ArrayList<Christian> toChristiansList(List<String> names) {
        ArrayList<Christian> christians = new ArrayList<>();
        for (String name : names) {
            christians.add(new Christian(name));
        }
        return christians;
    }

}