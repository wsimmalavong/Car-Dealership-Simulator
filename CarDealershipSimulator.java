import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;


/**
 * @author William Simmalavong
 * @student # = 500906232
 * 
 */

public class CarDealershipSimulator 
{


public static void main(String[] args)
  {
	  
	  Car lastCar = null;												//Sets the lastCar variable for buying and returning
	  CarDealership dealership = new CarDealership();
	  ArrayList<Car> lot = new ArrayList<Car>();						//Sets the ArrayList for the cars to be held
	  
	  //Initialization all the cars in the txt file
	  Car Toyota = new Car("Toyota", "Blue", Car.GAS_ENGINE, 4, Car.SEDAN, 500, 9.5, false,25000);
	  lot.add(Toyota);
	  Car Honda = new Car("Honda", "Red", Car.GAS_ENGINE, 4, Car.SPORTS, 450, 9.2, false, 30000);
	  lot.add(Honda);
	  Car Kia = new Car("Kia", "White", Car.GAS_ENGINE, 4, Car.MINIVAN, 550, 9.7, false, 20000);
	  lot.add(Kia);
	  Car BMW = new Car("BMW", "Black", Car.GAS_ENGINE, 4, Car.SEDAN, 600, 9.6, true, 55000);
	  lot.add(BMW);
	  ElectricCar Tesla = new ElectricCar("Tesla", "Red", Car.ELECTRIC_MOTOR, 4, Car.SEDAN, 425, 9.1, true, 85000,30, "LITHIUM"); 
	  lot.add(Tesla);
	  Car Chevy = new Car("Chevy", "Red", Car.GAS_ENGINE, 4, Car.MINIVAN, 475, 9.25, false, 40000);
	  lot.add(Chevy);
	  ElectricCar ChevyVolt = new ElectricCar("ChevyVolt", "Green", Car.ELECTRIC_MOTOR, 4, Car.SEDAN, 375, 8.9, true, 37000,45, "LITHIUM");
	  lot.add(ChevyVolt);
	  Car Bentley = new Car("Bentley", "Black", Car.GAS_ENGINE, 4, Car.SEDAN, 575, 9.8, false,150000);
	  lot.add(Bentley);
	  ElectricCar NissanLeaf = new ElectricCar("Nissan Leaf", "Green", Car.ELECTRIC_MOTOR, 4, Car.SEDAN, 325, 8.8,true, 32000,55, "LITHIUM");
	  lot.add(NissanLeaf);

	
	  Scanner input = new Scanner(System.in);

	  /**
	   * Checks the input that the user writes to call specific methods accordingly
	   */
	  while(input.hasNextLine()) {
		  String read2 = input.next();
		  if (read2.equals("L")) {
			 dealership.displayInventory();							//Displays the dealership if "L" is entered
		  }
		  else if (read2.equals("Q")) {
			  return;												//returns program if "Q" is entered
		  }
		  else if (read2.equals("BUY")) {
			  int index = input.nextInt();					//Buys a car if "BUY" is entered
			  if (dealership.checkCar(index) == true) {
				  lastCar = dealership.buyCar(index);
			  }
			  else {
				  System.out.println("Invalid car");
			  }
			  
		  }
		  else if (read2.equals("RET")) {
			  dealership.returnCar(lastCar);						//Returns a car if "RET" is entered
			  lastCar = null;
		  }
		  else if (read2.equals("ADD")) {
			  dealership.addCars(lot);								//Adds a car to the dealer ship if "ADD" is entered
		  }
		  else if (read2.equals("SPR")) {
			  dealership.sortByPrice();								//Sorts by price if "SPR" is entered
		  }
		  else if (read2.equals("SSR")) {
			  dealership.sortBySafetyRating();						//Sorts by safety rating if "SSR" is entered
		  }	
		  else if (read2.equals("SMR")) {
			  dealership.sortByMaxRange();
		  }
		  else if (read2.equals("FPR")) {							//Filters by price if "FPR" is entered
		      String read2array[] = read2.split("");
		      int minP = input.nextInt();
		      int maxP = input.nextInt();
			  dealership.filterByPrice(minP, maxP);
		  }
		  else if (read2.equals("FEL")) {							//Filters by electric is "FEL" is entered
			  dealership.filterByElectric();
		  }
		  else if (read2.equals("FAW")) {							//Filters by All wheel drive if "AWD" is entered
			  dealership.filterByAWD();
		  }
		  else if (read2.equals("FCL")) {							//Clears filters
			  dealership.FiltersClear();
		  }
		  else if(read2.equals(null)) {												//Checks if no value is entered
			  System.out.println("No value has been inputted try again");
		  }
		  else {
			  System.out.println("Invalid input try again");						//Displays if input is invalid
		  }
	  }
	 
  }
}


