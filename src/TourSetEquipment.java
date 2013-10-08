
public class TourSetEquipment extends Equipment {
	
	private String tourType;
	
	//Constructor for TourSetEquipment subclass
		public TourSetEquipment (String equipID, String equipDesc, double baseHireFee, int stockLevel, String tourType){
			super(equipID, equipDesc, baseHireFee, stockLevel);
			this.tourType = tourType;
		}

		public String getTourType() {
			return tourType;
		}
		
		public double getHireFee(int quantity){
			return super.getBaseHireFee() - (0.2 * super.getBaseHireFee());
			
		}

		public void print(){
			System.out.println();
			System.out.printf("Equipment Type: \tTour Set Equipment");
			super.print();
			System.out.printf("Tour Type: \t\t%s ", tourType);
			System.out.println();
			
		}
}
