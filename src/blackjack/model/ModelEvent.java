package blackjack.model;

public class ModelEvent {
	public enum EventKind {
		BalanceUpdate, AgentStatusUpdate
	}
	private EventKind kind;
	private double balance;
	public ModelEvent(EventKind kind, double balance){
		this.balance = balance;
		this.kind = kind;
	}
	public EventKind getKind(){return kind;}
	public double getBalance(){
		return balance;
	}
	
}