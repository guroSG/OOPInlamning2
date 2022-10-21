import javax.swing.*;
import java.io.*;
import java.time.LocalDate;

public class FilSök {
    private LocalDate nuvarandeDatum = LocalDate.now();
    private String filnamnBesöksregister = "besöksregister.txt";

    public boolean hittaKund (String söktKund, boolean test){
        String rad;
        try (BufferedReader br = new BufferedReader(new FileReader("src/kunder"))) {
            while((rad = br.readLine()) != null){
                if (rad.contains(",")) {
                    int kommaPlats = rad.indexOf(',');
                    String personnummer = rad.substring(0, kommaPlats);
                    String namn = rad.substring(kommaPlats + 2);
                    if (personnummer.equals(söktKund) || namn.equalsIgnoreCase(söktKund)){
                        String datumSträng = br.readLine();
                        LocalDate datum = LocalDate.parse(datumSträng);
                        if (!test){
                        kollaMedlemsstatus(namn, datum, false);
                        registreraBesök(personnummer, namn, filnamnBesöksregister);}
                        return true;
                    }
                }
            }
            if (!test){
                JOptionPane.showMessageDialog(null, söktKund + " är ej medlem.");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Filen finns inte. Error: " + e);
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            e.printStackTrace();
        }
        return false;
    }

    public boolean kollaMedlemsstatus(String namn, LocalDate datum, boolean test){
        if (datum.isAfter(nuvarandeDatum.minusYears(1))){
            if (!test) {
                JOptionPane.showMessageDialog(null, namn + " är en nuvarande medlem. Senaste årsavgift betalades " + datum);
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
