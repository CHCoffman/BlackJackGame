package blackjack.Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import blackjack.model.Card;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class CardTest {
	
	Card card = new Card("5", "clubs");


	@Before
	public void setUp() throws Exception 
	{	
		Card card;
	}
	
	@Test
	public void testCardCreated() throws Exception{
		assertNotNull(card);
	}
	
	@Test
	public void testCardValue() throws Exception{
		assertEquals(card.getValue(), 5);
	}
	
	@Test
	public void testCardSuit() throws Exception{
		assertEquals(card.getSuit(), "clubs");
	}
	
	@After
	public void tearDown() throws Exception 
	{
		card = null;
		System.gc();
	}


}
