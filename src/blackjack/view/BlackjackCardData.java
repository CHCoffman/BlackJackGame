package blackjack.view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import blackjack.model.Card;
public class BlackjackCardData {
    private static final String FilePathBase = "Resources\\Cards\\PNG\\";
    private Card m_cardBase;
    private Image m_baseImage = null;

    /**
     * BlackjackCardData creates storage for a given card
     * @param card The card to create storage for
     */
    public BlackjackCardData(Card card) {
        m_cardBase = card;
        String fileSourcePath = FilePathBase + ConvertCardToFilename(card);
        try {
            if(m_cardBase.getSuit().equals("INVALID")) {
                LoadInvalidCard();
            }
            else {
                m_baseImage = ImageIO.read(new File(fileSourcePath));
            }
        }
        catch (IOException e) {
            System.out.println("Failed to load file \"" + fileSourcePath + "\". File does not exist");
            LoadInvalidCard();
        }
    }

    /**
     * Gets a scaled representation of the card data
     * @param dimensions The size of the card to scale it to
     * @return A scaled version of the card
     */
    public Image GetScaledInstance(Dimension dimensions) {
        if(dimensions.width < 0 || dimensions.height < 0) {
            return m_baseImage.getScaledInstance(1, 1, Image.SCALE_FAST);
        }
        else if(dimensions.width > Math.sqrt(Integer.MAX_VALUE) || dimensions.height > Math.sqrt(Integer.MAX_VALUE)) {
            return m_baseImage.getScaledInstance(1, 1, Image.SCALE_FAST);
        }
        return m_baseImage.getScaledInstance(dimensions.width, dimensions.height, Image.SCALE_FAST);
    }

    /**
     * Set the card's data to be invalid. This is called when any of the BlackJackCardData's accessors fail
     */
    private void LoadInvalidCard() {
        BufferedImage invalidImg = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        invalidImg.setRGB(0, 0, Color.MAGENTA.getRGB());
        m_baseImage = invalidImg;
    }

    /**
     * Converts a card to a relative path to it's associated resource
     * @param card The card to build a filepath for
     * @return A Path to the card's resource
     */
    private String ConvertCardToFilename(Card card) {
        return card.getValue() + ConvertSuitToFilePart(card.getSuit()) + ".png";
    }

    /**
     * Converts a card's suit into the expected format for it's resource
     * @param suit The suite to convert
     * @return A string of length one of the first letter of the suit, and INVALID if the suit is not recognized.
     * E.g Clubs will return C, Cubs will return INVALID
     */
    private String ConvertSuitToFilePart(String suit) {
        switch(suit) {
            case "Clubs": return "C";
            case "Hearts": return "H";
            case "Diamonds": return "D";
            case "Spades": return "S";
        }
        return "INVALID";
    }
}
