package blackjack.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BlackjackHandComponent extends JPanel {
    private BlackjackCardComponent[] m_cards;
    private Dimension[] m_originalCardSizes;
    public BlackjackHandComponent(int maxHandSize) {
        m_cards = new BlackjackCardComponent[maxHandSize];
        m_originalCardSizes = new Dimension[maxHandSize];
        setLayout(new GridLayout(1, maxHandSize));
    }
    public void SetCard(BlackjackCardComponent v, int index) {
        if(m_cards[index] != null) {
            remove(m_cards[index]);
        }
        m_cards[index] = v;
        m_cards[index].setName(String.valueOf(index));
        m_cards[index].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                BlackjackCardView view = m_cards[index].GetView();
                m_originalCardSizes[index] = view.GetDimensions();
                view.Scale(new Dimension((int)(view.GetDimensions().width * 1.2), (int)(view.GetDimensions().height * 1.2)));
                m_cards[index].SetView(view);
                m_cards[index].setIcon(new ImageIcon(view.GetImage()));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                BlackjackCardView view  = m_cards[index].GetView();
                view.Scale(m_originalCardSizes[index]);
                m_cards[index].SetView(view);
                m_cards[index].setIcon(new ImageIcon(view.GetImage()));
            }
        });
        add(m_cards[index]);
    }
}
