import java.util.ArrayList;
import java.util.Scanner;

class Student {

    private String studentId;
    private String studentName;
    private double grade;

    private static int idCounter = 1;

    
    public Student(String studentName, double grade) {
        this.studentId = "STU" + (idCounter++);
        this.studentName = studentName;
        this.grade = grade;
    }

    
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getGrade() {
        return grade;
    }

    
    public void displayStudent() {
        System.out.println("ID    : " + studentId);
        System.out.println("Name  : " + studentName);
        System.out.println("Grade : " + grade);
        System.out.println("--------------------------");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        System.out.print("Enter number of students registering: ");
        int count = sc.nextInt();
        sc.nextLine(); 

        for (int i = 1; i <= count; i++) {

            System.out.println("\nEnter details for Student " + i);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Grade: ");
            double grade = sc.nextDouble();
            sc.nextLine(); 

            Student student = new Student(name, grade);
            studentList.add(student);
        }

       
        System.out.println("\n All Registered Students");
        for (Student s : studentList) {
            s.displayStudent();
        }

        
        System.out.println("\nStudents Eligible for Appreciation (Grade > 8) ");
        int eligibleCount = 0;

        for (Student s : studentList) {
            if (s.getGrade() > 8) {
                s.displayStudent();
                eligibleCount++;
            }
        }

        System.out.println("Total Eligible Students: " + eligibleCount);

        sc.close();
    }
}

