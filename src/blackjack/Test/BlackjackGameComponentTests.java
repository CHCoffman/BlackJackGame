package blackjack.Test;

import blackjack.model.Card;
import blackjack.view.BlackjackDeckDataStore;
import blackjack.view.BlackjackGameComponent;
import blackjack.view.GameState;
import blackjack.view.ViewExceptions.BlackjackGUIException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BlackjackGameComponentTests {
    BlackjackGameComponent component = new BlackjackGameComponent();
    ArrayList<Card> MakeHand(int size) {
        ArrayList<Card> hand = new ArrayList<Card>(size);
        for(int i = 0; i < size; i ++) {
            hand.add(new Card("A", "Clubs"));
        }
        return hand;
    }
    @BeforeAll
    public static void InitTests() {
        BlackjackDeckDataStore.Initialize();
    }
    @Test
    public void TestMinimum() {
        GameState state = new GameState(MakeHand(5), MakeHand(5), 14, 24);
        try {
            component.UpdateViewComponent(state);
        }
        catch(BlackjackGUIException e) {
            assert false;
        }
    }
    @Test void TestEmptyHands() {
        GameState state = new GameState(MakeHand(0), MakeHand(0), 0, 0);
        try {
            component.UpdateViewComponent(state);
        }
        catch(BlackjackGUIException e) {
            assert false;
        }
    }
    @Test void TestHandOverflow() {
        // Only use 200k here to avoid allocating too much memory in the helper function
        GameState state = new GameState(MakeHand(200000), MakeHand(200000), 0, 0);
        try {
            component.UpdateViewComponent(state);
        }
        catch(BlackjackGUIException e) {
            assert false;
        }
    }
}
