import java.util.*;
public class DatePractice {
	public static void main(String args[]){
	Calendar c1 = Calendar.getInstance();   //Can not using "new" to create a new instance of Calendar.
	int year = c1.get(Calendar.YEAR);
	int month = c1.get(Calendar.MONTH)+1;   //Calendar MONTH starts from 0
	int date = c1.get(Calendar.DATE);
	System.out.println("The Calendar.MONTH is:"+Calendar.MONTH);
	System.out.println("The Calendar YEAR is:"+Calendar.YEAR);
	System.out.println("The Calendar Date is:"+Calendar.DATE);
	System.out.println("year is:"+year+"month is:"+month+"date is:"+date);
	DatePractice datePractice = new DatePractice();
	datePractice.GregorianCalendarTest();
}
	
	public void GregorianCalendarTest(){
		GregorianCalendar gcalendar = new GregorianCalendar();
		String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		int year;
		System.out.println("The Calendar.MONTH is:"+Calendar.MONTH);
		System.out.println("the gcalendar.get(Calendar.MONTH) is:"+gcalendar.get(Calendar.MONTH));
		System.out.print("Data is:");
		System.out.print(months[gcalendar.get(Calendar.MONTH)]);
		System.out.print(" "+gcalendar.get(Calendar.DATE)+" ");
		System.out.println(year = gcalendar.get(Calendar.YEAR));
		System.out.print("Time: ");
		System.out.print(gcalendar.get(Calendar.HOUR)+":");
		System.out.print(gcalendar.get(Calendar.MINUTE)+":");
		System.out.println(gcalendar.get(Calendar.SECOND));
		
		if(gcalendar.isLeapYear(year)){
			System.out.println("this year is a leap year");
		}
		else
			System.out.println("this year is not a leap year");
	}
}
