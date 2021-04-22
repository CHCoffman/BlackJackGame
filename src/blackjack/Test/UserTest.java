package blackjack.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import blackjack.model.User;

class UserTest {
	User user = new User();

	@Before
	public void setUp() throws Exception 
	{	
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
	@After
	public void tearDown() throws Exception 
	{
		System.gc();
	}
}
