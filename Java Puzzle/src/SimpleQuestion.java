/**
 * Created by liu on 15-5-15.
 */
public class SimpleQuestion {
    static boolean yesOrNo(String s){
        s = s.toLowerCase();
        if(s.equals("yes") || s.equals("t") || s.equals("y"))
            s = "true";
        //this is a trap. Boolean.getBoolean() return true if and only if the System Property named by the argument exists
        //and is equal to String "true". the system property is accessible through getProperty, a method is defined by
        //the System class.
        //So, whatever you passed to getBoolean, if it is not exits in the system property and equals to "true", Boolean.
        //getBoolean() would not return true indeed.
        return Boolean.getBoolean(s);

        //this will fix
        //return Boolean.parseBoolean(s);
    }

    //the above method sucks, do following
    static boolean yesOrNo2(String s){
        s = s.toLowerCase();
        return s.equals("yes") || s.equals("t") || s.equals("y") || s.equals("true");
    }
    public static void main(String args[]){

        System.out.println(yesOrNo("true") + " " + yesOrNo("YES"));
    }
}
