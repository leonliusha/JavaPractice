import java.util.Calendar;


//the result will be "Elvis wears a size -1930 belt.". the reason is that, when we call Main method, the initialization of class Elvis is started, 
//then the static fields are set to its default value, so the INSTANCE is set to null, and CURRENT_YEAR is set to 0.
//Afterward, the constructor of Elvis has been called, and it set the value of beltSize to CURRENT_YEAR - 1930,but the CURRENT_YEAR is still 0.
//this program shows that it is possible to observe a final static field before it is initialized, when it still contains the default value for its type.
//this is counter-intuitive, because we usually think of final fields as constants. Final fields are constants only if the initializing expression is a constant expression.

public class Elvis {
	//To fix a class initialization cycle, reorder the static field initializers so that each initializer appears before any initializers that depends on it.
	//the following expression will fix the class initialization issue.
	//private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	public static final Elvis INSTANCE = new Elvis();
	private final int beltSize;
	private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	
	private Elvis(){
		beltSize = CURRENT_YEAR - 1930;
	}
	
	public int beltSize(){
		return beltSize;
	}
	
	public static void main(String args[]){
		System.out.println("Elvis wears a size "+INSTANCE.beltSize() + " belt.");
	}
}
