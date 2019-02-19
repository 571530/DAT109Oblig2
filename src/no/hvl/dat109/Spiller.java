package no.hvl.dat109;

/**
 * The type Spiller.
 */
public class Spiller {
    private String navn;

    private int verdi;

    /**
     * Spill.
     *
     * @param kopp the kopp
     */
    public void spill(Kopp kopp) {
        kopp.trill();
        verdi = kopp.getSum();
    }

    /**
     * Instantiates a new Spiller.
     *
     * @param navn the navn
     */
    public Spiller(String navn) {
        this.verdi = 0;
        this.navn = navn;
    }

    /**
     * Gets verdi.
     *
     * @return the verdi
     */
    public int getVerdi() {
        return verdi;
    }

    /**
     * Sets verdi.
     *
     * @param verdi the verdi
     */
    public void setVerdi(int verdi) {
        this.verdi = verdi;
    }

    @Override
    public String toString() {
        return navn + " med " + verdi + " poeng";
    }
}
