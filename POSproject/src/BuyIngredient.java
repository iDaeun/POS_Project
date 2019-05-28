

public abstract class BuyIngredient{
	int ingPrice; // 구매할 재료 원가격
	String ingName; // 구매할 재료 이름
	int ingNum = 0; // 구매할 재료 수량
	
	public BuyIngredient() {};
	
	public BuyIngredient(String name, int price) {
		ingName = name;
		ingPrice = price;
	}
	

	void setIngredient(String name, int price) {
		this.ingName = name;
		this.ingPrice = price;
	}
	
	void setIngName(String name) {
		ingName = name;
	}
	
	public String getIngName() {
		return ingName;
	}
	
	void setIngPrice(int price) {
		ingPrice = price;
	}
	
	public int getIngPrice() {
		return ingPrice;
	}
	
	void buying(String name, int num) {};
	

	
	// 알림창에서 구입하는 메소드.
//	void buying(int num) {	
//		int numOfIng = inginfo.getNum();		
//		numOfIng += num;		
//	}
}
