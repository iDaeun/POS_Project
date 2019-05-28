


public class Product {
	String date;
	String payItem;
	int totPayEa;
	long totPayAmount;
	
	public Product() {

		this.date = "";
		this.payItem = "";
		this.totPayEa = 0;
		this.totPayAmount = 0;
	}
	
	public Product(String date, String payItem, int totPayEa, long totPayAmount) {

		this.date = date;
		this.payItem = payItem;
		this.totPayEa = totPayEa;
		this.totPayAmount = totPayAmount;
	}
	
}
