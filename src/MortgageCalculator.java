import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
public class MortgageCalculator {
    public static void main(String[] args){
        //declaring constants
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        //defining the Scanner class
        Scanner scanner = new Scanner(System.in);

        int principal;
        float annualInterest;
        float monthlyInterest;
        byte years;
        int noOfPayments;


        //taking input for principal amount
        do {
            System.out.print("Principal ($1K - $1M) : ");
            principal = scanner.nextInt();//short is not enough
            if(principal<1_000 || principal>1_000_000)
            {
                System.out.println("Enter a number between 1,000 and 1,000,000");
                continue;
            }
            break;
        }while(true);


        //taking input of the annual interest rate
        do {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();//double will be too much
            if (annualInterest<=0 || annualInterest>30){
                System.out.println("Enter a value greater than zero and less than or equal to 30");
                continue;
            }
            monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
            break;
        }while(true);


        //taking input for period(years)
        do {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();//byte is sufficient
            if (years<1 || years>30){
                System.out.println("Enter a value between 1 and 30");
                continue;
            }
            noOfPayments = years * MONTHS_IN_YEAR;
            break;
        }while(true);


        //calculated mortgage value and displaying it
        double mortgage = principal
                * (monthlyInterest*(Math.pow(1+monthlyInterest, noOfPayments)))
                /((Math.pow(1+monthlyInterest, noOfPayments))-1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}


