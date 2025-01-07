package com.student.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    private int studentId;

    private String studentname;
    private String address;
    private String city;
    private double cgpa;

    @Column(name = "course_fees")
    private double courseFees;

    // Getters and Setters

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

    public double getCourseFees() {
        return courseFees;
    }

    public void setCourseFees(double courseFees) {
        this.courseFees = courseFees;
    }

    public void setStudentName(String s) {
        this.studentname = s;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("+------------------+-----------------------+\n");
        sb.append("| Field            | Value                 |\n");
        sb.append("+------------------+-----------------------+\n");

        // Formatting each field and value in a table format
        sb.append(String.format("| %-16s | %-21d |\n", "studentId", studentId));
        sb.append(String.format("| %-16s | '%-21s' |\n", "studentname", studentname));
        sb.append(String.format("| %-16s | '%-21s' |\n", "address", address));
        sb.append(String.format("| %-16s | '%-21s' |\n", "city", city));
        sb.append(String.format("| %-16s | %-21.2f |\n", "cgpa", cgpa));
        sb.append(String.format("| %-16s | %-21.2f |\n", "courseFees", courseFees));

        sb.append("+------------------+-----------------------+\n");

        return sb.toString();
    }




}
