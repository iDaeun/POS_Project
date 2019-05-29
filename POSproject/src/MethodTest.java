

import java.util.HashSet;

public class MethodTest {
	public static void main(String[] args) {
		
		Member kim = new Member("갹갹","11");
	
		MemberManager.getManager().getHashSet().add(kim);
		MemberManager.getManager().showData();
		System.out.println();
		
		PointManager.getManager().addPoint(10000);
		MemberManager.getManager().showData();
		System.out.println();
		
		PointManager.getManager().usePoint(1000);
		MemberManager.getManager().showData();
		System.out.println();

	}
}
