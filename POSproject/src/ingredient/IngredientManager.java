package ingredient;

import java.util.ArrayList;

import util.Util;

public class IngredientManager {
	// 재료 -> ArrayList배열에 추가
	//IngredientManager생성시 재료배열 자동 생성
	public static ArrayList<IngredientInfo> ingredientList = new ArrayList<IngredientInfo>();

	public IngredientManager() {
		//시연을 위해 기본 재료 정보 3개 저장함
		ingredientList.add(new IngredientInfo("김", 5, 10));
		ingredientList.add(new IngredientInfo("쌀", 5, 20));
		ingredientList.add(new IngredientInfo("단무지", 10, 10));
	}

	// 재고관리 메뉴 출력
	public void showMenu() {

		while (true) {

			System.out.println();
			System.out.println(
					Util.INGREDIENT_SHOWINFO+".재료검색|"+
					Util.INGREDIENT_EDIT+".재료수정|"+
					Util.INGREDIENT_DELETE+".재료삭제|"+
					Util.INGREDIENT_SHOWALL+".재료전체출력|"+
					Util.INGREDIENT_SHUTDOWN+".이전메뉴"
					);
			
			System.out.print("원하시는 메뉴를 선택해주세요: ");

			int choice = Util.scan.nextInt();
			Util.scan.nextLine();
			System.out.println();

			switch (choice) {

			case Util.INGREDIENT_SHOWINFO:
				showInfo();
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
	public static int searchIndex(String name) {

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
		String name = Util.scan.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("찾으시는 재료가 없습니다, 다시 검색해주세요.");
		} else {
			ingredientList.get(index).showInfo();
		}
	}

	// 재료추가
	public static IngredientInfo add() {
		IngredientInfo ingredientInfo = new IngredientInfo();

		System.out.print("[추가]재료 이름: ");
		String name = Util.scan.nextLine();

		int index = searchIndex(name);

		if (!(index < 0)) {
			System.out.println("중복된 이름이 있습니다, 다시 입력해주세요");
		} else {
			System.out.print("[추가]현재수량: ");
			int num = Util.scan.nextInt();
			System.out.print("[추가]최소수량: ");
			int minNum = Util.scan.nextInt();

			ingredientList.add(new IngredientInfo(name, minNum, num));
			int i = searchIndex(name);
			System.out.println(i);
			ingredientInfo = ingredientList.get(i);
			System.out.println("추가되었습니다!");
		}
		
		return ingredientInfo;
	}

	// 재료정보수정
	void edit() {
		System.out.print("수정할 재료 이름을 입력해주세요: ");
		String name = Util.scan.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("찾으시는 재료가 없습니다, 다시 검색해주세요.");
		} else {
			System.out.print("[수정]이름: ");
			name = Util.scan.nextLine();
			System.out.print("[수정]현재수량: ");
			int num = Util.scan.nextInt();
			System.out.print("[수정]최소수량: ");
			int minNum = Util.scan.nextInt();

			ingredientList.remove(index);
			ingredientList.add(index, new IngredientInfo(name, minNum, num));
			System.out.println("수정되었습니다!");
		}
	}

	// 재료삭제
	void delete() {
		System.out.print("검색할 재료 이름을 입력해주세요: ");
		String name = Util.scan.nextLine();

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
}
