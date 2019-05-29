package history;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import util.Util;

public class HistoryManager {

	// 해쉬를 이용하면 년도나 월 일 알아내기 쉬운가?
	ArrayList<History> arr = new ArrayList<History>();

	DateTimeFormatter f1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

	public void insertHistory(int payNum, LocalDateTime payTime, String payItem, int payEa, long payAmount,
			String memberId) {
		History history = new History(payNum, payTime, payItem, payEa, payAmount, memberId);
		arr.add(history);
	}

	// 5.전체출력 메소드
	public void showHistoryAll() {

		System.out.println("No\t결제 시각\t결제 메뉴\t수량\t결제금액\t구매자\t결제번호\t결제 날짜");
		System.out.println("--------------------------------------------------------");
		if (arr.size() < 1) {
			System.out.println("결제 내역이 없습니다.");
		} else {
			int cnt = 0;
			int tot = 0;
			int kimbobCnt = 0;

			for (int i = 0; i < arr.size(); i++) {
				tot += arr.get(i).getPayAmount();
				kimbobCnt += arr.get(i).getPayEa();

				cnt++;
				arr.get(i).showHistory(cnt);

				System.out.println(f1.format(arr.get(i).getPayTime()) + "\t");
			}
			System.out.println("총 매출액 :" + tot + ", " + "팔린 김밥 개수 : " + kimbobCnt);

		}

	}

	// ================================================================
	// 1. 오늘의 결제내역을 보여주는 메소드
	public void showTodayHistory() {
		showDayHistoryAll(LocalDate.now());
	}
	// ================================================================

	// ================================================================
	// 2. 일일 결제내역을 보여주는 메소드

	public void showTitle() {
		System.out.println("No\t결제 시각\t결제 메뉴\t수량\t결제금액\t구매자\t결제번호");
		System.out.println("--------------------------------------------------------");
	};

	public void showDayHistoryTitle(LocalDate date) {
		System.out.println("*********** " + f1.format(date) + "의 결제내역 ***********");
		showTitle();
	}

	public void showMonthHistoryTitle(String yyyyMM) {
		System.out.println("*********** " + yyyyMM + "의 결제내역 ***********");
		showTitle();
	}

	// 특정 날짜의 히스토리 알아내기
	// 받은걸 써야(수정해야함)
	public void showDayHistoryAll(LocalDate date) {
		showDayHistoryTitle(date);
		if (arr.size() < 1) {
			System.out.println("결제 내역이 없습니다.");
		} else {
			int cnt = 0;
			int tot = 0;
			int kimbobCnt = 0;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getPayTime().getDayOfYear() == date.getDayOfYear()) {
					tot += arr.get(i).getPayAmount();
					kimbobCnt += arr.get(i).getPayEa();
					cnt++;
					arr.get(i).showHistory(cnt);
					System.out.println();
				}
			}
			System.out.println("-------------------------------------------------");
			System.out.println("총 매출액 :" + tot + ", " + "팔린 김밥 개수 : " + kimbobCnt);
		}

		System.out.println("=============================================");
		System.out.println();
	}

	public void showDayHistory() {
		// 일별 결제내역
		System.out.println("어떤 날짜의 결제 내역을 출력할까요?(숫자 8자리로 입력해주세요 ex.20190527)");

		// 예외처리는 나중에...ㅎㅎ
		String date = Util.scan.nextLine();
		// 너무 지저분한 것 같은데...parse 도전해보자
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(4, 6));
		int day = Integer.parseInt(date.substring(6, 8));

		// LocalDateTime date = LocalDateTime.now();
		LocalDate yyyyMMdd = LocalDate.of(year, month, day);
		showDayHistoryAll(yyyyMMdd);
	}

	// ================================================================

	public void showMonthHistoryAll(String yyyyMM) {

		DateTimeFormatter f = DateTimeFormatter.ofPattern(yyyyMM);
		showMonthHistoryTitle(yyyyMM);
		if (arr.size() < 1) {
			System.out.println("결제 내역이 없습니다.");
		} else {

			int cnt = 0;
			int tot = 0;
			int kimbobCnt = 0;
			for (int i = 0; i < arr.size(); i++) {
				System.out.println(f.format((arr.get(i).getPayTime())));
			}
			// 잠깐! 페이타임 날짜 포맷을 yyyyMM한다음 이걸 스트링 비교하면 되잖아?
//			for (int i = 0; i < arr.size(); i++) {
//				if (f.format((arr.get(i).payTime))) {
//					tot += arr.get(i).payAmount;
//					kimbobCnt += arr.get(i).payEa;
//					cnt++;
//					arr.get(i).showHistory(cnt);
//					System.out.println();
//				}
//			}
			System.out.println("-------------------------------------------------");
			System.out.println("총 매출액 :" + tot + ", " + "팔린 김밥 개수 : " + kimbobCnt);
		}

		System.out.println("=============================================");
		System.out.println();
	}

	public void showMonthHistory() {

		// 일별 결제내역
		System.out.println("원하는 월을 입력해주세요.(숫자 6자리로 입력해주세요 ex.201905)");

		// 써보려했는데 안 된다
		String yyyyMM = Util.scan.nextLine();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
//		LocalDate localDate = LocalDate.parse(yyyyMM, formatter);
//		System.out.println(localDate.getMonthValue());
		showMonthHistoryAll(yyyyMM);

	}

	//
	public void showMemberHistory() {
		// 일별 결제내역
		System.out.println("어떤 회원의 결제 내역을 출력할까요?");

		String member = Util.scan.nextLine();

		if (arr.size() < 1) {
			System.out.println("결제 내역이 없습니다.");
		} else {
			System.out.println(member + "님의 결제내역입니다");
			showTitle();
			int cnt = 0;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getMemberId().equals(member.trim())) {
					cnt++;
					arr.get(i).showHistory(cnt);
					System.out.println();
				}
			}
		}

	}

	// ================================================================

	public int printMenu() {

		System.out.println("================================메뉴를 선택해주세요.===============================");
		System.out.println("1.오늘의 결제내역\t 2.일별 검색\t 3.월별 결제내역 검색\t 4.회원별 결제내역\t 5.모든 결제내역 보기");
		// 매출 총
		// System.out.println("5. 회원별 결제내역")
		// System.out.println("5. 인기메뉴");//이번주 인기메뉴, 이번달 인기메뉴
		System.out.println("===============================================================================");

		int choice = Util.scan.nextInt();

		Util.scan.nextLine(); // 현재 라인의 버퍼를 출력(clear)

		return choice;
	}
}
