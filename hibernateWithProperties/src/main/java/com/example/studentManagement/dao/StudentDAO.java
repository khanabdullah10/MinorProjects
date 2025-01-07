package com.example.studentManagement.dao;

import com.example.studentManagement.entity.Student;
import com.example.studentManagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class StudentDAO {
    private SessionFactory factory;

    public StudentDAO() {
        this.factory = HibernateUtil.getFactory();
    }

    // Add student
    public void addStudent(Student student) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get all students
    public List<Student> getAllStudents() {
        try (Session session = factory.openSession()) {
            Query<Student> query = session.createQuery("FROM Student", Student.class);
            return query.getResultList();
        }
    }

    // Get student by ID
    public Student getStudentById(int studentId) {
        try (Session session = factory.openSession()) {
            return session.get(Student.class, studentId);
        }
    }

    // Get students by city and CGPA
    public List<Student> getStudentsByCityAndCGPA(String city, double cgpa) {
        try (Session session = factory.openSession()) {
            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("city", city));
            criteria.add(Restrictions.gt("cgpa", cgpa));
            return criteria.list();
        }
    }

    // Update student
    public void updateStudent(Student student) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete student
    public void deleteStudent(int studentId) {
        try (Session session = factory.openSession()) {
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                Transaction transaction = session.beginTransaction();
                session.delete(student);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
