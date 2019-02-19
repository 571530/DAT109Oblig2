package no.hvl.dat109;

import java.util.ArrayList;

/**
 * The type Kopp.
 */
public class Kopp {
    private static final int ANTALL_TERNINGER = 2;

    private int id; // Ikke i bruk
    private int sum;

    private ArrayList<Terning> terninger;

    /**
     * Trill.
     */
    public void trill() {
        sum = 0;
        for (Terning terning : terninger) {
            terning.trill();
            sum += terning.getVerdi();
        }
    }

    /**
     * Sets sum.
     *
     * @param sum the sum
     */
    public void setSum(int sum) {
        this.sum = sum;
    }

    /**
     * Gets sum.
     *
     * @return the sum
     */
    public int getSum() {
        return sum;
    }

    /**
     * Instantiates a new Kopp.
     */
    public Kopp() {
        sum = 0;
        id = 0;
        terninger = new ArrayList<>();

        for (int i = 0; i < ANTALL_TERNINGER; i++) {
            terninger.add(new Terning());
        }
    }
}
