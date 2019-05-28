
public class Kimbab {
	
	String kim = "김";
	String rice = "쌀";

	Kimbab() {
		ingredientMinus();
		ingredientAlarm();
	}

	void ingredientMinus() {

		int index1 = IngredientManager.searchIndex("김");

		IngredientManager.ingredientList.get(index1).setNum(IngredientManager.ingredientList.get(index1).getNum() - 1);
		
		int index2 = IngredientManager.searchIndex("쌀");

		IngredientManager.ingredientList.get(index2).setNum(IngredientManager.ingredientList.get(index2).getNum() - 2);
		
		int index3 = IngredientManager.searchIndex("단무지");

		IngredientManager.ingredientList.get(index3).setNum(IngredientManager.ingredientList.get(index3).getNum() - 1);
		
	}

	void ingredientAlarm() {
		
	}

}
