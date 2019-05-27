package Phonebook;
//친구의 정보를 저장하는 클래스
//default class -> 다른 패키지(phoneBook2)에서는 볼 수 없도록
class PhoneInfo {
	
	//속성 = 변수 = 필드
	
	String name; //친구의 이름 저장
	String phoneNumber; //친구의 전화번호 저장
	String birthday; //친구의 생일 저장
	
	
	//shift + Alt + s 단축키
	//생성자: 기본정보초기화 (이름, 전화번호, 생일)
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	//생성자: 이름과 전화번호 저장
	public PhoneInfo(String name, String phoneNumber) {
		this(name, phoneNumber, "등록된 정보 없습니다");
	}
	
	//친구 정보 출력 메소드
	void showInfo() {
		  System.out.println("•이름"+'\t'+name);
		  System.out.println("•전화번호"+'\t'+phoneNumber);
		  System.out.println("•생년월일"+'\t'+birthday); 
		  
		  System.out.println();
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		
		if(obj != null && obj instanceof PhoneInfo) {
			PhoneInfo pi = (PhoneInfo) obj;
			result = this.phoneNumber.equals(pi.phoneNumber);
		}
		
		return result;
	}

	@Override
	public int hashCode() {
		
		//phoneNumber : String => int
		//01000001112 : 문자열의 맨마지막 문자 추출
		//유니코드 마지막 숫자 -> 0~9까지 그룹핑하게됨
		//index => n-1
		
		//char => int타입 (자동 형변환)
		return phoneNumber.charAt(phoneNumber.length()-1);
	}
		
}
