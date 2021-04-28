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
    public Image GetScaledInstance(Dimension dimensions) {
        if(dimensions.width < 0 || dimensions.height < 0) {
            return m_baseImage.getScaledInstance(1, 1, Image.SCALE_FAST);
        }
        else if(dimensions.width > Math.sqrt(Integer.MAX_VALUE) || dimensions.height > Math.sqrt(Integer.MAX_VALUE)) {
            return m_baseImage.getScaledInstance(1, 1, Image.SCALE_FAST);
        }
        return m_baseImage.getScaledInstance(dimensions.width, dimensions.height, Image.SCALE_FAST);
    }
    private void LoadInvalidCard() {
        BufferedImage invalidImg = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        invalidImg.setRGB(0, 0, Color.MAGENTA.getRGB());
        m_baseImage = invalidImg;
    }
    private String ConvertCardToFilename(Card card) {
        return card.getValue() + ConvertSuitToFilePart(card.getSuit()) + ".png";
    }
    private String ConvertSuitToFilePart(String suit) {
        switch(suit) {
            case "Clubs": return "C";
            case "Hearts": return "H";
            case "Diamonds": return "D";
            case "Spades": return "S";
        }
        return "INVALID";
    }
    /*

    private String ConvertCardNumToString(int num) {
        if(num <= 0 || num >= 14) {
            return "";
        }
        if(num > 10 || num == 1) {
            switch(num) {
                case 1: return "A";
                case 11: return "J";
                case 12: return "Q";
                case 13: return "K";
            }
        }
        else {
            return String.valueOf(num);
        }
        return "";
    }
     */
}
