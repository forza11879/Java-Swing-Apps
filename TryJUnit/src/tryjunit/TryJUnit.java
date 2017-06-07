package tryjunit;

import java.util.Scanner;

public class TryJUnit {

    public static int addTwoNaturalNumbers(int a, int b) {
        if ((a < 0) || (b < 0)) {
            throw new IllegalArgumentException(
                    "Parameters must be natural numbers (non-negative)");
        }
        return a + b;
    }
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Enter two natural numbers: ");
        int val1 = input.nextInt();
        int val2 = input.nextInt();
        int result = addTwoNaturalNumbers(val1, val2);
        System.out.printf("%d + %d = %d\n", val1, val2, result);
    }
    
}
