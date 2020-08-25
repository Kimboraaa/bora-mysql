package kr.or.test;

import java.util.function.IntSupplier;

public class Lambda {
	public static int method(int x, int y) {
		//람다식 메서드
		IntSupplier supplier = () -> { //일반 메서드로 변경 어떻게 하는가?=-미래공지 //x = x * 10; int
		int result = x + y; 
		return result; 
		 };
		//기존메서드
		/*IntSupplier supplier = new IntSupplier() {
			@Override
			public int getAsInt() {
				return x + y;
			}
		};*/
		int result = supplier.getAsInt();
		return result;
	}

	public static void main(String[] args) {
		System.out.println(method(3, 5));

	}

}