package Immigrants;

import java.util.ArrayList;

import Immigrants.weapons.Weapon;

public class NormalImmigrant extends Immigrant {

	public NormalImmigrant(Passport passport, int money, ArrayList<Immigrant> relatives) throws InvalidImmigrantPassportException, InvalidRelativesException {
		
		super(money, relatives,new ArrayList<>());
		if(passport == null) {
			throw new InvalidImmigrantPassportException();
		}else {
			this.passport = passport;
		}
		if(relatives != null && relatives.size() <= 10) {
			this.relatives = relatives;
		}
		else {
			throw new InvalidRelativesException(10);
		}
	}
	
	@Override
	public boolean isLegal() {
		return true;
	}
	
	@Override
	public void act() {
		System.out.println("Nothing to do ");
	}

}
