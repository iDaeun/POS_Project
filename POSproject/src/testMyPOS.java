
public class testMyPOS implements Util {

	static IngredientManager im = new IngredientManager();
	static SellManager sm = new SellManager();

	public static void main(String[] args) {

		while (true) {

			System.out.println("POS");
			System.out.println("1. 재고, 2. 판매");

			int select = sc.nextInt();

			switch (select) {
			case 1:
				im.showMenu();
				break;
			case 2:
				sm.selectSellMenu();
				break;
			case 3:
				MemberManager.getManager().showAll();
				break;
			default:
				System.out.println("올바르게 입력해\n");
				break;

			}
		}

	}

}
