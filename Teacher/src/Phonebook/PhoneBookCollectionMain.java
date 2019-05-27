package Phonebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

//친구의 데이터를 저장하고 출력하는 프로그램
class PhoneBookCollectionMain {

	public static void main(String[] args) {
		
		testHashSet();

	}
	
	static void testHashSet() {
		
		HashSet<PhoneInfo> pSet = new HashSet<PhoneInfo>();
		
		PhoneInfo pi1 = new PhoneInfo("짱구","123-123","0513");
		PhoneInfo pi2 = new PhoneInfo("철수","456-456");
		PhoneInfo pi3 = new PhoneInfo("짱구","123-123","0513");
		
		pSet.add(pi1);
		pSet.add(pi2);
		pSet.add(pi3);
		
		System.out.println("저장된 요소의 개수: " + pSet.size());
		
		Iterator<PhoneInfo> itr = pSet.iterator();
		
		while(itr.hasNext()) {
			itr.next().showInfo();
		}
		
		
	}
	
	static void testArrayList() {
//		int cnt = 0;
//		PhoneInfo[] arr = new PhoneInfo[30];
//		arr[10] = new PhoneInfo("test", "1111");
		
		ArrayList<PhoneInfo> pList = new ArrayList<PhoneInfo>();
				
		PhoneInfo pi1 = new PhoneInfo("짱구","123-123","0513");
		PhoneInfo pi2 = new PhoneInfo("철수","456-456");
		
		pList.add(pi1);
		pList.add(pi2);
		
//		pi1.showInfo();
//		pi2.showInfo();
		
		for(int i=0; i<pList.size(); i++) {
			pList.get(i).showInfo();
			//pList.get(i) => 참조변수 저장되어있음
			
			if(pList.get(i).name.equals("짱구")) {
				System.out.println("찾았다! => " + i);
			}
			System.out.println("====================");
		}
		
		pList.remove(0);
		
		for(int i=0; i<pList.size(); i++) {
			pList.get(i).showInfo();
			//pList.get(i) => 참조변수 저장되어있음
		}
	}
	
	static void iteratorTest() {
		
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("fourth");
		
		//정렬을위한 인터페이스 Iterator<E> 
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
//			System.out.println(itr.next());
//			System.out.println(itr.next().equals("first"));
//			System.out.println(itr.next());
			
			String str = itr.next();
			System.out.println(str);
			
			//문자열 확인 후 요소 삭제
			if(str.compareTo("third")==0) {
				itr.remove();
			} 
		}
		
		System.out.println("삭제 후 요소 참조");
		itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	static void hashSetTest() {
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("first");
		set.add("second");
		set.add("third");
		set.add("first");
		
		System.out.println("저장된 요소의 개수: " + set.size());
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("===============");
		System.out.println("배열객체로 변환, 참조");
		
		//Object타입[]배열로 받아내기, 필요에 따라서 형변환할 수 있음
		Object[] strArr = set.toArray();
		
		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		//같은 Collection상속, 서로 바꿔쓸 수 있음
		System.out.println("===============");
		System.out.println("Set => List");
		ArrayList<String> list = new ArrayList<String>(set);
		System.out.println("List요소의 개수: "+list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	static void hashSetTest1() {
		
		HashSet<SimpleNumber> set = new HashSet<SimpleNumber>();
		set.add(new SimpleNumber(10));
		set.add(new SimpleNumber(20));
		set.add(new SimpleNumber(20));
		
		System.out.println("저장된 요소의 개수: "+set.size());
		
		Iterator<SimpleNumber> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}//main

class SimpleNumber{
	
	int num;
	
	public SimpleNumber(int num) {
		this.num = num;
	}
	
	//equals 오버라이딩
	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		
		if(obj != null && obj instanceof SimpleNumber) {
			SimpleNumber number = (SimpleNumber) obj;
			result = this.num == number.num;
		}
		
		return result;
	}
	
	//hashCode 오버라이딩	
	@Override
	public int hashCode() {
		//num%3 => 0,1,2 세 그룹으로 그룹핑
		return num%3;
	}

	//toString 오버라이딩
	public String toString() {
		return String.valueOf(num);
		// = return ""+num;
	}
}//class