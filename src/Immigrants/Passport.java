package Immigrants;

public class Passport {
	
	private String name;
	private int age;
	private String city;
	
	public Passport(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Passport [name=" + name + ", age=" + age + "]";
	}
	

}
