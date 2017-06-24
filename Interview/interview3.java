package Practise;

public class interview3 extends interview{

	public static void main(String args[]){
		meeting m;
		interview inter;
		interview2 inter2 = new interview2();
		m = (meeting)inter2;
		inter = new interview3();
		//inter = m;  // can not cast interface meeting to class interview3.
		String value="Hello";
		int i =9;
		System.out.println("Hello"+",World"=="Hello,World");
		join(value,i);
		System.out.println(value);
		System.out.println(i);
		String res = getResult("a");
		System.out.println(res);
	}
	public static String getResult(String str) {
        String result = "default";
        switch ('a') {
        case 'a' :
        	result = "a";
        case 'b' :
        	result = "b";
        default:
        	result = "c";
        }
        return result;
    }
	public static void join(String value, int i){
		i += 1;
		value+=",World";
		System.out.println(value);
		System.out.println(value=="Hello,World");
	
	}
}
