package no.hvl.dat109;

public class Spiller {
    private String navn;
    private int verdi;

    public void spill(Kopp kopp) {
        kopp.trill();
        verdi = kopp.getSum();
    }

    public Spiller(String navn) {
        this.verdi = 0;
        this.navn = navn;
    }

    public int getVerdi() {
        return verdi;
    }

    @Override
    public String toString() {
        return navn +
                " med " + verdi +
                " poeng";
    }
}
