package com.example.homeworkmodule15;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.homeworkmodule15.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}