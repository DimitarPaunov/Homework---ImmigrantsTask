package Immigrants.weapons;

public abstract class Weapon {
	
	private int price;
	
	public Weapon(int price) {
		this.price = price > 0 ? price : 1;
	}
	
	public int getPrice() {
		return price;
	}
	
	public abstract int shoot();

	public abstract boolean isRadical();
	
	public boolean isBomb() {
		return false; 
	}

}
