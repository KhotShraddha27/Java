package GradeCalculator;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Student {
    private String name;
    private int rollNo;
    private int[] marks;

    public Student() { }

    public Student(String name, int rollNo,  int numSub) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = new int[numSub];
    }

    public void setMarks(int subjectIndex, int mark) {
        marks[subjectIndex] = mark;
    }

    public int getTotalMarks() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }

    public double getAveragePercentage() {
        return (double) getTotalMarks() / marks.length;
    }

    public char getGrade() {
        double avg = getAveragePercentage();
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else if (avg >= 50) return 'E';
        else return 'F';
    }

    public String getName() {
        return name;
    }
    
    public int getRollNo() {
        return rollNo;
    }

    public int getNumSubjects() {
        return marks.length;
    }
    
    // Static method to accept multiple student records and print them
    public static ArrayList<Student> acceptRecords(Scanner sc) {
        System.out.print("Enter the number of students: ");
        int numStu = sc.nextInt();
        sc.nextLine();  // consume newline
        
        ArrayList<Student> students = new ArrayList<>();

        for(int i = 0; i < numStu; i++) {
            System.out.println("\nEnter details for student " + (i+1) + ":");
            
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            while(name.matches("\\d+"))
            {
            		System.out.println("Invalid name!!Please enter valis name...");
            		System.out.print("Enter student name: ");
                 name = sc.nextLine();
            }

            System.out.print("Enter student roll number: ");
            int rollNo = sc.nextInt();

            System.out.print("Enter the number of subjects: ");
            int numSub = sc.nextInt();

            Student student = new Student(name, rollNo, numSub);

            for (int j = 0; j < numSub; j++) {
                int mark;
                do {
                    System.out.print("Enter marks for subject " + (j+1) + " (0-100): ");
                    mark = sc.nextInt();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Invalid marks! Please enter between 0 and 100.");
                    }
                } while (mark < 0 || mark > 100);
                
                student.setMarks(j, mark);
            }
            sc.nextLine(); // consume newline

            students.add(student);
        }return students;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo 
            + ", marks=" + Arrays.toString(marks) 
            + ", Total Marks=" + getTotalMarks() 
            + ", Average=" + String.format("%.2f", getAveragePercentage()) 
            + "%, Grade=" + getGrade() + "]";
    }
}
 