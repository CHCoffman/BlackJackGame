package blackjack.view;

import java.awt.*;
import java.awt.image.ImageObserver;

public class BlackjackCardView {
    private Image m_data = null;
    private int m_cardNumber = -1;
    private Dimension m_viewDimensions = new Dimension();
    private BlackjackCardData.CardSuite m_suite = BlackjackCardData.CardSuite.INVALID;
    public BlackjackCardView(Image image, int num, BlackjackCardData.CardSuite suite) {
        m_data = image;
        m_cardNumber = num;
        m_suite = suite;
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
    public Image GetImage() { return m_data; }
    public Dimension GetDimensions() { return m_viewDimensions; }
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
        return String.valueOf(m_cardNumber) + " of " + m_suite.name();
    }
}
