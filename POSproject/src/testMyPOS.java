
public class testMyPOS implements Util {

	static IngredientManager im = new IngredientManager();
	//static SellManager sm = new SellManager();
	static SupplierManager supm = new SupplierManager();
	//static MenuManager mm = new MenuManager();

	public static void main(String[] args) {

		while (true) {
			for(int i=0; i<im.ingredientList.size(); i++) {
				im.ingredientList.get(i).alarm();
			}

			System.out.println("POS");
			System.out.println("1.재고 |2.판매 |3.거래처 |4.메뉴");

			int select = sc.nextInt();

			switch (select) {
			case 1:
				im.showMenu();
				break;
			case 2:
				//sm.selectSellMenu();
				break;
				
			case 3:
				supm.printMenu();
				break;
				
			case 4:
				//mm.MenuManage();
				break;
				
			default:
				System.out.println("올바르게 입력해\n");
				break;

			}
		}

	}

}
