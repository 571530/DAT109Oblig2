package no.hvl.dat109;

import java.util.ArrayList;

public class Kopp {
    private static int AUTO_ID = 0;
    private static final int ANTALL_TERNINGER = 2;

    private int id;
    private int sum;

    private ArrayList<Terning> terninger;

    public void trill() {
        sum = 0;
        for (Terning terning : terninger) {
            terning.trill();
            sum += terning.getVerdi();
        }
    }

    public int getSum() {
        return sum;
    }

    public Kopp() {
        sum = 0;
        id = AUTO_ID++;
        terninger = new ArrayList<>();

        for (int i = 0; i < ANTALL_TERNINGER; i++) {
            terninger.add(new Terning());
        }
    }
}
