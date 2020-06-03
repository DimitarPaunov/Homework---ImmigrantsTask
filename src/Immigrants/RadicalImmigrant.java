package Immigrants;

import java.util.ArrayList;
import java.util.Random;

import Immigrants.weapons.Weapon;

public class RadicalImmigrant extends Immigrant {

	public RadicalImmigrant(Passport passport, int money, ArrayList<Immigrant> relatives, ArrayList<Weapon> weapons) {
		super(passport, money, relatives, weapons);
	}
	
	@Override
	protected ArrayList<Weapon> filterWeapons(ArrayList<Weapon> weps) {
		ArrayList<Weapon> filtered = new ArrayList<>();
		
		for (int i = 0; i < weps.size(); i++) {
			Weapon w = weps.get(i);
			
			if(w.isRadical()) {
				filtered.add(w);
				
				if(filtered.size() == 5) {
					break;
				}
				
			}
			
		}
		
		return filtered;
	}

	@Override
	public boolean isLegal() {
		return getPassport() != null;
	}
	
	public void shootThemAll() {
		int allAmmo = 0;
		
		for(Weapon w : weapons) {
			allAmmo+=w.shoot();
		}
		
		int percent = new Random().nextInt(61)+10;
		int casualties = (allAmmo*percent) / 100;
		this.city.losePeople(casualties);
		
	}
	
	@Override
	public void act() {
		this.shootThemAll();
	}

	

}
