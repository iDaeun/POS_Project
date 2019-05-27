package payHistory;

import java.time.LocalDateTime;
import java.util.Scanner;

public class HistoryMainTest {

	public static void main(String[] args) {

		HistoryManager hm = new HistoryManager();
		Scanner sc = new Scanner(System.in);
		
		//테스트용 데이터
		hm.insertHistory(1, LocalDateTime.now().minusDays(1), "멸추김밥", 2, 6000, "geust");
		hm.insertHistory(2, LocalDateTime.now().minusDays(1).plusHours(1).plusMinutes(30), "메롱김밥", 1, 7000, "aef01");
		hm.insertHistory(2, LocalDateTime.now().minusDays(1).plusHours(1).plusMinutes(30), "또잉김밥", 2, 11000, "aef01");
		hm.insertHistory(3, LocalDateTime.now().plusHours(2), "파김밥", 4, 10500, "cotton");
		hm.insertHistory(4, LocalDateTime.now().plusDays(1), "야채김밥", 9, 26000, "myym");
		hm.insertHistory(5, LocalDateTime.now().plusDays(2).plusHours(1).plusMinutes(30), "그냥김밥", 1, 3000, "geust");
		hm.insertHistory(6, LocalDateTime.now().plusMonths(1), "그냥김밥", 1, 3000, "cotton");
		hm.insertHistory(7, LocalDateTime.now().plusMonths(1).plusDays(2).plusHours(1).plusMinutes(30), "묨용김밥", 5, 13000, "geust");
		
		while (true) {
			int choice = hm.printMenu();

			switch (choice) {
			//임폴트하면 간단히 쓸수있고 안하면 풀네임 써야함
			case 1:
				hm.showTodayHistory();
				break;
			case 2:
				hm.showDayHistory();
				break;
			case 3:
				System.out.println("월별 결제내역");
				break;
			case 4:
				hm.showMemberHistory();
				break;
			case 5:
				hm.showHistoryAll();
				break;

			default:
				break;
			}
		}

	}



}
