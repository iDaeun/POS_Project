public class MenuInfo {

     String name;
     int price;
     IngredientInfo info;

    public MenuInfo(String name, int price) {

     this.name = name;
     this.price = price;
    }
    
    public MenuInfo(String name, int price, IngredientInfo info) {

        this.name = name;
        this.price = price;
        this.info = info;
       }

    public MenuInfo(String name) {
     this.name = name;
    }

    //메뉴명을 조회하므로 매개변수필요x
  public String getName() { 
     return name;
   }

  //메뉴이름 변경
    public void setName(String name) {
     this.name = name;
    }

    public int getPrice() {
     return price;
    }

    public void setPrice(int price) {
     this.price = price;

    }

    
   /* public String toString() {
     return String.format("%s %d", name,price);
    }
    */
    
   void showInfo() {

    System.out.println("메뉴이름 :"+name);
    System.out.println("메뉴가격 :"+price);
    System.out.println("사용되는 재료) ");
    this.info.showInfo();
   }

  }

 

 