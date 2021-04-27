package blackjack.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
	public void testDeckCreated() throws Exception{
		assertNotNull(deck);
	}
	@Test
	public void testDisplay() throws Exception{
		Deck.Display();
		assertEquals(outputStreamCaptor.toString(), outputStreamCaptor.toString());
	}
	
	@After
	public void tearDown() throws Exception 
	{
		deck = null;
		System.gc();
	}

}
