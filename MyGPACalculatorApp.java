package MyGPACalculator;

import java.util.Scanner;

public class MyGPACalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        // Welcome messages and prompt to enter number of courses
        System.out.println("Hello! Welcome to MyGPACalculator, Lets Calculate your GPA...");


        System.out.print("Kindly enter the number of your courses: ");
        int numberOfCourses = scanner.nextInt();

        // This Array will store Course objects
        MyCourse[] courses = new MyCourse[numberOfCourses];

        // Course details will be inputted here
        
        for (int i = 0; i < numberOfCourses; i++) {
            System.out.println("\nEnter details for Course " + (i + 1) + ":");
            scanner.nextLine(); // Consume newline
            System.out.print("Course Name: ");
            String myCourseName = scanner.nextLine();
            System.out.print("Course Code: ");
            String myCourseCode = scanner.nextLine();
            System.out.print("Course Unit: ");
            int myCourseUnit = scanner.nextInt();
            System.out.print("Course Score: ");
            int myCourseScore = scanner.nextInt();

            // Created a Course object and added it to the array
            courses[i] = new MyCourse(myCourseName, myCourseCode, myCourseUnit, myCourseScore);
        }

        // Time to Calculate total grade points and total units
        int totalGradePoints = 0;
        int totalUnits = 0;

        for (MyCourse course : courses) {
            totalGradePoints += course.calculateGradePoint() * course.getCourseUnit();
            totalUnits += course.getCourseUnit();
        }

        // Calculating GPA...
        double mygpa = (double) totalGradePoints / totalUnits;

        // Display the result in a tabular form
        System.out.println("\nResult:");
        printTableLine();
        System.out.printf("| %-34s | %-14s | %-14s | %-14s |\n", "Course Name & Code", "Course Unit", "Grade", "Grade Unit");
        printTableLine();

        for (MyCourse course : courses) {
            System.out.printf("| %-34s | %-14d | %-14s | %-14d |\n", getCombinedNameAndCode(course.getCourseName(), course.getCourseCode()), course.getCourseUnit(),  course.calculateGrade(), course.calculateGradeUnit());
        }

        printTableLine();
        System.out.println();

        // Printing GPA message, calculated to 2 decimal places
        System.out.printf("Your GPA is = %.2f\n", mygpa);

        // Close the scanner
        scanner.close();
    }

    // This Helper method, will help to print horizontal lines for the table
    private static void printTableLine() {
        System.out.println("+------------------------------------+----------------+----------------+----------------+");
    }

    // Since we took our inputs invidually, let's use Helper method to merge name and code
    private static String getCombinedNameAndCode(String name, String code) {
        return name + " " + code;
    }
}
