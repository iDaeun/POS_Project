package selling;
import java.util.ArrayList;

import menu.Menu;

public class Guest {

	static int payTotalNum = 1;
	int payNum;
	int totalPrice;
	int[] foodCnt;
	String foodname;

	ArrayList<Menu> order;

	Guest(ArrayList<Menu> orderList) {
		payNum = payTotalNum;
		++payTotalNum;

		totalPrice = 0;

		this.order = orderList;
		foodCnt = new int[order.size()];
		
		for (int i = 0; i < order.size(); i++) {
			totalPrice += order.get(i).getPrice() * order.get(i).getCnt();
			foodCnt[i] = order.get(i).getCnt();
			order.get(i).setCnt(0);
		}

	}

	public int getTotalPrice() {
		return totalPrice;
	}

	void showInfo() {
		System.out.println("주문번호 : " + payNum);

		for (int i = 0; i < order.size(); i++) {
			System.out.println(order.get(i).getName() + "의 개수 : " + foodCnt[i]);
		}
		System.out.println("총 금액 : " + totalPrice);
	}
}
