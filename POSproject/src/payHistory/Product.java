package payHistory;

public class Product {
	String payItem;
	int totPayEa;
	long totPayAmount;
	
	public Product(String payItem, int totPayEa, long totPayAmount) {
		this.payItem = payItem;
		this.totPayEa = totPayEa;
		this.totPayAmount = totPayAmount;
	}
	
}
