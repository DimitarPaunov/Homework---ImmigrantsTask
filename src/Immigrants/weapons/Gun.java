package Immigrants.weapons;

import java.util.Random;

public class Gun extends RadWeapon {

	public Gun(int price) {
		super(price);
	}

	@Override
	public int shoot() {
		System.out.println("BANG , BANG NATIVE PEOPLE!");
		return new Random().nextInt(100)+200; //some ammo
	}

}
