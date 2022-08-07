package org.example.service.serviceImpl;

import org.example.dao.LessonDao;
import org.example.dao.daoImpl.LessonDaoImpl;
import org.example.entityes.Lesson;

public class LessonDaoImplSer implements LessonDao {
    LessonDaoImpl lessonDao = new LessonDaoImpl();

    @Override
    public void saveLesson() {
        lessonDao.saveLesson();
    }

    @Override
    public void updateLesson() {
        lessonDao.updateLesson();
    }

    @Override
    public Lesson getLessonById() {
        return lessonDao.getLessonById();
    }

    @Override
    public void getLessonByCourseId() {
        lessonDao.getLessonByCourseId();
    }
}
