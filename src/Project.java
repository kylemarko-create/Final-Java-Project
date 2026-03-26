//To further strengthen your work, consider initializing the Scanner once outside the loop to improve efficiency, adding input validation to prevent invalid entries, and avoiding hardcoded values (e.g., using grades.length instead of 10) to enhance scalability. Overall, this is a well-structured and functional solution that reflects good programming fundamentals and thoughtful problem-solving.

// Write a program that will provide important statistics for the grades in a class. The program will utilize a for-loop to read ten floating-point grades from user input. Include code to prevent an endless loop. Ask the user to enter the values, then print the following data:

// Average
// Maximum
// Minimum
// Compile and submit your pseudocode, source code, and screenshots of the application executing the application, the results and GIT repository in a single document.

import java.util.Arrays;
import java.util.Scanner;

public class Project {

    public static void main(String[] args) {

        Double[] grades = new
        Double[10];

        Scanner gradeInput = new Scanner(System.in);

        for (int x = 0; x < grades.length; x++) {
            System.out.println("Enter an assignment grade:");
            while (!gradeInput.hasNextDouble()) {
                System.out.println("Error, please input something valid.");
                gradeInput.next(); // clears the invalid input
            }
            Double grade = gradeInput.nextDouble();
            grades[x] = grade;
        }


        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        double average = 0;
        average = sum / 10;
        System.out.println("Average:" + average);

        double max = 0;
        max = Arrays.stream(grades).max(Double::compare).get();
        System.out.println("Max:" + max);

        double min = 0;
        min = Arrays.stream(grades).min(Double::compare).get();
        System.out.println("Min:" + min);

    }
}
