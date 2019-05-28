package payHistory;

public class Product {
	String date;
	String payItem;
	int totPayEa;
	long totPayAmount;
	
	public Product(String date, String payItem, int totPayEa, long totPayAmount) {

		this.date = date;
		this.payItem = payItem;
		this.totPayEa = totPayEa;
		this.totPayAmount = totPayAmount;
	}
	
}
