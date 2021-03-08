
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Hello. Welcome to Mobility4You Catalogue!");
		System.out.println("Please write the full name and extension of the provided file.");
		System.out.println("Example: mobility.txt");
		
		Scanner consoleScanner = new Scanner(System.in);
		String fileName = consoleScanner.nextLine().toLowerCase().trim(); 
		
		PrintMenuAndReadConsoleInput(consoleScanner, fileName);
		
	}
	
	public static void PrintMenuAndReadConsoleInput(Scanner consoleScanner, String fileName) {
		List<Car> carsFromFile = new ArrayList<Car>();
		List<Car> carsFromConsole = new ArrayList<Car>();
		
		printMenu();
		int command = consoleScanner.nextInt();
		while(command != 8)
		{
			switch(command) {
				case 1:
					carsFromFile.clear();
					readFile(fileName, carsFromFile);
					System.out.println("From File: ");
					printCatalogue(carsFromFile);
					
					if(carsFromConsole.size() > 0) {
						System.out.println();
						System.out.println("Unsaved: ");
						printCatalogue(carsFromConsole);
						System.out.println();
						System.out.println("To save unsaved cars to file - enter command 7");
					}
				break;
				
				case 2: addElectricCar(carsFromConsole);
				break;
				
				case 3: addGasCar(carsFromConsole);
				break;
				
				case 4: addHybridCar(carsFromConsole);
				break;

				case 5:
					System.out.println("From File: ");
					Collections.sort(carsFromFile, CarTypeComparator);
					printCatalogue(carsFromFile);
					
					if(carsFromConsole.size() > 0) {
						System.out.println("Unsaved: ");
						Collections.sort(carsFromConsole, CarTypeComparator);
						printCatalogue(carsFromConsole);
						System.out.println("To save unsaved cars to file - enter command 7");
					}
				break;
				
				case 6:
					System.out.println("From File: ");
					Collections.sort(carsFromFile, CarBrandComparator);
					printCatalogue(carsFromFile);
					
					if(carsFromConsole.size() > 0) {
						System.out.println("Unsaved: ");
						Collections.sort(carsFromConsole, CarBrandComparator);
						printCatalogue(carsFromConsole);
						System.out.println("To save unsaved cars to file - enter command 7");
					}
				break;
				
				case 7:
					List<Car> allCars = new ArrayList<Car>();
					allCars.addAll(carsFromFile);
					allCars.addAll(carsFromConsole);
					writeToFile(fileName, allCars);
					carsFromFile.clear();
					carsFromConsole.clear();
				break;
				
				case 8: System.out.println("Stoping the program.");
				return;
				
				default:
				System.out.println("Input is invalid!");
				break;
			}
			
			printMenu();
			command = consoleScanner.nextInt();
		}
	}
	
	public static void printMenu() {
		System.out.println();
		System.out.println("Please make your choice:");
		System.out.println("1 - Show the entire Mobility4You catalogue");
		System.out.println("2 – Add a new electric car");
		System.out.println("3 – Add a new gas-powered car");
		System.out.println("4 – Add a new hybrid car");
		System.out.println("5 - Show the entire Mobility4You catalogue sorted by car-type");
		System.out.println("6 – Show the entire Mobility4You catalogue alphabetically sorted by brand");
		System.out.println("7 – Write to file");
		System.out.println("8 – Stop the program");
		System.out.println();
	}
	
	public static void printCatalogue(List<Car>carsCollection) {
		for (Car car : carsCollection){
			System.out.println(car.toString());
		}
	}
	
	public static void addElectricCar(List<Car> carsFromConsole) {
		Scanner consoleScanner = new Scanner(System.in);
		System.out.println("Adding electric car");
		System.out.println("Enter brand of the car:");
		String carBrand = consoleScanner.nextLine();
		
		System.out.println("Enter model of the car:");
		String carModel = consoleScanner.nextLine();
		
		System.out.println("Enter engine power of the car (KW):");
		int carEnginePower = Integer.parseInt(consoleScanner.nextLine());
		
		System.out.println("Enter battery capacity of the car (Ah):");
		int carBatteryCapacity = Integer.parseInt(consoleScanner.nextLine());
		
		System.out.println("Enter price of the car (euro):");
		double carPrice = Double.parseDouble(consoleScanner.nextLine());
		
		ElectricCar currentCar = new ElectricCar(carBrand, carModel, carEnginePower, carPrice, carBatteryCapacity); 
		carsFromConsole.add(currentCar);
		System.out.println(currentCar.getBrand() + " " + currentCar.getModel() + " has been succesfully added!");
		System.out.println("Remember to save new cars to file with command 7");
	}
	
	public static void addGasCar(List<Car> carsFromConsole) {
		Scanner consoleScanner = new Scanner(System.in);
		System.out.println("Adding gas car");
		System.out.println("Enter brand of the car:");
		String carBrand = consoleScanner.nextLine();
		
		System.out.println("Enter model of the car:");
		String carModel = consoleScanner.nextLine();
		
		System.out.println("Enter engine power of the car (KW):");
		int carEnginePower = Integer.parseInt(consoleScanner.nextLine());
		
		System.out.println("Enter engine discplacement of the car (L):");
		double carEngineDiscplacement = Double.parseDouble(consoleScanner.nextLine());
		
		System.out.println("Enter price of the car (euro):");
		double carPrice = Double.parseDouble(consoleScanner.nextLine());
		
		GasCar currentCar = new GasCar(carBrand, carModel, carEnginePower, carPrice, carEngineDiscplacement); 
		carsFromConsole.add(currentCar);
		System.out.println(currentCar.getBrand() + " " + currentCar.getModel() + " has been succesfully added!");
		System.out.println("Remember to save new cars to file with command 7");
	}
	
	public static void addHybridCar(List<Car> carsFromConsole) {
		//should check if input is correct
		Scanner consoleScanner = new Scanner(System.in);
		System.out.println("Adding hybrid car");
		System.out.println("Enter brand of the car:");
		String carBrand = consoleScanner.nextLine();
		
		System.out.println("Enter model of the car:");
		String carModel = consoleScanner.nextLine();

		System.out.println("Enter engine discplacement of the car (L):");
		double carEngineDiscplacement = Double.parseDouble(consoleScanner.nextLine());
		
		System.out.println("Enter engine power of the car (KW):");
		int carEnginePower = Integer.parseInt(consoleScanner.nextLine());
		
		System.out.println("Enter battery capacity of the car (Ah):");
		int carBatteryCapacity = Integer.parseInt(consoleScanner.nextLine());
		
		System.out.println("Enter price of the car (euro):");
		double carPrice = Double.parseDouble(consoleScanner.nextLine());
		
		HybridCar currentCar = new HybridCar(carBrand, carModel, carEnginePower, carPrice, carEngineDiscplacement, carBatteryCapacity); 
		carsFromConsole.add(currentCar);
		System.out.println(currentCar.getBrand() + " " + currentCar.getModel() + " has been succesfully added!");
		System.out.println("Remember to save new cars to file with command 7");
	}
	
	public static void readFile(String fileName, List<Car> carsFromFile) {
		ReadDataFromFile reader = new ReadDataFromFile();
		reader.openFile(fileName);
		reader.readFile(carsFromFile);
		reader.closeFile();
	}
	
	public static void writeToFile(String fileName, List<Car> carsCollection) {
		
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("C:\\Users\\Mel\\eclipse-workspace\\OOP-Java-Mobility4You\\src\\" + fileName);
			PrintWriter printWriter = new PrintWriter(fileWriter);
		    for (Car car : carsCollection){
			    printWriter.println(car.toString());
			}
		    printWriter.close();
		    carsCollection.clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}
	
	public static Comparator<Car> CarBrandComparator = new Comparator<Car>() {
		public int compare(Car c1, Car c2) {
			String firstCar = c1.getBrand().toUpperCase();
			String secondCar = c2.getBrand().toUpperCase();
			
			return firstCar.compareTo(secondCar);
		}
	};
	
	public static Comparator<Car> CarTypeComparator = new Comparator<Car>() {
		public int compare(Car c1, Car c2) {
			String firstCar = c1.getCarType().toUpperCase();
			String secondCar = c2.getCarType().toUpperCase();
			
			return firstCar.compareTo(secondCar);
		}
	};
}
