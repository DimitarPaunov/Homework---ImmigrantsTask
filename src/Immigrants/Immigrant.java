package Immigrants;

import java.util.ArrayList;

import Immigrants.cops.PoliceMan;
import Immigrants.weapons.Weapon;

public abstract class Immigrant {

	protected Passport passport;
	private int money;
	protected City city;
	protected ArrayList<Immigrant> relatives;
	protected ArrayList<Weapon> weapons;

	public Immigrant(Passport passport, int money, ArrayList<Immigrant> relatives, ArrayList<Weapon> weapons) {
		
		this(money, relatives, weapons);
		this.passport = passport;

	}

	public Immigrant(int money, ArrayList<Immigrant> relatives, ArrayList<Weapon> weapons) {

		this(money, weapons);
		this.relatives = relatives;

	}
	public Immigrant(int money, ArrayList<Weapon> weapons) {
		
		this.money = money;
		this.weapons = weapons == null ? new ArrayList<>() : filterWeapons(weapons);
	}

	protected ArrayList<Weapon> filterWeapons(ArrayList<Weapon> weps) {
		return weps;
	}

	public abstract boolean isLegal();

	public void enterCountry(Country country) {

		City c = country.getRandomCity();
		this.enterCity(c);

	}

	private void enterCity(City c) {
		PoliceMan p = c.getRandomPoliceMan();

		if (p.check(this)) {

			c.addImmigrant(this);
			this.city = c;

			for (int i = 0; i < this.relatives.size(); i++) {
				if (relatives.get(i).city != c) {
					relatives.get(i).enterCity(c);
				}

			}

		} else {
			System.out.println("Stay here ! You are not allowed to enter the city !");
		}

	}

	protected Passport getPassport() {
		return passport;
	}

	public boolean carryBomb() {
		for (int i = 0; i < weapons.size(); i++) {

			if (weapons.get(i).isBomb()) {
				return true;
			}

		}

		return false;
	}

	public void buyWeapon(Weapon w) throws NotEnoughMoneyException {

		if (w.getPrice() > this.money) {
			throw new NotEnoughMoneyException();
		} else {
			this.money -= w.getPrice();
			this.weapons.add(w);
			this.weapons = filterWeapons(weapons);
		}

	}

	public abstract void act() throws CityBlewUpException;

	public City getCity() {
		return city;
	}

	public int getMoney() {
		return money;
	}

	@Override
	public String toString() {
		return "Immigrant [passport=" + passport + ", money=" + money + ", city=" + city + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Immigrant other = (Immigrant) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		return true;
	}

}
