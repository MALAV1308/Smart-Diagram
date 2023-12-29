package com.umldesign.view;
import com.umldesign.model.Status;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * The statuspanel is reponsible for displaying the current status of the system using the JLabel.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public class StatusPanel extends JPanel implements Observer {
    private JLabel statusLabel;
    /**
     * The StatusPanel constructor initializes the UI for statuspanel and adds the statusbar.
     */
    public StatusPanel(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1000,50));
        setBorder(new EmptyBorder(5,10,5,10));
        addStatusBar();
    }

    /**
     * The addStatusBar method adds the statusLabel to the UI panel.
     */
    private void addStatusBar(){
        statusLabel  = new JLabel();
        statusLabel.setText("Status Bar :");
        statusLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
        statusLabel.setHorizontalTextPosition(JLabel.LEFT);
        statusLabel.setVerticalAlignment(JLabel.CENTER);

        add(statusLabel, BorderLayout.WEST);
    }

    /**
     * The update method is used to set the status message of the status bar.
     *
     * @param o observable reference
     * @param arg argument reference
     */
    @Override
    public void update(Observable o, Object arg) {
        statusLabel.setText(Status.getInstance().getCurrentStatus());
    }
}
