package blackjack.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.junit.jupiter.api.Test;

@RunWith(Suite.class)
@SuiteClasses({
        CardTest.class,
        DeckTest.class,
        GameTest.class,
        HandTest.class,
        UserTest.class})

class CombinedTests {

}
