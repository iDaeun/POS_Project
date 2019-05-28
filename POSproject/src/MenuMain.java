public class MenuMain {

  
 public static void main(String[] args) {

   MenuManager menulist = new MenuManager();
   
   menulist.firstAdd(new MenuInfo("야채김밥",3000, new IngredientInfo("야채", 5, 5)));
   menulist.firstAdd(new MenuInfo("참치김밥",4000, new IngredientInfo("참치", 5, 5)));
   menulist.firstAdd(new MenuInfo("치즈김밥",3500, new IngredientInfo("치즈", 5, 5)));
   
  
   menulist.MenuManage();   
  
   
}
}