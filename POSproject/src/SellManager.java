import java.util.ArrayList;

public class SellManager implements Util, Menu {
	// 판매관리
	// 1. 주문
	// 주문을 하면 손님 객체를 생성하고 배열에 삽입.
	// 단, 해당 배열이 null 값이 아닐 때

	// 2. 결제
	// 테이블 번호에 해당하는 배열의 원소를 제거...
	// 내 잔고 오름.

	int select;

	Kimbab k;
	TunaKimbab t;

	ArrayList<Kimbab> orderList = new ArrayList<Kimbab>();

	boolean check = false;

	void selectSellMenu() {
		while (true) {

			System.out.println("판매관리");
			System.out.println("1. 주문 | 2. 결제 | 3.테이블 정보 | 4. 이전 메뉴");

			select = sc.nextInt();

			switch (select) {
			case 1:
				if (check() == false) {
					System.out.println("자리가 없어.");
				} else {
					order();
				}
				break;
			case 2:
				pay();
				break;
			case 3:
				System.out.println("=================================");
				for (int i = 0; i < TABLE.length; i++) {
					if (TABLE[i] != null) {
						System.out.println((i + 1) + "번 테이블 주문내역");
						TABLE[i].showInfo();
					}
				}
				System.out.println("=================================");
				break;
			case 4:
				return;
			}
		}
	}

	void order() {

		do {
			System.out.println("-----메뉴-----");
			System.out.println("1. 김밥 | 2. 참치김밥 | 3. 주문 | 4. 취소"); // 메뉴판이 완성되면 sysout이 아닌 메뉴판의 내용을 출력하는 메서드를 사용.
			select = sc.nextInt();
			switch (select) {
			case KIMBAB:
				k = new Kimbab();
				check = whatOrderNum(k);
				orderList.add(k);
				break;

			case TUNAKIMBAB:
				k = new TunaKimbab();
				check = whatOrderNum(k);
				orderList.add(k);

				break;
			case 3:

			case 4:
				return;
			}

		} while (check == false);
		addTable();
		return;
	}

	void addTable() {
		for (int i = 0; i < TABLE.length; i++) {
			if (TABLE[i] == null) {
				TABLE[i] = new Guest(orderList);

				orderList = new ArrayList<Kimbab>();
				return;

			}
		}

	}

	boolean check() {
		boolean c = false;
		for (int i = 0; i < TABLE.length; i++) {
			if (TABLE[i] == null) {
				c = true;
			}
		}
		return c;
	}

	boolean whatOrderNum(Kimbab k) {

		System.out.println("몇 개 주문해 ?");
		select = sc.nextInt();
		if (select < 1) {
			System.out.println("1개 이상 주문해");

		}

		else {

			for (int i = 0; i < select; i++) {

				k.ingredientMinus();

			}
		}
		System.out.println("다른 메뉴도 주문해?");
		System.out.println("1. 응, 2. 아니");
		select = sc.nextInt();

		switch (select) {

		case 1:
			check = false;
			break;

		case 2:
			System.out.println("주문 완료.");
			check = true;
			break;
		}
		return check;
	}

	void pay() {
		System.out.println("몇 번 테이블 계산 할거야?");
		select = sc.nextInt();

		if (check() == true) {
			System.out.println("결제할 테이블이 없어.");
			return;
		}

		if (select < TABLE.length + 1 && select > 0) {
			System.out.println(select + "번 테이블");
			System.out.println("결제 금액 : " + TABLE[select - 1].getTotalPrice());
			MyPOS.money += TABLE[select - 1].getTotalPrice();
			System.out.println("잔고 : " + MyPOS.money);
			TABLE[select - 1] = null;

			// History history = new History(TABLE[select - 1].payNum, payTime, payItem,
			// TABLE[select - 1]., payAmount, memberId)
		} else {
			System.out.println("올바른 테이블 번호를 입력해.");
		}
	}
}