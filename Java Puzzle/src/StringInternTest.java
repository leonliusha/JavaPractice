/**
 * Created by Administrator on 2015/8/26.
 */
public class StringInternTest {
    public static void main(String args[])
    {
        String a = "b";
        String b = "b";
        System.out.println(a==b);
        String c = new String("b");
        System.out.println(a==c);
        String d = new String("b");
        System.out.println(c==d);
        String e = "b";
        //������inter()�����ǣ�������������Ѿ�������һ�����ڴ�String������ַ�������equals(Object�����жϣ���
        //�򷵻س����ַ��������򽫴�string������ӵ��������У����ҷ���
        String f = new String("b").intern();  //new String("b")���Ž��˷������ڵĳ�������
        System.out.println(e==f);
        String g = new String("b").intern();
        String h = new String("b");
        System.out.println(g==h);
        System.out.println(f==g);

    }
}
