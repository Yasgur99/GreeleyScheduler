package application;
/**
 * @author yasgur99
 **/

import javax.swing.SwingUtilities;
import application.gui.UserInterface;

public class Main {

    public static void main(String[] args) {
        //Create new UI and invoke it when possible
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }
}