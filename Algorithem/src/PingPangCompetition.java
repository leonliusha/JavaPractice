/**
 * Created by Administrator on 2015/8/29.
 */
public class PingPangCompetition {
    public static void main(String args[]){
        char[] m = new char[]{'a','b','c'};
        char[] n = new char[]{'x','y','z'};
        for(int i=0;i<m.length;i++){
            for(int j=0;j<n.length;j++){
                if(m[i]=='a' &&(n[j]=='x'|| n[j]=='y'))
                    continue;
                else if(m[i]=='c' && (n[j] =='x' || n[j] == 'z'))
                    continue;
                else if(m[i]=='b' && (n[j] == 'y' || n[j] == 'z'))
                    continue;
                System.out.println(m[i]+" VS "+n[j]);
            }
        }
    }
}
