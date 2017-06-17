import java.io.*;
public class BufferedReaderPractice {
	public static void main(String args[]){
		char c = 0;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("please enter 'q' to quit.");
		do{
			try {
				c = (char)bufferedReader.read();
				System.out.println(c);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(c !='q');
		BufferedReaderPractice brp = new BufferedReaderPractice();
		brp.readLine();
	}
	
	public void readLine(){
		String s = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 'end' to quit.");
		do{
			try {
				s = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(s);
		}while(!s.equalsIgnoreCase("end"));
	}
}
