package randarray;
import java.util.Scanner;
import java.util.Random;


public class RandArray {
    
    

   
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("How many rows?: ");
        int rowCount = input.nextInt();
        System.out.println("How many column?: ");
        int colCount = input.nextInt();
        System.out.println("Enter the minimum random?: ");
        int randMin = input.nextInt();
        System.out.println("Enter the maximum random?: ");
        int randMax = input.nextInt();
        
        
        
      int [][] randArray = new int[rowCount][colCount];
        

        for (int row = 0; row < rowCount; row++) {
           for (int col = 0; col < colCount; col++) {
               randArray [row][col] =rand.nextInt(randMax-randMin +1) + randMin ;//look into the formula
               System.out.print(randArray [row][col] + " , " );
               //System.out.prinf("%3, ", randArray[row][col]);   
           }
           System.out.println();
           
        }
    }
    
}
