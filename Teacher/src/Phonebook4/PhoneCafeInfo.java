package Phonebook4;

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
	
	

}
