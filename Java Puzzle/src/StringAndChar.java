/**
 * Created by Administrator on 2015/9/16.
 */

/**
 * 'h'+'a' is not a String operation, instead it is a Addition Operation in integer type.
 *  because 'h' and 'a' are basic char type, they are not unicode character type.
 *
 *  println��char[]���ذ汾���ӡ������������������unicode���ַ�������ֻ��char[]���鱻����Ϊ��ӡ����
 *  String.valueOf()Ҳ���char[]��unicode�ַ�����
 *
 *  �԰����������ڵĶ������õ��ַ���ת������Ϊ�£�
 *  �������ΪNull����ת��Ϊ"null"���������toString()���������������toString�����Ľ��Ϊnull���á�null������
 *  ����һ���ǿ�char�����ϵ���toString,����һ����������������֣�@����һ���޷���16��������"
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
        System.out.println(numberArray);               //��Ȼprintln()��char[]���ط������char����unicode��char��
                                                       //����������õ���println()��object�����ط�����
                                                        //Ҳ����˵�����˶����toString����������

        int length = 10;
        final String pig = "length: 10";
        final String dog = "length: "+length;          //dog�����ó������ʽ����ֵ�ģ�����ĳ� dog = "length: "+10;���ǳ�����ֵ
        System.out.println("Animals are equal:"+pig == dog);   //("Animals are equal:"+pig)==dog
        System.out.println("Animals are equal:"+(pig==dog));

    }
}
