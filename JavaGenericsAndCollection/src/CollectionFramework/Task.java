package CollectionFramework;

/**
 * Created by liu on 15-5-21.
 */
public abstract class Task implements Comparable<Task>{
    protected Task(){}

    public boolean equals(Object o){
        if(o instanceof Task){
            return toString().equals(o.toString());
        }
        else
            return false;
    }

    public int compareTo(Task task){
        return toString().compareTo(task.toString());
    }

    public int hashCode(){
        return toString().hashCode();
    }

    public abstract String toString();
}
