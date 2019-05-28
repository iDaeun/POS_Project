public class Menu extends MenuIngredient {

	IngredientInfo info;

	public Menu() {
	}

	// 메뉴 추가용 생성자
	public Menu(String name, int price, IngredientInfo info) {
		this.name = name;
		this.price = price;
		this.info = info;
		cnt = 0;

	}

	// 메뉴 수정용 생성자
	public Menu(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public void ingredientMinus() {
		super.ingredientMinus();
		info.setNum(info.getNum() - 1);
	}
	
	public void showInfo() {
		super.showInfo();
		int index = IngredientManager.searchIndex(info.getName());
		IngredientManager.ingredientList.get(index).showInfo();
	}
	/*
	 * public String toString() { return String.format("%s %d", name,price); }
	 */

}
