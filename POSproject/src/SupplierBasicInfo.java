

public class SupplierBasicInfo extends BuyIngredient{
	String name; // 거래처 이름
	String phoneNum; // 거래처 번호
	String address; // 거래처 주소
		
	SupplierBasicInfo(String name, String phoneNum,String address, String ingName, int ingPrice) {
		super(ingName,ingPrice);
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	
	public SupplierBasicInfo(String name, String phoneNum,String address, String ingName) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		super.ingName = ingName;
	}
	
	
	void showData(){
		System.out.println("거래처 이름: "+name);
		System.out.println("거래처 번호: "+phoneNum);
		System.out.println("거래처 주소: "+address);
		System.out.println("거래처 품목: "+ingName);
	}
	
	
	// 거래처 이름
	void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	
//	void buying(String name, int num) {
//		
//	}
	
	
}