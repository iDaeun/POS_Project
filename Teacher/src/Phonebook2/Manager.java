package Phonebook2;

import util.Util;
//기능만 클래스로 만든 것, 변수 없음 ===>"싱글톤"
 class Manager {
	 
	 //Singleton 패턴적용
	 
	 //1.생성자의 접근제어지시자를 private으로 정의: 외부에서 생성자 호출 불가 -> 인스턴스 생성 불가
	 
	 private Manager(){}
	 
	 //2.사용할 인스턴스 생성
	 //: static 메서드에서 사용가능하도록 변수에 static처리
	 //:외부의 직접 참조를 막기 위해 private처리
	 
	 static private Manager m = new Manager();
	 
	 //3.외부에서 인스턴스 요청할 메소드
	 //: static을 통한 외부 호출이 가능하도록 처리
	 //:외부 어디에서든 호출이 가능하도록 public처리
	 
	 public static Manager getinstance() {
		 
		 if(m==null) {
			 m = new Manager();
		 }
		 
		 return m;
	 }
	 
	 void insertMember() {
		// 입력받기 -> 인스턴스 생성 -> 출력
		// 지역변수는 처음에 초기화 해야함
					
		// 현재 입력 스케너의 버퍼를 삭제
			Util.sc.nextLine();
					
		//사용자의 입력데이터 저장:
			String name = null;
			String pNumber = null;
			String birthday = null;
					
			System.out.println("데이터입력");
			System.out.println("친구의 이름을 입력해주세요.");
			name = Util.sc.nextLine();
					
			System.out.println("친구의 전화번호를 입력해주세요.");
			pNumber = Util.sc.nextLine();
					
			System.out.println("친구의 생일을 입력해주세요.");
			birthday = Util.sc.nextLine();
					
			//사용자로부터 입력받은 데이터로 인스턴스 생성 (객체의 변수에 저장)
			PhoneInfo pi = null;
					
			//birthday.trim().length()<1 ==> 만약 사용자가 공백을 입력했을 경우> trim > 문자열길이가 =0
			//birthday==null ==> 앞쪽의 조건으로 제시해야지 오류가 안남
			if(birthday==null || birthday.trim().length()<1) {
				pi = new PhoneInfo(name, pNumber);
			} else {
				pi = new PhoneInfo(name, pNumber, birthday);
			}
					
			pi.showInfo();
	}
}
