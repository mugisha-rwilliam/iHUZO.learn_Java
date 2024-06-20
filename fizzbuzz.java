public class FizzBuzz {
    
}
import java.util.Scanner;

public class FizzBuzzCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter a number: ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();

                if (number % 3 == 0) {
                    if (number % 5 == 0) {
                        System.out.println("FizzBuzz");
                        return; // Exit the method
                    } else {
                        System.out.println("Fizz");
                        return; // Exit the method
                    }
                } else if (number % 5 == 0) {
                    System.out.println("Buzz");
                    return; // Exit the method
                } else {
                    System.out.println("Please try again.");
                }
            } else {
                System.out.println("Error: Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        scanner.close():
    }
}
