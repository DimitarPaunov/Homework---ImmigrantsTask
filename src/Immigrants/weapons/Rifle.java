package Immigrants.weapons;

import java.util.Random;

public class Rifle extends RadWeapon {

	public Rifle(int price) {
		super(price);
	}

	@Override
	public int shoot() {
		System.out.println("JUST DIE ALL!");
		return new Random().nextInt(500)+2000;//some ammo
	}

}
