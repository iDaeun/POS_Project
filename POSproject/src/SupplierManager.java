

import java.util.ArrayList;

//import util.Util;

public class SupplierManager {
	// 거래처 관리 클래스
	// 거래처 관리 기능 모음
	
	SupplierManager(){
		si.add(new SupplierBasicInfo("이천쌀전문","01099342242","서울시 종로구 어디어디","쌀",100));
		si.add(new SupplierBasicInfo("단무지공장","01023456789","인천시 남동구 어디","단무지",50));
		si.add(new SupplierBasicInfo("양반김","01000000000","서울시 종로구 광장시장","김",20));
	}

	
	public static ArrayList<SupplierBasicInfo> si = new ArrayList<SupplierBasicInfo>();
	public static ArrayList<BuyIngredient> bInfo = new ArrayList<BuyIngredient>();
	public static BuyIngredient bi = new BuyIngredient();

	
	
	// 포스 메인에서 불러와야 하기 때문에 public이어야함.
	public void printMenu(int choice) {
		// 거래처관리 메뉴 출력.
		while(true) {
			System.out.println("[거래처 관리]\n메뉴를 선택해주세요.");
			System.out.println("1. 거래처 등록\n2. 거래처 삭제\n3. 거래처 수정\n4. 발주 품목 관리\n5. 발주\n6. 거래처 목록\n7. 메인으로 돌아가기");
			
			choice = Util.sc.nextInt();
			Util.sc.nextLine();
			
			
			switch(choice) {
			case 1: 
				insertSupplier();
				break;
			case 2: 
				deleteSupplier();
				break;
			case 3: 
				modifySupplier();
				break;
			case 4: 
				manageIngre();
			case 5:
				orderSupplier();
				break;
			case 6:
				showAllSupplier();
				break;
			case 7:
					System.out.println("메인으로 돌아갑니다.");
					return;
				
			}
		}
	}
	
	void insertSupplier() {
		// 거래처 등록 기능
		String name;
		String phoneNum;
		String address;
		String ingName;
		
		System.out.println("거래처 이름을 입력하세요.");
		name = Util.sc.nextLine();
		System.out.println("거래처 전화번호를 입력하세요.");
		phoneNum = Util.sc.nextLine();
		System.out.println("거래처 주소를 입력하세요.");
		address = Util.sc.nextLine();
		System.out.println("거래할 품목을 적어주세요.");
		ingName = Util.sc.nextLine();
		
		
		si.add(new SupplierBasicInfo(name,phoneNum,address,ingName));
		
		
	}
	void deleteSupplier() {
			
		System.out.println("삭제할 거래처 이름을 입력하세요.");
		String name = Util.sc.nextLine();
		
		int idx = searchIndex(name);
			
		if(idx>0) {
			si.remove(idx);
			System.out.println("삭제를 완료했습니다.");
		} else {
			System.out.println("다시 검색해주세요.");
		}
	
		// 거래처 삭제
	}
	void modifySupplier() {
		// 거래처 수정
		System.out.println("수정할 거래처 이름을 입력하세요.");
		String name = Util.sc.nextLine();
		
		int idx = searchIndex(name);
		
		if(idx>0) {
			insertSupplier();
			System.out.println("수정을 완료했습니다.");
		} else {
			System.out.println("다시 검색해주세요.");
		}
	}
	
	int searchIndex(String keyword) {
		int idx = -1;
		
		for(int i=0;i<si.size();i++) {
			if(si.get(i).name.equals(keyword)) {
				idx = i;
				break;
			}
		}
		
		return idx;
	}
	
	void showAllSupplier() {
		// 거래처 현황 출력
		System.out.println("현재 거래처 현황입니다.");
		for(int i=0;i<si.size();i++) {
			System.out.println("-----------");
			si.get(i).showData();
			System.out.println("-----------");
		}
		
	}
	
	void manageIngre() {
		System.out.println("현재 거래하고 있는 품목 현황입니다.");
		
		for(int i=0;i<si.size();i++) {
			si.get(i).printIngredient();
		}
		
		return;
		
		
	}
	
	void orderSupplier() {
		
		
		System.out.println("발주할 재료의 이름을 입력하세요");
		
		
		String name = Util.sc.nextLine();
		int num = 0;
		
		for(int i=0;i<IngredientManager.ingredientList.size();i++) {
			if(IngredientManager.ingredientList.get(i).getName().equals(name)) {
				System.out.println("주문 수량을 입력하세요.");
				num = Util.sc.nextInt();
				IngredientManager.ingredientList.get(i).setNum(IngredientManager.ingredientList.get(i).getNum()+num);
				
				
				System.out.println("발주를 완료했습니다.");
				break;
			} else {
				System.out.println("재료가 일치하지 않습니다.");
			}
		}
		
		
		
//		for(int i=0;i<bi.size();i++) {			
//			if(name == bi.get(i).name) {
//				System.out.println("구매할 수량을 입력하세요.");
//				int num = Util.sc.nextInt();
//				
//				
//			}
//		}
		
		
		
		
		
		
	}

}
