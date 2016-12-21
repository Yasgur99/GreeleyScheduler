package application.gui;

/**
 * @author yasgur99
 *
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

    private JFrame frame;

    public UserInterface() {
    }

    /**
     * Setup Window: setup label, size, default close, packs, and sets frame visible
     * Parameters: none
     * Returns: nothing
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

    private void createComponents(Container container) {
    }

    /**
     * Get the root JFrame
     * Parameters: none
     * @return root JFrame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Create dimensions that are 2/3 the size of the screen
     * Parameters: none
     * @return a dimension that is 2/3 the size of the screen
     */
    private Dimension setScreenSize() {
        // get the screen size as a java dimension
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // get 2/3 of the height, and 2/3 of the width
        int height = screenSize.height * 2 / 3;
        int width = screenSize.width * 2 / 3;

        //Return Dimension based on set height and width
        return new Dimension(width, height);
    }
}
