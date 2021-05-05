package blackjack.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import blackjack.model.Card;
import blackjack.model.Deck;
import blackjack.model.Hand;

class HandTest {

	Hand hand = new Hand();
	Deck deck = new Deck();
	
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
		assertNotNull(hand.sumValues(0));
	}	
	@Test
	public void testDisplay() throws Exception{
		hand.display();
	}	
	@Test
	public void testGetHand() throws Exception{
		ArrayList<Card> hand2 = hand.getHand();
		assertNotNull(hand2);
	}	
	@Test
	public void testHit() throws Exception{
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		hand1.hit(deck);
		assertNotEquals(hand2, hand1);
	}	
	@After
	public void tearDown() throws Exception 
	{
		hand = null;
		System.gc();
	}
}
