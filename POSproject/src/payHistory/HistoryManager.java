package payHistory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import util.Util;

public class HistoryManager {

	ArrayList<History> arr = new ArrayList<History>();
//	Iterator<History> itrHistory = arr.iterator();

	ArrayList<YearHistory> yearHistoryArr = new ArrayList<YearHistory>(); // 년도
	MonthHistory[] monthHistoryArr = new MonthHistory[12]; // 월
	DateHistory[] dateHistoryArr = new DateHistory[31]; // 일

	DateTimeFormatter f1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL); // 2019년 5월 27일 월요일
	DateTimeFormatter f3 = DateTimeFormatter.ofPattern("yyyyMMdd"); // 20190527

	// 내역에서 데이트 뽑아내기
	public void historyToDate() {
//		while (itrHistory.hasNext()) {
//			System.out.println(itrHistory.next());
//		}

		// 이 포문은 히스토리 객체가 저장된 어레이리스트 arr을 전체 돌아본다
//		for (int i = 0; i < arr.size(); i++) {
//			
//			if (dateHistory 배열을 전체참조해서 해당 날짜(?)에 PayItem이 [참치김밥]인 객체가 들어가있는지 확인한다. 없는가? (근데 어떻게?)) {
//				없으면 
//				처음엔 이렇게 만들고
//				//아이템 항목, 갯수, 금액
//				Product pro= new Product(arr.get(i).getPayItem(), arr.get(i).getPayEa(), arr.get(i).getPayAmount());
//				//날짜, 프로덕트
//				DateHistory dateHistory = new DateHistory(해당날짜인데 형식은 아마 20190527같은 형식, pro);
//				dateHistoryArr[27(+1일)] = dateHistory;
//				
//			}else {
//				있으면 
//				
//				dateHistoryArr[27].product.totPayEa += 방금 참조한 arr.get(i).getPayEa();
//				dateHistoryArr[27].product.totPayEa += 방금 참조한 arr.get(i).getPayAmount();
//			}
//			
//			
//			System.out.println(f3.format(arr.get(i).getPayTime()));
//			System.out.println(arr.get(i).getPayItem());
//			System.out.println(arr.get(i).getPayEa());
//			

		// 잘모르겠으니까 그냥 2019만 두고 해보자! 이미 2019 5월 기정사실임
		for (int i = 0; i < arr.size(); i++) {
			// System.out.println(arr.get(i).getPayTime().getDayOfMonth());
			String fDate = f3.format(arr.get(i).getPayTime());

//			if (없으면) {
//				// 날짜 20190527, "멸추김밥", 3, 6000
//				Product product = new Product(fDate, arr.get(i).getPayItem(), arr.get(i).getPayEa(),arr.get(i).getPayAmount());
//				DateHistory dateHistory = new DateHistory(fDate, product);
//				dateHistoryArr[arr.get(i).getPayTime().getDayOfMonth()-1] = dateHistory;
//			}
//			있으면
//			else {
//				
//			}
//			
			// dateHistory.add(product);
			// dateHistoryArr[arr.get(i).getPayTime().getDayOfMonth()-1] = new
			// DateHistory(f3.format(arr.get(i).getPayTime()), 프로덕트뭉치);
		}

	}

	public void insertHistory(int payNum, LocalDateTime payTime, String payItem, int payEa, long payAmount,
			String memberId) {
		History history = new History(payNum, payTime, payItem, payEa, payAmount, memberId);
		arr.add(history);

	}

	// 5.전체출력 메소드
	public void showHistoryAll() {
		System.out.println("****************************  [저장된 결제내역 전체를 출력합니다.]  ********************************");
		System.out.println("No\t결제 시각\t\t결제 메뉴\t수량\t결제금액\t구매자\t결제번호\t결제 날짜");
		System.out
				.println("------------------------------------------------------------------------------------------");
		if (arr.size() < 1) {
			System.out.println("결제 내역이 없습니다.");
		} else {
			int cnt = 0;
			int tot = 0;
			int kimbobCnt = 0;

			for (int i = 0; i < arr.size(); i++) {
				cnt++;
				tot += arr.get(i).getPayAmount();
				kimbobCnt += arr.get(i).getPayEa();

				arr.get(i).showHistory(cnt);
			}
			System.out.println(
					"------------------------------------------------------------------------------------------");
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
	// 2. 일일 결제내역을 보여주는 메소드(검색해서)

	public void showTitle() {
		System.out.println("No\t결제 시각\t\t결제 메뉴\t수량\t결제금액\t구매자\t결제번호");
		System.out
				.println("------------------------------------------------------------------------------------------");

	};

	public void showDayHistoryTitle(LocalDate date) {
		System.out.println("***********  [" + f1.format(date) + "의 결제내역]  ***********");
		showTitle();
	}

	public void showMonthHistoryTitle(String yyyyMM) {
		System.out.println("***********  [" + yyyyMM + "의 상세 결제내역  ]***********");
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
				}
			}
			System.out.println(
					"------------------------------------------------------------------------------------------");
			System.out.println("총 매출액 :" + tot + ", " + "팔린 김밥 개수 : " + kimbobCnt);
		}

		System.out.println("****************************************************");
		System.out.println();
		System.out.println();
	}

	public void showDayHistory() {
		// 일별 결제내역
		System.out.println("어떤 날짜의 결제 내역을 출력할까요?(숫자 8자리로 입력해주세요 ex.20190527)");

		// 예외처리는 나중에...ㅎㅎ
		String date = Util.keyboard.nextLine().replaceAll(" ", "");
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

		int year = Integer.parseInt(yyyyMM.substring(0, 4));
		int month = Integer.parseInt(yyyyMM.substring(4, 6));

		if (arr.size() < 1) {
			System.out.println("결제 내역이 없습니다.");
		} else {
			int cnt = 0;
			int tot = 0;
			int kimbobCnt = 0;
			showMonthHistoryTitle(yyyyMM);
			for (int i = 0; i < arr.size(); i++) {
				if ((month == arr.get(i).getPayTime().getMonthValue()) && (year == arr.get(i).getPayTime().getYear())) {
					tot += arr.get(i).getPayAmount();
					kimbobCnt += arr.get(i).getPayEa();
					cnt++;
					arr.get(i).showHistory(cnt);
				}
			}

			System.out.println(
					"------------------------------------------------------------------------------------------");
			System.out.println("총 매출액 :" + tot + ", " + "팔린 김밥 개수 : " + kimbobCnt);
		}

	}

	public void showMonthHistory() {

		// 월별 결제내역
		System.out.println("원하는 월을 입력해주세요.(숫자 6자리로 입력해주세요 ex.201905)");

		String yyyyMM = Util.keyboard.nextLine().replaceAll(" ", "");

		// 안된거
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
//		LocalDate localDate = LocalDate.parse(yyyyMM, formatter);
//		System.out.println(localDate.getMonthValue());
		showMonthHistoryAll(yyyyMM);
	}

	//
	public void showMemberHistory() {
		// 일별 결제내역
		System.out.println("어떤 회원의 결제 내역을 출력할까요?");
		String member = Util.keyboard.nextLine();

		// 이거 처리해줘야하는데.. 일지하는 사람없을때...이터레이터???
//		if (arr.size() < 1) {
//			System.out.println("결제 내역이 없습니다.");
//		} else {
		System.out.println(member + "님의 결제내역입니다");
		showTitle();
		int cnt = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getMemberId().equals(member.trim())) {
				cnt++;
				arr.get(i).showHistory(cnt);
			}

		}
//		}

	}

	// ================================================================

	public int printMenu() {

		System.out.println("=====================================  메뉴를 선택해주세요  ====================================");
		System.out.println("1.오늘의 결제내역\t 2.일별 검색\t 3.월별 결제내역 검색\t 4.회원별 결제내역\t 5.모든 결제내역 보기");
		// System.out.println("5. 인기메뉴");//이번주 인기메뉴, 이번달 인기메뉴
		System.out
				.println("==========================================================================================");

		int choice = Util.keyboard.nextInt();

		Util.keyboard.nextLine(); // 현재 라인의 버퍼를 출력(clear)

		return choice;
	}
}