/**
 * The vehicle class that has instance variables model, color, power type, number of wheels and electric motor and gas engine.
 */
class Vehicle{
	private String mfr;
	private String color;
	private int power;
	private int numWheels;
	public static final int ELECTRIC_MOTOR = 1;
	public static final int GAS_ENGINE = 0;
	
	/**
	 * Constructor for Vehicle Class
	 * @param mfr - manufacturer
	 * @param color - color of car
	 * @param power - GAS_ENGINE or ELECTRIC_MOTOR
	 * @param numWheels - amount of wheels for driving
	 */
	
	public Vehicle(String mfr, String color, int power, int numWheels) {
		this.mfr = mfr;
		this.color = color;
		this.power = power;
		this.numWheels = numWheels;
	}

	
	/**
	 * @return manufacturer name
	 */
	public String getmfr() {
		return mfr;
	}
	
	
	/**
	 * @return color of car
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * @return power type of the car either GAS_ENGINE or ELECTRIC_MOTOR 
	 */
	public int getPower() {
		return power;
	}
	
	/**
	 * @return amount of wheels required for acceleration
	 */
	public int getnumWheels() {
		return numWheels;
	}
	
	/**
	 * sets manufacturer name
	 * @param newMfr
	 */
	public void setmfr(String newMfr) {
		mfr = newMfr;
	}
	
	/**
	 * Sets color of car
	 * @param newColor
	 */
	public void setColor(String newColor) {
		color = newColor;
	}
	
	/**
	 * sets power type of the car
	 * @param newPower
	 */
	public void setPower(int newPower) {
		power = newPower;
	}
	
	/**
	 * sets amount of wheels of the car
	 * @param newNumWheels
	 */
	public void setNumWheels(int newNumWheels) {
		numWheels = newNumWheels;
	}
	
	/**
	 * Checks to see if the manufacturer, power and the # of wheels is equal to other vehicle object
	 * 
	 */
	public boolean equals(Object other) {
		Vehicle otherVehicle = (Vehicle)other;
		if (this.mfr.equals(otherVehicle.mfr) && this.power == otherVehicle.power && this.numWheels == otherVehicle.numWheels) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return manufacturer and the color of the car
	 */
	public String display() {
		return mfr + " " + color;
	}
	
}

/**
 * Car class that extends vehicle and implements the Comparable Interface
 */
class Car extends Vehicle implements Comparable<Car>{
	private int model;
	private int maxRange;
	private double safetyRating;
	private boolean AWD;
	private double price;
	public static final int SEDAN = 100;			//Integer constants for model 
	public static final int SUV = 101;
	public static final int SPORTS = 102;
	public static final int MINIVAN = 103;
	
	
	/**
	 * Constructor for Car class
	 * @param mfr - manufacturer of car
	 * @param color - color of car
	 * @param power - power type of car
	 * @param numWheels - number of wheels on car
	 * @param model - model of the car
	 * @param maxRange - maximum range of car
	 * @param safetyRating - the safety rating of car
	 * @param AWD - if the car is all wheel drive  or not
	 * @param price - price of the car
	 */
	public Car(String mfr, String color, int power, int numWheels, int model, int maxRange, double safetyRating, boolean AWD, double price) {
		super(mfr,color,power,numWheels);
		this.model = model;
		this.setMaxRange(maxRange);
		this.setSafetyRating(safetyRating);
		this.AWD = AWD;
		this.price = price;
	}
	
	/**
	 * Displays the data and calls constructor of the superclass as well to display all data of the car
	 * If statements to determine what the model is and what string it should display
	 */
	public String display() {
		String strModel = "";
		if (model == SEDAN) {
			strModel = "SEDAN";
		}
		if (model == SUV) {
			strModel = "SUV";
		}
		if (model == SPORTS) {
			strModel = "SPORTS";
		}
		if (model == MINIVAN) {
			strModel = "MINIVAN";
		}
		return super.display() + " " + strModel + " RNG: " + getMaxRange() + " SF: " + getSafetyRating()  + " Price: " + price;
	}
	
