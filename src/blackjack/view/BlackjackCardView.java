package blackjack.view;

import blackjack.model.Card;

import java.awt.*;
import java.awt.image.ImageObserver;

public class BlackjackCardView {
    private Image m_data = null;
    private Dimension m_viewDimensions = new Dimension();
    private Card m_card;

    /**
     * An alias for a BlackJackCardData's memory
     * @param image An Image representing the card, but not actually containing the card's data
     * @param card The card to create a view of
     */
    public BlackjackCardView(Image image, Card card) {
        m_data = image;
        m_card = card;
        m_viewDimensions.width = m_data.getWidth(new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return true;
            }
        });
        m_viewDimensions.height = m_data.getHeight(new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return true;
            }
        });
    }

    /**
     * Gets the Image of the view
     * @return The view's image
     */
    public Image GetImage() { return m_data; }

    /**
     * Gets the size of the view
     * @return The size of the view
     */
    public Dimension GetDimensions() { return m_viewDimensions; }

    /**
     * Scales the view to be a new size
     * @param d The new size of the view
     * @return If the scale was successful
     */
    public boolean Scale(Dimension d) {
        if(d.width <= 0 || d.height <= 0) {
            return false;
        }
        m_viewDimensions = d;
        m_data = m_data.getScaledInstance(d.width, d.height, Image.SCALE_FAST);
        return true;
    }
    @Override
    public String toString() {
        return m_card.toString();
    }
}
