public class MenuInfo {

     String name;
     int price;
     String ingredient;

    public MenuInfo(String name, int price) {

     this.name = name;
     this.price = price;
    }

    public MenuInfo(String name, int price,String ingredient) {

        this.name = name;
        this.price = price;
        this.ingredient = ingredient;
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

    
   void showInfo() {

    System.out.println("메뉴이름 :"+name);
    System.out.println("메뉴가격 :"+price);
   }

  }

 
