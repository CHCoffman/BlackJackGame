package blackjack.view;
import blackjack.view.BlackjackCardView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;

/**
 * A GUI component for a card in a blackjack game
 */
public class BlackjackCardComponent extends JLabel {
    private BlackjackCardView m_curView = null;

    /**
     * A GUI Component that acts is used for displaying a card
     * @param view The component's card to display
     */
    public BlackjackCardComponent(BlackjackCardView view) {
        super();
        m_curView = view;
        setIcon(new ImageIcon(m_curView.GetImage()));
    }

    /**
     * Gets a view of the current blackjack card represented by the component
     * @return A view of the current blackjack card
     */
    public BlackjackCardView GetView() { return m_curView; }

    /**
     * Sets the current blackjack card view managed by the component
     * @param v The blackjack card view to use
     */
    public void SetView(BlackjackCardView v) { m_curView = v; }
}
