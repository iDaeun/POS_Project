
public class TunaKimbab extends Kimbab {
	String tuna = "참치";

	TunaKimbab() {
		name = "참치김밥";
		price = 4000;


	}
	@Override
	public void ingredientMinus() {

		super.ingredientMinus();

		int index4 = IngredientManager.searchIndex("참치");

		IngredientManager.ingredientList.get(index4).setNum(IngredientManager.ingredientList.get(index4).getNum() - 1);

	}

}
