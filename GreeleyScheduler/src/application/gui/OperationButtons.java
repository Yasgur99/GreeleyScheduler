package application.gui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author yasgur99
 *
 */
public class OperationButtons extends JPanel {

    private JRadioButton[] operationButtons;
    private ButtonGroup operationButtonGroup;
    private String type;

    public OperationButtons(String type) {
        super(new GridLayout(3, 1));
        this.type = type;
        this.operationButtonGroup = new ButtonGroup();
        this.operationButtons = new JRadioButton[2];
        createComponents();
    }

    private void createComponents() {

        JRadioButton add = new JRadioButton("Add " + type);
        add.setMnemonic(KeyEvent.VK_A);
        operationButtons[0] = add;

        JRadioButton remove = new JRadioButton("Remove " + type);
        remove.setMnemonic(KeyEvent.VK_R);
        operationButtons[1] = remove;

        operationButtonGroup.add(add);
        operationButtonGroup.add(remove);

        add(add);
        add(remove);
    }

    public JRadioButton[] getOperationButtons() {
        return operationButtons;
    }

    public ButtonGroup getOperationButtonGroup() {
        return operationButtonGroup;
    }
    
    
}
