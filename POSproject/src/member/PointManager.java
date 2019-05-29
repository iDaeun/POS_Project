package member;


import java.util.HashSet;
import java.util.Iterator;

import util.Util;

public class PointManager {

	// Singleton으로 구현하여 외부에서의 접근차단
	private PointManager() {
	};

	private static PointManager pointManager = new PointManager();

	public static PointManager getManager() {
		if (pointManager == null) {
			pointManager = new PointManager();
		}
		return pointManager;
	}

	// 회원정보 체크
	public void checkLevel(Member member) {
		
		String level = member.getLevel();
		
		int currentPoint = member.getPointNum();
				
		if (currentPoint > 1000) {
			System.out.println("VIP로 업그레이드 되었습니다.");
			member.setLevel("VIP회원");
		}
	}

	// 포인트 적립 계산
	public int calcPoint(int price, Member member) {
		
		String level = member.getLevel();
		
		int currentPoint = member.getPointNum();

		if (level == "일반회원") {
			int addPoint = (int) (price * 0.1); // 일반회원 - 10% 적립
			currentPoint += addPoint;

		} else if (level == "VIP회원") {
			int addPoint = (int) (price * 0.2); // VIP회원 - 20% 적립
			currentPoint += addPoint;
		}
		return currentPoint;
	}

	// ★ 포인트 증가
	public void addPoint(int price) {

		System.out.print("회원의 전화번호: ");
		String phoneNum = Util.scan.nextLine();
		HashSet<Member> hashSet = MemberManager.getManager().getHashSet();

		Iterator<Member> ir = hashSet.iterator();

		while (ir.hasNext()) {
			Member temp = ir.next();
			if (temp.getPhoneNum().equals(phoneNum)) {
				int pointNum = calcPoint(price, temp);
				temp.setPointNum(pointNum);
				System.out.println("포인트가 적립 완료되었습니다."); 
				
				checkLevel(temp); //포인트 적립 후, 포인트 반영
				
				return;
			}
		}
		System.out.println("회원정보가 존재하지 않습니다.");
	}

	//포인트 차감 계산
	public int deductPoint(int price, Member member) {
		int currentPoint = member.getPointNum();
		
		if (currentPoint > 0) {
			System.out.print("얼마의 포인트를 사용하시겠습니까?");
			int deductPoint = Util.scan.nextInt(); //사용할 포인트
			Util.scan.nextLine();

			if (currentPoint >= deductPoint) { //현재 포인트 > 사용할 포인트
				price -= deductPoint; //가격 - 차감포인트
				currentPoint -=deductPoint; //현재 내 포인트 = 포인트 - 차감포인트
				member.setPointNum(currentPoint);
				System.out.println("포인트가 사용되었습니다.");
				
			} else {
				System.out.println("현재 포인트를 초과하였습니다.");
			}
		} else {
			System.out.println("포인트가 없습니다.");
		}
		return currentPoint;
	}

	// ★ 포인트 차감
	public void usePoint(int price) {
		System.out.print("회원의 전화번호: ");
		String phoneNum = Util.scan.nextLine();
		HashSet<Member> hashSet = MemberManager.getManager().getHashSet();
		
		Iterator<Member> ir = hashSet.iterator();
		
		while(ir.hasNext()) {
			Member temp = ir.next();
			if(temp.getPhoneNum().equals(phoneNum)) {
				deductPoint(price, temp);
				return;
			}
		} 	
		System.out.println("회원정보가 존재하지 않습니다.");
	}
	
	
}