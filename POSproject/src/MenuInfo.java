
public class MenuInfo {
		  
		   String name;
		   int price;
		  
		  public MenuInfo(String name, int price) {
			  this.name = name;
			  this.price = price;
		  }
		  
		  public MenuInfo(String name) {
			  this.name = name;
		  }
		  
	/*
	 * public MenuInfo(int number,String name) { this.name = name; this.number =
	 * number; }
	 */
		  

		public String getName() { 
			  return name;
			}
	 
		  
		  public void setName() {
		   this.name = name;
		  }
		  
		  public int getPrice() {
			  return price;
		  }
		  
		  public void setPrice() {
			  this.price = price;
		  }
		  
		  
		  
			void showInfo() {
				System.out.println("메뉴이름 :"+name);
				System.out.println("메뉴가격 :"+price);
		
			}
		  
		  

		  
		  
		  
		  
		  
		  
		  
		  
		  
		  /*메뉴가 들어왔을때 쓰이는 재료개수
		     메뉴 주문 -> 메뉴선택 -> 메뉴따라 또는 메뉴 개수마다 쓰이는 재료 개수가 다르다
		  -> 감소되는 재료개수 나타내는 메서드 (김, 쌀, 단무지)
		  
		  void ingredientNum() {
			  
			  
			  
		  }
		  */
		  
		  
		  
		}
