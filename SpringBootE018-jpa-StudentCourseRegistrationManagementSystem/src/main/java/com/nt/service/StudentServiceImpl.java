package com.nt.service;

import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository repo;

	StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public void registerStudent(Student stud) {
        repo.save(stud);
        System.out.println("Student Registered Successfully");
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(Long sid) {
        return repo.findById(sid).orElse(null);
    }

    @Override
    public String updateCourse(String courseName, Long sid) {

        Student student = repo.findById(sid).orElse(null);

        if (student != null) {
            student.setCourseName(courseName);
            repo.save(student);
            return "Student Updated Succesfully ...";
        }

        return "Student Not Found!!!!!!!!!!!!!!";
    }

    @Override
    public void deleteStudent(Long sid) {
//        repo.deleteById(sid);
//        System.out.println("Student Deleted Successfully");
    			boolean existsById = repo.existsById(sid);
    			if(existsById) {
    				repo.deleteById(sid);
    				System.out.println("Student Deleted Successfully");
    			}else {
    				System.out.println("ID not Found....");
    			}
    }

    @Override
    public long countStudents() {
        return repo.count();
    }


}