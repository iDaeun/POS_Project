package PhoneBook5;

public class PhoneUnivInfo extends PhoneInfo1{

	String address; //주소
	String email; //메일
	String major; //전공
	int grade; //학년
	
	//데이터의 초기화	
	public PhoneUnivInfo(String name, String phoneNumber, String address, String email, String major, int grade) {
		super(name, phoneNumber); //상위 클래스의 생성자 호출: 멤버 변수의 초기화
		this.address = address;
		this.email = email;
		this.major = major;
		this.grade = grade;
	}
	
	@Override
	public void showData() {
		super.showData();
		System.out.println("주소    :" + address);
		System.out.println("메일    :" + email);
		System.out.println("전공    :" + major);
		System.out.println("학년    :" + grade);
	}

	@Override
	public void showBasicInfo() {
		System.out.printf("대학 친구 %s정보입니다.\n",this.name);
		System.out.println("전화번호는 "+ this.phoneNumber+"입니다.");
		
		
	}
}
