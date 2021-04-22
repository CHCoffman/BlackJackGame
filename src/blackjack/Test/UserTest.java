package blackjack.Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import blackjack.model.User;

// TODO need to test User once it is set up
class UserTest {
	User user = new User();

	@Before
	public void setUp() throws Exception 
	{		
		User user;
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
	public void testGetHand() throws Exception{
		//User.getHandSum(3);
	}
	@Test
	public void testStand() throws Exception{
		user.stand();
	}
	@Test
	public void testAddWins() throws Exception{
		user.addWins();
		assertEquals(1, user.getWins());
	}
	@Test
	public void testSplit() throws Exception{
		user.split(3);
	}
	@After
	public void tearDown() throws Exception 
	{
		System.gc();
	}

}
