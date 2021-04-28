package blackjack.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackjackControllerPanel extends JPanel {
    private static final String dealerTotalBase = "Dealer Total:";
    private static final String userTotalBase = "Player Total:";
    private JButton m_hitButton = new JButton("Hit");
    private JButton m_standButtton = new JButton("Stand");
    private JLabel m_userTotal = new JLabel(userTotalBase);
    private JLabel m_dealerTotal = new JLabel(dealerTotalBase);
    public BlackjackControllerPanel() {
        setLayout(new GridLayout(4, 1));
        add(m_dealerTotal);
        add(m_userTotal);
        add(m_hitButton);
        add(m_standButtton);

        m_hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Send event to model
                System.out.println("Hit");
            }
        });
        m_standButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Send event to model
                System.out.println("Stand");
            }
        });
    }
    public void UpdatePlayerTotal(int newTotal) {
        m_userTotal.setText(userTotalBase + " " + Integer.toString(newTotal));
    }
    public void UpdateDealerTotal(int newTotal) {
        m_dealerTotal.setText(dealerTotalBase + " " + Integer.toString(newTotal));
    }
}
