


import java.util.ArrayList;
public class testposMain{

	public static void main(String[] args) {
		
		// 1. 재고관리 
		// 2. 판매관리
		//    2-1. 주문    2-2 결제
		// 3. 거래처 관리 
		// 4. 판매내역 - 히스토리 어떤 주문을 어떤가격으로 갔는지 현재시간 -> 일별 주별 월별 /판매 정보 클래스 있고 결제할때 거기에 처리 / 통계 기능 클래스 따로
		//   4-1. 일별 4-2 주별 4-3 월별
		// 5. 메뉴관리 /시즌메뉴같은거 추가삭제/재고
		// 6 회원 - 포인트적립/ 계산시 포인트사용/ 
		// 7. 종료
		
		
		/* 분담 정리 */
		
		// 1. 회원 관리 - [김한솔]
		// 2. 재고 관리 - [강다은]
		// 3. 판매 관리 - [백민종]
		//    3-1 주문   3-2 결제
		// 4. 거래처 관리 - [주예리나]
		// 5. 판매내역 관리 - [김다애]
		// 6. 메뉴 관리 - [김희수]
		// 7. 종료
		int choice = 0;
		
		SupplierManager sp = new SupplierManager();
		IngredientManager im = new IngredientManager();
//		SellManager sm = new SellManager();
		
		while(choice>0 ||choice<7) {
			
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1. 회원관리 2. 재고관리 3. 판매관리 4. 거래처 관리 5.판매내역관리 6.메뉴관리 7. 종료");
			choice = Util.sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("회원관리");
				break;
			case 2:
				System.out.println("재고관리");
				im.showMenu();
				break;
			case 3:
				System.out.println("판매관리");
//				sm.selectSellMenu();
				break;
			case 4:
				sp.printMenu();
				break;
			case 5:
				break;
			case 6:
				return;
			}
	}
	}

}
