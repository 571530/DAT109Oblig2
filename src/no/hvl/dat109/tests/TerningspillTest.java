package no.hvl.dat109.tests;

import no.hvl.dat109.Spiller;
import no.hvl.dat109.Terningspill;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TerningspillTest {

    @Test
    public void finnVinnerTest() {
        Terningspill spill = new Terningspill();
        Spiller spiller1 = new Spiller("1");
        Spiller spiller2 = new Spiller("2");
        spiller1.setVerdi(5);
        spiller2.setVerdi(4);

        ArrayList<Spiller> spillere = new ArrayList<>();
        spillere.add(spiller1);
        spillere.add(spiller2);

        spill.setSpillere(spillere);

        assert(spiller1.equals(spill.finnVinner()));

        spiller2.setVerdi(6);

        assert(spiller2.equals(spill.finnVinner()));
    }

    @Test
    public void finnVinnerUavgjortTest() {
        Terningspill spill = new Terningspill();
        Spiller spiller1 = new Spiller("1");
        Spiller spiller2 = new Spiller("2");
        spiller1.setVerdi(7);
        spiller2.setVerdi(7);

        ArrayList<Spiller> spillere = new ArrayList<>();
        spillere.add(spiller1);
        spillere.add(spiller2);

        spill.setSpillere(spillere);
        spill.setKopp(new KoppMock());

        // Kopp mock øker verdien med 1 hver gang den brukes så spiller2 er forventet vinner
        assert(spill.finnVinner().equals(spiller2));
    }

}
