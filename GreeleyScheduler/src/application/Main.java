package application;

/**
 * @author yasgur99
 **/

import javax.swing.SwingUtilities;
import application.gui.UserInterface;
import application.logic.PDFParser;
import javax.swing.UIManager;
public class Main {

    public static void main(String[] args) throws Exception {
        /*Setup data*/
        PDFParser parser = new PDFParser("resources/master schedule 15-16 from IC.pdf");
        
        /*Set look and feel of gui*/
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        
        /*Create new UI and invoke it when possible*/
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }
}