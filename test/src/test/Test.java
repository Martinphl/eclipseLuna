package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split("]");
		str[0] = str[0].substring(1);
		str[1] = str[1].substring(2);

		List<Integer> leftL = new ArrayList<Integer>();
		List<Integer> rightL = new ArrayList<Integer>();

		String[] str0 = str[0].split(",");
		String[] str1 = str[1].split(",");

		for (int i = 0; i < str0.length; i++) {
			leftL.add(Integer.valueOf(str0[i]));
		}

		for (int i = 0; i < str1.length; i++) {
			rightL.add(Integer.valueOf(str1[i]));
		}

		List<Integer> list = new ArrayList<Integer>();

		for (Integer each : leftL) {
			if (!rightL.contains(each)) {
				list.add(each);
			}
		}

		for (Integer each : rightL) {
			if (!leftL.contains(each)) {
				list.add(each);
			}
		}

		System.out.print(list.size());

	}
}
