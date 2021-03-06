package blackjack.view;
import blackjack.model.Card;
import blackjack.view.BlackjackCardData;
import blackjack.view.ViewExceptions.BlackjackDeckDataStoreException;

import java.awt.*;

/**
 * A static class that manages the memory for blackjack cards and handles the creation of card views
 */
public class BlackjackDeckDataStore {
    private static BlackjackCardData[] m_cardData = new BlackjackCardData[53];
    private static final int SUITE_CLUBS_OFFSET = 0;
    private static final int SUITE_HEARTS_OFFSET = 13;
    private static final int SUITE_DIAMONDS_OFFSET = 26;
    private static final int SUITE_SPADES_OFFSET = 39;
    private static final int INVALID_CARD_INDEX = m_cardData.length-1;

    /**
     * Initialize the data store with data loaded from Resources/Cards/PNG
     */
    public static void Initialize() {
        GenerateData("Clubs");
        GenerateData("Hearts");
        GenerateData("Diamonds");
        GenerateData("Spades");
        m_cardData[INVALID_CARD_INDEX] = new BlackjackCardData(new Card("INVALID", "INVALID"));
    }

    /**
     * Generate card data for a particular suite
     * @param suite The suite to generate data for
     */
    private static void GenerateData(String suite) {
        int offset = GetBufferOffsetOfSuite(suite);
        // Load images into buffer
        for(int i = 1; i < 14; i ++) {
            m_cardData[i + offset - 1] = new BlackjackCardData(new Card(GetCardValFromInt(i), suite));
        }
    }

    /**
     * Gets a view of the data store's invalid card
     * @param viewDimensions The size of the view
     * @return A view of the invalid card
     */
    public static BlackjackCardView GetInvalidCard(Dimension viewDimensions) {
        if(viewDimensions.width > Math.sqrt(Integer.MAX_VALUE) || viewDimensions.height > Math.sqrt(Integer.MAX_VALUE)) {
            System.out.println("Invalid dimensions " + viewDimensions.height + "x" + viewDimensions.height + " passed to GetInvalidCard");
            viewDimensions = new Dimension(1, 1);
        }
        return new BlackjackCardView(m_cardData[INVALID_CARD_INDEX].GetScaledInstance(viewDimensions), new Card("INVALID", "INVALID"));
    }

    /**
     * Creates a view of a specific card from the data store.
     * @param c The card to create a view for
     * @param viewDimensions The size of the view to create
     * @return A view of the specified card. This will be the invalid card if the card or dimensions are invalid
     */
    public static BlackjackCardView GetCard(Card c, Dimension viewDimensions) {
        int offset = GetBufferOffsetOfSuite(c.getSuit());
        int location = -1;
        try {
            location = Integer.parseInt(c.getValue()) + offset - 1;
        } catch(NumberFormatException e) {
            location = 1;
        }
        if(location < 0 || location >= 52 || offset == -1) {
            System.out.println("Invalid card " + c.getValue() + " of " + c.getSuit() + " passed in BlackjackDeckDataStore.GetCard");
            return GetInvalidCard(viewDimensions);
        }
        int index = GetIntFromCardVal(c.getValue()) + GetBufferOffsetOfSuite(c.getSuit())-1;
        if(index < 0 || index > 52) {
            return GetInvalidCard(viewDimensions);
        }
        return new BlackjackCardView(m_cardData[GetIntFromCardVal(c.getValue()) + GetBufferOffsetOfSuite(c.getSuit())-1].GetScaledInstance(viewDimensions), c);
    }

    /**
     * Gets the offset into the store's card buffer of a particular suite
     * @param suite The suite to get the offset for
     * @return The offset into the data store's buffer of the specified suite, and the maximum integer value if the suite
     * is invalid
     */
    private static int GetBufferOffsetOfSuite(String suite) {
        switch(suite) {
            case "Spades": return SUITE_SPADES_OFFSET;
            case "Clubs":   return SUITE_CLUBS_OFFSET;
            case "Diamonds": return SUITE_DIAMONDS_OFFSET;
            case "Hearts": return SUITE_HEARTS_OFFSET;
            default: return Integer.MAX_VALUE; // Force invalid card
        }
    }

    /**
     * Converts a string card value into the expected integer format
     * @param val The value to convert
     * @return An integer representation of the card value. A is 1, 2 is 2, and so on. Face cards continue this pattern
     * such that J is 11, Q is 12, and K is 13
     */
    private static int GetIntFromCardVal(String val) {
        switch(val) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "A": return 1;
        }
        return Integer.MAX_VALUE; // Force invalid card
    }

    /**
     * Convert's a card value's integer representation into a string
     * @param val The value to convert
     * @return A string representation of the integer card value. See GetIntFromCardVal
     */
    private static String GetCardValFromInt(int val) {
        if(val <= 10 && val > 1) {
            return Integer.toString(val);
        }
        switch(val) {
            case 1: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
        }
        return "INVALID";
    }
}
