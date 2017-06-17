import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by liu on 15-5-29.
 */
public class NumberPuzzles {
    private static Random random = new Random();
    public static void main(String args[]){
        //THE result is 0.899999999999999, so avoid float and double where exact answers are required,for example,
        //when dealing with money, using BigDecimal, int or long instead
        System.out.println(2.00-1.10);

        //garbge in garbeg out. The spec says that: Translate a double into a BigDecimal which is the exact decimal representation
        //of the double's binary floating-point value
        //so the result will be 0.899999999999999999999992398583744712734157283482347
        //we are using the wrong constructor, do not using new BigDecimal(double)
        BigDecimal payment = new BigDecimal(2.00);
        BigDecimal cost = new BigDecimal(1.10);
        System.out.println("the actual cost is:"+payment.subtract(cost));

        //using the constructor with String arguments when we create BigDecimal.
        //using new BigDecimal(String)

        //but if you have to using double as argument, using BigDecimal.valueOf(double)
        BigDecimal payment2 = new BigDecimal("2.00");
        BigDecimal cost2 = new BigDecimal("1.10");
        System.out.println("the actual cost is:"+payment2.subtract(cost2));

        //Byte.MIN_VALUE = -128  and  Byte.MAX_VALUE = 127. But 0x90 = 144
        //(byte)0x90 = -112, but (byte)0x90 != 0x90
        for(byte b=Byte.MIN_VALUE;b<Byte.MAX_VALUE;b++){
                if(b == 0x90)
                    System.out.print("Joy");
        }

        //we can fix it by comparing apple to apple, orange to orange
        //private static final byte TARGET = (byte)0x90;

        //the following code has 3 bugs
        //Chars are not Strings, they are more like ints
        StringBuffer buffer = null;
        switch(random.nextInt(2)){  //(1) if expecting 0,1,2, we should using 3   (2) no breaks on each cases;
            case 1: buffer = new StringBuffer('P');//the StringBuffer does not have a constructor that takes character arguments
            case 2: buffer = new StringBuffer('G');//what happens if we pass an character? that character will be converted to an integer
            default: buffer = new StringBuffer('M');//to represent the capacity of the StringBuffer:   To Fix using: StringBuffer sb = new StringBuffer("P");
        }
        buffer.append('a');  //this is Ok, because StringBuffer already created.we can append a character to String
        buffer.append('i');
        buffer.append('n');
        System.out.println(buffer);

        //this will be a better solution
        String[] a = {"Pain","Gain","Main"};
        System.out.println(randomElement(a));


        //Long devision puzzle   Large numbers are silent killers
        final long MILLS_PER_DAY = 24*60*60*1000;
        final long MICROS_PER_DAY = 24*60*60*1000*1000; //>> Integer.MAX_VALUE. Because we ONLY using integer values to do the computation, 24,60,1000 are integers.
        System.out.println("the MILLS_PER_DAY IS:"+MILLS_PER_DAY);//so, even we declared a long variable, but we still got a INTEGER value.
        System.out.println("the MICROS_PER_DAY IS:"+MICROS_PER_DAY);

        System.out.println(MICROS_PER_DAY / MILLS_PER_DAY); // the result is not 1000

        //to fix this, marking some value as a LONG value
        final long MILL_PER_DAY2 = 24L * 60 * 60 * 1000;
        final long MICRO_PER_DAY2 = 24L * 60 * 60 * 1000 * 1000;
        System.out.println(MICRO_PER_DAY2 / MILL_PER_DAY2);// this result is 1000


        //its Elementary
        System.out.println(12345 + 5432l);  // watch carefully dude!!!!     ALWAYS USING CAPITAL L FOR LONG value, such as 1234L
        System.out.println(01234 + 43210); // leading zeros can always cause trouble
        System.out.println(01234);  //leading 0 means something else, this is an octal literal equal to 668

        Math.round(10.8);
    }



    //A better solution will be following
    private static String randomElement(String[] a) {
        return a[random.nextInt(a.length)];
    }





}
