package util;

import java.util.Scanner;

import selling.Guest;

public interface Util {

	int INGREDIENT_SHOWINFO = 1;
	int INGREDIENT_EDIT = 2;
	int INGREDIENT_DELETE = 3;
	int INGREDIENT_SHOWALL = 4;
	int INGREDIENT_SHUTDOWN = 5;
	
	int ADDMEMBER = 1;
	int CHANGEMEMBER = 2;
	int REMOVEMEMBER = 3;
	int SHOWMEMBERDATA = 4;
	int SHOWALL = 5;
	
	
	Scanner scan = new Scanner(System.in);
	
	Guest[] TABLE = new Guest[5];
	
	
}
