import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilSök {

    public boolean hittaKund (String söktKund){
        String rad;
        try (BufferedReader br = new BufferedReader(new FileReader("src/kunder"))) {
            while((rad = br.readLine()) != null){
                if (rad.contains(",")) {
                    int kommaPlats = rad.indexOf(',');
                    String personNummer = rad.substring(0, kommaPlats);
                    String namn = rad.substring(kommaPlats + 2);
                    if (personNummer.equals(söktKund) || namn.equalsIgnoreCase(söktKund)){
                        String datumSträng = br.readLine();
                        LocalDate datum = LocalDate.parse(datumSträng);
                        LocalDate nuvarandeDatum = LocalDate.now();
                        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/besöksregister", true))){
                            bw.write(personNummer+  " " + namn + " " + "\n" + nuvarandeDatum+ "\n");
                            bw.newLine();
                        }
                        System.out.println(datum);
                        if (datum.isAfter(nuvarandeDatum.minusYears(1))){
                            JOptionPane.showMessageDialog(null, "Nuvarande medlem");
                            return true;
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Tidigare medlem");
                            return false;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Ej medlem");
        return false;
    }

    public boolean pung(String söktKund) {

        if (söktKund == "Anon Anonsson" || söktKund == "9811010000") {
            return false;
        } else {
            return true;
        }
    }
}
