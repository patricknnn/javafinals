import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI for Soccer League
 * @author Patrick Niewold
 * @version 1.0
 */
public class GUI {
    private JPanel panelMain;
    private Main m = new Main();
    private JButton Test;

    private GUI() {
        Test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, m.Test());
            }
        });
    }

    /**
     * Entry point for the prison program, starts the GUI
     * @param args arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Soccer league");
        frame.setContentPane(new GUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
