import java.util.*;

public interface Util {
	Scanner sc = new Scanner(System.in);
	
	int INGREDIENT_SHOWINFO = 1;
	int INGREDIENT_ADD = 2;
	int INGREDIENT_EDIT = 3;
	int INGREDIENT_DELETE = 4;
	int INGREDIENT_SHOWALL = 5;
	int INGREDIENT_SHUTDOWN = 6;
	
	Guest[] TABLE = new Guest[3];
}
