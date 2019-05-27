
public class CheeseKimbab extends Kimbab {
	String tuna = "치즈";

	CheeseKimbab() {
		name = "치즈김밥";
		price = 3500;
		cnt = 0;

	}
	@Override
	public void ingredientMinus() {

		super.ingredientMinus();

		int index5 = IngredientManager.searchIndex("치즈");

		IngredientManager.ingredientList.get(index5).setNum(IngredientManager.ingredientList.get(index5).getNum() - 1);

		cnt++;
	}

}
