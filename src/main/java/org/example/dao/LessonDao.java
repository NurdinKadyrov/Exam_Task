package org.example.dao;

import org.example.entityes.Lesson;

public interface LessonDao {
    void saveLesson();//Lesson сакталып жатканда кандайдыр бир курска сакталуусу керек

    void updateLesson();

    Lesson getLessonById();

    void getLessonByCourseId();//курска тиешелуу сабактарды чыгаруу
}
