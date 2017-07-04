package test;

import java.util.HashSet;
import java.util.Set;

class MyClass {
	Integer i;

	public MyClass(Integer i) {
		this.i = i;
	}

	public boolean equals(MyClass c) {
		return false;

	}

	public boolean equals(Object o) {
		return true;
	}

	public int hashCode() {
		return 32;
	}
}

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<MyClass> set = new HashSet<MyClass>();
		set.add(new MyClass(5));
		set.add(new MyClass(2));
		set.add(new MyClass(3));
		System.out.println(set.size());

	}

}
