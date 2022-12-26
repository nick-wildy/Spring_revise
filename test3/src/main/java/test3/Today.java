package test3;

import java.util.Date;

public class Today {

	private Date date = null;
	private String name;
	
	public Today() {
		setDate(new Date());
		System.out.println("Today 객체 생성 !!");
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
