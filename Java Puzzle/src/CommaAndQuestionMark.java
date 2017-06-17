/**
 * Created by Administrator on 2015/9/16.
 */

/***
 * Three RULES for Condition Statement
 * 1: if the second and third factory are the same type, than this type will be the return type
 * 2: if one of the factory is T,which in "byte, short, char", and the other factory is an int constant value,
 *    then the statement type is T
 * 3: Otherwise, using Binary Promotion Algorithm, it will be the statement return type.
 *
 *
 * In the first statement, x is char, 0 is a constant int value, so the statement type is char
 * In the second statement, x is char, but i is an variable with int type, so "Binary Promotion" is called,
 * the result is int. Therefore, the value of x will be represented by the int type, which is 88.
 *
 * So, make sure the second and third factory are the same data type.
 */
public class CommaAndQuestionMark {
    public static void main(String args[]){
        char x = 'X';
        int i = 0;
        System.out.println(true?x:0);
        System.out.println(false?i:x);

    }
}
