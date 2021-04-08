package blackjack.view;
import blackjack.view.guiUtils.ImageActionComponent;

import java.awt.*;

public class BlackjackCardView {
    private static final String FilePathBase = "Resources\\Cards\\PNG\\";
    public enum CardSuite {
        CLUBS,
        SPADES,
        DIAMONDS,
        HEARTS,
    }
    private ImageActionComponent m_displayComponent;

    public BlackjackCardView(int num, CardSuite suite) {
        assert num < 14 && num > 0;
        char fileCardID = '\0';
        char fileCardNum = '0';
        switch(suite) {
            case CLUBS: fileCardID = 'C'; break;
            case SPADES: fileCardID = 'S'; break;
            case HEARTS: fileCardID = 'H'; break;
            case DIAMONDS: fileCardID = 'D'; break;
            default: assert false; break;
        }
        if(num > 10 || num == 1) {
            switch(num) {
                case 1: fileCardNum = 'A'; break;
                case 11: fileCardNum = 'J'; break;
                case 12: fileCardNum = 'Q'; break;
                case 13: fileCardNum = 'K'; break;
            }
        }
        else {
            fileCardNum = Character.forDigit(num, 10);
        }
        String cardImgSrcPath = FilePathBase + fileCardNum + fileCardID + ".png";
        m_displayComponent = new ImageActionComponent(cardImgSrcPath, new Dimension(100, 150));
    }
    ImageActionComponent GetComponent() { return m_displayComponent; }
}
