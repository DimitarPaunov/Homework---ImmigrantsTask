package Immigrants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Country {
	
	private String name;
	private ArrayList<City> cities;
	private static final String[] NAMES = {
			
			"SOFIA" , "VT" , "BURGAS" , "VARNA" , "PLEVEN" , "KARDZHALI" , "SOZOPOL" , "KITEN" , "PLOVDIV" , "HASKOVO"
			
	};

	public Country(String name,int cities) {
		this.name = name;
		this.cities = new ArrayList<City>();
		Random r = new Random();
		
		for (int i = 0; i < cities; i++) {
			
			City c = new City(NAMES[r.nextInt(NAMES.length)]);
			
				c.setCountry(this);		
				this.cities.add(c);
			
		}
		
	}

	public City getRandomCity() {
		return this.cities.get(new Random().nextInt(cities.size()));
	}

	public void removeCity(City city) {
		this.cities.remove(city);
		
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", cities=" + cities + "]";
	}
	
	public String getName() {
		return name;
	}
	
	public List<City> getCities() {
		return Collections.unmodifiableList(cities);
	}
	

}