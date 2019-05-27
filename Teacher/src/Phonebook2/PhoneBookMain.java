package Phonebook2;

import java.util.Scanner;

import util.Util;

class PhoneBookMain {
	
	//static 변수로 만들어주기~!!
//	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이 핵심.
		//단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
		//프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.

		//Scanner sc = new Scanner(System.in); -> sc는 지역변수이기 때문에 밑에 static method에서 사용 불가
		
		while(true) {
			
		System.out.println("================");
		System.out.println("메뉴를 선택하세요");
		System.out.println("1.입력 | 2.종료");
		System.out.println("================");
		
		//Util.sc.nextInt(); -> Util class의 scanner참조
		int choice = Util.sc.nextInt();
		
		if(choice==1) {
			//Manager manager = new Manager(); => method참조
			//new Manager().insertMember();
			//Manager클래스 -> Singleton => Manager.getinstance()을 통해서 불러옴!
			Manager.getinstance().insertMember();
		} else if(choice==2) {
			System.out.println("프로그램 종료");
			return; //=break;
			//종료!! => return 사용!!!
		} else {
			//메뉴 선택으로 이동
			System.out.println("정상적인 메뉴번호를 입력해주세요.");
			}
		}
				
	}
	
	

}
