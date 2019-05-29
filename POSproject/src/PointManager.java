

import java.util.HashSet;
import java.util.Iterator;

import Util.util;

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
	public String checkLevel(Member member) {
		String level = member.getLevel();

		if (member.getPointNum() > 1000) {
			member.setLevel("VIP회원");
			level = member.getLevel();
		}
		return level;
	}

	// 포인트 적립 계산
	public int calcPoint(int price, Member member) {
		String level = checkLevel(member);
		int pointNum = member.getPointNum();

		if (level == "일반회원") {
			int point = (int) (price * 0.1); // 10% 적립
			pointNum += point;

		} else if (level == "VIP회원") {
			int point = (int) (price * 0.2); // 20% 적립
			pointNum += point;
		}
		return pointNum;
	}

	// ★ 포인트 증가
	public void addPoint(int price) {

		System.out.println("회원의 전화번호: ");
		String phoneNum = util.scan.nextLine();
		HashSet<Member> hashSet = MemberManager.getManager().getHashSet();

		Iterator<Member> ir = hashSet.iterator();

		while (ir.hasNext()) {
			Member temp = ir.next();
			if (temp.getPhoneNum().equals(phoneNum)) {
				int pointNum = calcPoint(price, temp);
				temp.setPointNum(pointNum);
				System.out.println("포인트가 적립 완료되었습니다.");
				return;
			}
		}
		System.out.println("회원정보가 존재하지 않습니다.");
	}

	//포인트 차감 계산
	public int deductPoint(int price, Member member) {
		int point = member.getPointNum();
		int pointNum = 0;
		
		if (point > 0) {
			System.out.println("얼마의 포인트를 사용하시겠습니까?");
			int deductPoint = util.scan.nextInt();
			util.scan.nextLine();

			if (point >= deductPoint) {
				price -= deductPoint; //가격 - 차감포인트
				pointNum -=deductPoint; //내 포인트 - 차감포인트
				member.setPointNum(pointNum);
				System.out.println("포인트가 사용되었습니다.");
			} else {
				System.out.println("현재 포인트를 초과하였습니다.");
			}
		} else {
			System.out.println("포인트가 없습니다.");
		}
		return price;
	}

	// ★ 포인트 차감
	public int usePoint(int price) {
		
		int currentPrice = 0;
		System.out.println("회원의 전화번호: ");
		String phoneNum = util.scan.nextLine();
		HashSet<Member> hashSet = MemberManager.getManager().getHashSet();
		
		Iterator<Member> ir = hashSet.iterator();
		
		while(ir.hasNext()) {
			Member temp = ir.next();
			if(temp.getPhoneNum().equals(phoneNum)) {
				currentPrice = deductPoint(price, temp);
				break;
			}
		} 
		System.out.println("회원정보가 존재하지 않습니다.");	
		return currentPrice;	
	}
		
}