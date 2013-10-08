
public class Tour {
	private String tourID;
	private String tourDescript;
	private double tourFee;
	private int noOfBookings;

	//Constructor for Tour Class
	public Tour (String tourID, String tourDescript, double tourFee){
		this.tourID = tourID;
		this.tourDescript = tourDescript;
		this.tourFee = tourFee;
		this.noOfBookings = 0;
	}

	// Accessor for Get Tour ID
	public String getTourID() {
		return tourID;
	}

	// Accessor for Get Tour Description
	public String getTourDescript() {
		return tourDescript;
	}

	// Accessor for Get Tour Fee
	public double getTourFee() {
		return tourFee;
	}

	// Accessor for Get Number of Bookings
	public int getNoOfBookings() {
		return noOfBookings;
	}

	// addBooking method for Tours
	public double addBooking(int numberOfTourists) throws TourException{
		if (numberOfTourists < 1){
			throw new TourException ("Error! Tour Group Size Limit Exceeded!\nBooking Rejected...");
		}
		noOfBookings += numberOfTourists;
		double totalBookingFee;
		totalBookingFee = tourFee * noOfBookings;
		System.out.println("Total booking fee is: $" +  totalBookingFee);
		return totalBookingFee;
	}

	// cancelBooking method for Tours
	public boolean cancelBooking(int numberOfTourists) throws TourException{
		if (numberOfTourists > noOfBookings){
			throw new TourException ("Error! Insufficient number of bookings!\nBooking Cancellation Rejected!");
		}
		if (numberOfTourists <= noOfBookings){
			noOfBookings -= numberOfTourists;
			return true;
		}
		else{
			return false;
		}
	}

	// Print method for Tours
	public void print(){
		System.out.println("");
		System.out.printf("TourID: \t\t%s\n", tourID);
		System.out.printf("Description: \t\t%s\n",tourDescript);
		System.out.printf("Tour Fee: \t\t$%.2f\n",tourFee);
		System.out.printf("Total Bookings: \t%d\n",noOfBookings);


	}
}



