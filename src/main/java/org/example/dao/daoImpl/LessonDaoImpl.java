package org.example.dao.daoImpl;

import org.example.config.Config;
import org.example.dao.LessonDao;
import org.example.entityes.Course;
import org.example.entityes.Lesson;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class LessonDaoImpl implements LessonDao {
    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);
    Scanner scannerLon = new Scanner(System.in);

    @Override
    public void saveLesson() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    save lesson
                    Enter course id for save lesson:""");
            Lesson lesson = new Lesson();
            Course course = entityManager.find(Course.class, scannerLon.nextLong());
            System.out.println("Enter lesson name");
            lesson.setLessonName(scannerStr.nextLine());
            System.out.println("Enter lesson videoLink");
            lesson.setVideoLink(scannerStr.nextLine());
            lesson.setCourse(course);
            entityManager.persist(lesson);
            entityManager.getTransaction().commit();
            System.out.println("Successfully saved lesson");
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateLesson() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    update lesson
                    Enter lesson id:""");
            Lesson lesson = entityManager.find(Lesson.class, scannerLon.nextLong());
            System.out.println("""
                    1. lesson name
                    2. lesson videoLink
                    3. all""");
            switch (scannerInt.nextInt()) {
                case 1 -> lesson.setLessonName(scannerStr.nextLine());
                case 2 -> lesson.setVideoLink(scannerStr.nextLine());
                case 3 -> {
                    System.out.println("lesson name:");
                    lesson.setLessonName(scannerStr.nextLine());
                    System.out.println("lesson videoLink:");
                    lesson.setVideoLink(scannerStr.nextLine());
                }
            }
            entityManager.persist(lesson);
            entityManager.getTransaction().commit();
            System.out.println("Successfully update lesson");
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Lesson getLessonById() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    get lesson by id
                    Enter lesson id:""");
            Lesson lesson = entityManager.find(Lesson.class, scannerLon.nextLong());
            entityManager.getTransaction().commit();
            System.out.println(lesson);
            entityManager.close();
            return lesson;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void getLessonByCourseId() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    get lesson by course id
                    Enter course id:""");
            Course course = entityManager.find(Course.class, scannerLon.nextLong());
            List<Lesson> lessonList = course.getLessonList();
            entityManager.getTransaction().commit();
            for (Lesson lesson : lessonList) {
                System.out.println(lesson);
                System.out.println("Successfully get lesson by course id");
            }
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
