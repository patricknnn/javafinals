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
    private JButton leagueWinner;
    private JButton showLeagueResults;
    private JButton initializeLeague;
    private Boolean initialized = false;

    private GUI() {
        initializeLeague.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                m.initialize();
                initialized = true;
                initializeLeague.setEnabled(false);
                leagueWinner.setEnabled(true);
                showLeagueResults.setEnabled(true);
            }
        });
        leagueWinner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, m.showSingleLeagueWinner());
            }
        });
        showLeagueResults.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, m.showSingleLeagueResults());
            }
        });

        if (!this.initialized) {
            leagueWinner.setEnabled(false);
            showLeagueResults.setEnabled(false);
        } else {
            leagueWinner.setEnabled(true);
            showLeagueResults.setEnabled(true);
        }
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
