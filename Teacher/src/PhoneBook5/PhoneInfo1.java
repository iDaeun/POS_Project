package PhoneBook5;
//PhoneInfoBasic = 인터페이스도 추상클래스 => PhoneInfo1를 abstract class로 만들기
public abstract class PhoneInfo1 implements PhoneInfoBasic{ 
	String name;
	String phoneNumber; 
	
	public PhoneInfo1(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showData() {
		System.out.println("이름   :" + name);
		System.out.println("전화번호   :" +  phoneNumber);
	}
	
	
	

	
	
	
}
