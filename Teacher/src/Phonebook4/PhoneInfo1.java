package Phonebook4;
//상속을 목적으로 하는 클래스 -> field가 private이면 상속 클래스에서 가져올 수 없음
public class PhoneInfo1 { 
	String name;
	String phoneNumber; 
	
	public PhoneInfo1(String name, String phoneNumber) {
		//super(); //Object클래스의 생성자 상속받고 있기 때문
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showData() {
		System.out.println("이름   :" + name);
		System.out.println("전화번호   :" +  phoneNumber);
	}
	

	
	
	
}
