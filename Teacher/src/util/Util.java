package util;

import java.util.Scanner;
//public class -> public+
public class Util {
	//public static Scanner -> public+ =>누구나 다 사용할 수 있도록!
	//static사용할때 대부분 public붙임 : 공용목적
	public static Scanner sc = new Scanner(System.in);
	
	public static final int INSERT = 1;
	public static final int SEARCH = 2;
	public static final int DELETE = 3;
	public static final int ALLDATA = 4;
	public static final int QUIT = 5;
}
