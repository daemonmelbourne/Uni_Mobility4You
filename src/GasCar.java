
public class GasCar extends Car{

	private double engineDiscplacement;
	
	public GasCar(String Brand, String Model, int EnginePower, double Price, double EngineDiscplacement) {
		super(Brand, Model, EnginePower, Price);
		setEngineDiscplacement(engineDiscplacement);
		carType = "GAS_CAR";
	}

	public double getEngineDiscplacement() {
		return engineDiscplacement;
	}

	public void setEngineDiscplacement(double EngineDiscplacement) {
		engineDiscplacement = EngineDiscplacement;
	}
	
	public String toString() {
		//Output: GAS_CAR Honda, Civic, 1.5L, 80KW, 18000 euro
		return carType + " " + getBrand() + ", " 
				+ getModel() + ", " + getEngineDiscplacement() + "L, " 
				+ getEnginePower() + "KW, " + getPrice() + " euro";
	}
}
