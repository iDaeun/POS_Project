//각 재료 정보 저장
public class IngredientInfo {
	private String name; //재료 이름
	private int num; //재료 현재 수량
	private int minNum; //재료 최소 필요 수량

	
	public IngredientInfo(String name, int minNum, int num) {
		this.name = name;
		this.minNum = minNum;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getMinNum() {
		return minNum;
	}

	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}
	
	//개별 매뉴 현황 출력
	void showInfo() {
		System.out.println("======================");
		System.out.printf("재료 이름:\t%s\n재료 현재수량:\t%s\n",name,num);
		System.out.println("재료 최소수량:\t"+minNum);
		System.out.println("======================");
	}
	
	//재고가 최소수량이하로 떨어졌을시 -> '재고부족'알람
	void alarm() {
		if(this.num<this.minNum) {
			System.out.println("*["+name+"]재고부족*, 발주가 필요합니다.");
			System.out.println("현재 수량: "+num);
			System.out.println(minNum-num+"개 부족!");
			
			////거래처관리 for문 -> equals(name) -> 거래처 showInfo
		}
	}
	
	
}
