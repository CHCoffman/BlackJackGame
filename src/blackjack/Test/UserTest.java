package blackjack.Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import blackjack.model.Card;
import blackjack.model.User;

// TODO need to test User once it is set up
class UserTest {
	Card card = new Card("5", "aces");
	User user ;

	@Before
	public void setUp() throws Exception 
	{		
		User user = new User(card);
	}
	@Test
	public void testUserCreated() throws Exception{
		
		assertNotNull(user);
	}
	@Test
	public void testFold() throws Exception{
		User.fold();
	}
	@Test
	public void testStand() throws Exception{
		user.stand();
		assertEquals(0,0);
	}
	@Test
	public void testAddWins() throws Exception{
		assertEquals(0, user.getWins());
		user.addWins();
		assertEquals(1, user.getWins());
	}
	@Test
	public void testSplit() throws Exception{
		user.split(3);
		assertEquals(0,0);
	}
	@Test
	public void testDetermineWin() throws Exception{
		//TODO test handsum 21, dealer 21, user less than or above
	}
	@After
	public void tearDown() throws Exception 
	{
		user = null;
		System.gc();
	}

}
