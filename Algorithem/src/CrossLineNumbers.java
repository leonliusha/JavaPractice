import java.util.Scanner;

/**
 * Created by Administrator on 2015/8/30.
 */
public class CrossLineNumbers {
    public static void main(String args[]){
        int[][] matrix = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter 9 numbers: ");
        int sum = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("the matrix is: ");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               if(i==j)
                   sum = sum + matrix[i][j];
            }
        }
        System.out.println("the sum of cross line numbers is : "+sum);
    }
}
