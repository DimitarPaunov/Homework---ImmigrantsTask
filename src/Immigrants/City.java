package Immigrants;

import java.util.ArrayList;
import java.util.Random;
import Immigrants.cops.Officer;
import Immigrants.cops.PoliceMan;
import Immigrants.cops.Swat;

public class City {
	
	private Country country;
	private String name;
	private ArrayList<PoliceMan> police;
	private int citizens;
	private ArrayList<Immigrant> immigrants;
	
	public City(String name) {
		this.name = name;
		Random r = new Random();
		this.police = new ArrayList<>();
		
		for(int i = 0; i < r.nextInt(20)+20; i++) {
			int chance = r.nextInt(100);
			
			if(chance < 52) {
				this.police.add(new Officer("Policai " + i,this));
			}else {
				this.police.add(new Swat("Swat " + i, this));
			}
			
		}
		
		this.citizens = new Random().nextInt(1000)+1000;
		
		this.immigrants = new ArrayList<>();
		
	}
	
	public PoliceMan getRandomPoliceMan() {
		return this.police.get(new Random().nextInt(police.size()));
	}

	public Country getCountry() {
		return country;
	}

	public void addImmigrant(Immigrant immigrant) {
		this.immigrants.add(immigrant);
		this.citizens++;
		
	}

	
	public void losePeople(int casualties) {
		this.citizens -= casualties;
		
		if(citizens < 0) {
			citizens = 0;
		}
	}

	public void dissappear() {
		this.country.removeCity(this);
		
	}
	
	public void setCountry(Country country2) {
		this.country = country2;
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getCitizens() {
		return citizens;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", citizens=" + citizens + "]";
	}

	
	
	

	

}
