package no.hvl.dat109;

import java.util.Random;

public class Terning {
    private static int AUTO_ID = 0;

    private Random rand;
    private int verdi;
    private int id;

    public Terning() {
        rand = new Random();
        verdi = 0;
        id = AUTO_ID++;
        trill();
    }

    public void trill() {
        verdi = rand.nextInt(6) + 1;
    }

    public int getVerdi() {
        return verdi;
    }
}
