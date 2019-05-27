package PhoneBook5;

public class PhoneCafeInfo extends PhoneInfo1 {
	
	String nickName;

	public PhoneCafeInfo(String name, String phoneNumber, String nickName) {
		super(name, phoneNumber);
		this.nickName = nickName;
	}
	
	@Override
	public void showData() {
		super.showData();
		System.out.println("닉네임: "+nickName);
	}

	@Override
	public void showBasicInfo() {
		System.out.printf("동호회 친구 %s정보입니다.\n",this.name);
		System.out.println("전화번호는 "+ this.phoneNumber+"입니다.");
		
	}
	
	

}
