

public abstract class BuyIngredient{
	int ingPrice; // 구매할 재료 원가격
	String ingName; // 구매할 재료 이름
	int ingNum; // 구매할 재료 수량

	public BuyIngredient() {
		
	}
	

	void setIngredient(String name, int price) {
		this.ingName = name;
		this.ingPrice = price;
	}
	
	void buying(String name, int num) {
	}


	public String getIngName() {
		return ingName;
	}
	
	
//	
//	public BuyIngredient(String name, int price) {
//		this.name = name;
//		this.price = price;
//	}
//	private void setPrice(String n) {
//		name = name;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	private void setPrice(int p) {
//		price = p;
//	}
//	
//	public int getPrice() {
//		return price;
//	}
//	
	
	// 알림창에서 구입하는 메소드.
//	void buying(int num) {	
//		int numOfIng = inginfo.getNum();		
//		numOfIng += num;		
//	}
}
