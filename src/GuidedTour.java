
public class GuidedTour extends Tour {
	
	// Declaring private variables which extend Tour Class
	private String tourDate;
	private int groupSize;
	private String tourGuideName;
	private String equipID;

	// Constructor for GuidedTour, which extends Tour Class
	public GuidedTour (String tourID, String tourDescript, double tourFee,
			String tourDate, int groupSize, String tourGuideName, String equipID){
		super(tourID, tourDescript, tourFee);
		this.tourDate = tourDate;
		this.groupSize = groupSize;
		this.tourGuideName = tourGuideName;
		this.equipID = equipID;
	}

	// Accessor for Tour Date
	public String getTourDate(){
		return tourDate;
	}

	// Accessor for Group Size
	public int getGroupSize(){
		return groupSize;
	}

	// Accessor for Tour Guide Name
	public String getTourGuideName(){
		return tourGuideName;
	}
	
	// Accessor for Equipment ID
		public String getEquipmentID(){
			return equipID;
		}

	// Overwritten addBooking method for Guided Tours only
	public double addBooking(int numberOfTourists) throws TourException{
		if (groupSize < numberOfTourists + super.getNoOfBookings())

		{
			return -1.0;
		}else{
			return super.addBooking(numberOfTourists);
		}
	}

	// Overwritten print method for Guided Tours only
	public void print(){
		super.print();
		System.out.printf("Tour Date: \t\t%s\n", tourDate);
		System.out.printf("Maximum Group Size: \t%s\n", groupSize);
		System.out.printf("Tour Guide: \t\t%s\n", tourGuideName);

	}

}

