package org.example.dao.daoImpl;

import org.example.config.Config;
import org.example.dao.InstructorDao;
import org.example.entityes.Course;
import org.example.entityes.Instructor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class InstructorDaoImpl implements InstructorDao {
    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);
    Scanner scannerLon = new Scanner(System.in);

    @Override
    public void saveInstructor() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Instructor instructor = new Instructor();
            System.out.println("""
                    Save instructor
                    Enter instructor firstName""");
            instructor.setFirstName(scannerStr.nextLine());
            System.out.println("Enter instructor lastName");
            instructor.setLastName(scannerStr.nextLine());
            System.out.println("Enter Instructor email.");
            instructor.setEmail(scannerStr.nextLine());
            System.out.println("Enter Instructor phoneNumber");
            instructor.setPhoneNumber(scannerInt.nextInt());
            entityManager.persist(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully saved instructor");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateInstructor() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    Update instructor
                    Enter instructor Id:""");
            Instructor instructor = entityManager.find(Instructor.class, scannerLon.nextLong());
            System.out.println("""
                    1. firstName
                    2. lastName
                    3. email
                    4. phoneNumber
                    5. all""");

            switch (scannerInt.nextInt()) {
                case 1 -> instructor.setFirstName(scannerStr.nextLine());
                case 2 -> instructor.setLastName(scannerStr.nextLine());
                case 3 -> instructor.setEmail(scannerStr.nextLine());
                case 4 -> instructor.setPhoneNumber(scannerInt.nextInt());
                case 5 -> {
                    System.out.println("firstName:");
                    String firstName = scannerStr.nextLine();
                    System.out.println("lastName:");
                    String lastName = scannerStr.nextLine();
                    System.out.println("email:");
                    String email = scannerStr.nextLine();
                    System.out.println("phoneNumber:");
                    int phoneNumber = scannerInt.nextInt();
                    instructor.setFirstName(firstName);
                    instructor.setLastName(lastName);
                    instructor.setEmail(email);
                    instructor.setPhoneNumber(phoneNumber);
                }
            }
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully update instructor");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Instructor getInstructorById() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    get instructor by id
                    Enter instructor id:""");
            Instructor instructor = entityManager.find(Instructor.class, scannerLon.nextLong());
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully getInstructor");
            System.out.println(instructor);
            return instructor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void getInstructorByCourseId() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("Enter instructor id:");
            Course course = entityManager.find(Course.class, scannerLon.nextLong());
            List<Instructor> queryList = course.getInstructorList();
            entityManager.getTransaction().commit();
            entityManager.close();
            for (Instructor i : queryList) {
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteInstructorById() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    delete instructor by id.
                    Enter instructor id:""");
            Instructor instructor = entityManager.find(Instructor.class, scannerLon.nextLong());
            entityManager.remove(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully deleted instructor");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void assignInstructorToCourse() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    assign instructor to course
                    Enter instructor id:""");
            Instructor instructor = entityManager.find(Instructor.class, scannerLon.nextLong());
            System.out.println("Enter course id:");
            Course course = entityManager.find(Course.class, scannerInt.nextInt());
            instructor.addCourse(course);
            course.addInstructor(instructor);
            entityManager.persist(course);
            entityManager.persist(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully assigned instructor to course");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
