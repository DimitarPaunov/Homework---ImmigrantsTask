package Immigrants.cops;

import java.util.Random;

import Immigrants.City;
import Immigrants.Immigrant;

public class Swat extends PoliceMan {

	public Swat(String name, City city) {
		super(name, city);
	}

	@Override
	public boolean check(Immigrant i) {
		
		if(i.isLegal()) {
			return true;
		}else {
			if(new Random().nextInt(10) == 1) {
				return true;
			}
			
		}
		
		return false;
		
	}
	

}
