package com.example.studentManagement.entity;




import javax.persistence.Entity;
import javax.persistence.Id;



@Entity

public class Student {
    @Id
    private int studentId;
    private String studentname;
    private String address;
    private String city;
    private double cgpa;
    private double course_Fees;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public double getCourse_Fees() {
        return course_Fees;
    }

    public void setCourse_Fees(double course_Fees) {
        this.course_Fees = course_Fees;
    }

    @Override
    public String toString() {
        // Table Header
        StringBuilder table = new StringBuilder();
        table.append("+------------+----------------------+-------------------------------+-----------------+--------+-------------+\n");
        table.append("| StudentId | Student Name        | Address                        | City           | CGPA   | Course Fees |\n");
        table.append("+------------+----------------------+-------------------------------+-----------------+--------+-------------+\n");

        // Student Data Row
        table.append(String.format("| %-10d | %-20s | %-30s | %-15s | %-6.2f | %-10.2f |\n",
                studentId, studentname, address, city, cgpa, course_Fees));

        // Table Footer
        table.append("+------------+----------------------+-------------------------------+-----------------+--------+-------------+\n");

        return table.toString();
    }


}
