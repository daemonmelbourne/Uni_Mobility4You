
public class HybridCar extends Car {

	private double engineDiscplacement;
	private int	batteryCapacity;
		
	public HybridCar(String Brand, String Model, int EnginePower, double Price, double EngineDiscplacement, int BatteryCapacity) {
		super(Brand, Model, EnginePower, Price);
		setEngineDiscplacement(EngineDiscplacement);
		setBatteryCapacity(BatteryCapacity);
		carType = "HYBRID_CAR";
	}

	public double getEngineDiscplacement() {
		return engineDiscplacement;
	}

	public void setEngineDiscplacement(double EngineDiscplacement) {
		engineDiscplacement = EngineDiscplacement;
	}
	
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	
	public void setBatteryCapacity(int BatteryCapacity) {
		batteryCapacity = BatteryCapacity;
	}
	
	public String toString() {
		//Output: HYBRID_CAR Toyota, Prius, 1.5L, 50KW, 12000Ah, 24000 euro
		return carType + " " + getBrand() + ", " + getModel() + ", " 
				+ getEngineDiscplacement() + "L, " + getEnginePower() + "KW, " 
				+ getBatteryCapacity() + "Ah, " + getPrice() + " euro";
	}
}
