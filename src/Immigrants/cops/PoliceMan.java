package Immigrants.cops;

import Immigrants.City;
import Immigrants.Immigrant;

public abstract class PoliceMan {
	
	private String name;
	private City city;
	
	public PoliceMan(String name, City city) {
		this.name = name;
		this.city = city;
	}
	
	public abstract boolean check(Immigrant i);
	

}
