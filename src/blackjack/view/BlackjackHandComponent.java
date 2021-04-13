package blackjack.view;

import blackjack.view.ViewExceptions.BlackjackDeckDataStoreException;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BlackjackHandComponent extends JPanel {
    private BlackjackCardComponent[] m_cards;
    private Dimension m_originalCardSize;
    private int m_curCardIndex = 0;
    public BlackjackHandComponent(int maxHandSize, Dimension cardSize) {
        m_cards = new BlackjackCardComponent[maxHandSize];
        m_originalCardSize = cardSize;
        setLayout(new GridLayout(1, maxHandSize));
        Dimension componentSize = new Dimension(
                (int)(m_originalCardSize.width * maxHandSize * 1.2),
                (int)(m_originalCardSize.height * 1.2));
        setMinimumSize(componentSize);
        setMaximumSize(componentSize);
        setPreferredSize(componentSize);
    }
    public boolean AddCard(int number, BlackjackCardData.CardSuite suite) {
        if(m_curCardIndex == m_cards.length) {
            return false;
        }
        try {
            BlackjackCardView v = BlackjackDeckDataStore.GetCard(suite, number, new Dimension(100, 150));
            BlackjackCardComponent cardComponent = new BlackjackCardComponent(v);
            int thisCardIndex = m_curCardIndex;
            m_cards[m_curCardIndex] = cardComponent;
            m_cards[m_curCardIndex].addMouseListener(new MouseListener() {
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
                    BlackjackCardView view = m_cards[thisCardIndex].GetView();
                    view.Scale(new Dimension((int)(view.GetDimensions().width * 1.2), (int)(view.GetDimensions().height * 1.2)));
                    m_cards[thisCardIndex].SetView(view);
                    m_cards[thisCardIndex].setIcon(new ImageIcon(view.GetImage()));
                    m_cards[thisCardIndex].setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    BlackjackCardView view  = m_cards[thisCardIndex].GetView();
                    view.Scale(m_originalCardSize);
                    m_cards[thisCardIndex].SetView(view);
                    m_cards[thisCardIndex].setIcon(new ImageIcon(view.GetImage()));
                    m_cards[thisCardIndex].setBorder(BorderFactory.createEmptyBorder());
                }
            });

            add(cardComponent);
            m_curCardIndex++;
            return true;
        }
        catch(BlackjackDeckDataStoreException e) {
            add(new BlackjackCardComponent(BlackjackDeckDataStore.GetInvalidCard(new Dimension(100, 150))));
            return false;
        }
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
                m_originalCardSize = view.GetDimensions();
                view.Scale(new Dimension((int)(view.GetDimensions().width * 1.2), (int)(view.GetDimensions().height * 1.2)));
                m_cards[index].SetView(view);
                m_cards[index].setIcon(new ImageIcon(view.GetImage()));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                BlackjackCardView view  = m_cards[index].GetView();
                view.Scale(m_originalCardSize);
                m_cards[index].SetView(view);
                m_cards[index].setIcon(new ImageIcon(view.GetImage()));
            }
        });
        add(m_cards[index]);
    }
}
