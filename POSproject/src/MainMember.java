

import Util.util;

public class MainMember {

	public static void main(String[] args) {

		System.out.println("회원관리 메뉴입니다. 원하시는 번호를 선택해주세요.");
		while (true) {
			System.out.printf("%d. 회원정보 등록 |%d. 회원정보 수정 |%d. 회원정보 삭제 |%d. 회원정보검색 |%d. 회원현황", util.addMember,
					util.changeMember, util.removeMember, util.showMemeberData, util.showAll);
			int choice = util.scan.nextInt();
			util.scan.nextLine();

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

}
