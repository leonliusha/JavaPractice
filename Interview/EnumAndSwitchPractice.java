package Practise;

public class EnumAndSwitchPractice {
	public enum Day{
		SUNDAY,MONDAY,TUESDAY,WEDNESDAY,
		THURSDAY,FRIDAY,SATUDAY,NOVALUE;
		public static Day toDay(String str){
			return valueOf(str);
		}
	}
	
	public static void main(String args[]){
		System.out.println(Day.toDay("MONDAY"));
		switch(Day.toDay("MONDAY")){
		case SUNDAY:
			System.out.println("星期天");
			break;
		case MONDAY:
			System.out.println("星期一");
			break;
		}
	}

}
