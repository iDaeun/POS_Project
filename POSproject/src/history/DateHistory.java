package history;

import java.util.HashMap;

public class DateHistory {

	String date;
	HashMap<String, Product> productMap = new HashMap<>();

	public DateHistory(String date) {
		this.date = date;
	}

}
