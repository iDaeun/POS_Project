
public class CheeseKimbab extends Kimbab {
	String cheese = "치즈";

	CheeseKimbab() {
		String name = "치즈김밥";
		int price = 3500;
		int cnt = 0;

	}
	@Override
	public void ingredientMinus() {

		super.ingredientMinus();

		int index5 = IngredientManager.searchIndex("치즈");

		IngredientManager.ingredientList.get(index5).setNum(IngredientManager.ingredientList.get(index5).getNum() - 1);
		
	}

}
