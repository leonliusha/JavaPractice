/**
 * Created by Administrator on 2015/9/15.
 * Enum class is a class with a private constructor, in which we can not instantiate a Enum class.
 * Enum class contains one or more public static final instance.
 */
public class EnumTest {
    private final String name;
    private EnumTest(String name){this.name = name;}
    public String toString(){return name;}

    public static final EnumTest TESTA = new EnumTest("A");
    public static final EnumTest TESTB = new EnumTest("B");
    public static final EnumTest TESTC = new EnumTest("C");
    public static final EnumTest TESTD = new EnumTest("D");

    public static void main(String args[]){
        System.out.println(EnumTest.TESTA);
    }
}

class OwnTest{
    public EnumTest[] enumTests = new EnumTest[]{EnumTest.TESTA,EnumTest.TESTB,EnumTest.TESTC,EnumTest.TESTD};
    //EnumTest a = new EnumTest("testtest"); //can not instantiat
}
