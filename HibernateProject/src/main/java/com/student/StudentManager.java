package com.student;

import com.student.dao.HibernateUtil;
import com.student.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Scanner;

public class StudentManager {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n---------------------------------Menu:---------------------------------");
            System.out.println("1) Add Student");
            System.out.println("2) Get Student");
            System.out.println("3) Update Student");
            System.out.println("4) Delete Student");
            System.out.println("5) Exit");
            System.out.print("###### Enter your choice: ######");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    getStudentMenu();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    HibernateUtil.closeSessionFactory();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addStudent() {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = new Student();
            System.out.print("Enter Student ID: ");
            student.setStudentId(scanner.nextInt());
            scanner.nextLine(); // consume newline
            System.out.print("Enter Student Name: ");
            student.setStudentName(scanner.nextLine());
            System.out.print("Enter Address: ");
            student.setAddress(scanner.nextLine());
            System.out.print("Enter City: ");
            student.setCity(scanner.nextLine());
            System.out.print("Enter CGPA: ");
            student.setCgpa(scanner.nextDouble());
            System.out.print("Enter Course Fees: ");
            student.setCourseFees(scanner.nextDouble());

            session.save(student);
            transaction.commit();
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getStudentMenu() {
        System.out.println("1) Get All Students");
        System.out.println("2) Get Student by ID");
        System.out.println("3) Get Students by City and CGPA");
        System.out.print("Enter your choice: ");
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
                System.out.println("Invalid choice");
        }
    }

    private static void getAllStudents() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Student> query = session.createQuery("FROM Student", Student.class);
            List<Student> students = query.getResultList();
            students.forEach(student -> System.out.println(student));
        }
    }

    private static void getStudentById() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        try (Session session = HibernateUtil.getSession()) {
            Student student = session.get(Student.class, id);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("Student not found!");
            }
        }
    }

    private static void getStudentsByCityAndCGPA() {
        System.out.print("Enter City: ");
        String city = scanner.next();
        System.out.print("Enter CGPA: ");
        double cgpa = scanner.nextDouble();

        try (Session session = HibernateUtil.getSession()) {
            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("city", city));
            criteria.add(Restrictions.gt("cgpa", cgpa));
            List<Student> students = criteria.list();
            students.forEach(student -> System.out.println(student));
        }
    }

    private static void updateStudent() {
        // Prompt user for student ID and the field to update
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter field to update (cgpa/fees): ");
        String fieldToUpdate = scanner.next();

        try (Session session = HibernateUtil.getSession()) {
            // Fetch student by ID
            Student student = session.get(Student.class, studentId);

            // Check if the student exists
            if (student == null) {
                System.out.println("Student not found.");
                return;
            }

            // Depending on which field the user wants to update, handle accordingly
            switch (fieldToUpdate.toLowerCase()) {
                case "cgpa":
                    System.out.print("Enter new CGPA: ");
                    double newCgpa = scanner.nextDouble();
                    student.setCgpa(newCgpa);
                    System.out.println("CGPA updated to " + newCgpa);
                    break;

                case "fees":
                    System.out.print("Enter new fees: ");
                    double newFees = scanner.nextDouble();
                    student.setCourseFees(newFees);
                    System.out.println("Fees updated to " + newFees);
                    break;

                default:
                    System.out.println("Invalid field selected. Please choose either 'cgpa' or 'fees'.");
                    return;
            }

            // Start a transaction to save the updated student
            Transaction transaction = session.beginTransaction();
            session.update(student);  // Save the updated student
            transaction.commit();  // Commit the transaction

            System.out.println("Student updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while updating the student.");
        }
    }


    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                transaction.commit();
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }
        }
    }
}
