package org.example.dao;

import org.example.entityes.Instructor;

public interface InstructorDao {
    void saveInstructor();

    void updateInstructor();

    Instructor getInstructorById();

    void getInstructorByCourseId();//тиешелуу курстун инструкторлорун чыгарып беруу

    void deleteInstructorById();//инструктор очкондо, инструкторго тиешелуу курс очпошу керек

    void assignInstructorToCourse();//инструкторду курска кошуп коюу(назначить)
}
