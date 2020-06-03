package Immigrants.cops;

import java.util.Random;

import Immigrants.City;
import Immigrants.Immigrant;

public class Officer extends PoliceMan {

	public Officer(String name, City city) {
		super(name, city);
	}

	@Override
	public boolean check(Immigrant i) {
		if(i.carryBomb()) {
			return true;
		}
		
		if(i.isLegal()) {
			return true;
		}else {
			return new Random().nextBoolean(); // 50% of illegal immigrants pass
		}
		
	}

}
