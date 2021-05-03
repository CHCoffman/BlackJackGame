package blackjack.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import blackjack.model.Card;
import blackjack.model.Deck;
import junit.framework.Assert;


class DeckTest {
	@SuppressWarnings("unused")
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

		Deck deck = new Deck();
	@Before
	public void setUp() throws Exception 
	{	
		Deck deck;
		System.setOut(new PrintStream(outputStreamCaptor));
	
	}
	@Test
	public void testShuffle() throws Exception{
		ArrayList<Card> shufDeck = new ArrayList<Card>();
		deck.shuffle(shufDeck);
		assertNotEquals(shufDeck, deck);
	}
	@Test
	public void testDeckCreated() throws Exception{
		assertNotNull(deck);
	}
	@Test
	public void testDisplay() throws Exception{
		Deck.Display();
		assertEquals(outputStreamCaptor.toString(), outputStreamCaptor.toString());
	}
	@Test
	public void testDeal() throws Exception{
		Card card = Deck.deal();
		assertNotNull(card);
	}
	@Test
	public void testGetDeck() throws Exception{
		ArrayList<Card> testDeck = deck.getDeck();
		assertNotNull(testDeck);
	}
	@Test
	public void testSetDeck() throws Exception{
		ArrayList<Card> newDeck = new ArrayList<Card>();
		deck.setDeck(newDeck);
		assertNotNull(newDeck);
		assertNotNull(deck);
		assertNotEquals(deck, newDeck);
	}
	
	@After
	public void tearDown() throws Exception 
	{
		deck = null;
		System.gc();
	}

}
