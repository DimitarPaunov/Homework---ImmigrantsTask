package Immigrants;

import java.util.ArrayList;

import Immigrants.weapons.Weapon;

public class ExtremistImmigrant extends Immigrant {

	public ExtremistImmigrant(int money, ArrayList<Immigrant> relatives, ArrayList<Weapon> weapons) {
		super(null, money, relatives, weapons);
	}

	@Override
	public boolean isLegal() {
		return false;
	}
	
	public void blowUp() throws CityBlewUpException {
		
		for(Weapon w: weapons) {
			
			if(w.isBomb()) {
				
				w.shoot();
				throw new CityBlewUpException();
				
			}
			
		}
		
	}
	
	@Override
	public void act() throws CityBlewUpException {
		this.blowUp();
	}
	
	public boolean usedBomb() {
		
		for(Weapon w: weapons) {
			
			if(w.isBomb()) {
				return true;
			}
			
		}
		return false;
	}

	

}
