package com.example.homeworkmodule15;

import com.example.homeworkmodule15.entity.Note;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Homeworkmodule15Application {

	public static void main(String[] args) {
		SpringApplication.run(Homeworkmodule15Application.class, args);

		// Тестовий запуск NoteService (як у твоєму старому коді)
		// Це лише приклад для перевірки логіки без контролера

        NoteService noteService = new NoteService();
        Note note = new Note();
        note.setTitle("First note");
        note.setContent("This is a test note");
        noteService.add(note);

        System.out.println("Saved: " + note.getId());
        System.out.println("All notes:");
        noteService.listAll().forEach(n -> System.out.println(n.getTitle()));

	}
}