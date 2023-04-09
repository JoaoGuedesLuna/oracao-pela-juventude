package main.java.std.guedes.oracaopelajuventude.model;

import java.util.Objects;

/**
 * Classe que representa um cristão.
 *
 * @author João Guedes.
 */
public class Christian {

    /**
     * Nome do cristão.
     */
    private String name;
    /**
     * Atributo que diz se o cristõo já orou por alguém.
     */
    private boolean prayed;
    /**
     * Atributo que diz se o cristão já recebeu oração de alguém.
     */
    private boolean receivedPrayer;

    public Christian(String name) {
        this.name = name;
        this.prayed = false;
        this.receivedPrayer = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getPrayed() {
        return this.prayed;
    }

    public void setPrayed(boolean prayed) {
        this.prayed = prayed;
    }

    public boolean getReceivedPrayer() {
        return this.receivedPrayer;
    }

    public void setReceivedPrayer(boolean receivedPrayer) {
        this.receivedPrayer = receivedPrayer;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Christian christian = (Christian) o;
        return Objects.equals(this.name, christian.name) &&
                Objects.equals(this.prayed, christian.prayed) &&
                Objects.equals(this.receivedPrayer, christian.receivedPrayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.prayed, this.receivedPrayer);
    }

    @Override
    public String toString() {
        return "Christian {\n" +
                "	Name : '" + this.name + "',\n" +
                "	prayed : " + this.prayed + ",\n" +
                "	receivedPrayer : " + this.receivedPrayer + "\n" +
                "}";
    }

    /**
     * Esse método faz o cristão que chamou método orar pelo cristão passado como parâmetro.
     *
     * @param christianWhoWillReceivePrayer cristão que receberá a oração.
     */
    public void pray(Christian christianWhoWillReceivePrayer) {
        System.out.println("🙏 " + this.getName() + " ora por " + christianWhoWillReceivePrayer.getName());
        this.setPrayed(true);
        christianWhoWillReceivePrayer.setReceivedPrayer(true);
    }

}