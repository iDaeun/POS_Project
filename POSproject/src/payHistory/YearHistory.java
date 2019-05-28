package payHistory;


public class YearHistory {

	String year;
	MonthHistory[] oneYearHistory = new MonthHistory[12];
	
	public YearHistory(String year, MonthHistory[] oneYearHistory) {
		this.year = year;
		this.oneYearHistory = oneYearHistory;
	}
	

	
	

}
