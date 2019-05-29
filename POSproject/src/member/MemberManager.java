package member;

import java.util.HashSet;
import java.util.Iterator;

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

	public HashSet<Member> getHashSet() {
		return hashSet;
	}

	// 1.입력
	public void addMember() {
		System.out.print("이름: ");
		String name = util.Util.scan.nextLine();
		System.out.print("전화번호: ");
		String phoneNum = util.Util.scan.nextLine();

		Member member = new Member(name, phoneNum);

		hashSet.add(member);
		System.out.println("회원정보가 등록되었습니다.");
	}

	// 2. 수정
	public void changeMember() {

		System.out.print("검색할 회원의 전화번호: ");
		String phoneNum = util.Util.scan.nextLine();

		Iterator<Member> ir = hashSet.iterator();

		while (ir.hasNext()) {
			Member temp = ir.next();
			if (temp.getPhoneNum().equals(phoneNum)) {
				System.out.print("어떤 사항을 수정하시겠습니까? 1. 이름 |2. 전화번호");
				int choice = util.Util.scan.nextInt();
				util.Util.scan.nextLine();
				switch (choice) {
				case 1:
					System.out.print("이름: ");
					String rename = util.Util.scan.nextLine();
					temp.setName(rename);
					return;

				case 2:
					System.out.print("전화번호: ");
					String rePhoneNum = util.Util.scan.nextLine();
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
		String phoneNum = util.Util.scan.nextLine();

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
		String phoneNum = util.Util.scan.nextLine();

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

	public String showPoint() {
		System.out.print("검색할 회원의 전화번호: ");
		String phoneNum = util.Util.scan.nextLine();

		Iterator<Member> ir = hashSet.iterator();
		while (ir.hasNext()) {
			Member temp = ir.next();
			if (temp.getPhoneNum().equals(phoneNum)) {
				return "현재 포인트는 " + temp.getPointNum() + "입니다.";
			}
		}
		return "회원정보가 존재하지 않습니다.";
	}

	// 5. 모든 데이터 보여주기
	public void showAll() {
		for (Member member : hashSet) {
			member.showData();
		}
		System.out.println();
	}

	public void showMenu() {
		System.out.println("회원관리 메뉴입니다. 원하시는 번호를 선택해주세요.");

		System.out.printf("%d. 회원정보 등록 |%d. 회원정보 수정 |%d. 회원정보 삭제 |%d. 회원정보검색 |%d. 회원현황", util.Util.ADDMEMBER,
				util.Util.CHANGEMEMBER, util.Util.REMOVEMEMBER, util.Util.SHOWMEMBERDATA, util.Util.SHOWALL);
		int choice = util.Util.scan.nextInt();
		util.Util.scan.nextLine();

		// 나중에 예외처리하기
		switch (choice) {
		// 1. 회원정보 등록
		case 1:
			MemberManager.getManager().addMember();
			break;
		// 2. 회원정보 수정
		case 2:
			MemberManager.getManager().changeMember();
			break;
		// 3. 회원정보 삭제
		case 3:
			MemberManager.getManager().removeMember();
			break;

		// 4. 회원정보: 포인트, 레벨 보여주기
		case 4:
			MemberManager.getManager().showData();
			break;

		// 5. 모든 회원정보 보여주기
		case 5:
			MemberManager.getManager().showAll();
			break;

		}
	}

}
