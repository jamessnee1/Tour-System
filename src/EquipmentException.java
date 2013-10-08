
public class EquipmentException extends Exception {
	private String error;
	
	public String getError(){
		return error;
	}
	


public EquipmentException(String error){
	this.error = error;
}
}

