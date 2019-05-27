package Phonebook;

//친구의 데이터를 저장하고 출력하는 프로그램
class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneInfo pi1 = new PhoneInfo("짱구","123-123","0513");
		PhoneInfo pi2 = new PhoneInfo("철수","456-456");
		
		pi1.showInfo();
		pi2.showInfo();

	}

}
