/**
 * Created by Administrator on 2015/8/28.
 */
public class subString {

    public static boolean isLetter(char c){
        return ('a'<=c && c<= 'z')?true:false;
    }
    public static int length(String origin){
        if(origin == null)
            return 0;
        int len = 0;
        char[] charArray = origin.toCharArray();
        for(int i=0;i<charArray.length;i++){
            len++;
            if(!isLetter(charArray[i]))
                len++;
        }
        return len;
    }

    public static String subString(String origin, int len){
        if(origin==null||origin.equals("")||len<0){
            return "";
        }
        if(len>origin.length())
            return origin;
        byte[] strByte = new byte[len];
        System.arraycopy(origin.getBytes(),0,strByte,0,len);
        int count=0;
        for(int i=0;i<len;i++){
            int value = strByte[i];
            if(value<0)
                count++;
        }
        if(count % 2 !=0)
            --len;
        return new String(strByte,0,len);
    }

    public static void main(String args[]){
        System.out.println(" "+subString("ÎÒabcººDEF",6));
    }
}
