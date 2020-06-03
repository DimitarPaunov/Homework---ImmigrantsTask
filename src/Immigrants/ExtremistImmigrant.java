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
	
	public void blowUp() {
		
		for(Weapon w: weapons) {
			
			if(w.isBomb()) {
				w.shoot();
				System.out.println("The city blew up !");
				city.dissappear();
			}
			
		}
		
	}
	
	@Override
	public void act() {
		this.blowUp();
	}

	

}
