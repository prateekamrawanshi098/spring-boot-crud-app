package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication

public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }
        @Bean
        public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
            return runner -> {
                createStudent(studentDAO);

                //createMultipleStudents(studentDAO);

                //readStudents(studentDAO);

               // queryForStudents(studentDAO);

               //queryForStudentsByLastName(studentDAO);

                //updateStudent(studentDAO);

                //deleteStudent(studentDAO);

                //deleteAllStudent(studentDAO);
            };
        }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("deleting all students from table ");
        System.out.println("No. of rows deletd "+studentDAO.deleteAll());
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int id=3;
        System.out.println("Deleting student with id "+id);
        studentDAO.delete(id);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrive student based on id:primary key
        int theId=1;
        System.out.println("retriving the by id: "+theId);
        Student myStudent=studentDAO.findById(theId);

        //change first name to scooby
        System.out.println("updatin the student ....");
        myStudent.setFirstName("Scooby");

        //update student
        studentDAO.update(myStudent);

        //display updated studnet
        System.out.println("updated student : "+myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        //get a list of students
        List<Student>theStudent=studentDAO.findByLastName("malkova");

        //display students
        for (Student s:theStudent){
            System.out.println(s);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        //get a list of students

        List<Student>theStudent=studentDAO.findAll();


        //display list of students
        for(Student s:theStudent){
            System.out.println(s);
        }

    }

    private void readStudents(StudentDAO studentDAO){

           // create the student object
            System.out.println("Creating new student object");
            Student tempStudent4=new Student("kisan","kanna","kissankanna@gmail.com");

            //save the student
            System.out.println("Saving the student");
            studentDAO.save(tempStudent4);
            //display id of saved student
            int theID=tempStudent4.getId();
            System.out.println("Id : "+theID);
            //retrive student based on id : Primary key
            System.out.println("Retriving student with the id...");
            Student myStudent=studentDAO.findById(theID);
            //display student
            System.out.println(myStudent);
        }

        private void createMultipleStudents(StudentDAO studentDAO){
            // create multiple students
            System.out.println("Creating 3 students object...");
            Student tempStudent1=new Student("John","Saur","JohnSuer@gmail.com");
            Student tempStudent2=new Student("angella","white","angellawhite@gmail.com");
            Student tempStudent3=new Student("Mia","malkova","miamalkova@gmail.com");

            //save the students object
            System.out.println("Saving the students");
            studentDAO.save(tempStudent1);
            studentDAO.save(tempStudent2);
            studentDAO.save(tempStudent3);
        }

    private void createStudent(StudentDAO studentDAO) {

        //create the student object
        System.out.println("Creating new student object...");
        Student tempStudent=new Student("Paul","Doe","pauldoe@gmail.com");


        //save the student object
        System.out.println("Saving the students...");
        studentDAO.save(tempStudent);


        //display id of the saved student
        System.out.println("Saved student generated id "+tempStudent.getId());
    }

}

