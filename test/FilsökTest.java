
import junit.framework.TestCase;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class FilsökTest extends TestCase {

    private boolean test = true;
    private Filsökare fs = new Filsökare();
    private Kundbearbetare kb = new Kundbearbetare();

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
        assert(kb.kollaMedlemsstatus(testNamn, testDatumNuvarandeMedlem, test));
        assert(!kb.kollaMedlemsstatus(testNamn, testDatumFöreDettaMedlem, test));

    }
    public void testRegistreraBesök() {
        String testNamn = "Anon Anonsson";
        String testPersonnummer = "9811011234";
        LocalDate testDagensDatum = LocalDate.now();
        String testFilnamn = "test/testBesökregister.txt";
        Path testFilPath = Path.of("test/testBesökregister.txt");
        try {
            Files.deleteIfExists(testFilPath);
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        kb.registreraBesök(testNamn, testPersonnummer, testFilnamn);
        try {
            String testLäsRegister = Files.readAllLines(testFilPath).toString();
            assert(testLäsRegister.contains(testNamn));
            assert(testLäsRegister.contains(testPersonnummer));
            assert(testLäsRegister.contains(testDagensDatum.toString()));
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
}
