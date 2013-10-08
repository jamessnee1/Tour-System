
public class CasualHireEquipment extends Equipment {
	
	public CasualHireEquipment(String equipID, String equipDesc, double baseHireFee, int stockLevel){
		super(equipID, equipDesc, baseHireFee, stockLevel);
	}
	
	public double getBond(int quantity){
		double bond = (getBaseHireFee() * 0.2 * quantity);
		return bond;
		
	}
	
	public double getHireFee(int quantity){
		return (getBond(quantity) + super.getBaseHireFee() * quantity);

	}

	public void print(){
		System.out.println();
		System.out.printf("Equipment Type: \tCasual Hire");
		super.print();
		System.out.printf("Equipment Bond: \t$%.2f\n", getBond(1));
		
	}
}
