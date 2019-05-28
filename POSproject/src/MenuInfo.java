
public class MenuInfo {

	String name;

	protected int price;
	protected int cnt;

	public MenuInfo(String name, int price) {

		this.name = name;
		this.price = price;
		cnt = 0;
	}

	public MenuInfo(String name) {
		this.name = name;
	}

	// 메뉴명을 조회하므로 매개변수필요x
	public String getName() {
		return name;
	}

	// 메뉴이름 변경
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;

	}

	public void ingredientMinus() {

		int index1 = IngredientManager.searchIndex("김");

		IngredientManager.ingredientList.get(index1).setNum(IngredientManager.ingredientList.get(index1).getNum() - 1);

		int index2 = IngredientManager.searchIndex("쌀");

		IngredientManager.ingredientList.get(index2).setNum(IngredientManager.ingredientList.get(index2).getNum() - 2);

		int index3 = IngredientManager.searchIndex("단무지");

		IngredientManager.ingredientList.get(index3).setNum(IngredientManager.ingredientList.get(index3).getNum() - 1);

		cnt++;
	}

	void showInfo() {

		System.out.println("메뉴이름 :" + name);
		System.out.println("메뉴가격 :" + price);
	}

}
