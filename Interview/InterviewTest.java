package Practise;

import java.util.ArrayList;
import java.util.List;

class Person {
private String name;
private int age;
public Person(String name, int age) {
        this.name = name;
this.age = age;
    }
public String getName() {
return name;
    }
public int getAge() {
return age;
    }
}

public class InterviewTest {

public static void main(String args[]) {
        List<Person> pList = new ArrayList<Person>();
        pList.add(new Person("a", 11));
        pList.add(new Person("b", 21));
        pList.add(new Person("c", 61));
        pList.add(new Person("d", 5));
        pList = new InterviewTest().sort(pList);
        for(Person p:pList){
        	System.out.println(p.getAge());
        }
}


public List<Person> sort(List<Person> pList){
	for(int i=1;i<pList.size();i++){
		Person temp = pList.get(i);
		while(i > 0 && pList.get(i-1).getAge()>temp.getAge()){
			//Person temp = pList.get(i);
			pList.set(i, pList.get(i-1));
			i=i-1;

		}
		pList.set(i, temp);
	
	}
	return pList;

	}

}
