
public class ElectricCar extends Car{

	private int	batteryCapacity;
	
	public ElectricCar(String Brand, String Model, int EnginePower, double Price, int BatteryCapacity) {
		super(Brand, Model, EnginePower, Price);
		setBatteryCapacity(batteryCapacity);
		carType = "ELECTRIC_CAR";
	}
	
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	
	public void setBatteryCapacity(int BatteryCapacity) {
		batteryCapacity = BatteryCapacity;
	}
	
	public String toString() {
		//Output: ELECTRIC_CAR Tesla, Model 3, 150KW, 50000Ah, 30000 euro
		return carType + " " + getBrand() + ", " 
				+ getModel() + ", " + getEnginePower() + "KW, " 
				+ getBatteryCapacity() + "Ah, " + getPrice() + " euro";
	}
}
