package test;

import java.util.Scanner;

class LNode {
	public int val;
	public LNode next;
}

public class Main {
	public static LNode reverse(LNode list) {
		LNode pt = list;
		int count = 1;
		while (pt.next != null) {
			pt = pt.next;
			count++;
		}
		int mid = (count + 1) / 2;

		LNode ptr = list;
		LNode midptr = null;
		count = 1;
		while (ptr.next != null) {
			count++;
			ptr = ptr.next;
			if (count == mid) {
				midptr = ptr;
				break;
			}
		}

		LNode ptr_temp = midptr.next;
		String str = "";

		while (ptr_temp != null) {
			str = " " + ptr_temp.val + str;
			ptr_temp = ptr_temp.next;
		}

		String[] eaches = str.split(" ");
		LNode ptr1 = midptr;

		for (int i = 1; i < eaches.length; i++) {
			LNode temp = new LNode();
			temp.val = Integer.valueOf(eaches[i]);
			ptr1.next = temp;
			ptr1 = ptr1.next;
		}

		return list;
	}

	public static void main(String[] Args) {
		Scanner sc = new Scanner(System.in);
		String[] eaches = sc.nextLine().split(" ");
		LNode list;
		list = new LNode();
		list.val = Integer.valueOf(eaches[0]);
		LNode ptr = list;
		
		for (int i = 1; i < eaches.length; i++) {
			LNode temp = new LNode();
			temp.val = Integer.valueOf(eaches[i]);
			ptr.next = temp;
			ptr = ptr.next;
		}

		list = reverse(list);

		LNode temp = list;
		for (int i = 0; i < eaches.length; i++) {
			System.out.print(temp.val);
			temp = temp.next;
		}
	}
}
