import javax.swing.*;
import java.io.*;
import java.time.LocalDate;

public class FilSök {

    public void hittaKund (String söktKund){
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
                            if (!rad.isBlank()){
                                bw.newLine();
                            }
                        }
                        System.out.println(datum);
                        if (datum.isAfter(nuvarandeDatum.minusYears(1))){
                            JOptionPane.showMessageDialog(null, "Nuvarande medlem.");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Tidigare medlem.");
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Filen finns inte. Error: " + e);
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Filen finns inte. Error: " + e);
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Ej medlem.");
    }
}
