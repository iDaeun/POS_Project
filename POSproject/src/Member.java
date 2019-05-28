

public class Member {

	// 회사에서 관리해야할 정보
	private static int serialNum = 1; // 회원번호 자동부여
	private int memberNum; // 회원번호
	private int pointNum; // 포인트
	private String level; //회원등급 : 일반회원, VIP회원
	
	// 회원으로부터 받아야 할 정보
	private String name; // 이름
	private String phoneNum; // 전화번호

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public int getPointNum() {
		return pointNum;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public void setPointNum(int pointNum) {
		this.pointNum = pointNum;
	}

	//생성자
	public Member(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
		memberNum = serialNum;
		serialNum++;
		this.pointNum = 0;
		this.level = "일반회원";
	}

	//회원정보 출력
	public void showData() {
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNum);
		System.out.println("회원번호: " + memberNum);
		System.out.println("잔액 포인트: " + pointNum);
		System.out.println("회원등급: " + level);

	}

}
