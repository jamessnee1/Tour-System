
// Import Scanner and File Reading and Writing

import java.util.*;
import java.io.*;

public class TourSystem 
{

	public static void main(String[] args) throws IOException, TourException
	{
		// Create scanners for printing to file
		
		Scanner tours = new Scanner (new File("Tour.txt"));
		Scanner equipment = new Scanner (new File ("Equipment.txt"));
		
		// Code to read from a file - Tours
		
		while (tours.hasNext())
		{
			String tempType = tours.next();
			String tempID = tours.next();
			String tempTourDesc = tours.next();
			double tempTourFee = tours.nextDouble();
			int tempNoOfBookings = tours.nextInt();
			if (tempType.compareTo("Tour") == 0)
			{
			TourManager.createTour(tempID, tempTourDesc, tempTourFee);
			}
			
			else if (tempType.compareTo("Guided") == 0)
			{
				String tempDate = tours.next();
				int tempSize = tours.nextInt();
				String tempGuideName = tours.next();
				String tempTourEquipID = tours.next();
				TourManager.createGuidedTour(tempID, tempTourDesc, tempTourFee, tempDate, 
						tempSize, tempGuideName, tempTourEquipID);
			}
	
		}
		
		// Code to read from a file - Equipment
		
		while (equipment.hasNext())
		{
			String tempEquipType = equipment.next();
			String tempEquipID = equipment.next();
			String tempEquipDesc = equipment.next();
			double tempEquipFee = equipment.nextDouble();
			int tempStockLevel = equipment.nextInt();
			if (tempEquipType.compareTo("CasualHire") == 0)
			{
			EquipmentManager.createCasualHireEquipment(tempEquipID, tempEquipDesc, tempEquipFee, tempStockLevel);
			}
			
			else 
			{
				String tempTourType = equipment.next();
				EquipmentManager.createTourSetEquipment(tempEquipID, 
						tempEquipDesc, tempEquipFee, tempStockLevel, tempTourType);
			}

		}
		
		// Declaring variables to be used in the Tour System menu
		
		String input1;
		String equipID;
		String equipDesc;
		double baseHireFee;
		int stockLevel;
		String equipType;
		String booking;
		String tourID;
		String tourDescript;
		String tourType;
		String tourDate;
		int tourGroupSize;
		String tourGuideName;
		int tourFee;
		int hired;
		String cancellation;
		char temp;
		boolean quit = false;
		boolean found = true;
		
		// Create PrintWriters for Tour and Equipment
		
		PrintWriter toursOutput = new PrintWriter("Tour.txt");
		PrintWriter equipmentOutput = new PrintWriter("Equipment.txt");

		// Do While loop to control menu functionality
		
		do{
			// Menu layout
			
			Scanner input = new Scanner(System.in);
			System.out.println("******* Tour Booking System Menu *******");
			System.out.println("----------------------------------------");

			// Print list of selections
			
			System.out.printf("Add New Tour\t\t\t-A\n");
			System.out.printf("Display Tour Summary\t\t-B\n");
			System.out.printf("Add New Equipment\t\t-C\n");
			System.out.printf("Display Equipment Summary\t-D\n");
			System.out.printf("Add Tour Booking\t\t-E\n");
			System.out.printf("Cancel Tour Booking\t\t-F\n");
			System.out.printf("Casual Equipment Hire\t\t-G\n");
			System.out.printf("Equipment Return\t\t-H\n");
			System.out.printf("Exit\t\t\t\t-X\n\n");
			System.out.print("Enter your selection: ");

			// User input for menu
			
			input1 = input.nextLine().toUpperCase();
			temp = input1.charAt(0);
			
			// Option A: Add Tour
			
			if (temp == 'A')
			{
				System.out.println("(Add New Tour to system)");
				System.out.print("Enter Tour ID to add: ");
				tourID = input.nextLine().toUpperCase();
				System.out.print("Enter Tour Description: ");
				tourDescript = input.nextLine();
				System.out.print("Enter Tour Fee: ");
				tourFee = input.nextInt();
				if (input.hasNextLine())
				{
					input.nextLine();
				}
				System.out.print("Enter Tour Type(Guided or Tour): ");
				tourType = input.nextLine();
				if (tourType.compareTo("Guided")== 0)
				{
					System.out.print("Enter Tour Date: ");
					tourDate = input.nextLine();
					System.out.print("Enter Tour Group Size: ");
					tourGroupSize = input.nextInt();
					if (input.hasNextLine())
					{
						input.nextLine();
					}
					System.out.print("Enter Tour Guide Name: ");
					tourGuideName = input.nextLine();
					
					for (int i = 0; i < EquipmentManager.equipArrayPos; i++)
					{
						if (EquipmentManager.addedEquipment[i] instanceof TourSetEquipment)
						{
							System.out.println();
							System.out.println("Equipment ID: \t"+ EquipmentManager
									.addedEquipment[i].getEquipID());
							System.out.println("Tour Type: \t"+ ((TourSetEquipment) EquipmentManager
									.addedEquipment[i]).getTourType());
							System.out.println();
						}
					}
					
					System.out.print("Enter Equipment ID you wish to use: ");
					equipID = input.nextLine();
					for(int i = 0; i < EquipmentManager.equipArrayPos; i++)
					{
						if (EquipmentManager.addedEquipment[i].getEquipID().compareTo(equipID) == 0) 
						{
							
							TourManager.createGuidedTour(tourID, tourDescript, tourFee, tourDate,
									tourGroupSize, tourGuideName, equipID);
							System.out.println();
							System.out.println("Guided Tour Created Successfully!");
							System.out.println();
							
						}
					}
				}
				else if (tourType.compareTo("Tour") == 0)
				{
					TourManager.createTour(tourID, tourDescript, tourFee);
					System.out.println();
					System.out.println("Tour Created Successfully!");
					System.out.println();
				}
			}

			// Option B: Display Tour Summary
			
			if (temp == 'B')
			{
					TourManager.displayTourSummary();
				System.out.println("");
				System.out.println("--------");
				System.out.println("");
			}
			
			// Option C: Add Equipment
			
			if (temp == 'C')
			{
				System.out.println("(Add New Equipment to system)");
				System.out.print("Enter Equipment ID to add: ");
				equipID = input.nextLine().toUpperCase();
				System.out.print("Enter Equipment Description: ");
				equipDesc = input.nextLine();
				System.out.print("Enter Equipment Base Hire Fee: ");
				baseHireFee = input.nextDouble();
				if (input.hasNextLine())
				{
					input.nextLine();
				}
				System.out.print("Enter Stock Level: ");
				stockLevel = input.nextInt();
				if (input.hasNextLine())
				{
					input.nextLine();
				}
				System.out.print("Enter Equipment Type (Casual or TourSet): ");
				equipType = input.nextLine().toUpperCase();
				if (equipType.compareTo("TOUR SET")== 0)
				{
					System.out.print("Enter Type of Tour this equipment will be used for (Guided or Tour): ");
					tourType = input.nextLine().toUpperCase();
					EquipmentManager.createTourSetEquipment(equipID, equipDesc, baseHireFee, stockLevel, tourType);
					System.out.println();
					System.out.println("Equipment Added Successfully!");
					System.out.println();
				}
					
				else if (equipType.compareTo("CASUAL") == 0)
				{
					EquipmentManager.createCasualHireEquipment(equipID, equipDesc, baseHireFee, stockLevel);
					System.out.println();
					System.out.println("Equipment Added Successfully!");
					System.out.println();
				}
			}
			
			
			// Option D: Display Equipment Summary
			
			if (temp == 'D')
			{
					EquipmentManager.displayEquipmentSummary();
				System.out.println("");
				System.out.println("--------");
				System.out.println("");
			}
			
			

			// Option E: Add Tour Bookings
			
			if (temp == 'E')
			{
				System.out.println("(Add Booking)");
				System.out.print("Enter Tour ID: ");
				booking = input.nextLine().toUpperCase();
				for (int i = 0; i < TourManager.arrayPos; i++) 
				{
					if (TourManager.addedTours[i].getTourID().compareTo(booking) == 0) 
					{
						System.out.println("Tour - "
								+ TourManager.addedTours[i].getTourDescript());
						System.out.print("Enter number of Tourists: ");
						int people = input.nextInt();
						try
						{
						if (TourManager.addTourBooking(booking, people) == -1)
						{
							System.out.println();
							System.out.println("Error! Tour Group Size Limit Exceeded!");
							System.out.println("Booking Rejected...");
						}
						}
						catch (TourException te2)
						{
							System.out.println();
							System.out.println(te2.getError());
							
						}
						
						System.out.println();
						System.out.println("--------");
						System.out.println();
						found = true;
						break;

					}
					
					else
					{
						found = false;
					}
				}
				if (found == false)
				{
					System.out.println();
					System.out.println("Error: Tour ID not found!");
					System.out.println();
				}
			}

			// Option F: Cancel Tour Bookings
			
			if (temp == 'F')
			{
				System.out.println("(Cancel Booking Option Selected)");
				System.out.print("Enter Tour ID: ");
				cancellation = input.nextLine().toUpperCase();

				for (int i = 0; i < TourManager.arrayPos; i++)
				{ 
					if (TourManager.addedTours[i].getTourID().compareTo(cancellation) == 0)
					{ 
						System.out.println("Tour - "
								+ TourManager.addedTours[i].getTourDescript());
						System.out.print("Enter number of bookings to cancel: ");
						int canbook = input.nextInt();
						try
						{
						if (TourManager.addedTours[i].cancelBooking(canbook) == true)
						
						{
							System.out.println();
							System.out.println("Bookings cancelled successfully.");
							System.out.println("Refunded tour fees: $" + 
							(canbook * TourManager.addedTours[i].getTourFee()));
						}
						}
						catch (TourException te)
						{
							System.out.println();
							System.out.println(te.getError());	
						}
						System.out.println();
						System.out.println("--------");
						System.out.println();
						found = true;
						break;
					}
					else
					{
						found = false;
					}
				}
				if (found == false)
				{
					System.out.println();
					System.out.println("Error: Tour ID not found!");
					System.out.println();
				}

			}

			
			// Option G: Casual Equipment Hire

			if (temp == 'G')
			{

				System.out.println("(Casual Equipment Hire)");
				System.out.print("Enter Equipment ID to hire: ");
				equipID = input.nextLine().toUpperCase();
				for(int i = 0; i < EquipmentManager.equipArrayPos; i++)
				{
					if (EquipmentManager.addedEquipment[i].getEquipID().compareTo(equipID) == 0 
							&& EquipmentManager.addedEquipment[i] instanceof CasualHireEquipment) 
					{
						System.out.println("Equipment - " + EquipmentManager.addedEquipment[i].getEquipDesc());
						System.out.print("Enter quantity to hire: ");
						stockLevel = input.nextInt();
						if (input.hasNextLine())
						{
							input.nextLine();
						}
						try
						{
							if (EquipmentManager.addEquipment(equipID, stockLevel) == -1)
							{

								System.out.println();
								System.out.println("Error! Stock Level Exceeded!");
								System.out.println("Equipment Hire Rejected...");
							}
						}
						catch (EquipmentException te2)
						{
							System.out.println();
							System.out.println(te2.getError());
						}
						System.out.println();
						System.out.println("--------");
						System.out.println();
						found = true;
						break;

					}
					else if (EquipmentManager.addedEquipment[i].getEquipID().compareTo(equipID) == 0) 
					{
						found = true;
						if (EquipmentManager.addedEquipment[i] instanceof TourSetEquipment)
						{
							
							System.out.println();
							System.out.println("Error! Not a Casual Hire Equipment Set!");
							System.out.println("Equipment Hire Rejected...");
							System.out.println();
							break;
						}
						
					}
					

				}
				if (found == false)
				{
					System.out.println();
					System.out.println("Error: Equipment ID not found!");
					System.out.println();
				}
			}
			
			// Option H: Equipment Return

			if (temp == 'H')
			{

				System.out.println("(Equipment Return)");
				System.out.print("Enter the type of equipment to return (Tour Set or Casual): ");
				tourType = input.nextLine().toUpperCase();
	
				for(int i = 0; i < EquipmentManager.equipArrayPos; i++)
				{
					// if loop for casual hire equip
					
					if(EquipmentManager.addedEquipment[i] instanceof CasualHireEquipment)
					{
						System.out.print("Enter Casual Hire Equipment ID: ");
						equipID = input.nextLine().toUpperCase();
						for (int j = 0; j < EquipmentManager.equipArrayPos; j++)
						{
							if (EquipmentManager.addedEquipment[j] instanceof TourSetEquipment)
							{
								System.out.println();
								System.out.println("Error: Tour Set Equipment Selected! Tour Set Equipment cannot be returned!");
								System.out.println();
							}
							else if (EquipmentManager.addedEquipment[j].getEquipID().compareTo(equipID) == 0)
							{
								
								System.out.println("Equipment - " + EquipmentManager.addedEquipment[j].getEquipDesc());
								System.out.print("Enter quantity to return: ");
								hired = input.nextInt();
								if (input.hasNextLine())
								{
									input.nextLine();
								}
								
								EquipmentManager.addedEquipment[j].returnStock(hired);
								
							
								System.out.println();
								System.out.println("Equipment Returned Successfully.");
								System.out.printf("Refunded equipment bond: $%.2f" , 
								(((CasualHireEquipment) EquipmentManager.addedEquipment[j]).getBond(hired)));
								System.out.println();
								System.out.println("--------");
								System.out.println();
								found = true;
								break;
										
							}
							
						}
					}
					
					
					// if loop for tour set equip 
					
					if(EquipmentManager.addedEquipment[i] instanceof TourSetEquipment)
					{
						System.out.print("Enter Tour ID of Guided Tour equipment was used for: ");
						tourID = input.nextLine().toUpperCase();
						for (int j = 0; j < TourManager.arrayPos; j++)
						{
							if (TourManager.addedTours[j] instanceof Tour)
							{
								System.out.println();
								System.out.println("Error! Tour Set Equipment can only be returned on Guided Tours!");
								System.out.println();
							}
							else if (TourManager.addedTours[j].getTourID().compareTo(tourID) == 0)
							{
								found = true;
								System.out.println("Equipment ID - " + EquipmentManager.addedEquipment[j].getEquipID());
								System.out.println("Number of Bookings - " + TourManager.addedTours[j].getNoOfBookings());
								System.out.print("Enter quantity to return: ");
								stockLevel = input.nextInt();
								if (input.hasNextLine())
								{
									input.nextLine();
								}
								System.out.println();
								System.out.println("Equipment Returned Successfully.");
								System.out.println();
								System.out.println("--------");
								System.out.println();
								found = true;
								break;
										
							}
							
						}
					}
					
				}
				if (found == false)
				{
					System.out.println();
					System.out.println("Error: Equipment ID not found!");
					System.out.println();
				}
				
				else
				{
					found = false;
				}
			}
				
			
			
			
			// Option X: Exit the tour system
			
			if (temp == 'X')
			{
				
				// Code to write to a file
				
				for (int i = 0; i < TourManager.arrayPos; i++)
				{
					if (TourManager.addedTours[i] instanceof GuidedTour)
					{
						toursOutput.print("Guided");
					}
					else
					{
						toursOutput.print("Tour");
					}
					toursOutput.print("\t" + TourManager.addedTours[i].getTourID());
					toursOutput.print("\t" + TourManager.addedTours[i].getTourDescript());
					toursOutput.print("\t" + TourManager.addedTours[i].getTourFee());
					toursOutput.print("\t" + TourManager.addedTours[i].getNoOfBookings());
					
					if (TourManager.addedTours[i] instanceof GuidedTour)
					{
						toursOutput.print("\t" + ((GuidedTour)TourManager.addedTours[i]).getTourDate());
						toursOutput.print("\t" + ((GuidedTour)TourManager.addedTours[i]).getGroupSize());
						toursOutput.print("\t" + ((GuidedTour)TourManager.addedTours[i]).getTourGuideName());
						toursOutput.print("\t" + ((GuidedTour)TourManager.addedTours[i]).getEquipmentID());
					}
					toursOutput.println();
				}
				
				for (int i = 0; i < EquipmentManager.equipArrayPos; i++)
				{
					if (EquipmentManager.addedEquipment[i] instanceof TourSetEquipment)
					{
						equipmentOutput.print("TourSet");
					}
					else
					{
						equipmentOutput.print("CasualHire");
					}
					equipmentOutput.print("\t" + EquipmentManager.addedEquipment[i].getEquipID());
					equipmentOutput.print("\t" + EquipmentManager.addedEquipment[i].getEquipDesc());
					equipmentOutput.print("\t" + EquipmentManager.addedEquipment[i].getBaseHireFee());
					equipmentOutput.print("\t" + EquipmentManager.addedEquipment[i].getStockLevel());
					
					if (EquipmentManager.addedEquipment[i] instanceof TourSetEquipment)
					{
						equipmentOutput.print("\t" + ((TourSetEquipment)EquipmentManager.addedEquipment[i]).getTourType());	
					}
					equipmentOutput.println();
				}
				
				// Closing Files
				
				toursOutput.close();
				equipmentOutput.close();
				System.out.println();
				System.out.println("Tours and Equipment parameters saved.");
				System.out.println();
				break;

			}
			

		}
		// While part of the Do While loop
		while (quit == false);

		// Exit Message
		System.out.println("Tour system shutting down - goodbye!");


	}
}
	