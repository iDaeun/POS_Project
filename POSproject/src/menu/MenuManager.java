package menu;

import java.util.ArrayList;
import ingredient.IngredientInfo;
import ingredient.IngredientManager;
import util.Util;

public class MenuManager {

	public static ArrayList<Menu> MenuList = new ArrayList<Menu>();

	public MenuManager() {
		IngredientInfo ingre1 = new IngredientInfo("야채", 10, 2);
		IngredientManager.ingredientList.add(ingre1);
		Menu kimbab1 = new Menu("야채김밥", 3000, ingre1);

		IngredientInfo ingre2 = new IngredientInfo("참치", 10, 2);
		IngredientManager.ingredientList.add(ingre2);
		Menu kimbab2 = new Menu("참치김밥", 3500, ingre2);

		MenuList.add(kimbab1);
		MenuList.add(kimbab2);
	}

	// 메뉴관리 선택
	public void printMenu() {

		while (true) {

			System.out.println("=============================");
			System.out.println(" 1.메뉴 추가\n 2.메뉴 수정\n 3.메뉴 삭제\n 4.전체 메뉴 출력\n 5.종료");
			System.out.println("=============================");
			System.out.println("원하는 메뉴를 선택해주세요 : ");

			int choice = Util.scan.nextInt();
			Util.scan.nextLine();
			System.out.println();

			switch (choice) {

			case 1:
				menuAdd();
				break;

			case 2:
				menuEdit();
				break;

			case 3:
				menuDelete();
				break;

			case 4:
				showAllMenu();
				break;

			case 5:
				System.out.println("메뉴관리를 종료합니다.");
				return;

			}

		}

	}

	// 메뉴를 배열에 저장!!!!!!!!!!!!!!!!!!!
	public void firstAdd(Menu name) {
		MenuList.add(name);
	}

	// 검색할 메뉴의 이름을 출력!!!!!!!!!!!!!
	public void searchPrint() {
		System.out.println("검색할 메뉴를 입력해주세요");
		String name = Util.scan.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("검색하신 메뉴의 정보가 없습니다.");
		} else {
			MenuList.get(index).showInfo();
		}
	}

	// 같은 이름을 가지는 메뉴이름을 찾는다!!
	int searchIndex(String name) {
		int index = -1;
		for (int i = 0; i < MenuList.size(); i++) {
			if (MenuList.get(i).getName().equals(name)) {
				index = i;
				break;
			}
		}
		return index;
	}

	// 메뉴이름등록!!!!!!!!!!!!!!!!!!!!!!!
	/*
	 * void insertMenu() {
	 * 
	 * System.out.println("메뉴이름 :"); String name = Util.sc.nextLine();
	 * System.out.println("메뉴가격 :"); int price = Util.sc.nextInt();
	 * 
	 * MenuList.add(new Menu(name, price)); System.out.println("메뉴가 등록되었습니다.");
	 * 
	 * }
	 */

	// 신메뉴 추가 메서드!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	void menuAdd() {
		System.out.println("추가할 메뉴의 이름을 입력하세요 : ");
		String name = Util.scan.nextLine();

		System.out.println("추가할 메뉴의 가격을 입력하세요 : ");
		int price = Util.scan.nextInt();

		int index = searchIndex(name);

		if (!(index < 0)) {
			System.out.println("같은 이름이 존재합니다.\n 다른 이름을 입력해주세요");
		} else {

			System.out.println("새로운 메뉴이름: " + name);
			System.out.println("가격 :" + price);

			Util.scan.nextLine();
			IngredientInfo ingredientInfo = IngredientManager.add();

			MenuList.add(new Menu(name, price, ingredientInfo));
			System.out.printf("%d원인 %s메뉴가 추가되었습니다.\n", price, name);
		}

	}

	// 메뉴 수정 메서드!!!!!!!!!!!!!!

	void menuEdit() {
		System.out.println("수정할 메뉴의 이름을 입력하세요 : ");
		String name = Util.scan.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("메뉴의 이름이 존재하지 않습니다.");
		} else {

			System.out.println("수정된 메뉴 이름 : ");
			name = Util.scan.nextLine();
			System.out.println("수정할 메뉴의 가격을 입력하세요 : ");
			int price = Util.scan.nextInt();
			System.out.println("수정이 완료되었습니다.");

			MenuList.remove(index);
			MenuList.add(index, new Menu(name, price));
		}

	}

	// 메뉴 삭제 메서드!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	void menuDelete() {

		System.out.println("삭제할 메뉴의 이름을 입력하세요 : ");
		String name = Util.scan.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("메뉴의 이름이 존재하지 않습니다.");
		} else {
			for (int i = index; i < MenuList.size(); i++) {
				MenuList.remove(index);
			}
			System.out.printf("%s메뉴가 삭제되었습니다.", name);
		}
	}

	// 배열에 저장된 모든 데이터를 출력!!
	void showAllMenu() {
		System.out.println("=======================");

		if (MenuList.size() > 0) {
			for (int i = 0; i < MenuList.size(); i++) {
				MenuList.get(i).showInfo();
				// MenuInfo name = MenuList.get(i);
				System.out.println("------------");
			}
		} else {
			System.out.println("등록된 메뉴정보가 없습니다.");
		}
		System.out.println("=======================");
	}

}