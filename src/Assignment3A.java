import java.util.*;

public class Assignment3A {

	public static void main(String[] args) throws TourException {
		Tour tourReference[] = new Tour[5];
		tourReference[0] = new Tour("FP001", "Fun Park 3 Day Pass", 110);
		tourReference[1] = new Tour("WC002", "3 Day Wilderness Camping Pass", 120);
		tourReference[2] = new Tour("NP003", "National Park Explorer Pass", 25);
		tourReference[3] = new Tour("BG004", "Botanical Gardens Entry Pass", 30);
		tourReference[4] = new Tour("OZ005", "Open Range Zoo Entry Pass", 45);

		String input1;

		System.out.println("Available Tour List: \n");

		for (int i = 0; i < tourReference.length; i++) {
			System.out.println("Tour ID: " + tourReference[i].getTourID() + ", " + 
					"Tour Description: " + tourReference[i].getTourDescript());
		}
		System.out.println("");
		
		int temp = 0;
		do {
			boolean found = true;
			Scanner input = new Scanner(System.in);
			System.out.print("Enter Tour ID: ");
			input1 = input.nextLine().toUpperCase();
			temp = input1.length();
			for (int i = 0; i < tourReference.length; i++) {
				if (tourReference[i].getTourID().compareTo(input1) == 0) {
					System.out.println("Tour - "
							+ tourReference[i].getTourDescript());
					System.out.print("Enter number of Tourists: ");
					int input2 = input.nextInt();
					tourReference[i].addBooking(input2);
					found = true;
					break;
					
				}
				else{
					found = false;
				}
					
				}
				
				 if (found == false)
				System.out.println("Tour ID not found!");
				 

			
	}
	while (temp != 0);

	System.out.println("\nPrinting details of all Tours: \n");
	for (int i = 0; i < tourReference.length; i++)
		tourReference[i].print();

}
}
