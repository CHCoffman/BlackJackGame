package blackjack.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


	@RunWith(Suite.class)
	@SuiteClasses({
	        CardTest.class,
	        DeckTest.class,
	        HandTest.class,
	        GameTest.class,
	        //UserTest.class,
	        })

	public class CombinedTest {	
	}
