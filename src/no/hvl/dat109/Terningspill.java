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
    private int id;

    /**
     * The Spillere.
     */
    ArrayList<Spiller> spillere;
    /**
     * The Kopp.
     */
    Kopp kopp;


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
                vinnere = spillere.stream().filter(x -> x.getVerdi() == nyvinner.getVerdi()).collect(Collectors.toList());
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

        Scanner sc = new Scanner(System.in);

        System.out.println("Antall spillere?");
        int antall = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < antall; i++) {
            System.out.println("Navn på spiller nummer " + (i + 1));
            leggTilSpiller(sc.nextLine());
        }
    }
}
