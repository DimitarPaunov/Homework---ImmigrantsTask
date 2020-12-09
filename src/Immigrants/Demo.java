package Immigrants;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

import Immigrants.weapons.Bomb;
import Immigrants.weapons.Gun;
import Immigrants.weapons.Rifle;
import Immigrants.weapons.Weapon;

public class Demo {

	public static void main(String[] args) {
		
		try {
			Country c = new Country("BULGARIA", 5);
			
			System.out.println("All cities in country " +c.getName() +"\n");
			System.out.println(c.getCities() +"\n");
			
			ArrayList<Weapon> weapons = new ArrayList<>();
			
			for(int i = 0; i < 250; i++) {
				Weapon w  = null;
				int chance = new Random().nextInt(100);
				
				if(chance < 25) {
					w = new Gun(130);
					weapons.add(w);
				}
				else if(chance >= 25 && chance < 65) {
					w = new Rifle(150);
					weapons.add(w);
				}
				else {
					w = new Bomb(600);
					weapons.add(w);
				}
				
			}
			
			ArrayList<Immigrant> immigrants = new ArrayList<>();
			
			for (int i = 0; i < 100; i++) {
				int chance = new Random().nextInt(100);
				
				if(chance < 25) {
					Passport p = null;
					
					if(new Random().nextInt(100) < 35) {
						p = new Passport("Pencho" , 30,  "AbuDabi");
					}
					immigrants.add(new RadicalImmigrant(p ,5000, getRandom2(immigrants), weapons));
					
				}
				else
				if(chance >= 25 && chance < 65) {
					immigrants.add(new ExtremistImmigrant(5000, getRandom2(immigrants), weapons));
				}
				else {
					Passport p = null;
					p = new Passport("Ivan", 30, "Kardzhali");
					immigrants.add(new NormalImmigrant(p,2000, getRandom2(immigrants)));
				}
				
			}
			
			for(int i = 0; i < immigrants.size(); i++ ) {
		
				for(int j = 0; j < 5; j++) {
					
					if(weapons.size() > 0) {
						
						Weapon w = weapons.get(new Random().nextInt(weapons.size()));
						try {
							immigrants.get(i).buyWeapon(w);
							
						} catch (NotEnoughMoneyException e) {
							immigrants.remove(i);
							System.out.println(e.getMessage());
						}
						
						weapons.remove(w);
					}
					
				}
		
			}
			
			for(int i = 0; i < immigrants.size(); i++ ) {
				immigrants.get(i).enterCountry(c);
			}
			
			for(int i = 0; i < 20; i++ ) {
				Immigrant imm = immigrants.get(new Random().nextInt(immigrants.size()));
				
				if(imm.getCity() != null) {
					
					try {
						imm.act();
					} catch (CityBlewUpException e) {
						
						imm.getCity().dissappear();
						System.out.println(e.getMessage());
					}
				}
			
			}
			System.out.println("================================================");
			System.out.println("Cities left after the immigration !\n");
			System.out.println(c.getCities());
			System.out.println("=================================================");
			
			System.out.println("\nShow all illegal immigrants :\n");
			printAllIllegalImmigrants(immigrants);
			
			System.out.println("=================================================");
			System.out.println("\nInformation about all immigrants !\n");
			immigrantComparatorByMoney(immigrants);
		
			System.out.println("\nAlive citizens in every city after the immigrant attack !\n");
			cityComparatorByCitizens(c);
			
			
		} catch (InvalidImmigrantPassportException | InvalidRelativesException e) {
			
			System.out.println(e.getMessage());
			
		}
	}	

		private static ArrayList<Immigrant> getRandom2(ArrayList<Immigrant> immigrants) {
			ArrayList<Immigrant> random = new ArrayList<>();
			
			if(immigrants.size() == 0) {
				return random;
			}
			for(int i = 0;  i < 2 ; i++) {
				random.add(immigrants.get(new Random().nextInt(immigrants.size())));
			}
			
			return random;
		}
		
		private static void printAllIllegalImmigrants(ArrayList<Immigrant> imm) {
			for(Immigrant i : imm) {
				
				if(!i.isLegal()) {
					System.out.println(i);
				}
				
			}
			
		}
		
		private static TreeSet<Immigrant> immigrantComparatorByMoney(ArrayList<Immigrant> imm){
			
			TreeSet<Immigrant> immigrants = new TreeSet<>(new Comparator<Immigrant>() {

				@Override
				public int compare(Immigrant o1, Immigrant o2) {
					
					return o1.getMoney() - o2.getMoney();
					
				}
				
			});
			
			immigrants.addAll(imm);
			
			for(Immigrant m : immigrants) {
				System.out.println(m);
			}
			
			return immigrants;
			
		}
		
		private static TreeSet<City> cityComparatorByCitizens(Country c) {
			TreeSet<City> city = new TreeSet<>(new Comparator<City>() {

				@Override
				public int compare(City o1, City o2) {
					
					if(o1.getCitizens() - o2.getCitizens() == 0) {
						return o1.getName().compareTo(o2.getName());
					}
					
					return o1.getCitizens() - o2.getCitizens();
				}
				
			});
			city.addAll(c.getCities());
			
			for(City i : city) {
				System.out.println(i);
			}
			
			return city;
		}
		
}
	