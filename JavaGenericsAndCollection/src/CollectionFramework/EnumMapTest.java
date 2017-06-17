package CollectionFramework;

import java.util.ArrayDeque;
import java.util.EnumMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by liu on 15-5-25.
 */
public class EnumMapTest {

    private Map<Priority,ArrayDeque<Task>> taskMap = new EnumMap<Priority,ArrayDeque<Task>>(Priority.class);

    public void setTaskMap(){
        for(Priority p: Priority.values())
            taskMap.put(p,new ArrayDeque<Task>());
        //populate the list
        taskMap.get(Priority.HIGH).add(new Task() {
            @Override
            public String toString() {
                return null;
            }
        });
        taskMap.get(Priority.HIGH).add(new Task() {
            @Override
            public String toString() {
                return null;
            }
        });
    }

    public Map<Priority,ArrayDeque<Task>> getTeskMap(){
        return this.taskMap;
    }

    public static void main(String args[]){
        EnumMapTest enumMapTest = new EnumMapTest();
        enumMapTest.setTaskMap();
        Queue<Task> highPriorityTasks = enumMapTest.getTeskMap().get(Priority.HIGH);
        System.out.println("the highPriorityTasks has :"+highPriorityTasks.size());
    }


}
