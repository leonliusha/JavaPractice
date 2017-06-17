/**
 * Created by Administrator on 2015/9/16.
 */

/**
 * 'h'+'a' is not a String operation, instead it is a Addition Operation in integer type.
 *  because 'h' and 'a' are basic char type, they are not unicode character type.
 *
 *  println的char[]重载版本会打印出数组所包含的所有unicode的字符，而且只有char[]数组被重载为打印内容
 *  String.valueOf()也会把char[]以unicode字符处理
 *
 *  对包含数组在内的对象引用的字符串转换引用为下：
 *  如果引用为Null，则转换为"null"，否则调用toString()方法，但如果调用toString（）的结果为null，用“null”代替
 *  对于一个非空char数组上调用toString,返回一个对象所属类的名字，@，和一个无符号16进制整数"
 */
public class StringAndChar {
    public static void main(String args[]){
        System.out.println("H"+"A");
        System.out.println('h'+'a');                  // the + operator will treat char as int value
        System.out.println('c');                      //without + operator, char will be treat as an unicode character char
        System.out.println("2+2 = "+2+2);
        System.out.println('c');
        System.out.printf("%c%c%c", 'H', 'a', '3');    //this will make char as an unicode character type
        System.out.println();
        char[] numbers = {'1','2','3'};
        System.out.println(numbers);
        System.out.println(numbers.toString());

        String[] strings = {"1","2","3"};
        System.out.println(strings);
        System.out.println(strings.toString());

        int[] ints = {1,2,3};
        System.out.println(ints);
        System.out.println(ints.toString());

        String lettes = "ABC";
        Object numberArray = new char[]{'1','2','3'};
        System.out.print(lettes + " easy as " );
        System.out.println(numberArray);               //虽然println()的char[]重载方法会把char当作unicode的char，
                                                       //但是这里调用的是println()的object的重载方法，
                                                        //也就是说调用了对象的toString（）方法。

        int length = 10;
        final String pig = "length: 10";
        final String dog = "length: "+length;          //dog不是用常量表达式来赋值的，如果改成 dog = "length: "+10;就是常量赋值
        System.out.println("Animals are equal:"+pig == dog);   //("Animals are equal:"+pig)==dog
        System.out.println("Animals are equal:"+(pig==dog));

    }
}
