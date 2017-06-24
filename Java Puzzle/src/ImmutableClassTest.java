/**
 * Created by Administrator on 2015/9/8.
 */
public class ImmutableClassTest {
    public static void main(String args[]){
        int[] friends ={1,2,3};
        People people = new People("sha liu","14",friends);
        for(int i=0;i<people.getFriends().length;i++){
            System.out.print(people.getFriends()[i]);
        }
        System.out.println();
        friends[2] = 4;
        for(int i=0;i<friends.length;i++){
            System.out.print(friends[i]);
        }
        System.out.println();

        for(int i=0;i<people.getFriends().length;i++){
            System.out.print(people.getFriends()[i]);
        }


    }
}

final class People{
    private String name;
    private String age;
    private int[] friends;
    public People(String name, String age, int[] friends){
        this.name = name;
        this.age = age;
        this.friends = friends.clone();
    }
    public String getName(){
        return name;
    }
    public String getAge(){
        return age;
    }
    public int[] getFriends(){
        return friends;
    }
}
