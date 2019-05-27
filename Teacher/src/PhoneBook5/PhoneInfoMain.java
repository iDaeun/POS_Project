package PhoneBook5;

import util.Menu;
import util.Util;

public class PhoneInfoMain {

	public static void main(String[] args) {
		
		//PhoneBookManager manager = new PhoneBookManager(100);
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while (true) {

			int choice = manager.printMenu();

			switch (choice) {

			case Menu.INSERT:
				manager.insert();
				break;

			case Menu.SEARCH:
				manager.searchPrint();
				break;

			case Menu.ALLDATA:
				manager.showAllData();
				break;

			case Menu.DELETE:
				manager.searchDelete();
				break;

			case Menu.QUIT:
				System.out.println("종료");
				return;

			}

		}

	}

}
