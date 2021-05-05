package blackjack.Test;

import blackjack.view.BlackjackControllerPanel;
import blackjack.view.BlackjackDeckDataStore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BlackjackControllerPanelTests {
    BlackjackControllerPanel panel = new BlackjackControllerPanel(null);
    @BeforeAll
    public static void InitTests() {
        BlackjackDeckDataStore.Initialize();
    }
    @Test
    public void TestMinimum() {
        panel.UpdateDealerTotal(5);
        panel.UpdatePlayerTotal(5);
    }
}
