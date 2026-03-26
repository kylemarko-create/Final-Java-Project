// There is one key area for improvement in your control flow. In your Java code, the final condition (if (income >= 2500)) is not part of the else if chain. Because of this, it will still be evaluated even if a previous condition has already been met. While it may not always cause incorrect results due to the mutually exclusive ranges, it is best practice to keep all mutually exclusive conditions within a single if → else if → else structure. This ensures clarity and prevents potential logical errors as programs become more complex.

// Additionally, you could slightly improve readability and maintainability by:

// Using double instead of Double unless object behavior is needed

// Adding comments to explain each tax bracket

// Formatting output for clarity (e.g., including spacing or currency formatting)

import java.util.Scanner; 

public class incomeTaxCalc {
    public static void main(String[] args) {
        Scanner incomeInput = new Scanner(System.in);
        System.out.println("Enter your weekly income");

        if (incomeInput.hasNextDouble()) {
            Double income = incomeInput.nextDouble();
            Double tax = 0.00;
            
            if (income <= 500){
                tax = income * 0.1;
            }

            else if (income >= 500 && income < 1500){
                tax = 100 + (income - 500) * 0.15;
            }

            else if (income >= 1500 && income < 2500){
                tax = 100 + 150 + (income - 1500) * 0.2;
            }

            if (income >= 2500){
                tax = 100 + 150 + 200 + (income - 2500) * 0.3;
            }

            System.out.println("Your tax deduction is:" + tax);
        }

        else {
            System.out.println("Invalid Input, please input a number.");
        }
    }
}