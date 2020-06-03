package Immigrants;

import java.util.ArrayList;

import Immigrants.weapons.Weapon;

public class NormalImmigrant extends Immigrant {

	public NormalImmigrant(Passport passport, int money, ArrayList<Immigrant> relatives) {
		
		super(passport, money, relatives,new ArrayList<>());
	}
	
	@Override
	protected boolean validRelatives(ArrayList<Immigrant> relatives2) {
		return super.validRelatives(relatives2) && relatives2.size() <= 10;
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
