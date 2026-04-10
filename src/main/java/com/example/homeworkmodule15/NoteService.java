package com.example.homeworkmodule16;

import com.example.homeworkmodule16.entity.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public Note update(Note note) {
        Note existing = noteRepository.findById(note.getId())
                .orElseThrow(() ->
                        new NoSuchElementException("Failed, didn't find on id: " + note.getId()));

        existing.setTitle(note.getTitle());
        existing.setContent(note.getContent());

        return noteRepository.save(existing);
    }

    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Note not found with id: " + id));
    }
}
