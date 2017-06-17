/**
 * Created by Administrator on 2015/9/15.
 */
public class EnumTest {
    private final String name;
    private EnumTest(String name){this.name = name;}

    public String toString(){return name;}

    public static final EnumTest TESTA = new EnumTest("A");
    public static final EnumTest TESTB = new EnumTest("B");
    public static final EnumTest TESTC = new EnumTest("C");
    public static final EnumTest TESTD = new EnumTest("D");
}

class OwnTest{
    public EnumTest[] enumTests = new EnumTest[]{EnumTest.TESTA,EnumTest.TESTB,EnumTest.TESTC,EnumTest.TESTD};
}
