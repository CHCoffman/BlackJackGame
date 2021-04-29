package blackjack.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import blackjack.model.Hand;

class HandTest {

	Hand hand = new Hand();
	
	@Before
	public void setUp() throws Exception 
	{	
	}
	@Test
	public void testHandCreated() throws Exception{
		assertNotNull(hand);
	}
	@Test
	public void testSumValues() throws Exception{
		assertNotNull(hand.sumValues());
	}	
	@After
	public void tearDown() throws Exception 
	{
		hand = null;
		System.gc();
	}
}
