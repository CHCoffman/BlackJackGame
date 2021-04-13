package blackjack.Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import blackjack.model.Card;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class ModelTests {
	
	Card card = new Card(5, "clubs");

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Before
	public void setUp() throws Exception 
	{		
	}
	
	@Test
	public void testCardCreated() throws Exception{
		assertNotNull(card);
	}
	@After
	public void tearDown() throws Exception 
	{
		card = null;
		System.gc();
	}


}
