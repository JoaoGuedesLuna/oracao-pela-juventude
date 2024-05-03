package main.java.dev.guedes.oracaopelajuventude.raffler;

import main.java.dev.guedes.oracaopelajuventude.renderer.Renderer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Randomizer class for selecting who will pray for whom.
 *
 * @author João Guedes
 */
public class PrayerPairRaffler implements Raffler {

    @Override
    public void raffle(List<String> participants) {
        List<String> shuffledParticipants = this.shuffle(participants);
        List<String> pray = new LinkedList<>(shuffledParticipants);
        List<String> receive = new LinkedList<>(shuffledParticipants);
        this.raffle(pray, receive, new Random());
    }

    /**
     * Randomly selects who will pray for whom from a list of participants.
     *
     * @param pray The list of participants who will pray.
     *
     * @param receive The list of participants who will receive prayer.
     *
     * @param rand Random number generator.
     */
    private void raffle(List<String> pray, List<String> receive, Random rand) {
        if (pray.isEmpty() || receive.isEmpty()) {
            return;
        }
        String participant1 = pray.get(rand.nextInt(pray.size()));
        String participant2 = receive.get(rand.nextInt(receive.size()));
        List<String> auxPray = pray.stream().filter(p1 -> !p1.equals(participant1)).toList();
        List<String> auxReceive = receive.stream().filter(p2 -> !p2.equals(participant2)).toList();
        if (pray.size() == 1 || !participant1.equals(participant2)) {
            if (pray.size() != 2 || auxPray.stream().noneMatch(auxReceive::contains)) {
                pray = auxPray;
                receive = auxReceive;
                Renderer.renderPrayerPair(participant1, participant2);
            }
        }
        this.raffle(pray, receive, rand);
    }

    /**
     * Shuffles a list.
     *
     * @param list The list to be shuffled.
     *
     * @return Returns a shuffled list.
     *
     * @param <T> Data type contained in the list.
     */
    private <T> List<T> shuffle(List<T> list) {
        List<T> shuffledList = new LinkedList<>(list);
        Collections.shuffle(shuffledList);
        return shuffledList;
    }

}
