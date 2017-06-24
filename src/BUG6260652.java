import java.util.Arrays;
import java.util.List;


public class BUG6260652 {
	public static void main(String args[]){
		List<String> l = Arrays.asList("1","2","3","4");
		System.out.println(l.toArray());
		System.out.println(l.toArray(new Object[0]));
	}
}
