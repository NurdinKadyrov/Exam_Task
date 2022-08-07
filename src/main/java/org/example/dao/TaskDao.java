package org.example.dao;

public interface TaskDao {
    void saveTask();

    void updateTask();

    void getAllTaskByLessonId();

    void deleteTaskById();
}
