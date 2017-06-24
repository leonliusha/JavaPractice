package Practise;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NullTesting {
	public static void main(String args[]){
		List l = new ArrayList();
		l.add(null);
		Set s = new HashSet();
		s.add(null);
		Map m = new HashMap();
		m.put(null, null);
		Hashtable t = new Hashtable();
		t.put("String",null);
	}

}
