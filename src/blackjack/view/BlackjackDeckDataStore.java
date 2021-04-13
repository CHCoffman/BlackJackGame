package blackjack.view;
import blackjack.view.BlackjackCardData;
import blackjack.view.ViewExceptions.BlackjackDeckDataStoreException;

import java.awt.*;

public class BlackjackDeckDataStore {
    private static BlackjackCardData[] m_cardData = new BlackjackCardData[53];
    private static final int SUITE_CLUBS_OFFSET = 0;
    private static final int SUITE_HEARTS_OFFSET = 13;
    private static final int SUITE_DIAMONDS_OFFSET = 26;
    private static final int SUITE_SPADES_OFFSET = 39;
    private static final int INVALID_CARD_INDEX = m_cardData.length-1;
    public static void Initialize() {
        GenerateData(BlackjackCardData.CardSuite.CLUBS);
        GenerateData(BlackjackCardData.CardSuite.HEARTS);
        GenerateData(BlackjackCardData.CardSuite.DIAMONDS);
        GenerateData(BlackjackCardData.CardSuite.SPADES);
        m_cardData[INVALID_CARD_INDEX] = new BlackjackCardData(-1, BlackjackCardData.CardSuite.INVALID);
    }
    private static void GenerateData(BlackjackCardData.CardSuite suite) {
        int offset = GetBufferOffsetOfSuite(suite);
        if(offset == -1) {
            // Throw exception
            return;
        }
        // Load images into buffer
        for(int i = 1; i < 14; i ++) {
            m_cardData[i + offset - 1] = new BlackjackCardData(i, suite);
        }
    }
    public static BlackjackCardView GetCard(BlackjackCardData.CardSuite suite, int num, Dimension viewDimensions) throws BlackjackDeckDataStoreException {
        int offset = GetBufferOffsetOfSuite(suite);
        int location = num + offset - 1;
        if(location < 0 || location >= 52 || offset == -1) {
            System.out.println("Invalid card " + num + " of " + suite.name() + " passed in BlackjackDeckDataStore.GetCard");
            return new BlackjackCardView(m_cardData[INVALID_CARD_INDEX].GetScaledInstance(viewDimensions), num, suite);
        }
        return new BlackjackCardView(m_cardData[num + GetBufferOffsetOfSuite(suite)-1].GetScaledInstance(viewDimensions), num, suite);
    }
    private static int GetBufferOffsetOfSuite(BlackjackCardData.CardSuite suite) {
        switch(suite) {
            case CLUBS: return SUITE_CLUBS_OFFSET;
            case HEARTS: return SUITE_HEARTS_OFFSET;
            case DIAMONDS: return SUITE_DIAMONDS_OFFSET;
            case SPADES: return SUITE_SPADES_OFFSET;
            default: return -1;
        }
    }
}
