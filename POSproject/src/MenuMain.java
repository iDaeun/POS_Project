public class MenuMain {

  
 public static void main(String[] args) {

   MenuManager menulist = new MenuManager();
   
   menulist.firstAdd(new MenuInfo("야채김밥",3000));
   menulist.firstAdd(new MenuInfo("참치김밥",4000));
   menulist.firstAdd(new MenuInfo("치즈김밥",3500));
   
  
   menulist.MenuManage();   
  
   
}
}