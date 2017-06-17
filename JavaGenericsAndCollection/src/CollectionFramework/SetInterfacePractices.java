package CollectionFramework;

import java.util.HashSet;
import java.util.Set;

public class SetInterfacePractices {
	public static void main(String args[]){
		String a = "abc";
		String b ="abc";
		System.out.println("the hash code of A is:"+a.hashCode());
		System.out.println("the hash code of B is:"+b.hashCode());
		
		Set<Character> s1 = new HashSet<Character>(8);
	}

}
