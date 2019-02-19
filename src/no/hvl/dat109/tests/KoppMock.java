package no.hvl.dat109.tests;

import no.hvl.dat109.Kopp;

public class KoppMock extends Kopp {
    public KoppMock() {
        setSum(0);
    }

    @Override
    public void trill() {
        setSum(getSum()+1);
    }
}
