package com.microservicetraining.microservices;

import com.dao.StudentRepository;
import com.dao.TrainingRepository;
import com.entities.Student;
import com.entities.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class MicroservicesApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Stream.of("Java","Python","Oracle").forEach(f -> {
            Training training = new Training();
            training.setName(f);
            trainingRepository.save(training);
        });

        studentRepository.save(new Student( 1L,"Sanssy","Dansso", new Training(1L,null, null)));
        studentRepository.save(new Student( 2L ,"Hachim","Barri", new Training(2L,null, null)));
        studentRepository.save(new Student( 3L ,"Bouchra","Hamid", new Training(3L,null, null)));
        studentRepository.save(new Student( 4L ,"aaaaa","Test", new Training(1L,null, null)));

        trainingRepository.findAll().forEach(f->{
            System.out.println(f.getName());
        });

    }
}
