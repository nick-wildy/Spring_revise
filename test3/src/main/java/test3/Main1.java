package test3;

import java.util.Date;

public class Main1 {
	public static void main(String[] args) {
		
		Today t1 = new Today();	// 메인함수 시작 이후 객체를 생성하면 느리다
		Date d1 = t1.getDate();
		System.out.println(d1);
		
		Today t2 = new Today();	// 싱글톤이 아니므로, 메모리 낭비가 발생한다
		Date d2 = t2.getDate();
		System.out.println(d2);
		
		System.out.println(t1 == t2);
	}
}
