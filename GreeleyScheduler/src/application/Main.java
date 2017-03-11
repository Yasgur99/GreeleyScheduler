package application;

/**
 * This class is responsible for spawning the GUI so it can take care of the program
 * 
 * @author yasgur99
 **/

import javax.swing.SwingUtilities;
import application.gui.UserInterface;
import application.logic.ExcelParser;
import application.logic.MasterSchedule;
import javax.swing.UIManager;

public class Main {

    /**
     * Initializes the GUI and leaves it up to the GUI to execute the application as intended
     * @param args
     * @throws Exception from setting the look and feel as the system look and feel
     */
    public static void main(String[] args) throws Exception{
        /*Set look and feel of gui*/
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        
        /*Create new UI and invoke it when possible*/
        UserInterface ui = new UserInterface();
        //SwingUtilities.invokeLater(ui);
        
        /*Setup data*/
        String[] filenames = {"resources/2016-2017 Art & Life Scheduling Projections.xlsx"};
        ExcelParser parser = new ExcelParser(filenames);
        
        /*Create Master Schedule with a population of 1000*/
        MasterSchedule schedule = new MasterSchedule(parser.getSections(), 1000);
        schedule.run();
    }
}
