
public class MyPOS_Test implements Util {

	static IngredientManager im = new IngredientManager();
	static SellManager sm1 = new SellManager();
	static MemberManager mm2 = MemberManager.getManager();
	static MenuManager mm1 = new MenuManager();
	static SupplierManager sm2 = new SupplierManager();

	public static void main(String[] args) {

		while (true) {
			System.out.println("POS");
			System.out.println("1. 재고, 2. 판매, 3. 메뉴관리, 4. 회원관리, 5. 거래처관리");

			int select = sc.nextInt();

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
				default:
				System.out.println("올바르게 입력해\n");
				break;

			}
		}

	}

}
