package history;

import java.time.LocalDateTime;
import java.util.Scanner;

public class HistoryMain {

	public static void main(String[] args) {

		HistoryManager hm = new HistoryManager();
		Scanner sc = new Scanner(System.in);
		
		//테스트용 데이터
		
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
