import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {
	ArrayList<Card> hand = new ArrayList<Card>();
	String[] royals = {"J", "Q", "K"};
	List<String> rList = Arrays.asList(royals);
	int sum;
	
	public void hit(Deck deck) {
		
	}
	
	public int sumValues() {
		sum = 0;
		for(Card c : hand) {
			if(rList.contains(c.getValue())) 
				sum += 10;
			else
				sum += Integer.valueOf(c.getValue());
		}
		return sum;
	}
}
