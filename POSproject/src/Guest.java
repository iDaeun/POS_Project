import java.util.ArrayList;

public class Guest {

	static int payTotalNum = 1;
	int payNum;
	int totalPrice;

	ArrayList<Kimbab> order;

	Guest(ArrayList<Kimbab> orderList) {
		payNum = payTotalNum;
		++payTotalNum;
		
		totalPrice = 0;

		this.order = orderList;
		
		for (int i = 0; i < order.size(); i++) {
			totalPrice += order.get(i).getPrice() * order.get(i).getCnt();
		}

	}
	
	public int getTotalPrice() {
		return totalPrice;
	}

	void showInfo() {
		System.out.println("주문번호 : " + payNum);

		for (int i = 0; i < order.size(); i++) {
			System.out.println(order.get(i).getName() + "의 개수 : " + order.get(i).getCnt());
		}
		System.out.println("총 금액 : " + totalPrice);
	}
}
