package application.gui;

/**
 * @author yasgur99
 *
 */
import application.logic.MasterSchedule;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

    private JFrame frame;
    private MasterSchedule schedule;

    public UserInterface() {
        this.schedule = new MasterSchedule();
    }

    /**
     * Setup Window: setup label, window size, default close method, and
     * displays window
     * Parameters: none
     * Returns: void
     *
     */
    @Override
    public void run() {
        frame = new JFrame("ProctAssign");
        frame.setPreferredSize(setScreenSize());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Adds interface components to JFrame's container
     * Parameters: container - our JFrame's container
     * Returns: void
     *
     */
    private void createComponents(Container container) {
        container.add(new MyTabbedPane(schedule));
    }

    /**
     * Get the root JFrame
     * Parameters: none
     * Returns: root JFrame
     *
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Create dimensions that has a length of 2/3 the size of the screen
     * and 4/7 the size of the height
     * Parameters: none
     * Returns: a dimension that has a length of 2/3 the size of the screen
     * and 4/7 the size of the height
     *
     */
    private Dimension setScreenSize() {
        // get the screen size as a java dimension
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // get 2/3 of the height, and 2/3 of the width
        int height = screenSize.height * 4 / 7;
        int width = screenSize.width * 2 / 3;

        //Return Dimension based on set height and width
        return new Dimension(width, height);
    }
}