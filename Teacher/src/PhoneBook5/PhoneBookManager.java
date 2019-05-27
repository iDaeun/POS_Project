package PhoneBook5;

import util.Menu;
import util.Util;

public class PhoneBookManager {
	
	//객체저장을 목적으로 배열 생성
	//배열의 요소 컨트롤을 위한 메서드 구성
	
	final PhoneInfo1[] pb;
	int cnt;
	
	//싱글톤 처리 방식
	//1.생성자의 접근제한: private 생성자()
	//2.클래스 내부에서 인스턴스 생성: static, private(외부에서 인스턴스 접근 못함)
	//3.참조값을 반환하는 메소드 생성: static
	
	//인스턴스를 반환하는 메소드 생성
	public static PhoneBookManager getInstance() {
		if(m==null) {
			m = new PhoneBookManager();
		}
		return m;
	}
	
	//인스턴스 생성
	//static PhoneBookManager m = new PhoneBookManager(200);
	//PhoneBookManager.m = null; => 접근이 가능하게됨!
		private static PhoneBookManager m = new PhoneBookManager(200);


	//외부에서 인스턴스 생성을 금지 + private
	private PhoneBookManager() {
		this(100); //this -> 생성자 호출
	}
	
	private PhoneBookManager(int size) {
	pb = new PhoneInfo1[size];
	cnt = 0;
	}
	
	public void insertMember(int select) {
		//1. 기본정보 받기 : 이름, 전화번호
		//2. 프로그램 흐름결정 : if/switch(select) 
		//  1=> 대학친구의 추가정보 받기
		//  2=> 회사친구의 추가정보 받기
		//  3=> 동호회친구의 추가정보 받기
		//3. 인스턴스 생성
		//4. 배열에 저장
		
		PhoneInfo1 pi = null;
		
		//1. 기본정보 받기
		System.out.println("친구의 이름을 입력해주세요");
		String name = Util.sc.nextLine();
		System.out.println("친구의 전화번호를 입력해주세요");
		String phoneNumber = Util.sc.nextLine();
		
		// 2. 입력의 흐름 처리
		if (select == Menu.INSERT_UNIV) {

			// 대학친구 추가정보 받기
			System.out.println("주소 입력해주세요");
			String address = Util.sc.nextLine();
			System.out.println("이메일 입력해주세요");
			String email = Util.sc.nextLine();
			System.out.println("전공 입력해주세요");
			String major = Util.sc.nextLine();
			System.out.println("학년 입력해주세요");
			int grade = Util.sc.nextInt();

			// 3. 인스턴스 생성
			pi = new PhoneUnivInfo(name, phoneNumber, address, email, major, grade);

		} else if (select == Menu.INSERT_COM) {

			// 회사친구 추가정보 받기
			System.out.println("회사이름을 입력해주세요");
			String company = Util.sc.nextLine();
			System.out.println("이메일을 입력해주세요");
			String email = Util.sc.nextLine();

			// 3. 인스턴스 생성
			pi = new PhoneCompanyInfo(name, phoneNumber, company, email);

		} else {

			// 동호회친구 추가정보 받기
			System.out.println("별명을 입력해주세요");
			String nickName = Util.sc.nextLine();

			// 3. 인스턴스 생성
			pi = new PhoneCafeInfo(name, phoneNumber, nickName);

		}

		// 4. 인스턴스를 배열에 저장
		pb[cnt++] = pi;

	}

	// 배열에 저장된 모든 데이터 출력
	public  void showAllData() {

		System.out.println("----------------------");
		if (cnt > 0) {
			for (int i = 0; i < cnt; i++) {
				pb[i].showData();
			}
		} else {
			System.out.println("등록된 친구정보가 없습니다.");
		}
		System.out.println("----------------------");
	}

	public  void searchPrint() {

//		Util.sc.nextLine();
		System.out.println("검색할 친구의 이름을 입력해주세요.");
		String name = Util.sc.nextLine();
		
		int index = searchIndex(name);

		// 검색된 index 값을 비교하고 정보 출력
		if (index < 0) {
			System.out.println("검색하신 이름의 정보가 없습니다.");
		} else {
			pb[index].showBasicInfo();
		}
	}

	public  void searchDelete() {
//		Util.sc.nextLine();
		
		System.out.println("삭제하고자하는 친구의 이름을 입력해 주세요.");
		String name = Util.sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다."); 
		} else {
			// 삭제: 검색한 index부터 저장된 위치까지 왼쪽으로 시프르처리
			for(int i=index; i<cnt-1; i++) {
				pb[i] = pb[i+1];
			}
			//저장된 친구 정보의 개수 감소
			cnt--;
			System.out.println("요청하신 이름의 정보를 삭제했습니다.");
		}
	}
	
	//키워드로 배열의 요소.name 문자열과 비교 후 매칭되는 요소의 index를 반환
	public int searchIndex(String keyword) {
		//검색 결과의 index: -1(검색의 결과가 없다)
		int index = -1;
		
		// 배열에서 문자열 비교 후 같은 값을 가지는 객체의 index 값을 구하는 기능
		for(int i=0; i<cnt; i++) {
			if(pb[i].name.equals(keyword)) {
				index = i;
				break;
			}
		}
		return index;
	}	

	public int printMenu() {
		System.out.println("==============================");
		System.out.println("메뉴를 선택해 주세요.");
				//해당 숫자가 바뀌어도 내용이 알아서 바뀐 숫자에 맞출 수 있도록:
		System.out.printf("%d.입력\n%d.검색\n%d.삭제 \n%d.전체 정보 출력\n%d.종료\n",
				Menu.INSERT,Menu.SEARCH,Menu.DELETE,Menu.ALLDATA,Menu.QUIT);
		System.out.println("==============================");

		int choice = Util.sc.nextInt();
		
		//버퍼 지워버리기
		Util.sc.nextLine();

		return choice;
	}
	
	public void insert() {
		System.out.println("===================");
		System.out.println("입력 형태를 선택해주세요.");
		System.out.println(Menu.INSERT_UNIV +". 대학친구 ");
		System.out.println(Menu.INSERT_COM +". 회사친구 ");
		System.out.println(Menu.INSERT_CAFE +". 동호회친구 ");
		System.out.println("===================");
		
		//입력방식 선택
		int select = Util.sc.nextInt();
		
		Util.sc.nextLine();
		
		insertMember(select);
		
	}
	
}
