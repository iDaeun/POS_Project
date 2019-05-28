

import java.util.HashSet;
import java.util.Iterator;

import Util.util;

public class MemberManager {

	// Singleton으로 구현하여 외부에서의 접근 차단
	private MemberManager() {
	};

	private static MemberManager manager = new MemberManager();

	public static MemberManager getManager() {
		if (manager == null) {
			manager = new MemberManager();
		}
		return manager;
	}

	private HashSet<Member> hashSet = new HashSet<Member>();

	public HashSet<Member> getHashSet(){
		return hashSet;
	}
	
	// 1.입력
	public void addMember() {
		System.out.print("이름: ");
		String name = util.scan.nextLine();
		System.out.print("전화번호: ");
		String phoneNum = util.scan.nextLine();

		Member member = new Member(name, phoneNum);

		hashSet.add(member);
		System.out.println("회원정보가 등록되었습니다.");
	}

	// 2. 수정
	public void changeMember() {

		System.out.print("검색할 회원의 전화번호: ");
		String phoneNum = util.scan.nextLine();

		Iterator<Member> ir = hashSet.iterator();

		while (ir.hasNext()) {
			Member temp = ir.next();
			if (temp.getPhoneNum().equals(phoneNum)) {
				System.out.print("어떤 사항을 수정하시겠습니까? 1. 이름 |2. 전화번호");
				int choice = util.scan.nextInt();
				util.scan.nextLine();
				switch (choice) {
				case 1:
					System.out.print("이름: ");
					String rename = util.scan.nextLine();
					temp.setName(rename);
					return;

				case 2:
					System.out.print("전화번호: ");
					String rePhoneNum = util.scan.nextLine();
					temp.setPhoneNum(rePhoneNum);
					return;
				}
			}

		}
		System.out.println("회원정보가 존재하지 않습니다.");
	}

	// 3. 삭제
	public void removeMember() {

		System.out.print("검색할 회원의 전화번호: ");
		String phoneNum = util.scan.nextLine();

		Iterator<Member> ir = hashSet.iterator();
		while (ir.hasNext()) {
			Member temp = ir.next();
			if (temp.getPhoneNum().equals(phoneNum)) {
				hashSet.remove(temp);
				System.out.println("정보가 삭제되었습니다.");
				return;
			}
		}
		System.out.println("회원정보가 존재하지 않습니다.");
		return;
	}

	// 4. 데이터 보여주기
	public void showData() {
		System.out.print("검색할 회원의 전화번호: ");
		String phoneNum = util.scan.nextLine();

		Iterator<Member> ir = hashSet.iterator();
		while (ir.hasNext()) {
			Member temp = ir.next();
			if (temp.getPhoneNum().equals(phoneNum)) {
				temp.showData();
				return;
			}
		}
		System.out.println("회원정보가 존재하지 않습니다.");
	}

	// 5. 모든 데이터 보여주기
	public void showAll() {
		for (Member member : hashSet) {
			member.showData();
		}
		System.out.println();
	}
	
	public void showMenu() {
		
	}

}
