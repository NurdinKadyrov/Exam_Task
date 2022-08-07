package org.example.dao.daoImpl;

import org.example.config.Config;
import org.example.dao.CourseDao;
import org.example.entityes.Course;
import org.example.entityes.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CourseDaoImpl implements CourseDao {
    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);
    Scanner scannerLon = new Scanner(System.in);

    @Override
    public void saveCourse() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Course course = new Course();
            System.out.println("Save course ^");
            System.out.println("Enter course name:");
            course.setCourseName(scannerStr.nextLine());
            System.out.println("Enter course duration:");
            course.setDuration(scannerStr.nextLine());
            System.out.println("Enter course create at: YYYY-MM-DD");
            course.setCreatAt(LocalDate.of(scannerInt.nextInt(), scannerInt.nextInt(), scannerInt.nextInt()));
            System.out.println("Enter course description:");
            course.setDescription(scannerStr.nextLine());
            System.out.println("Enter course imageLink:");
            course.setImageLink(scannerStr.nextLine());
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully saved course.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Oops, exception save course");
        }
    }

    @Override
    public Course getCourseById() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("Get course by id.");
            System.out.println("Enter course id:");
            Course course = entityManager.find(Course.class, scannerLon.nextLong());
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully get course by id");
            return course;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("Get all courses");
            TypedQuery<Course> queryList = entityManager.createQuery("SELECT c FROM Course c ORDER BY C.creatAt", Course.class);
            List<Course> courseList = queryList.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully get all courses");
            return courseList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateCourse() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("Update course by id.");
            System.out.println("Enter course id:");
            Course course = entityManager.find(Course.class, scannerLon.nextLong());
            System.out.println("""
                    1. name
                    2. duration
                    3. createAt
                    4. imageLink
                    5. description
                    6. all""");
            switch (scannerInt.nextInt()) {
                case 1 -> course.setCourseName(scannerStr.nextLine());
                case 2 -> course.setDuration(scannerStr.nextLine());
                case 3 -> {
                    System.out.println("YYYY-MM-DD");
                    course.setCreatAt(LocalDate.of(scannerInt.nextInt(), scannerInt.nextInt(), scannerInt.nextInt()));
                }
                case 4 -> course.setImageLink(scannerStr.nextLine());
                case 5 -> course.setDescription(scannerStr.nextLine());
                case 6 -> {
                    System.out.println("courseName:");
                    String courseName = scannerStr.nextLine();
                    System.out.println("duration:");
                    String duration = scannerStr.nextLine();
                    System.out.println("createAt:  YYYY-MM-DD");
                    LocalDate createAt = LocalDate.of(scannerInt.nextInt(), scannerInt.nextInt(), scannerInt.nextInt());
                    System.out.println("ImageLink:");
                    String imageLink = scannerStr.nextLine();
                    System.out.println("description:");
                    String description = scannerStr.nextLine();
                    course.setCourseName(courseName);
                    course.setDuration(duration);
                    course.setCreatAt(createAt);
                    course.setImageLink(imageLink);
                    course.setDescription(description);
                }
            }
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully update course.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteCourseById() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    Delete course by id.
                    Enter id:""");
            Course course = entityManager.find(Course.class, scannerLon.nextLong());
            for (Instructor i : course.getInstructorList()) {
                i.setCourseList(null);
            }
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully deleted course");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Course getCourseByName() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    Get course by name.
                    Enter course name:""");
            Course course = entityManager.createQuery("SELECT c FROM Course c WHERE c.courseName =: name ", Course.class)
                    .setParameter("name", scannerStr.nextLine()).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully get course by name");
            return course;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
