package org.example.service.serviceImpl;

import org.example.dao.InstructorDao;
import org.example.dao.daoImpl.InstructorDaoImpl;
import org.example.entityes.Instructor;

public class InstructorDaoImplSer implements InstructorDao {
    InstructorDaoImpl instructorDao = new InstructorDaoImpl();

    @Override
    public void saveInstructor() {
        instructorDao.saveInstructor();
    }

    @Override
    public void updateInstructor() {
        instructorDao.updateInstructor();
    }

    @Override
    public Instructor getInstructorById() {
        return instructorDao.getInstructorById();
    }

    @Override
    public void getInstructorByCourseId() {
        instructorDao.getInstructorByCourseId();
    }

    @Override
    public void deleteInstructorById() {
        instructorDao.deleteInstructorById();
    }

    @Override
    public void assignInstructorToCourse() {
        instructorDao.assignInstructorToCourse();
    }
}
