
import history.HistoryManager;
import ingredient.IngredientManager;
import member.MemberManager;
import menu.MenuManager;
import selling.SellManager;
import supplier.SupplierManager;
import util.Util;

public class MyPOS_Test {

	static IngredientManager im = new IngredientManager();
	static SellManager sm1 = new SellManager();
	static MemberManager mm2 = MemberManager.getManager();
	static MenuManager mm1 = new MenuManager();
	static SupplierManager sm2 = new SupplierManager();
	static HistoryManager hm = new HistoryManager();

	public static void main(String[] args) {

		while (true) {
			for (int i = 0; i < im.ingredientList.size(); i++) {
				im.ingredientList.get(i).alarm();
			}
			System.out.println("-----------------------");
			System.out.println("POS");
			System.out.println("1. 재고, 2. 판매, 3. 메뉴관리, 4. 회원관리, 5. 거래처관리, 6. 판매내역");

			int select = Util.scan.nextInt();

			switch (select) {
			case 1:
				im.showMenu();
				break;
			case 2:
				sm1.selectSellMenu();
				break;
			case 3:
				mm1.printMenu();
				break;
			case 4:
				mm2.showMenu();
				break;
			case 5:
				sm2.printMenu();
				break;
			case 6:
				hm.printMenu();
				break;

			}
		}

	}

}
