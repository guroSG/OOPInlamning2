import javax.swing.*;
import java.io.*;
import java.time.LocalDate;

public class Filsökare {

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
                        Kundbearbetare kb = new Kundbearbetare();
                        kb.kollaMedlemsstatus(personnummer, namn, datum, false);
                        }
                        return true;
                    }
                }
            }
            if (!test) {
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
}
