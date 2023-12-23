import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        String[] subjectNames = new String[numSubjects];
        double[] subjectMarks = new double[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter the name of Subject"+(i+1)+": ");
            subjectNames[i] = scanner.next();
            System.out.print("Enter marks for " + subjectNames[i]+": ");
            subjectMarks[i] = scanner.nextDouble();
        }

        scanner.close();

        double totalMarks = calculateTotalMarks(subjectMarks);
        double percentage = calculatePercentage(totalMarks, numSubjects);
        char grade = calculateGrade(percentage);
        displayResult(subjectNames, subjectMarks, totalMarks, percentage, grade);
    }

    private static double calculateTotalMarks(double[] subjectMarks) {
        double totalMarks=0;
        for (double marks:subjectMarks) {
            totalMarks+=marks;
        }
        return totalMarks;
    }

    private static double calculatePercentage(double totalMarks, int numSubjects) {
        // Assuming each subject has a maximum of 100 marks
        double maxMarksPerSubject=100.0;
        double totalMaxMarks=maxMarksPerSubject*numSubjects;
        return (totalMarks/totalMaxMarks)*100.0;
    }

    private static char calculateGrade(double percentage) {
        if (percentage>=90) {
            return 'A';
        } else if (percentage>=80) {
            return 'B';
        } else if (percentage>=70) {
            return 'C';
        } else if (percentage>=60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    private static void displayResult(String[] subjectNames, double[] subjectMarks, double totalMarks, double percentage, char grade) {
        System.out.println("Subject-wise Marks:");
        for (int i = 0; i < subjectNames.length; i++) {
            System.out.println(subjectNames[i] + ": " + subjectMarks[i]);
        }

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Total Percentage: " + percentage + "%");
        System.out.println("The grade is: " + grade);
    }
}
