import java.util.*;

public class IngredientManager {
	// 재료 -> ArrayList배열에 추가
	protected static ArrayList<IngredientInfo> ingredientList;

	public IngredientManager() {
		// IngredientManager생성시 재료배열 자동 생성 & 재고관리 매뉴 출력 기능 실행
		ingredientList = new ArrayList<IngredientInfo>();

		ingredientList.add(new IngredientInfo("김", 10, 100));
		ingredientList.add(new IngredientInfo("쌀", 10, 100));
		ingredientList.add(new IngredientInfo("단무지", 10, 100));
		ingredientList.add(new IngredientInfo("참치", 10, 100));


	}

	// 재고관리 메뉴 출력
	void showMenu() {

		while (true) {

			int choice = 0;

			System.out.println("\n1.재료검색|2.재료추가|3.재료정보수정|4.재료삭제|5.재료전체출력|6.이전메뉴");
			System.out.print("원하시는 메뉴를 선택해주세요: ");

			choice = Util.sc.nextInt();
			Util.sc.nextLine();
			System.out.println();

			switch (choice) {

			case Util.INGREDIENT_SHOWINFO:
				showInfo();
				break;

			case Util.INGREDIENT_ADD:
				add();
				break;

			case Util.INGREDIENT_EDIT:
				edit();
				break;

			case Util.INGREDIENT_DELETE:
				delete();
				break;

			case Util.INGREDIENT_SHOWALL:
				showAll();
				break;

			case Util.INGREDIENT_SHUTDOWN:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;

			default:
				System.out.println("잘못된 입력");
				break;
			}
		}

	}

	// 이름 검색 -> 매칭되는 index 리턴
	static int searchIndex(String name) {

		int index = -1;
		for (int i = 0; i < ingredientList.size(); i++) {
			if (ingredientList.get(i).getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}

	// 재료검색
	void showInfo() {
		System.out.println("검색할 재료 이름을 입력해주세요:");
		String name = Util.sc.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("찾으시는 재료가 없습니다, 다시 검색해주세요.");
		} else {
			ingredientList.get(index).showInfo();
		}
	}

	// 재료추가
	void add() {

		System.out.print("[추가]이름: ");
		String name = Util.sc.nextLine();

		int index = searchIndex(name);

		if (!(index < 0)) {
			System.out.println("중복된 이름이 있습니다, 다시 입력해주세요");
		} else {
			System.out.print("[추가]현재수량: ");
			int num = Util.sc.nextInt();
			System.out.print("[추가]최소수량: ");
			int minNum = Util.sc.nextInt();

			ingredientList.add(new IngredientInfo(name, minNum, num));
			System.out.println("추가되었습니다!");
		}
	}

	// 재료정보수정
	void edit() {
		System.out.print("수정할 재료 이름을 입력해주세요: ");
		String name = Util.sc.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("찾으시는 재료가 없습니다, 다시 검색해주세요.");
		} else {
			System.out.print("[수정]이름: ");
			name = Util.sc.nextLine();
			System.out.print("[수정]현재수량: ");
			int num = Util.sc.nextInt();
			System.out.print("[수정]최소수량: ");
			int minNum = Util.sc.nextInt();

			ingredientList.remove(index);
			ingredientList.add(index, new IngredientInfo(name, minNum, num));
			System.out.println("수정되었습니다!");
		}
	}

	// 재료삭제
	void delete() {
		System.out.print("검색할 재료 이름을 입력해주세요: ");
		String name = Util.sc.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("찾으시는 재료가 없습니다, 다시 검색해주세요.");
		} else {
			ingredientList.remove(index);
			System.out.println("삭제되었습니다!");
		}
	}

	// 재료 전체 정보 출력
	void showAll() {
		for (int i = 0; i < ingredientList.size(); i++) {
			ingredientList.get(i).showInfo();
		}
	}

	// 주문-> 해당 메뉴에 쓰이는 재료 삭제 (Menu 메뉴이름, int 주문수량) [메뉴관리에서 메소드 만들기]
	// -> alarm() [재고부족시 알람]

}
