import javax.swing.*;

public class Huvudprogram {

    Huvudprogram() {

    Filsökare fs = new Filsökare();
        while(true) {
            String inmatning = JOptionPane.showInputDialog("Ange kundens namn eller personnummer.");
            if (inmatning == null) {
                break;
            }
            fs.hittaKund(inmatning, false);
        }
    }
}
