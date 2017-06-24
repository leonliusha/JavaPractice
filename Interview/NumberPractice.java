package NumberPractice;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Months;


public class test {

	public static void main(String args[]){
		int a = 68;
		int b = 123;
		double c = 52.25;
		//String result =  new DecimalFormat("#.00").format((double)a/b*100);
		//String result =  new DecimalFormat("0.#").format(5.87);
		//c = (double)a/b;
		String result = new DecimalFormat("0").format((double)0);
		System.out.println(result);
		
		String result1 = new DecimalFormat("#.00").format((double)c/100*134/12);
		//String result1 = new DecimalFormat("#").format(0);
		System.out.println(result1);
		Long temp = Math.round(0.1/100*1678);
		System.out.println("the temp is :"+temp);
		String calculateResult = String.valueOf(temp-(260+110+80));
		System.out.println("calculateResult is:"+calculateResult);
		
		long duration = 24600000L;
		BigDecimal bg = new BigDecimal(duration / (double)3600000);
		double dutyHours = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("duty hours is:"+dutyHours);
		
		Long number  = Math.round(55.0 / 100 * 1000);
		System.out.println("number is:" + number);
		//Long result2 = Math.round((Double.parseDouble(number.toString()) - 450)/7);
		Long result2 = Math.round((new Double(number) - 450)/6);
		System.out.println("reslut is :"+result2);
		
		double testingresult = 2/3;
		System.out.println("testingresult is:"+testingresult);
		
		SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");
		System.out.println("the formated date is: "+df.format(new Date()));
		
		DateTime start = new DateTime(2015,8,1,0,0);
		DateTime end = new DateTime(2016,7,1,0,0);
		System.out.println("the difference is:"+Months.monthsBetween(start, end).getMonths());
		start = start.dayOfMonth().withMinimumValue();
		end = end.dayOfMonth().withMaximumValue();
		System.out.println("the start with min value is:"+start.toString());
		System.out.println("the end with max value is:"+end.toString());
		System.out.println("the difference is:"+Months.monthsBetween(start, end).getMonths());
		DateTime current = new DateTime(2016,7,20,0,0);
		System.out.println("the differnece with end date is:"+Months.monthsBetween(current, end).getMonths());
		System.out.println("the end with max value is:"+end.toString());
		DateTime newEnd = end.plusMonths(1).dayOfMonth().withMinimumValue();
		System.out.println("the current date is:"+current.toString());
		System.out.println("the new end date is:"+newEnd.toString());
		System.out.println("the difference with new end is:"+Months.monthsBetween(current,newEnd).getMonths());
		DateTime newEnd2 = newEnd.dayOfMonth().withMaximumValue();
		System.out.println("the new end 2 date is:"+newEnd2.toString());
		System.out.println("the difference with new end2 is:"+Months.monthsBetween(current,newEnd2).getMonths());
		
		
		
		
		DateTime today = new DateTime(DateTime.now().getYear(),DateTime.now().getMonthOfYear(),1,0,0);
		System.out.println("the today is:"+today.toString());
		DateTime finishDay = new DateTime(2014,12,1,0,0);
		System.out.println("the finishDay is:"+finishDay.toString());
		System.out.println("the difference from today to finishDay is:"+Months.monthsBetween(today, finishDay).getMonths());
		DateTime tomorrowDay = new DateTime().minusMonths(-1).withMillisOfDay(0);
		System.out.println("the tomorrowDay is:"+tomorrowDay.toString());
		int i = 10;
		if(--i < 10){
			System.out.println("i is:"+i);
		}
	}
}