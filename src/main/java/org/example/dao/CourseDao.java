package org.example.dao;

import org.example.entityes.Course;

import java.util.List;

public interface CourseDao {
    void saveCourse();

    Course getCourseById();

    List<Course> getAllCourse();//(датасы боюнча сорттоп чыгаруу

    void updateCourse();

    void deleteCourseById();//курсту очургондо, курска assign болгон инструктор очпошу керек,курсун ичиндеги сабактар очуш керек

    Course getCourseByName();
}
