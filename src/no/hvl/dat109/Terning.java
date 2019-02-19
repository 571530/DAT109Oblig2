package no.hvl.dat109;

import java.util.Random;

/**
 * The type Terning.
 */
public class Terning {
    private static int AUTO_ID = 0;

    private Random rand;
    private int verdi;
    private int id;

    /**
     * Instantiates a new Terning.
     */
    public Terning() {
        rand = new Random();
        verdi = 0;
        id = AUTO_ID++;
        trill();
    }

    /**
     * Trill.
     */
    public void trill() {
        verdi = rand.nextInt(6) + 1;
    }

    /**
     * Gets verdi.
     *
     * @return the verdi
     */
    public int getVerdi() {
        return verdi;
    }
}
