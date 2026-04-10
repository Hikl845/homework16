package com.example.homeworkmodule16;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.homeworkmodule16.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
