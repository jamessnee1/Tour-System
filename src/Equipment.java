
abstract public class Equipment {

	private String equipID;
	private String equipDesc;
	private double baseHireFee;
	private int stockLevel;


	//Constructor for Equipment Class
	public Equipment (String equipID, String equipDesc, double baseHireFee, int stockLevel){
		this.equipID = equipID;
		this.equipDesc = equipDesc;
		this.baseHireFee = baseHireFee;
		this.stockLevel = stockLevel;
	}

	// Accessor for Getting Equipment ID
	public String getEquipID() {
		return equipID;
	}

	// Accessor for Getting Equipment Description
	public String getEquipDesc() {
		return equipDesc;
	}

	// Accessor for Getting Base Hire Fee
	public double getBaseHireFee() {
		return baseHireFee;
	}

	// Accessor for Getting Equipment Stock Level
	public int getStockLevel() {
		return stockLevel;
	}
	
	public double allocateStock(int quantity) throws EquipmentException{
		if (quantity < 1){
			throw new EquipmentException ("Error! No Stock Available!\nEquipment Hire Rejected...");
		}
		if (stockLevel >= quantity){
			stockLevel -= quantity;
			System.out.printf("Total hire fee is: $%.2f" ,  (quantity * baseHireFee));
			System.out.println();
			return (quantity * getBaseHireFee());
			
		}
		return -1;
	}
	
	public void returnStock(int quantity) {
		stockLevel += quantity;
		
	}
	
	public void print(){
		System.out.println();
		System.out.printf("Equipment ID: \t\t%s\n", equipID);
		System.out.printf("Equpment Description: \t%s\n",equipDesc);
		System.out.printf("Base Hire Fee: \t\t$%.2f\n",baseHireFee);
		System.out.printf("Stock Level: \t\t%d\n", stockLevel);
	}
	
	public abstract double getHireFee(int quantity);
}