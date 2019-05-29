import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class SupplierManager {
	// 거래처 관리 클래스
	// 거래처 관리 기능 모음
	

	SupplierManager(){
	// 기본으로 입력되어 있어야 할 정보를 생성자로 통해 초기화
		si.add(new SupplierBasicInfo("이천 쌀 전문","01099342242","서울시 종로구 어디어디","쌀",10000));
		si.add(new SupplierBasicInfo("단무지 공장","01023456789","인천시 남동구 어디","단무지",500));
		si.add(new SupplierBasicInfo("양반김 상회","01012345678","서울시 종로구 광장시장","김",2000));
	}

	
	static ArrayList<SupplierBasicInfo> si = new ArrayList<SupplierBasicInfo>();
	
	
	// 거래처관리 메뉴 출력.
	public void printMenu() {
		System.out.println("=====================");
		while(true) {
			System.out.println("[거래처 관리]\n메뉴를 선택해주세요.\n");
			System.out.println("1. 거래처 등록 / 2. 거래처 삭제 / 3. 거래처 수정 / 4. 거래처 목록 / 5. 발주하기 / 6. 메인으로 돌아가기");
			
			int choice = Util.sc.nextInt();
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
				showAllSupplier();
				break;
			case 5:
				showOrderIngredients();
				break;
			case 6:
					System.out.println("메인으로 돌아갑니다.\n");
					return;
				
			}
		}
	}
	
	// 거래처 등록 기능
	void insertSupplier() {
		
		String name;
		String phoneNum;
		String address;
		String ingName;
		int ingPrice;
		
		System.out.println("거래처 이름을 입력하세요.");
		name = Util.sc.nextLine();
		System.out.println("거래처 전화번호를 입력하세요.");
		phoneNum = Util.sc.nextLine();
		
		System.out.println("거래처 주소를 입력하세요.");
		address = Util.sc.nextLine();
		System.out.println("거래할 품목을 적어주세요.");
		ingName = Util.sc.nextLine();		
		System.out.println("거래 품목의 원가를 지정해주세요.");
		ingPrice = Util.sc.nextInt();
		Util.sc.nextLine();
		
		si.add(new SupplierBasicInfo(name,phoneNum,address,ingName,ingPrice));		
	}
	
	
	// 거래처 삭제
	void deleteSupplier() {
		
		System.out.println("삭제할 거래처 번호를 입력하세요.");
		String num = Util.sc.nextLine();
		
		int idx = searchIndex(num);
		
			if(si.get(idx).phoneNum.equals(num)) {
				System.out.println("================================");	
				si.get(idx).showData();
				System.out.println("================================");	
				
				System.out.println("삭제하시겠습니까? \n1. 네 / 2. 아니오.");
				int select = Util.sc.nextInt();
				
				switch(select) {
					case 1: 
						si.remove(si.get(idx));
						System.out.println("삭제를 완료했습니다.\n");
						break;
					case 2: 
						System.out.println("취소했습니다.");
						return;
					default :
						System.out.println("올바른 값을 입력하세요.");						
				}
				
			} else {
				
				System.out.println("다시 검색해주세요.\n");
				return;
				
			}
		}	
	
	
	
	// 거래처 수정
	void modifySupplier() {
		
		System.out.println("수정할 거래처 번호를 입력하세요.\n");
		String num = Util.sc.nextLine();
		
		int idx = searchIndex(num);
			
			if(idx>0) {
				
				System.out.println("================================");				
				si.get(idx).showData();
				System.out.println("================================");
				
				System.out.println("수정할 목록을 선택하세요.\n1. 거래처 이름 / 2. 거래처 주소 / 3. 거래처 번호");
				int select = Util.sc.nextInt();
				Util.sc.nextLine();
				
				switch(select){
				
					case 1:
						System.out.println("수정할 거래처 이름을 입력하세요.\n");
						String name = Util.sc.nextLine();
						si.get(idx).setName(name);
						break;
					
					case 2: 
						System.out.println("수정할 거래처 주소를 입력하세요.\n");
						String address = Util.sc.nextLine();
						si.get(idx).setAddress(address);
						break;
					
					case 3: 
						System.out.println("수정할 거래처 번호를 입력하세요.\n");
						String phoneNum = Util.sc.nextLine();
						si.get(idx).setPhoneNum(phoneNum);
						break;
						
					default:
						System.out.println("올바른 값을 넣어주세요.\n");
						
				}
			System.out.println("수정을 완료했습니다.\n");
			
			} else {
				
				System.out.println("해당 정보를 가진 거래처가 존재하지 않습니다.\n");
				return;
				
			}
		}
	

	// 거래처 현황 출력 기능
	void showAllSupplier() {
		System.out.println("===============================");
		System.out.println("현재 거래처 현황입니다.\n");
		
		for(int i=0;i<si.size();i++) {
			System.out.println("================================");
			si.get(i).showData();
			System.out.println("================================");
		}
		
	}
	
	

	// 발주 기능
	void showOrderIngredients() {
		System.out.println("===============================");
		System.out.println("현재 거래하고 있는 품목 현황입니다.\n");
		
		for(int i=0;i<si.size();i++) {
			System.out.println("================================");
			si.get(i).printIngredient(si.get(i).getName());
			System.out.println("================================");
		}
		
		System.out.println("재료 주문을 하시겠습니까?\n1. 네 / 2. 아니오(돌아가기)");
		
		int choice = Util.sc.nextInt();
		Util.sc.nextLine();
		
		if(choice ==1) {
			orderIngredient();
		} else {
			return;
		}

		
	}

	void orderIngredient() {
		System.out.println("=====================");
		
		int num = 0;
		int idx = -1;
		
		System.out.println("[발주 관리]");
		System.out.println("발주할 재료의 이름을 입력하세요.");
		String name = Util.sc.nextLine();
		
		
		for(int i=0;i<IngredientManager.ingredientList.size();i++) {
			
			if(IngredientManager.ingredientList.get(i).getName().equals(name)) {
				idx = i; 
			}
			
		}
		
		
		if(idx>0) {
			System.out.println("주문 수량을 입력해주세요.\n");		
			
			// 재료 수량 추가
			num = Util.sc.nextInt();
			System.out.println("------------------------");
			System.out.println("예상 재고 수량 : "+(int)(IngredientManager.ingredientList.get(idx).getNum()+(num))+"\n주문 하시겠습니까? 1. 네 2. 아니오\n");
			System.out.println("------------------------");
			int select = Util.sc.nextInt();
			switch(select) {
				case 1:
					IngredientManager.ingredientList.get(idx).setNum(IngredientManager.ingredientList.get(idx).getNum()+num);
					System.out.println("발주를 완료했습니다.\n");
					break;
				case 2:
					System.out.println("취소했습니다.\n");
					break;
			}
		} else {
				System.out.println("현재고의 품목과 일치하지 않습니다. 다시 입력해주세요.\n");	
		}
		
	}
	
	
	int searchIndex(String keyword) {
		int idx = -1;
		
		for(int i=0;i<si.size();i++) {
			if(si.get(i).phoneNum.equals(keyword)) {
				idx = i;
				break;
			}
		}
		
		return idx;
	}

	
}
