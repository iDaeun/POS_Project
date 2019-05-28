package payHistory;


public class MonthHistory {

	String month;
	DateHistory[] dateHistoryArr = new DateHistory[31];
	
	public MonthHistory(String month, DateHistory[] dateHistoryArr) {
		this.month = month;
		this.dateHistoryArr = dateHistoryArr;
	}
	
	

}
