package org.example.service;

import org.example.service.serviceImpl.CourseDaoImplSer;
import org.example.service.serviceImpl.InstructorDaoImplSer;
import org.example.service.serviceImpl.LessonDaoImplSer;
import org.example.service.serviceImpl.TaskDaoImplSer;

import java.util.Scanner;

public class Service {
    public static void service() {
        CourseDaoImplSer course = new CourseDaoImplSer();
        InstructorDaoImplSer instructor = new InstructorDaoImplSer();
        LessonDaoImplSer lesson = new LessonDaoImplSer();
        TaskDaoImplSer task = new TaskDaoImplSer();
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        do {
            System.out.println("""
                    0. End loop
                    1. Course
                    2. Instructor
                    3. Lesson
                    4. Task""");
            number = scanner.nextInt();
            switch (number) {
                case 1 -> {
                    System.out.println("""
                            1. save course
                            2. getCourseById
                            3. getAllCourse
                            4. updateCourse
                            5. deleteCourseById
                            6. getCourseByName""");
                    switch (scanner.nextInt()) {
                        case 1 -> course.saveCourse();
                        case 2 -> course.getCourseById();
                        case 3 -> course.getAllCourse();
                        case 4 -> course.updateCourse();
                        case 5 -> course.deleteCourseById();
                        case 6 -> course.getCourseByName();
                    }
                }
                case 2 -> {
                    System.out.println("""
                            1. saveInstructor
                            2. updateInstructor
                            3. getInstructorById
                            4. getInstructorByCourseId
                            5. deleteInstructorById
                            6. assignInstructorToCourse""");
                    switch (scanner.nextInt()) {
                        case 1 -> instructor.saveInstructor();
                        case 2 -> instructor.updateInstructor();
                        case 3 -> instructor.getInstructorById();
                        case 4 -> instructor.getInstructorByCourseId();
                        case 5 -> instructor.deleteInstructorById();
                        case 6 -> instructor.assignInstructorToCourse();
                    }
                }
                case 3 -> {
                    System.out.println("""
                            1. saveLesson
                            2. updateLesson
                            3. getLessonByID
                            4. getLessonByCourseId""");
                    switch (scanner.nextInt()) {
                        case 1 -> lesson.saveLesson();
                        case 2 -> lesson.updateLesson();
                        case 3 -> lesson.getLessonById();
                        case 4 -> lesson.getLessonByCourseId();
                    }
                }
                case 4 -> {
                    System.out.println("""
                            1. saveTask
                            2. updateTask
                            3. getAllTaskByLessonId
                            4. deleteTaskById""");
                    switch (scanner.nextInt()) {
                        case 1 -> task.saveTask();
                        case 2 -> task.updateTask();
                        case 3 -> task.getAllTaskByLessonId();
                        case 4 -> task.deleteTaskById();
                    }
                }
            }
        } while (number != 0);
    }
}
