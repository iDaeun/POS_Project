package Phonebook4;

public class PhoneInfo { 
	private String name; //이름 저장 + private(외부에서 함부로 값변경을 못하도록!)
	private String phoneNumber; //전화번호 저장 + private(외부에서 함부로 값변경을 못하도록!)
	
	public PhoneInfo(String name, String phoneNumber) {
		//super(); //Object클래스의 생성자 상속받고 있기 때문
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showData() {
		System.out.println("이름   :" + name);
		System.out.println("전화번호   :" +  phoneNumber);
	}
	
	//private의 field를 참조할 수 있도록 getter메소드
	public String getName() {
		return name;
	}
	
	//private의 field를 대입하는 setter메소드
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
