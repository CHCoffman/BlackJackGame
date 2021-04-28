package blackjack.Test;
import blackjack.model.Card;
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
        BlackjackCardView view = BlackjackDeckDataStore.GetCard(new Card("2", "Hearts"), new Dimension(1, 1));
        assertNotNull(view);
    }
    @Test
    public void TestCardNumberNegative() {
        BlackjackCardView view = BlackjackDeckDataStore.GetCard(new Card("-1", "Hearts"), new Dimension(1, 1));
        assertNotNull(view);
    }
    @Test
    public void TestCardNumberMax() {
        BlackjackCardView view = BlackjackDeckDataStore.GetCard(new Card("999999999999999999999999", "Hearts"), new Dimension(1, 1));
        assertNotNull(view);
    }
    @Test
    public void TestInvalidSuit() {
        BlackjackCardView view = BlackjackDeckDataStore.GetCard(new Card("2", "a"), new Dimension(1, 1));
        assertNotNull(view);
    }
    @Test
    public void TestInvalidCard() {
        BlackjackCardView view = BlackjackDeckDataStore.GetCard(new Card("abcdef", "a"), new Dimension(1, 1));
        assertNotNull(view);
    }
}
