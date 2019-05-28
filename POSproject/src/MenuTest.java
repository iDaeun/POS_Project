import java.util.ArrayList;

public class MenuTest {

	public static void main(String[] args) {
			
		MenuManager a = new MenuManager();
		
		a.firstAdd(new MenuInfo("야채김밥", 3000, new IngredientInfo("야채", 5,5)));
		a.firstAdd(new MenuInfo("참치김밥", 2000, new IngredientInfo("참치", 5,5)));
		a.firstAdd(new MenuInfo("치즈김밥", 3000, new IngredientInfo("치즈", 5,5)));
		
		a.MenuManage();
		
			
	

	}

}
