package no.hvl.dat109;

import java.util.Random;

/**
 * The type Terning.
 */
public class Terning {
    private Random rand;
    private int verdi;
    private int id; // Ikke i bruk

    /**
     * Instantiates a new Terning.
     */
    public Terning() {
        rand = new Random();
        verdi = 0;
        id = 0;
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
