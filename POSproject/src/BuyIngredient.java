

public class BuyIngredient{
	int ingPrice; // 구매할 재료 원가격
	String ingName; // 구매할 재료 이름
	int ingNum = 0; // 구매할 재료 수량
	
	public BuyIngredient() {};
	
	public BuyIngredient(String name, int price) {
		ingName = name;
		ingPrice = price;
	}
	
	// 
	void setIngName(String name) {
		ingName = name;
	}
	
	String getIngName() {
		return ingName;
	}
	
	void setIngPrice(int price) {
		
		ingPrice = price;
	}
	
	public int getIngPrice() {
		return ingPrice;
	}
	
	// 
	void printIngredient(String name) {
		System.out.println("품목 : "+ingName);
		System.out.println("원가 : "+ingPrice);
		System.out.println("거래처 : "+name);
	}
	
	
	

}
