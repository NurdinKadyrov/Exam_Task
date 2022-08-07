package org.example.service.serviceImpl;


import org.example.dao.TaskDao;
import org.example.dao.daoImpl.TaskDaoImpl;

public class TaskDaoImplSer implements TaskDao {
    TaskDaoImpl taskDao = new TaskDaoImpl();

    @Override
    public void saveTask() {
        taskDao.saveTask();
    }

    @Override
    public void updateTask() {
        taskDao.updateTask();
    }

    @Override
    public void getAllTaskByLessonId() {taskDao.getAllTaskByLessonId();}

    @Override
    public void deleteTaskById() {
        taskDao.deleteTaskById();
    }
}
