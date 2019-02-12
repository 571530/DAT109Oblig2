package no.hvl.dat109;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Terningspill {
    private int id;

    ArrayList<Spiller> spillere;
    Kopp kopp;

    void leggTilSpiller(String navn) {
        spillere.add(new Spiller(navn));
    }

    void spill() {
        for (Spiller spiller : spillere) {
            spiller.spill(kopp);
            System.out.println(spiller);
        }

        System.out.println("\nVinneren er " + finnVinner());
    }

    public Spiller finnVinner() {
        Spiller vinner = spillere.stream().max(Comparator.comparingInt(Spiller::getVerdi)).orElse(null);

        return vinner;
    }

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
