package blackjack.Test;
import blackjack.view.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;

public class BlackjackCardDataTest {
    BlackjackCardData testCase = new BlackjackCardData(1, BlackjackCardData.CardSuite.HEARTS);
    @Before
    public void InitializeDataStore() {
        BlackjackDeckDataStore.Initialize();
    }
    @Test
    public void TestScaleBase() {
        assertNotNull(testCase.GetScaledInstance(new Dimension(1, 1)));
    }
    @Test
    public void TestScaleNegative() {
        Image output = testCase.GetScaledInstance(new Dimension(-1, -1));
        output.flush();
        int width = output.getWidth(new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return true;
            }
        });
        int height = output.getHeight(new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return true;
            }
        });
        assertEquals(1, width);
        assertEquals(1, height);
    }
    @Test
    public void TestScaleMax() {
        Image output = testCase.GetScaledInstance(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        output.flush();
        int width = output.getWidth(new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return true;
            }
        });
        int height = output.getHeight(new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return true;
            }
        });
        assertEquals(1, width);
        assertEquals(1, height);
    }
}
