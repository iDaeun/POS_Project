
public class SellManager implements Util, Menu {
	// 판매관리
	// 1. 주문
	// 주문을 하면 손님 객체를 생성하고 배열에 삽입.
	// 단, 해당 배열이 null 값이 아닐 때

	// 2. 결제
	// 테이블 번호에 해당하는 배열의 원소를 제거...
	// 내 잔고 오름.

	int select;

	void selectSellMenu() {
		while (true) {
			System.out.println("판매관리");
			System.out.println("1. 주문 | 2. 결제 | 3. 이전 메뉴");

			select = sc.nextInt();

			switch (select) {
			case 1:
				order();
				break;
			case 2:
				// 결제
				break;
			case 3:
				return;
			}
		}
	}

	void order() {

		while (true) {

			System.out.println("-----메뉴-----");
			System.out.println("1. 김밥 | 2. 취소"); // 메뉴판이 완성되면 sysout이 아닌 메뉴판의 내용을 출력하는 메서드를 사용.
			select = sc.nextInt();

			switch (select) {
			case kimbab:

				whatOrderNum();
				return;

			case 2:
				return;

			}
		}
	}

	void whatOrderNum() {

		System.out.println("몇 개 주문해 ?");
		select = sc.nextInt();

		if (select < 1) {
			System.out.println("1개 이상 주문해");
		}

		for (int i = 0; i < select; i++) {

			new Kimbab();
			System.out.println();

		}

		System.out.println("다른 메뉴도 주문해?");
		System.out.println("1. 응, 2. 아니");
		select = sc.nextInt();

		switch (select) {
		case 1:
			break;
		case 2:
			System.out.println("주문 완료");
			return;
		}
	}
}