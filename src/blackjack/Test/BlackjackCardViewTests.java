package blackjack.Test;

import static org.junit.jupiter.api.Assertions.*;
import blackjack.view.BlackjackCardData;
import blackjack.view.BlackjackCardView;
import blackjack.view.BlackjackDeckDataStore;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class BlackjackCardViewTests {
    BlackjackCardView testView = BlackjackDeckDataStore.GetCard(BlackjackCardData.CardSuite.HEARTS, 1, new Dimension(100, 150));
    @BeforeClass
    public static void InitializeDataStore() {
        BlackjackDeckDataStore.Initialize();
    }
    @Test
    public void TestInitialized() {
        assertNotNull(testView);
    }
    @Test
    public void TestGetImage() {
        assertNotNull(testView.GetImage());
    }
    @Test
    public void TestViewDimensions() {
        assertEquals(testView.GetDimensions().width, 100);
        assertEquals(testView.GetDimensions().height, 150);
    }
}
