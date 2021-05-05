package blackjack.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import blackjack.model.Game;

class GameTest {
	
	Game game = new Game();
	@Before
	public void setUp() throws Exception 
	{
	}
	@Test
	public void testGameCreated() throws Exception{
		assertNotNull(game);
		assertNotNull(game.GetState());
	}
	
	@After
	public void tearDown() throws Exception 
	{
		game = null;
		System.gc();
	}
}
