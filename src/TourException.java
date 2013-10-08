
public class TourException extends Exception {

	private String error;
	
	public String getError(){
		return error;
	}
	


public TourException(String error){
	this.error = error;
}
}


