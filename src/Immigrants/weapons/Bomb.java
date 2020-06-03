package Immigrants.weapons;

public class Bomb extends Weapon {

	public Bomb(int price) {
		super(price);
	}

	@Override
	public int shoot() {
		System.out.println("BOOOM NATIVE PEOPLE!");
		return -1;//monkey hack
	}
	
	@Override
	public boolean isRadical() {
		return false;
	}
	
	@Override
	public boolean isBomb() {
		return true;
	}

}
