package Java_apps;
import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final float MAX_INTEREST_RATE = 20.0f; // The maximum allowed interest rate
        final float MIN_INTEREST_RATE = 8.0f; // The minimum allowed interest rate
        final int MIN_PRINCIPAL = 3000; // The minimum allowed principal
        final int MAX_PRINCIPAL = 2000000; // The maximum allowed principal

        Scanner scanner = new Scanner(System.in);
        int principal = 0;

        // Input validation for principal
        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal < MIN_PRINCIPAL || principal > MAX_PRINCIPAL) {
                System.out.println("The principal should not be less than 3,000 and not higher than 2,000,000. Please enter a valid principal.");
            } else {
                break;
            }
        }

        // Input validation for annual interest rate
        float annualInterest = 0;
        while (true) {
            System.out.print("Annual Interest Rate (%): ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > MIN_INTEREST_RATE && annualInterest <= MAX_INTEREST_RATE) {
                break;
            } else {
                System.out.println("Please enter a valid interest rate between 8 and " + MAX_INTEREST_RATE + "%.");
            }
        }
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        // Input validation for period (years)
        byte years = 0;
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >= 5 && years <= 30) {
                break;
            } else {
                System.out.println("Enter any number between 5 and 30.");
            }
        }
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Your monthly mortgage is: " + mortgageFormatted);
    }
}
