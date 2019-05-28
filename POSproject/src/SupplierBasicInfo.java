

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
	
	public SupplierBasicInfo() {};
	
	@Override
	public boolean equals(Object obj) {
		

		if(obj != null) {
			return true; 
		}
		
		SupplierBasicInfo sbi = (SupplierBasicInfo)obj;
		
		
		if(obj != null && sbi.phoneNum == obj) {
			return true;
		}
		
		if(obj != null && sbi.ingName == obj) {
			return true;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return phoneNum.hashCode();
	}
	
	
	
	void showData(){
		System.out.println("거래처 이름: "+name);
		System.out.println("거래처 번호: "+phoneNum);
		System.out.println("거래처 주소: "+address);
		System.out.println("거래처 품목: "+ingName);
	}
	
}