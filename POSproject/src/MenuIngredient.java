public class MenuIngredient {

	String name;
	int price;
	int cnt;

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

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void setPrice(int price) {
		this.price = price;

	}

	public int getCnt() {
		return cnt;
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

	/*
	 * public String toString() { return String.format("%s %d", name,price); }
	 */

	void showInfo() {
		System.out.println("메뉴 이름 : " + name);
		System.out.println("메뉴 가격 : " + price);
		for (int i = 0; i < 3; i++) {
			IngredientManager.ingredientList.get(i).showInfo();
		}
		
	}

}