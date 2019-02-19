package no.hvl.dat109;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The type Terningspill.
 */
public class Terningspill {
    private int id; // Ikke i bruk

    /**
     * The Spillere.
     */
    private ArrayList<Spiller> spillere;
    /**
     * The Kopp.
     */
    private Kopp kopp;


    /**
     * Legg til spiller.
     *
     * @param navn the navn
     */
    void leggTilSpiller(String navn) {
        spillere.add(new Spiller(navn));
    }

    /**
     * Spill.
     */
    void spill() {
        spill(spillere);

        Spiller vinner = finnVinner();

        System.out.println("\nVinneren er " + vinner);
    }

    /**
     * Spill.
     *
     * @param spillere the spillere
     */
    void spill(List<Spiller> spillere) {
        for (Spiller spiller : spillere) {
            spiller.spill(kopp);
            System.out.println(spiller);
        }
    }

    /**
     * Finn vinner spiller.
     *
     * @return the spiller
     */
    public Spiller finnVinner() {
        Spiller vinner = spillere.stream().max(Comparator.comparingInt(Spiller::getVerdi)).orElse(null);

        if (vinner != null) {

            List<Spiller> vinnere = spillere.stream().filter(x -> x.getVerdi() == vinner.getVerdi()).collect(Collectors.toList());

            while (vinnere.size() > 1) {

                spill(vinnere);

                Spiller nyvinner = spillere.stream().max(Comparator.comparingInt(Spiller::getVerdi)).orElse(null);
                vinnere = vinnere.stream().filter(x -> x.getVerdi() == nyvinner.getVerdi()).collect(Collectors.toList());
            }

            return vinnere.get(0);
        }
        return null;
    }

    /**
     * Instantiates a new Terningspill.
     */
    public Terningspill() {
        spillere = new ArrayList<>();
        id = 0;
        kopp = new Kopp();

    }


    /**
     * Leser inn spillerne.
     */
    public void lesInnSpillere() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Antall spillere?");
        int antall = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < antall; i++) {
            System.out.println("Navn på spiller nummer " + (i + 1));
            leggTilSpiller(sc.nextLine());

        }
    }

    /**
     * Gets spillere.
     *
     * @return the spillere
     */
    public ArrayList<Spiller> getSpillere() {
        return spillere;
    }

    /**
     * Sets spillere.
     *
     * @param spillere the spillere
     */
    public void setSpillere(ArrayList<Spiller> spillere) {
        this.spillere = spillere;
    }

    /**
     * Gets kopp.
     *
     * @return the kopp
     */
    public Kopp getKopp() {
        return kopp;
    }

    /**
     * Sets kopp.
     *
     * @param kopp the kopp
     */
    public void setKopp(Kopp kopp) {
        this.kopp = kopp;
    }
}
