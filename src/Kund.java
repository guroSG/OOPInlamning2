import java.time.LocalDate;

public class Kund {
    String namn;
    String personnummer;
    LocalDate senasteÅrsavgift;

    public void setSenasteÅrsavgift(LocalDate senasteÅrsavgift) {
        this.senasteÅrsavgift = senasteÅrsavgift;
    }

    public String getNamn() {
        return namn;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public Kund(String namn, String personnummer) {
        this.namn = namn;
        this.personnummer = personnummer;
        this.senasteÅrsavgift = senasteÅrsavgift;
    }
}
