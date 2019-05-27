

import java.util.HashSet;

public class MethodTest {
	public static void main(String[] args) {
		
		Member kim = new Member("김갹갹","1111-1111");
		MemberManager.getManager().getHashSet().add(kim);
		MemberManager.getManager().showData();
		
		PointManager.getManager().addPoint(10000);
		PointManager.getManager().addPoint(10000);
		MemberManager.getManager().showData();
	}
}
