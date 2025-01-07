package com.example.studentManagement;

import com.example.studentManagement.dao.StudentDAO;
import com.example.studentManagement.entity.Student;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    private static StudentDAO studentDAO = new StudentDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("-------------------------Menu:-------------------------");
            System.out.println("1) Add Student");
            System.out.println("2) Get Student");
            System.out.println("3) Update Student");
            System.out.println("4) Delete Student");
            System.out.println("0) Exit");
            System.out.println("######### Enter your choice ######### ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    getStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 0:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void addStudent() {
        System.out.println("Enter student ID:");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter student name:");
        String studentname = scanner.nextLine();

        System.out.println("Enter address:");
        String address = scanner.nextLine();

        System.out.println("Enter city:");
        String city = scanner.nextLine();

        System.out.println("Enter CGPA:");
        double cgpa = scanner.nextDouble();

        System.out.println("Enter course fees:");
        double courseFees = scanner.nextDouble();

        Student student = new Student();
        student.setStudentId(studentId);
        student.setStudentname(studentname);
        student.setAddress(address);
        student.setCity(city);
        student.setCgpa(cgpa);
        student.setCourse_Fees(courseFees);

        studentDAO.addStudent(student);
        System.out.println("Student added successfully!");
    }

    public static void getStudent() {
        System.out.println("======================= Choose option: =======================");
        System.out.println("1) Get all students");
        System.out.println("2) Get by ID");
        System.out.println("3) Get based on city and CGPA");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                getAllStudents();
                break;
            case 2:
                getStudentById();
                break;
            case 3:
                getStudentsByCityAndCGPA();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void getAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        students.forEach(student -> System.out.println(student));
    }

    public static void getStudentById() {
        System.out.println("Enter student ID:");
        int studentId = scanner.nextInt();

        Student student = studentDAO.getStudentById(studentId);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("No student found with ID " + studentId);
        }
    }

    public static void getStudentsByCityAndCGPA() {
        System.out.println("Enter city:");
        String city = scanner.next();

        System.out.println("Enter minimum CGPA:");
        double cgpa = scanner.nextDouble();

        List<Student> students = studentDAO.getStudentsByCityAndCGPA(city, cgpa);
        students.forEach(student -> System.out.println(student));
    }

    public static void updateStudent() {
        System.out.println("Enter student ID to update:");
        int studentId = scanner.nextInt();

        Student student = studentDAO.getStudentById(studentId);
        if (student != null) {
            // Simulate updating course fees based on CGPA condition
            if (student.getCgpa() > 7.0) {
                student.setCourse_Fees(student.getCourse_Fees() * 0.9); // Reduce fees by 10%
            }
            studentDAO.updateStudent(student);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public static void deleteStudent() {
        System.out.println("Enter student ID to delete:");
        int studentId = scanner.nextInt();

        studentDAO.deleteStudent(studentId);
        System.out.println("Student deleted successfully!");
    }
}
