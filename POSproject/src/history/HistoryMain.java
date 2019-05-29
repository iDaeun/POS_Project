package history;

import java.time.LocalDateTime;
import java.util.Scanner;

public class HistoryMain {

	public static void main(String[] args) {

		HistoryManager hm = new HistoryManager();
		Scanner sc = new Scanner(System.in);
		
		//테스트용 데이터
		hm.insertHistory(1, LocalDateTime.now().minusDays(1), "멸추김밥", 2, 6000, "geust");
		hm.insertHistory(2, LocalDateTime.now().minusDays(1).plusHours(1).plusMinutes(30), "메롱김밥", 1, 7000, "aef01");
		hm.insertHistory(2, LocalDateTime.now().minusDays(1).plusHours(2).plusMinutes(30), "또잉김밥", 2, 11000, "aef01");
		hm.insertHistory(3, LocalDateTime.now().minusDays(1).plusHours(3).plusMinutes(30), "메롱김밥", 5, 35000, "aef01");
		hm.insertHistory(4, LocalDateTime.now().plusHours(2), "파김밥", 4, 10500, "cotton");
		hm.insertHistory(5, LocalDateTime.now().plusDays(1), "야채김밥", 9, 26000, "myym");
		hm.insertHistory(6, LocalDateTime.now().plusDays(2).plusHours(1).plusMinutes(30), "그냥김밥", 1, 3000, "geust");
		hm.insertHistory(7, LocalDateTime.now().plusMonths(1), "그냥김밥", 1, 3000, "cotton");
		hm.insertHistory(8, LocalDateTime.now().plusMonths(1).plusDays(2).plusHours(1).plusMinutes(30), "묨용김밥", 5, 13000, "geust");
		hm.insertHistory(9, LocalDateTime.now().plusMonths(1).plusDays(3).plusHours(10).plusMinutes(13), "피자김밥", 1, 3000, "geust");
		
		while (true) {
			int choice = hm.printMenu();

			switch (choice) {
			case 1:
				hm.showTodayHistory();
				break;
			case 2:
				hm.showDayHistory();
				break;
			case 3:
				hm.showMonthHistory();
				break;
			case 4:
				hm.showMemberHistory();
				break;
			case 5:
				hm.showHistoryAll();
				break;
			case 6:
				hm.makeDailyHistory("20190528");
				break;

			default:
				break;
			}
		}

	}



}
