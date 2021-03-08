import java.io.File;
import java.util.List;
import java.util.Scanner;

public class ReadDataFromFile {
	
	private Scanner x;
	
	public void openFile(String fileName) {
		try {
			File file = new File("C:\\Users\\Mel\\eclipse-workspace\\OOP-Java-Mobility4You\\src\\" + fileName);
			x = new Scanner(file);
		}
		catch(Exception e){
			System.out.println(fileName +" file not found");
		}
	}
	
	public void readFile(List<Car> cars) {
		while(x.hasNext()){
			String command = x.nextLine();
			AddCarsToCollection(command, cars);
		}
	}
	
	public void closeFile() {
		x.close();
	}
	
	public void AddCarsToCollection(String command, List<Car> cars) {
		String[]splitCommand = command.split(" ", 2);
		String[] info = splitCommand[1].split(", ");
		String typeOfCar = splitCommand[0];
		String carBrand = info[0];
		String carModel = info[1];
		
		if(typeOfCar.equals("ELECTRIC_CAR")){
			int carEnginePower = Integer.parseInt(info[2].replaceAll("[^\\d.]", ""));
			int carBatteryCapacity = Integer.parseInt(info[3].replaceAll("[^\\d.]", ""));
			double carPrice = Double.parseDouble(info[4].replaceAll("[^\\d.]", ""));
			
			ElectricCar currentCar = new ElectricCar(carBrand,carModel, carEnginePower, carPrice, carBatteryCapacity);
			cars.add(currentCar);
		}
		else if (typeOfCar.equals("GAS_CAR")) {
			double carEngineDisplacement = Double.parseDouble(info[2].replaceAll("[^\\d.]", ""));
			int carEnginePower = Integer.parseInt(info[3].replaceAll("[^\\d.]", ""));
			double carPrice = Double.parseDouble(info[4].replaceAll("[^\\d.]", ""));
			
			GasCar currentCar = new GasCar(carBrand,carModel, carEnginePower, carPrice, carEngineDisplacement);
			cars.add(currentCar);
		}
		else if (typeOfCar.equals("HYBRID_CAR")) {
			double carEngineDisplacement = Double.parseDouble(info[2].replaceAll("[^\\d.]", ""));
			int carEnginePower = Integer.parseInt(info[3].replaceAll("[^\\d.]", ""));
			int carBatteryCapacity = Integer.parseInt(info[4].replaceAll("[^\\d.]", ""));
			double carPrice = Double.parseDouble(info[5].replaceAll("[^\\d.]", ""));
			
			HybridCar currentCar = new HybridCar(carBrand,carModel, carEnginePower, carPrice, carEngineDisplacement, carBatteryCapacity);
			cars.add(currentCar);
		}
	}

}
