

public class SupplierBasicInfo extends BuyIngredient{
	String name; // 거래처 이름
	String phoneNum; // 거래처 번호
	String address; // 거래처 주소
	String addIngre; // 거래처 추가정보
		
	SupplierBasicInfo(String name, String phoneNum,String address, String addIngre) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		this.addIngre = addIngre;
	}
	
	SupplierBasicInfo(String name, String phoneNum, String address){
		this(name,phoneNum,address,"-");
	}
	
	void showData(){
		System.out.println("거래처 이름: "+name);
		System.out.println("거래처 번호: "+phoneNum);
		System.out.println("거래처 주소: "+address);
		System.out.println("거래처 품목: "+addIngre);
	}
	
	void setIngredient(String name, int price) {
		
	}
	
	// 거래처 이름
	String getName() {
		return this.name;
	}
	
	String getIngre() {
		return this.addIngre;
	}
	
//	void buying(String name, int num) {
//		
//	}
	
	
}