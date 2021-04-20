package blackjack.Test;
import blackjack.view.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class BlackjackCardDataStoreTest {
    @BeforeAll
    public static void TestInitializer() {
        BlackjackDeckDataStore.Initialize();
    }
    @Test
    public void TestInvalidCardBase() {
        BlackjackCardView view = BlackjackDeckDataStore.GetInvalidCard(new Dimension(1, 1));
        assertNotNull(view);
        assertEquals(1, view.GetDimensions().width);
        assertEquals(1, view.GetDimensions().height);
    }
    @Test
    public void TestInvalidCardNegativeSize() {
        BlackjackCardView view = BlackjackDeckDataStore.GetInvalidCard(new Dimension(-1, -1));
        assertNotNull(view);
        assertEquals(1, view.GetDimensions().width);
        assertEquals(1, view.GetDimensions().height);
    }
    @Test
    public void TestInvalidCardMaxSize() {
        BlackjackCardView view = BlackjackDeckDataStore.GetInvalidCard(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertNotNull(view);
        assertEquals(1, view.GetDimensions().width);
        assertEquals(1, view.GetDimensions().height);
    }
    @Test
    public void TestCardNumberBase() {
        BlackjackCardView view = BlackjackDeckDataStore.GetCard(BlackjackCardData.CardSuite.HEARTS, 1, new Dimension(1, 1));
        assertNotNull(view);
    }
    @Test
    public void TestCardNumberNegative() {
        BlackjackCardView view = BlackjackDeckDataStore.GetCard(BlackjackCardData.CardSuite.HEARTS, -1, new Dimension(1, 1));
        assertNotNull(view);
    }
    @Test
    public void TestCardNumberMax() {
        BlackjackCardView view = BlackjackDeckDataStore.GetCard(BlackjackCardData.CardSuite.HEARTS, Integer.MAX_VALUE, new Dimension(1, 1));
        assertNotNull(view);
    }
}