	/**
	 * Method that checks to see if this Car is equal to another car by checking if AWD and the model is equal
	 * @param other car
	 */
	public boolean equals(Object other) {
		Car otherCar = (Car)other;
		if (super.equals(otherCar) == true) {
			if (this.model == otherCar.model && this.AWD == otherCar.AWD) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	/**
	 * Implemented method used for the comparable class that organises the ArrayList when using sort from least ot greatest.
	 * @param other car
	 */
	public int compareTo(Car other) {
		if (this.price > other.price) {
			return 1;
		}
		if (this.price < other.price) {
			return -1;
		}
		return 0;
	}

	/**
	 * @return the safety rating
	 */
	public double getSafetyRating() {
		return safetyRating;
	}

	/**
	 * Sets the safety rating
	 * @param safetyRating
	 */
	public void setSafetyRating(double safetyRating) {
		this.safetyRating = safetyRating;
	}
	
	/**
	 * @return maximum range
	 */
	public int getMaxRange() {
		return maxRange;
	}
	
	/**
	 * sets the maximum range
	 * @param maxRange
	 */
	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}
	
	/**
	 * 
	 * @return if the car is AWD or not
	 */
	public boolean getAWD() {
		return AWD;
	}
	
	/**
	 * 
	 * @returns the price of the car
	 */
	public double getPrice() {
		return price;
	}
	
}

/**
 * Class electric car that is a subclass of Car has new instance variables recharge time as well as battery type.
 */
class ElectricCar extends Car{
	private int rechargeTime;
	private String batteryType;
	
	/**
	 * Constructor for electric car that sets the instance variables by calling the previous super class 
	 */
	public ElectricCar(String mfr, String color, int power, int numWheels, int model, int maxRange, double safetyRating, boolean AWD, double price, int rechargeTime, String batteryType) {
		super(mfr, color, power, numWheels, model, maxRange, safetyRating, AWD, price);
		this.rechargeTime = rechargeTime;
		this.batteryType = batteryType;
		power = ELECTRIC_MOTOR;
	}
	
	/**
	 * Displays data from the super classes as well as the new recharge time and battery type
	 */
	public String display() {
		return super.display() + " RCH: " + rechargeTime + " BAT: " + batteryType;
	}
}

/**
 * The dealer ship class that is in charge of filtering and displaying the data of all the cars that are added to the array list inside of it.
 * Variables include , filter by price, filter by all wheel drive, filter by electric, the minimum price and the maximum price all used for filtering the display data.
 */
class CarDealership {
	private ArrayList<Car> cars;
	private boolean filterByPrice = false;
	private boolean filterByAWD = false;
	private boolean filterByElectric = false;
	private double minPrice;
	private double maxPrice;
	
	/**
	 * constructor for dealership initalizes an array list of cars
	 */
	public CarDealership() {
		cars = new ArrayList<Car>();
	}
	
	/**
	 * Adds a new array list to the existing array list in car dealership
	 * @param newCars
	 */
	public void addCars(ArrayList<Car> newCars) {
		for (int i = 0; i < newCars.size(); i++) {
			cars.add(newCars.get(i));
		}
	}
	
	/**
	 * Removes a car from the array list and returns a reference variable to it if the  car does not exist return null.
	 * @param index of the car
	 * @return the reference variable to the car object
	 */
	public Car buyCar(int index) {
		if (index < (cars.size()) && index >= 0) {
			if (cars.get(index) != null) {
				Car reference;
				reference = cars.get(index);
				cars.remove(index);
				return reference;
			}
		}
		else {
			System.out.println("Invalid car");
		}
		return null;
		
	}
	
	/**
	 * Adds a car back to the array list
	 * @param car
	 */
	public boolean checkCar(int index) {
		if (index < cars.size()) {
			if (cars.get(index) != null) {
				return true;
			}
		}
		return false;
	}
	
	public void returnCar(Car car) {
		if (car != null) {
			cars.add(car);
		}
	}
	
	/**
	 * Sets the filter by electric on
	 */
	public void filterByElectric() {
		filterByElectric = true;
	}
	
	/**
	 * Sets the filter by All Wheel Drive on
	 */
	public void filterByAWD() {
		filterByAWD = true;
	}
	
