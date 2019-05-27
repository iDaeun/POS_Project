package Phonebook4;

import util.Util;

public class PhoneInfoMain {

	public static void main(String[] args) {
		
		//PhoneBookManager manager = new PhoneBookManager(100);
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while (true) {

			int choice = manager.printMenu();

			switch (choice) {

			case Util.INSERT:
				manager.insert();
				break;

			case Util.SEARCH:
				manager.searchPrint();
				break;

			case Util.ALLDATA:
				manager.showAllData();
				break;

			case Util.DELETE:
				manager.searchDelete();
				break;

			case Util.QUIT:
				System.out.println("종료");
				return;

			}

		}

	}

}
