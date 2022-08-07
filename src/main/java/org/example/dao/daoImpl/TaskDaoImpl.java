package org.example.dao.daoImpl;

import org.example.config.Config;
import org.example.dao.TaskDao;
import org.example.entityes.Lesson;
import org.example.entityes.Task;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Scanner;

public class TaskDaoImpl implements TaskDao {
    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);
    Scanner scannerLon = new Scanner(System.in);

    @Override
    public void saveTask() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    save task
                    Enter lesson id for save task:""");
            Lesson lesson = entityManager.find(Lesson.class, scannerLon.nextLong());
            Task task = new Task();
            System.out.println("Enter task name:");
            task.setTaskName(scannerStr.nextLine());
            System.out.println("Enter deadline task: YYYY-MM-DD");
            task.setDeadline(LocalDate.of(scannerInt.nextInt(), scannerInt.nextInt(), scannerInt.nextInt()));
            System.out.println("Enter text task:");
            task.setTask(scannerStr.nextLine());
            lesson.addTask(task);
            task.setLesson(lesson);
            entityManager.persist(lesson);
            entityManager.persist(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully saved task");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTask() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    update task
                    Enter task id:""");
            Task task = entityManager.find(Task.class, scannerLon.nextLong());
            System.out.println("""
                    1. task name
                    2. deadline task
                    3. text task
                    4. all""");
            switch (scannerInt.nextInt()) {
                case 1 -> task.setTaskName(scannerStr.nextLine());
                case 2 -> {
                    System.out.println("deadline : YYYY-MM-DD");
                    task.setDeadline(LocalDate.of(scannerInt.nextInt(), scannerInt.nextInt(), scannerInt.nextInt()));
                }
                case 3 -> task.setTask(scannerStr.nextLine());
                case 4 -> {
                    System.out.println("task name:");
                    task.setTaskName(scannerStr.nextLine());
                    System.out.println("task deadline : YYYY-MM-DD");
                    task.setDeadline(LocalDate.of(scannerInt.nextInt(), scannerInt.nextInt(), scannerInt.nextInt()));
                    System.out.println("task text:");
                    task.setTask(scannerStr.nextLine());
                }
            }
            entityManager.persist(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully updated task");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAllTaskByLessonId() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    get all task by lesson id
                    Enter lesson id:""");
            Lesson lesson = entityManager.find(Lesson.class, scannerLon.nextLong());
            for (Task task : lesson.getTaskList()) {
                System.out.println(task);
            }
            System.out.println("Successfully get all task");
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteTaskById() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println("""
                    delete task by id
                    Enter task id:""");
            Task task = entityManager.find(Task.class, scannerLon.nextLong());
            entityManager.remove(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Successfully deleted task");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}