	/**
	 * Turns the Filters by price on in between two given minimum and maximum price values
	 * @param minPrice - minimum price value to search between
	 * @param maxPrice - maximum price value to search between
	 */
	public void filterByPrice(double minPrice, double maxPrice) {
		filterByPrice = true;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	
	/**
	 * Sorts the array list of cars from least to greatest
	 */
	public void sortByPrice() {
		Collections.sort(cars);
	}
	
	/**
	 * Sorts the safety rating of cars from least to greatest
	 */
	public void sortBySafetyRating() {
		Collections.sort(cars, new ComparatorSafetyRating());
	}
	
	/**
	 * Sorts the maximum range of cars from least to greatest
	 */
	public void sortByMaxRange() {
		Collections.sort(cars, new ComparatorMaxRange());
	}
	
	/**
	 * Turns all the filters ff
	 */
	public void FiltersClear() {
		filterByPrice = false;
		filterByElectric = false;
		filterByAWD = false;
	}
	
	/**
	 * This method will display the cars given the specific filters that are on.
	 */
	public void displayInventory() {

		if (filterByPrice == true && filterByElectric == false && filterByAWD == false) {																		
			for (int i = 0; i < cars.size(); i++) {
				if (cars.get(i).getPrice() <= maxPrice && cars.get(i).getPrice() >= minPrice) {
					System.out.println(i + ". " + cars.get(i).display());
				}
			}
		}
		if (filterByPrice == true && filterByElectric == true && filterByAWD == false) {
			for (int i = 0; i < cars.size(); i++) {
				if (cars.get(i).getPrice() <= maxPrice && cars.get(i).getPrice() >= minPrice  && cars.get(i).getPower() == 1) {
					System.out.println(i + ". " + cars.get(i).display());
				}
			}
		}
		if (filterByPrice == true && filterByElectric == true && filterByAWD == true) {
			for (int i = 0; i < cars.size(); i++) {
				if (cars.get(i).getPrice() <= maxPrice && cars.get(i).getPrice() >= minPrice  && cars.get(i).getPower() == 1 && cars.get(i).getAWD() == true) {
					System.out.println(i + ". " + cars.get(i).display());
				}
			}
		}
		if (filterByPrice == false && filterByElectric == true && filterByAWD == false) {
			for (int i = 0; i < cars.size(); i++) {
				if (cars.get(i).getPower() == 1) {
					System.out.println(i + ". " + cars.get(i).display());
				}
			}
		}
		if (filterByPrice == false && filterByElectric == true && filterByAWD == true) {
			for (int i = 0; i < cars.size(); i++) {
				if (cars.get(i).getPower() == 1 && cars.get(i).getAWD() == true) {
					System.out.println(i + ". " + cars.get(i).display());
				}
			}
		}
		if (filterByPrice == true && filterByElectric == false && filterByAWD == true) {
			for (int i = 0; i < cars.size(); i++) {
				if (cars.get(i).getPrice() <= maxPrice && cars.get(i).getPrice() >= minPrice && cars.get(i).getAWD() == true) {
					System.out.println(i + ". " + cars.get(i).display());
				}
			}
		}
		if (filterByPrice == false && filterByElectric == false && filterByAWD == true) {
			for (int i = 0; i < cars.size(); i++) {
				if (cars.get(i).getAWD() == true) {
					System.out.println(i + ". " + cars.get(i).display());
				}
			}
		}
		if (filterByPrice == false && filterByElectric == false && filterByAWD == false) {
			for (int i = 0; i < cars.size(); i++) {
				System.out.println(i + ". " + cars.get(i).display());
			}
		}
		
		
	}
}

/**
 * Comparator class used for sorting by safety rating from least to greatest
 */
class ComparatorSafetyRating implements Comparator<Car> {

	public int compare(Car car1, Car car2) {
		if (car1.getSafetyRating() > car2.getSafetyRating()) {
			return 1;
		}
		else if (car1.getSafetyRating() < car2.getSafetyRating()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}

/**
 * Comparator class used for sorting the maximum range from least to greatest
 */
class ComparatorMaxRange implements Comparator<Car> {
	public int compare(Car car1, Car car2) {
		if (car1.getMaxRange() > car2.getMaxRange()) {
			return 1;
		}
		else if (car1.getMaxRange() < car2.getMaxRange()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}
	
