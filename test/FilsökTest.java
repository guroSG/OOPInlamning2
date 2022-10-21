
import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class FilsökTest extends TestCase {

    private boolean test = true;
    FilSök fs = new FilSök();

    @Test
    public void testHittaKund(){
    String testNamnFel = "Anon Anonsson";
    String testNamnRätt = "Greger Ganache";
    String testPersonnummerFel = "9811011234";
    String testPersonnummerRätt = "7703021234";

    assert(!fs.hittaKund(testNamnFel, test));
    assert(fs.hittaKund(testNamnRätt, test));
    assert(!fs.hittaKund(testPersonnummerFel, test));
    assert(fs.hittaKund(testPersonnummerRätt, test));
    }
    @Test
    public void testKollaMedlemsstatus(){
        LocalDate testDatumNuvarandeMedlem = LocalDate.now();
        LocalDate testDatumFöreDettaMedlem = LocalDate.now();
        String testNamn = "Anon Anonsson";
        testDatumNuvarandeMedlem = testDatumNuvarandeMedlem.minusMonths(11);
        testDatumFöreDettaMedlem = testDatumFöreDettaMedlem.minusYears(2);
        assert(fs.kollaMedlemsstatus(testNamn, testDatumNuvarandeMedlem, test));
        assert(!fs.kollaMedlemsstatus(testNamn, testDatumFöreDettaMedlem, test));

    }
    public void testRegistreraBesök() {
        String testNamn = "Anon Anonsson";
        String testPersonnummer = "9811011234";
        String testFilnamn = "test/testBesökregister.txt";
        LocalDate testDagensDatum = LocalDate.now();
        fs.registreraBesök(testNamn, testPersonnummer, testFilnamn);
        assert(1==1);
    }
}
