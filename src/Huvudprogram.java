import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Huvudprogram {

    Huvudprogram() {

    FilSök fs = new FilSök();
        while(true) {
            String inmatning = JOptionPane.showInputDialog("Skriv in kundens namn eller personnummer.");
            if (inmatning == null) {
                break;
            }
            fs.hittaKund(inmatning);
        }
    }
}
