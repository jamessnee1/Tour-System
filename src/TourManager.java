
public class TourManager {

	// Declare static array for mixedTours 
	static Tour[] mixedTours = new Tour[6];
	public static Tour[] addedTours = new Tour[100];
	
	public static int arrayPos = 0;

	
	public static void createTour(String tourID, String tourDescript, double tourFee){
	addedTours[arrayPos++] = new Tour(tourID, tourDescript, tourFee);
	}
	
	public static void createGuidedTour(String tourID, String tourDescript, double tourFee, String tourDate, int tourGroupSize, String tourGuideName, String equipID){
		addedTours[arrayPos++] = new GuidedTour(tourID, tourDescript, tourFee, tourDate, tourGroupSize, tourGuideName, equipID);
		}
	// listCurrentTours method which displays Tour ID, Tour Description and if GuidedTour, Tour Date
	public static void listCurrentTours(){
		for(int i = 0; i < arrayPos; i++){
			System.out.print("Tour ID: " + addedTours[i].getTourID() + ", " + 
					"Tour Description: " + addedTours[i].getTourDescript());
			if (addedTours[i] instanceof GuidedTour){
				System.out.print(", Tour Date: " + ((GuidedTour) addedTours[i]).getTourDate());
			}
			System.out.println("");
		}
	}
	
	// addTourBooking method which returns a double
	public static double addTourBooking(String tourID, int tourists) throws TourException{
		for (int i = 0; i < arrayPos; i++){
			if (addedTours[i].getTourID().compareTo (tourID) == 0){
				return addedTours[i].addBooking(tourists);
			}
		}
		return -2;
	}
	
	// cancelTourBooking method which returns a double
	public static double cancelTourBooking(String tourID, int tourists) throws TourException{
		for (int i = 0; i < addedTours.length; i++){
			if (addedTours[i].getTourID() == tourID){
				addedTours[i].cancelBooking(tourists);
				return 0;
			}
		}
		return -2;
	}

	// displayTourSummary method which displays all details for all tours on screen
	public static void displayTourSummary(){
		System.out.println("\nPrinting details of all Tours: \n");
		for (int i = 0; i < arrayPos; i++)
			addedTours[i].print();
	}

}

