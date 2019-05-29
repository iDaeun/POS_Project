import java.util.*;

public interface Util {
	Scanner sc = new Scanner(System.in);
	
	int INGREDIENT_SHOWINFO = 1;
	int INGREDIENT_EDIT = 2;
	int INGREDIENT_DELETE = 3;
	int INGREDIENT_SHOWALL = 4;
	int INGREDIENT_SHUTDOWN = 5;
	
	Scanner scan = new Scanner(System.in);
	
	Guest[] TABLE = new Guest[3];
}
