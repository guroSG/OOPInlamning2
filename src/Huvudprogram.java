import javax.swing.*;

public class Huvudprogram {

    Huvudprogram() {

    FilSök fs = new FilSök();
        while(true) {
            String inmatning = JOptionPane.showInputDialog("Skriv in kundens namn eller personnummer.");
            if (inmatning == null) {
                break;
            }
            fs.hittaKund(inmatning, false);
        }
    }
}
