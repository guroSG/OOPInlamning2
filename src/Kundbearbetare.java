import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Kundbearbetare {
    private String filnamnBesöksregister = "besöksregister.txt";

    private LocalDate nuvarandeDatum = LocalDate.now();
    public boolean kollaMedlemsstatus(String personnummer, String namn, LocalDate datum, boolean test){
        if (datum.isAfter(nuvarandeDatum.minusYears(1))){
            if (!test) {
                JOptionPane.showMessageDialog(null, namn + " är en nuvarande medlem. Senaste årsavgift betalades " + datum);
                registreraBesök(personnummer, namn, filnamnBesöksregister);
            }
            return true;
        }
        else {
            if (!test) {
                JOptionPane.showMessageDialog(null, namn + " är en tidigare medlem. Senaste årsavgift betalades " + datum);
            }
        }
        return false;
    }
    public void registreraBesök(String personnummer, String namn, String filnamn){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filnamn, true))){
            bw.write(personnummer+  " " + namn + " " + "\n" + nuvarandeDatum+ "\n");
            bw.newLine();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            e.printStackTrace();
        }
    }
}
