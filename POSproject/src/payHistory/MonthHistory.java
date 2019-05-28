package payHistory;


public class MonthHistory {

	String month;
	DateHistory[] oneMonthHistory = new DateHistory[31];
	
	public MonthHistory(String month, DateHistory[] oneMonthHistory) {
		this.month = month;
		this.oneMonthHistory = oneMonthHistory;
	}
	
	

}
