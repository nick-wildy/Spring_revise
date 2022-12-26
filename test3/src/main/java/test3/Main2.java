package test3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
	
		// 스프링이 준비한 객체들의 저장소(객체 컨테이너)를 먼저 불러와야 한다
		
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:context.xml");
		
		Today t1 = context.getBean(Today.class);
		// context.xml 에서 Today 타입의 객체(bean)는 하나뿐이라서, 타입만 지정해도 객체를 찾을 수 있다
		
		Today t2 = context.getBean("t3", Today.class);
		// 만약, 같은 타입의 객체가 여러개라면 id를 이용하여 구분하여 가져올 수도 있다
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		System.out.println(t1 == t2);
		context.close();
	}
}
