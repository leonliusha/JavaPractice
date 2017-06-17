import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by liu on 15-5-15.
 */
public class ConcurrentCollectionsTest {
    ConcurrentMap<String,String> map = new ConcurrentHashMap<>();
    //do not use Collections.SynchronizedMap(), its nearly obsolete.
    //instead, using the java.util.concurrent.ConcurrentHashMap
    //and NEVER AND EVER synchronize on a concurrent collection
    public String intern(String s){
        String result = map.get(s);
        if(result == null){
            //call ConcurrentHashMap.putIfAbsent() only if map does not contain entry
            //otherwise, fail if map already contains value
            //and do not ignore return types,
             result = map.putIfAbsent(s,s);
            if(result == null)
                result = s;
        }
        return result;
    }
    public static void main(String args[]){

    }
}
