package org.example.service.serviceImpl;

import org.example.dao.CourseDao;
import org.example.dao.daoImpl.CourseDaoImpl;
import org.example.entityes.Course;

import java.util.List;

public class CourseDaoImplSer implements CourseDao {
    CourseDaoImpl courseDao = new CourseDaoImpl();

    @Override
    public void saveCourse() {
        courseDao.saveCourse();
    }

    @Override
    public Course getCourseById() {
        return courseDao.getCourseById();
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public void updateCourse() {
        courseDao.updateCourse();
    }

    @Override
    public void deleteCourseById() {
        courseDao.deleteCourseById();
    }

    @Override
    public Course getCourseByName() {
        return courseDao.getCourseByName();
    }
}
