package com.example.homeworkmodule15;


import com.example.homeworkmodule15.entity.Note;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Homeworkmodule16Application {

    public static void main(String[] args) {
        SpringApplication.run(Homeworkmodule16Application.class, args);
    }

    @Bean
    CommandLineRunner run(NoteService noteService) {
        return args -> {
            Note note = new Note();
            note.setTitle("First note");
            note.setContent("This is a test note");

            noteService.add(note);

            System.out.println("Saved: " + note.getId());
            System.out.println("All notes:");
            noteService.listAll().forEach(n -> System.out.println(n.getTitle()));
            noteService.listAll().forEach(n -> System.out.println(n.getContent()));
        };
    }
}