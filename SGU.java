package GradeCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//class StudentGradeCalculator
public class SGU 
{   
    // Display menu and return choice
    public static int menu(Scanner sc) 
    {
        System.out.println("****************************");
        System.out.println("\n--- Student Records ---");
        System.out.println("0. EXIT");
        System.out.println("1)Roll numberwise.");
        System.out.println("2)Gradewise.");
        System.out.println("3)Order entered.");
        System.out.println("4)Name numberwise.");
        System.out.print("Enter the choice - ");
        int choice  = sc.nextInt();
        System.out.println("****************************");
        return choice;
    }       

    // Methods receive students list as parameter
    private static void roll(ArrayList<Student> students)
    {
        ArrayList<Student> sortedList = new ArrayList<>(students);
        Collections.sort(sortedList, Comparator.comparingInt(s -> s.getRollNo()));
        System.out.println("Students sorted by Roll Number-");
        for(Student s : sortedList)
        {
            System.out.println(s);
        }
    }

    private static void grade(ArrayList<Student> students)
    {
        ArrayList<Student> sortedList = new ArrayList<>(students);
        Collections.sort(sortedList, Comparator.comparingInt(s -> s.getGrade()));
        System.out.println("Students sorted by Grades-");
        for(Student s : sortedList)
        {
            System.out.println(s);
        }
    }

    private static void seq(ArrayList<Student> students)
    {
        // Print students in original order entered
        System.out.println("Students in order entered:");
        for (Student s : students)
        {
            System.out.println(s);
        }
    }

    private static void name(ArrayList<Student> students)
    {
        ArrayList<Student> sortedList = new ArrayList<>(students);
        Collections.sort(sortedList, Comparator.comparing(s -> s.getName()));
        System.out.println("Students sorted by Names-");
        for(Student s : sortedList)
        {
            System.out.println(s);
        }
    }
    
    public static void main(String[] args) 
    { 
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = Student.acceptRecords(sc);
        int choice;
        while((choice = menu(sc)) != 0)
        {
            switch (choice)
            {
                case 1:
                    roll(students);
                    break;
                case 2:
                    grade(students);
                    break;
                case 3:
                    seq(students);
                    break;
                case 4:
                    name(students);
                    break;   
                default:
                    System.out.println("Wrong choice...");
                    break;
            }
        }

        sc.close();
    }   
}
