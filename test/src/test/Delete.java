package test;

import java.util.Scanner;

public class Delete {

	public static String getVal(String[] arr, int val) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].equals(String.valueOf(val))) {
				str += arr[i] + " ";
			}
		}
		return str.substring(0, str.length() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();
		String[] arr = line.split(" ");

		int a = Integer.valueOf(sc.nextLine());
		int b = Integer.valueOf(sc.nextLine());
		int c = Integer.valueOf(sc.nextLine());

		System.out.println(getVal(arr, a));
		System.out.println(getVal(arr, b));
		System.out.println(getVal(arr, c));
	}

}
