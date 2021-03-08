import java.util.Comparator;

abstract class Car {

	private String brand;
	private String model;
	private int enginePower;
	private double price;
	public String carType;
	
	public Car(String Brand, String Model, int EnginePower, double Price){
		setBrand(Brand);
		setModel(Model);
		setEnginePower(EnginePower);
		setPrice(Price);
		setCarType();
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String Brand) {
		brand = Brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String Model) {
		model = Model;
	}
	
	public int getEnginePower() {
		return enginePower;
	}
	
	public void setEnginePower(int EnginePower) {
		enginePower = EnginePower;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double Price) {
		price = Price;
	}
	
	public String getCarType() {
		return carType;
	}
	
	public void setCarType() {
		carType = null;
	}
}
