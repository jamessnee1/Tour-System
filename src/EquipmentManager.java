public class EquipmentManager {

	// Declare static array for mixedEquipment 
	static Equipment[] mixedEquipment = new Equipment[6];
	public static Equipment[] addedEquipment = new Equipment[100];
	
	public static int equipArrayPos = 0;

	// createSampleEquipment method which contains the array mixedTours
	public static void createSampleEquipment(){

		mixedEquipment[0] = new TourSetEquipment("EQ001", "Walking Stick", 5.0, 8, "Guided Tour");
		mixedEquipment[1] = new CasualHireEquipment("EQ002", "Bird Seed", 4.0, 5);
		mixedEquipment[2] = new CasualHireEquipment("EQ003", "Ski's, Masks and Jackets", 60.0, 9);
		mixedEquipment[3] = new TourSetEquipment("EQ004", "Animal Food", 45.00, 8, "Guided Tour");
		mixedEquipment[4] = new CasualHireEquipment("EQ005", "Abseiling Equipment", 120.00, 35);
		mixedEquipment[5] = new CasualHireEquipment("EQ006", "White Water Rafting Equipment", 200, 16);
	}

	
	public static void createTourSetEquipment(String equipID, String equipDesc, double baseHireFee, int stockLevel, String tourType){
		addedEquipment[equipArrayPos++] = new TourSetEquipment(equipID, equipDesc, baseHireFee, stockLevel, tourType);
		}
		
		public static void createCasualHireEquipment(String equipID, String equipDesc, double baseHireFee, int stockLevel){
			addedEquipment[equipArrayPos++] = new CasualHireEquipment(equipID, equipDesc, baseHireFee, stockLevel);
			}
	// listCurrentEquipment method which displays Equipment ID, Equipment Description and if CasualHireEquipment, Hire Fee
	public static void listCurrentEquipment(){
		for(int i = 0; i < equipArrayPos; i++){
			System.out.print("Equipment ID: " + addedEquipment[i].getEquipID() + ", " + 
					"Equipment Description: " + addedEquipment[i].getEquipDesc());
			if (addedEquipment[i] instanceof CasualHireEquipment){
				System.out.print(", Hire Fee: " + ((CasualHireEquipment) mixedEquipment[i]).getBaseHireFee());
			}
			System.out.println("");
		}
	}
	
	// addEquipment method which returns a double
	public static double addEquipment(String equipID, int stockLevel) throws EquipmentException{
		for (int i = 0; i < equipArrayPos; i++){
			if (addedEquipment[i].getEquipID().compareTo (equipID) == 0){
				return addedEquipment[i].allocateStock(stockLevel);
			}
		}
		return -2;
	}
	
	// cancelEquipment method which returns a double
	public static double cancelEquipment(String equipID, int stockLevel) throws EquipmentException{
		for (int i = 0; i < equipArrayPos; i++){
			if (addedEquipment[i].getEquipID() == equipID){
				addedEquipment[i].returnStock(stockLevel);
				return 0;
			}
		}
		return -2;
	}

	// displayEquipmentSummary method which displays all details for all tours on screen
	public static void displayEquipmentSummary(){
		System.out.println("\nPrinting details of all Equipment: \n");
		for (int i = 0; i < equipArrayPos; i++)
			addedEquipment[i].print();
	}

}

