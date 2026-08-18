package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Student;
import com.nt.service.StudentServiceImpl;

@Component
public class StudentRunner implements CommandLineRunner {

    @Autowired
    private StudentServiceImpl service;

    @Override
    public void run(String... args) throws Exception {

        while (true) {

            System.out.println("\n===== STUDENT COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search By ID");
            System.out.println("4. Update Course");
            System.out.println("5. Delete Student");
            System.out.println("6. Count Students");
            System.out.println("7. Exit");

            int choice = Integer.parseInt(IO.readln("Enter your choice : "));

            switch (choice) 
            {
            case 1: Student student = new Student();

               // student.setStudentId(Long.parseLong(IO.readln("Enter Student Id : ")));

                student.setStudentName(IO.readln("Enter Student Name : "));

                student.setCourseName(IO.readln("Enter Course Name : "));

                student.setCourseFee(Double.parseDouble(IO.readln("Enter Course Fee : ")));

                student.setInstituteName(IO.readln("Enter Institute Name : "));

                service.registerStudent(student);
                
                break;

            case 2: Iterable<Student> list = service.getAllStudents();

                list.forEach(System.out::println);

            case 3:

                Long searchId = Long.parseLong(IO.readln("Enter Student Id : "));

                Student st = service.getStudentById(searchId);

                if (st != null) {
                    System.out.println(st);
                } else {
                    System.out.println("Student Not Found");
                }

                break;

            case 4:

                Long updateId = Long.parseLong(IO.readln("Enter Student Id : "));

                String newCourse =IO.readln("Enter New Course Name : ");

                System.out.println(service.updateCourse(newCourse, updateId));

                break;

            case 5:

                Long deleteId = Long.parseLong(IO.readln("Enter Student Id : "));

                service.deleteStudent(deleteId);

                break;

            case 6: System.out.println( "Total Students : " + service.countStudents());

                		break;

            case 7:System.out.println("Application Closed Successfully");
                		System.exit(0);

            default: System.out.println("Invalid Choice");
            		//System.exit(0);
            }
        }
    }
}