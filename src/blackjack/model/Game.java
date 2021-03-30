package blackjack.model;

public class Game {
    public Game() {
        // Initialize game state
        Player = 0;
        Dealer = 0;
    }
    public void OnEvent() { // Event e
        // Update game state
        Player++;
        Dealer++;
    }
    // Make these Users
    private int Player;
    private int Dealer;
}
