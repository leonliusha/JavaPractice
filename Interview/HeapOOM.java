package Practise;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
	
	static class OOMObject{
		public static void main(String args[]){
			List<OOMObject> list = new ArrayList<OOMObject>();
		//!!!Becareful to run this program. Heap will running out of memory
		//	while(true){
		//		list.add(new OOMObject());
		//	}
		}
	}

}
