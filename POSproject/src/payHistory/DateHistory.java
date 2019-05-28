package payHistory;

import java.util.ArrayList;

public class DateHistory {

	String date;
	ArrayList<Product> product = new ArrayList<Product>();

	public DateHistory(String date, ArrayList<Product> product) {
		this.date = date;
		this.product = product;
	}
}
