package Phonebook3;

import util.Util;

public class PhoneBookMain1 {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager(200);
		int choice = 5; //5=종료로 초기값으로 둠
		
		while(true) {
			
			choice = manager.printMenu();
			
			switch (choice) {
			case Util.INSERT:
				manager.insertMember();
				break;

			case Util.SEARCH:
				manager.searchPrint();
				break;

			case Util.DELETE:
				manager.searchDelete();
				break;

			case Util.ALLDATA:
				manager.showAllData();
				break;

			case Util.QUIT:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				break;
			}	
		}
	} //메인

}
