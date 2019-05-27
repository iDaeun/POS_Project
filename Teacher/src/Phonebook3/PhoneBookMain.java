//package Phonebook3;
//
//import util.Util;
//
//public class PhoneBookMain {
//
//	// 친구정보를 배열로 저장 : 100개 저장 가능
//	static PhoneInfo[] pb = new PhoneInfo[100];
//
//	// 입력된 친구 정보의 개수 : 입력 시에 +1, 삭제 시 -1
//	// 배열의 전체 참조시에 배열의 사이즈 대신 반복의 횟수를 정
//	static int cnt = 0;
//
//	public static void main(String[] args) {
//
//		while (true) {
//			int choice = printMenu();
//
//			System.out.println("사용자가 입력한 메뉴값: " + choice);
//
//			switch (choice) {
//			case 1:
//				insertMember();
//				break;
//
//			case 2:
//				searchPrint();
//				break;
//
//			case 3:
//				searchDelete();
//				break;
//
//			case 4:
//				showAllData();
//				break;
//
//			case 5:
//				System.out.println("사용자가 입력한 명령은 종료 입니다. \n프로그램을 종료 합니다.");
//				return; // 메소드 완전 종료
//			// break; //블록을 빠져나감
//
//			default:
//				break;
//			}
//		}
//
//	} // 메인메소드
//
//
//
//}
