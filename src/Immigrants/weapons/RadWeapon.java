package Immigrants.weapons;

public abstract class RadWeapon extends Weapon {

	public RadWeapon(int price) {
		super(price);
	}
	
	@Override
	public boolean isRadical() {
		return true;
	}

}
