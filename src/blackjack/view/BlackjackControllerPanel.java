package blackjack.view;

import blackjack.model.AbstractModel;
import blackjack.model.Model;
import blackjack.model.ModelEvent;
import blackjack.model.ModelListener;
import org.junit.jupiter.params.provider.EnumSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A GUI component for blackjack controls
 */
public class BlackjackControllerPanel extends AbstractModel {
    private static final String dealerTotalBase = "Dealer Total:";
    private static final String userTotalBase = "Player Total:";
    private JButton m_hitButton = new JButton("Hit");
    private JButton m_standButtton = new JButton("Stand");
    private JButton m_splitButton = new JButton("Split");
    private JButton m_foldButton=  new JButton("Fold");
    private JLabel m_userTotal = new JLabel(userTotalBase);
    private JLabel m_dealerTotal = new JLabel(dealerTotalBase);
    private JPanel m_panel = new JPanel();
    private ModelEvent m_lastEvent = null;

    /**
     * A GUI component for blackjack controls
     * @param listener The listener to update when the controls are used
     */
    public BlackjackControllerPanel(ModelListener listener) {
        m_panel.setLayout(new GridLayout(6, 1));
        m_panel.add(m_dealerTotal);
        m_panel.add(m_userTotal);
        m_panel.add(m_hitButton);
        m_panel.add(m_standButtton);
        m_panel.add(m_splitButton);
        m_panel.add(m_foldButton);
        addModelListener(listener);

        m_hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Send event to model
                notifyChanged(new ModelEvent(ModelEvent.EventType.HIT));
            }
        });
        m_standButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Send event to model
                notifyChanged(new ModelEvent(ModelEvent.EventType.STAND));
            }
        });
        m_splitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyChanged(new ModelEvent(ModelEvent.EventType.SPLIT));
            }
        });
        m_foldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyChanged(new ModelEvent(ModelEvent.EventType.FOLD));
            }
        });
    }

    /**
     * Gets the java swing JPanel component managed by the controller panel
     * @return The java swing JPanel component
     */
    public JPanel GetPanel() { return m_panel; }

    /**
     * Updates the player total JLabel text with a new score
     * @param newTotal The score to set for the player
     */
    public void UpdatePlayerTotal(int newTotal) {
        m_userTotal.setText(userTotalBase + " " + Integer.toString(newTotal));
    }

    /**
     * Updates the dealer total JLabel text with a new score
     * @param newTotal The score to set for the dealer
     */
    public void UpdateDealerTotal(int newTotal) {
        m_dealerTotal.setText(dealerTotalBase + " " + Integer.toString(newTotal));
    }
}
